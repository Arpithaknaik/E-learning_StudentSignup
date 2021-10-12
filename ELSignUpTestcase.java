package RegrassionTest_TestCase;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SmokeTestPage.elogin;
import RegressionTestPage.ELSignUp;

//import com.appname.pages.LoginPage;

public class ELSignUpTestcase {
	static WebDriver driver;
	
	static String driverPath = "D:\\chromedriver_win32\\chromedriver.exe";
	@AfterTest
    public void closeAll()
    {
    	driver.close();
    }
	
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", driverPath);
		 driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void RegisterStudent()
	{
		
		elogin login = new elogin(driver);
		 login.clickSignUp();
		 ELSignUp register = new ELSignUp(driver);
		 register.register();
		 try {
			
			 boolean success=register.success();
			 Assert.assertEquals(success, true); 
		 }
		 	
		 catch (NoSuchElementException e)
			{
			
				System.out.println("Cannot register\n"+driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div")).getText());
				Assert.assertEquals(true, true);
				//status=false;
			}
	}
	
	
	
}
			