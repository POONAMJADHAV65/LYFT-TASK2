 
package model;
 
import bean.QuestionPaperBean;
import bean.TestdataBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestdataDao {
    Connection con =null;
    PreparedStatement pstmt=null;
    Statement stmt = null;
    ResultSet rs = null;
    public int insertData(TestdataBean td)
    {
        int result=0;
         
        try{
            con=MyConnection.getMyConnection();
            String sql="INSERT INTO testdata(qid,answer,email,testid) VALUES (?,?,?,?)";
            pstmt=con.prepareStatement(sql);
             pstmt.setInt(1, td.getQid());
             pstmt.setString(2, td.getAnswer());
             pstmt.setString(3,td.getEmail());
             pstmt.setInt(4,td.getTestid());
             
            result=pstmt.executeUpdate();
             
         }catch(SQLException sqle){sqle.printStackTrace();}
        return result;
    }
    
    public ArrayList<TestdataBean> displayByTestID(int testid)  {        
    ArrayList<TestdataBean> a1 = new ArrayList<TestdataBean>();
    try{
    con=MyConnection.getMyConnection();
    stmt = con.createStatement();
    String sqlQ = "SELECT * FROM testdata WHERE testid="+testid;
    rs= stmt.executeQuery(sqlQ);
    
    while(rs.next()) {
        TestdataBean tdb = new TestdataBean();
        tdb.setAnswer(rs.getString("answer"));
        tdb.setEmail(rs.getString("email"));
        tdb.setQid(rs.getInt("qid"));
        tdb.setTestdataid(rs.getInt("testdataid"));
        tdb.setTestid(rs.getInt("testid"));
        a1.add(tdb);
    }
    }catch(Exception se){
    se.printStackTrace();
    }
    return a1;
    }
    
    
    
    
    public int ansCount(TestdataBean td)  {        
    int r=0;
    try{
    con=MyConnection.getMyConnection();
    stmt = con.createStatement();
    String sqlQ = "SELECT count(answer) FROM qpaper WHERE qid="+td.getQid()+" AND answer='"+td.getAnswer()+"' ";
    rs= stmt.executeQuery(sqlQ);
    
    while(rs.next()) {
         
        r=rs.getInt(1);       
        
    }
    }catch(Exception se){
    se.printStackTrace();
    }
    return r;
    }
    
    
    
    
    
    
    
}
