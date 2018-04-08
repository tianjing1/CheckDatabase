import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TianJing on 2018/4/8.
 */
public class InquireData {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args){
        sql = "SELECT * FROM user where name = '测试A'";
        db1 = new DBHelper(sql);
        try {
            ret = db1.pst.executeQuery();
            while (ret.next()){
                String id = ret.getString(1);
                String name = ret.getString(2);
                String mobile = ret.getString(3);
                System.out.println(id + "\t" + name + "\t" + mobile);
            }
            ret.close();
            db1.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
