import db.Connectivity;
import serevice.DbService;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {

        try {
            Connectivity connectivity = new Connectivity();

            DbService service = new DbService(connectivity.getConnection());
//            int cnt = service.create(
//                    5,
//                    "lmn",
//                    Date.valueOf(LocalDate.now()),
//                    true
//            );
//            if(cnt > 0) {
//                System.out.println("Employee Created Successfully");
//            }

//            service.findEmployeeByName("pqr");
//            service.find();

            service.txnDemo(12, "abc", Date.valueOf(LocalDate.now()), true, 13);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
