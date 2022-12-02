import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class SeleniumWithDB {
    public static void main(String[] args) throws SQLException, InterruptedException {
//        Creating connection
//       URL: "jdbc:mysql://+host + ":"+port+"/databasename"
        String host = "localhost";
        String port = "3306";
        Connection con = DriverManager.getConnection("jdbc:mysql://"+host + ":"+port+"/seleniumtest", "root", "root");


//        Executing query
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from Employeeinfo  where age <22");

        String name="";
        String age="";
        while (rs.next()) {
             name = rs.getString("name");
             age = rs.getString("age");
            System.out.println(name + " - " + age);
        }

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.stealmylogin.com/demo.html");

        driver.findElement(By.name("username")).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(age);
        driver.findElement(By.xpath("//input[@value='login']")).click();



    }
}
