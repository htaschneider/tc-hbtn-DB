import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Iterator;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        Iterator<Driver> it = drivers.asIterator();
        while (it.hasNext()) {
            Driver driver = it.next();
            System.out.printf("%s %d %d\n", driver.getClass().getName(), driver.getMinorVersion(),
                    driver.getMajorVersion());
        }
    }

}