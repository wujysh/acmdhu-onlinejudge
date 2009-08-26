package dhuoj.primeserver.common.form;

public class SubmitCodeForm implements java.io.Serializable{

    private String userID = null;
    private String password = null;
    private String source = null;
    private int language = 0;
    private int contestID = 0;
    private int problemID = 0;
    private int localJudgeResult = 0;

    public SubmitCodeForm() {
    }

    public SubmitCodeForm(String uid, int pid, int cid, int lang, String src) {
        this.userID = uid;
        this.problemID = pid;
        this.contestID = cid;
        this.language = lang;
        this.source = src;
    }

    public int getContestID() {
        return contestID;
    }

    public void setContestID(int contestID) {
        this.contestID = contestID;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProblemID() {
        return problemID;
    }

    public void setProblemID(int problemID) {
        this.problemID = problemID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getLocalJudgeResult() {
        return localJudgeResult;
    }

    public void setLocalJudgeResult(int localJudgeResult) {
        this.localJudgeResult = localJudgeResult;
    }
    
}
