import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by TianJing on 2018/4/8.
 */
public class DBHelper {
    public static final String url = "jdbc:mysql://192.168.32.20:3306/patient_app_service";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "mingyizhudao123";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper(String sql){
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url,user,password);
            pst = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            this.conn.close();
            this.pst.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
