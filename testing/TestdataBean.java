
package bean;

public class TestdataBean {
    private int qid;
    private int	testdataid;
    private String answer;
    private String email;
   private int testid;

    public TestdataBean() {
    }

    public TestdataBean(int qid, int testdataid, String answer, String email, int testid) {
        this.qid = qid;
        this.testdataid = testdataid;
        this.answer = answer;
        this.email = email;
        this.testid = testid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getTestdataid() {
        return testdataid;
    }

    public void setTestdataid(int testdataid) {
        this.testdataid = testdataid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    @Override
    public String toString() {
        return "TestdataBean{" + "qid=" + qid + ", testdataid=" + testdataid + ", answer=" + answer + ", email=" + email + ", testid=" + testid + '}';
    }
   
}
