package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.invoice.LoginPage;
import com.testing.invoice.RegisterPage;

import utils.DriverSetup;

public class RegisterTest {
	
	WebDriver driver;
	RegisterPage rp;
	
	
	 @BeforeClass
	    public void setUp() {
	        driver = DriverSetup.getDriver();
	        driver.get("http://localhost:8080/register");
	        rp = new RegisterPage(driver);
	    }

	    @Test
	    public void testLogin() {
	        rp.register("Kudale", "nikhilnkudale@gmail.com", "1941");
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
