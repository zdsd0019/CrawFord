package com.example;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AppTest 
{

    WebDriver driver = new ChromeDriver();
    @BeforeTest
		public void getWebsite() {
            
			driver.get("https://www.crawco.co.uk/");
			driver.manage().window().maximize(); //Max Chrome Browser
		}
		
		@Test(priority=1, description="Facebook - Link check") 
        
		public void testCaseOne()
		{	
			//Confirms that the URL of our facebook link on this page is: https://www.facebook.com/crawfordandco

			String expected = "https://www.facebook.com/crawfordandco";
			String actual = driver.findElement(By.xpath("//*[@id='mmenu-page']/footer/div/div[1]/p[2]/a[2]")).getAttribute("href");
			Assert.assertEquals(actual, expected, "test passed");
			
			
		}	

        @AfterTest
        public void terminateBrowser() {
            driver.quit();
        
        
    }
}
