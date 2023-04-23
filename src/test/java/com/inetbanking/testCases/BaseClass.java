package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilites.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {	
	    public String baseURL="http://demo.guru99.com/v4/index.php";
		public String username="mngr491279";
		public String password="bapazuh";
	
	ReadConfig readconfig = new ReadConfig();
	
	/*public String baseURL = readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();*/
	
	
	public static WebDriver driver=null;
	public static Logger log;
	
	@BeforeClass
	public void setup() 
	{
		String br="edge";
		
		
		System.out.println("test 111");
		
		if(br.equalsIgnoreCase("chrome"))
		{
			System.out.println("test 222");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("test 333");
	
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			
		}
		else if(br.equalsIgnoreCase("ie"))
		{
			
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();	
			
		}
		driver.get(baseURL);
	}

	@AfterClass
	public void teardown() throws IOException
	{
		driver.quit();		
		//Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");			
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	public static String randomstring()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	
	public static String randomNum() {
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return generatedstring2;
	}

}
