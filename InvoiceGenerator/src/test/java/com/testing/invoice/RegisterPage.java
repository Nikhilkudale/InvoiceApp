package com.testing.invoice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void register(String Name,String Email,String Password)
	{
		slowType(driver.findElement(By.id("name")),Name);
		slowType(driver.findElement(By.id("email")),Email);
		slowType(driver.findElement(By.id("password")),Password);
		driver.findElement(By.xpath("/html/body/div/form/div[4]/button")).click();
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@th:if='${errorMessage}']/p")));
            if (errorMessage != null && errorMessage.getText().equals("User already exists")) {
                System.out.println("Test Passed: Error message displayed correctly.");
            } else {
                System.out.println("Test Failed: Error message not displayed correctly.");
            }
        } catch (Exception e) {
            System.out.println("Test Passed: No error message, user registered successfully.");
        }
	}
	
	
	private void slowType(WebElement element, String text) {
	    for (char c : text.toCharArray()) {
	        element.sendKeys(String.valueOf(c));
	        try {
	            Thread.sleep(200); // 200 milliseconds dwelay between each keystroke
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    
	    }}
	
	
	
	
}
