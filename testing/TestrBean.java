
package bean;

public class TestrBean {
    private int testid;
    private String email;
    private int catid;

    public TestrBean() {
    }

    public TestrBean(int testid, String email, int catid) {
        this.testid = testid;
        this.email = email;
        this.catid = catid;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    @Override
    public String toString() {
        return "TestrBean{" + "testid=" + testid + ", email=" + email + ", catid=" + catid + '}';
    }
    
}
