package cn.edu.dhu.acm.oj.buslogic.rank;

import java.io.PrintWriter;
import java.util.Date;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuffer;

import cn.edu.dhu.acm.oj.persistence.beans.ContestBean;
import cn.edu.dhu.acm.oj.persistence.beans.SolutionBean;
import cn.edu.dhu.acm.oj.persistence.beans.UserBean;
import cn.edu.dhu.acm.oj.persistence.beans.ContestProblemBean;
import cn.edu.dhu.acm.oj.buslogic.facade.contest.WSContestFacade;
import cn.edu.dhu.acm.oj.common.util.Util;

public class RanklistClient {

    private Object printingLock;
    private int numProblems;
    private TreeMap<Integer, ContestProblemBean> problem_map;
    private TreeMap<String, UserBean> user_map;
    private ArrayList<SolutionBean> allRuns;
    private long[] psdAccepted;
    private long[] psdAttempts;
    
    private ContestBean contest;

    public RanklistClient(int cid) {
        WSContestFacade contestFacade = new WSContestFacade();
        this.contest = contestFacade.getContest(cid);
        // get contest problems
        problem_map = contestFacade.getProblemsByContest(cid);
        // get all runs
        this.allRuns = (ArrayList)contestFacade.querySubmitStatusByContest(cid);
        // private contest get users by reservation.
//        if (contest.getPrivate_() != 0) {
//            this.user_map = contestFacade.getContestReservation(cid);
//        } else {
            // get users who submit codes in this contest.
            this.user_map = contestFacade.getUsersByRank(allRuns);
//        }
        this.numProblems = problem_map.size();
        this.psdAccepted = new long[numProblems+1];
        this.psdAttempts = new long[numProblems+1];
        this.printingLock = new Object();
    }

    public void updateBoardTimely(PrintWriter out) {
        initSummaryPSD();
        printHTML(out);
    }

    private void initSummaryPSD() {
        for (int i = 1; i <= this.numProblems; ++i) {
            this.psdAccepted[i] = (this.psdAttempts[i] = 0);
        }
    }

    private void printHeader(PrintWriter os) {
        if (os == null) {
            os = new PrintWriter(System.out, true);
        }
        os.println("<html>");
        os.println("<head>");
        os.println("<title>" + contest.getTitle() + "Ranklist</title>");
        os.println("</body>");
        os.println("<body>");
        os.print("<div align='center'>");
        os.println("<h1>" + contest.getTitle() + "</h1>");
        os.println("<h4>contest time: " + contest.getStartTime() + " ----- " + contest.getEndTime() + "</h4>");
        os.println("<h4>last update: " + Util.getTimeString() + "</h4>");

        int border = 1;
        os.println("<table border=\"" + border + "\">");
        os.print("<tr>");
        os.print("<th><strong><u>Rank</u></strong></th>");
        os.print("<th><strong><u>Name</u></strong></th>");
        os.print("<th><strong><u>School</u></strong></th>");
        os.print("<th><strong><u>Solved</u></strong></th>");
        os.print("<th><strong><u>Time</u></strong></th>");
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int j = 0; j < this.numProblems; ++j) {
            os.print("<th>&#160;&#160;&#160;&#160;<strong><u>" + alphabet.charAt(j % 26) + "</u></strong>&#160;&#160;&#160;&#160;</th>");
        }
        os.print("<th><strong><u>Total att/solv</strong></th>");
        os.print("</tr>");
        os.println();
    }

    private void printHTML(PrintWriter out) {
        boolean aborted = true;
        try {
            synchronized (printingLock) {
                Ranklist rank = new Ranklist(contest);
                TreeMap tm = (TreeMap)user_map.clone();
                ClientScoreData sd[] = rank.getStandings(allRuns, tm.keySet());

                printHeader(out);

                if (sd == null) {
                    System.out.println("no standings ?!?");
                } else if (sd.length == 0) {
                    System.out.println("no standings");
                } else {
                    int totalSolved = 0;
                    for (int i = 0; i < sd.length; i++) {
                        totalSolved = (int) ((long) totalSolved + sd[i].getNumberOfSolvedProblems());
                        printRow(out, sd[i]);
                    }
                }

                summarizePSD(out);
                printTrailer(out);

                out.close();
            }
            aborted = false;
        } catch (Exception e) {
            System.out.println("printHTML()" + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("printHTML() end (aborted=" + aborted + ")");
            String date = (new Date()).toString();
            System.out.println(date + " html generated");
        }
    }

    private void printRow(PrintWriter os, ClientScoreData csd) {
        if (os == null) {
            os = new PrintWriter(System.out, true);
        }
        if (csd == null) {
            System.out.println("printRow no ClientScoreData to print");
        } else {
            UserBean ub = user_map.get(csd.getUserID());
            String name = ub.getNick() != null ? ub.getNick().trim() : ub.getUserId();
            String school = ub.getSchool() != null ? ub.getSchool() : "N/A";
            os.print("<tr>");
            os.print("<td  align='center'>" + csd.getRank() + "</td>");
            os.print("<td  align='center'>" + name + "</td>");
            os.print("<td  align='center'>" + school + "</td>");
            os.print("<td  align='center'>" + csd.getNumberOfSolvedProblems() + "</td>");
            os.print("<td  align='center'>" + (csd.getScore() / 60000L) + "</td>");
            String stats = "";

            ProblemScoreData psd = null;
            int attempts = 0, solved = 0;
            for (int j = 1; j <= this.numProblems; ++j) {
                int problemId = problem_map.get(new Integer(j)).getProblemId();

                if (problemId == 0) {
                    psd = null;
                } else {
                    psd = csd.getProblemScoreData(problemId);
                }
                if (psd == null) {
                    stats = "--/--";
                } else {
                    this.psdAttempts[j] += psd.getAttempts();
                    attempts += psd.getAttempts();
                    if (psd.isSolved()) {
                        solved ++;
                        stats = psd.getAttempts() + "/" + (psd.getSolutionTime() / 60000L);
                        this.psdAccepted[j]++;
                    } else {
                        stats = psd.getAttempts() + "/--";
                    }
                }
                os.print("<td  align='center'>" + stats + "</td>");
            }

            os.print("<td  align='center'>" + attempts + "/" + solved + "</td>");
            os.print("</tr>");
            os.println();
        }
    }

    private void printTrailer(PrintWriter os) {
        if (os == null) {
            os = new PrintWriter(System.out, true);
        }

        os.println("</table>");
        os.println("</div>");
        os.println("</body>");
        os.println("</html>");
    }

    private void summarizePSD(PrintWriter os) {
        StringBuffer line = new StringBuffer();
        line.append("<tr>");
        line.append("<td>Summary</td>");
        line.append("<td>Submitted/Total Yes</td>");
        line.append("<td/><td/><td/>");
        int totalAttempts = 0, totalAccepted = 0;
        for (int p = 1; p <= this.numProblems; ++p) {
            totalAttempts += psdAttempts[p];
            totalAccepted += psdAccepted[p];
            line.append("<td align='center'>" + this.psdAttempts[p] + "/" + this.psdAccepted[p] + "</td>");
        }
        line.append("<td align='center'>" + totalAttempts + "/" + totalAccepted + "</td>");
        line.append("</tr>");
        os.println(line);
    }
}