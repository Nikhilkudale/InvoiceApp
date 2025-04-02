package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.invoice.LoginPage;

import utils.DriverSetup;

public class LoginTest {
	
	WebDriver driver;
	LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetup.getDriver();
        driver.get("http://localhost:8080/getlogin");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("nik@gmail.com", "1234");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
