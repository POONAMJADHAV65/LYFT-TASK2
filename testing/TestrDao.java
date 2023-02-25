
package model;

 
import bean.TestrBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestrDao {
    Connection con =null;
    PreparedStatement pstmt=null;
    Statement stmt = null;
    ResultSet rs = null;
    
    
    public int insertData(TestrBean q)
    {
        int result=0;
         
        try{
            con=MyConnection.getMyConnection();
            String sql="INSERT INTO testr(testid,email,catid) VALUES(?,?,?)";
            pstmt=con.prepareStatement(sql);    
             pstmt.setInt(1, q.getTestid());
             pstmt.setString(2, q.getEmail());
             pstmt.setInt(3,q.getCatid());             
            
            result=pstmt.executeUpdate();
             
         }catch(SQLException sqle){sqle.printStackTrace();}
        return result;
    }
    
}
