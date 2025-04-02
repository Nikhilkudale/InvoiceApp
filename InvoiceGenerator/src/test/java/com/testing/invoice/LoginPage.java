package com.testing.invoice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	 WebDriver driver;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void login(String Email, String Password) {
	    	 driver.findElement(By.id("email")).sendKeys(Email); 
	         driver.findElement(By.id("password")).sendKeys(Password); 
	         driver.findElement(By.xpath("/html/body/form/div[3]/button")).click();
	       
	    
	    
	    }

}
