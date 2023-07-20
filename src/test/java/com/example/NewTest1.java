package com.example;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class NewTest1 {
	
	 WebDriver wd=null;
	 
	 @BeforeTest
	  public void beforeTest() {
	     WebDriverManager.chromedriver().setup();	
		  wd=new ChromeDriver();
		  wd.manage().window().maximize();
	     
		
	  }
	 
  @Test(priority = 1)
  public void registrationTest() {
	   System.out.println("In registration test");
		wd.get("https://www.amazon.in/");
		wd.findElement(By.linkText("Start here.")).click();
		wd.findElement(By.name("customerName")).sendKeys("Vasanth R");
		wd.findElement(By.id("ap_phone_number")).sendKeys("9597452906");
		wd.findElement(By.id("ap_email")).sendKeys("vasanthwonder29@gmail.com");
		wd.findElement(By.id("ap_password")).sendKeys("<password>");
	
		wd.findElement(By.id("continue")).click();
		
		wd.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		boolean doAccExists =wd.findElement(By.id("auth-error-message-box")).isDisplayed();
		if(doAccExists)
		{
			System.out.println("The account already exists ! Please sign in ");
		}
		Reporter.log("Registration Testing completed !");
		
		
  }
  
  @Test(priority = 2,dependsOnMethods = "registrationTest")
  public void signinTest()  {
	     wd.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		 System.out.println("In signin test");
		 System.out.println("Sign in with the existing account");
		 wd.findElement(By.className("a-link-emphasis")).click();
		 wd.findElement(By.id("ap_email")).sendKeys("9597452906");
		
		 wd.findElement(By.id("continue")).click();
		
		 wd.findElement(By.id("ap_password")).sendKeys("<password>");
		 wd.findElement(By.id("signInSubmit")).click();
		 
		 
		 List<WebElement> errorMessageBox = wd.findElements(By.id("auth-error-message-box"));

		 if (!errorMessageBox.isEmpty()) {
		     boolean isPwdInvalid = errorMessageBox.get(0).isDisplayed();
		     System.out.println("Invalid password !");
		 } else {
		     System.out.println("Login successful....");
		 }
		 
		 Reporter.log("Sigin Testing completed !");
		 

  }
  
  @Test(priority = 3,dependsOnMethods = "signinTest")
  public void searchbarTest()  {
	     wd.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		 System.out.println("In search bar test");
		 WebElement searchbar=wd.findElement(By.id("twotabsearchtextbox"));
		
		 if(searchbar.isDisplayed())
		 {
			 searchbar.sendKeys("Samsung J6 series phones"); 
			 wd.findElement(By.id("nav-search-submit-button")).click();
		 }
		 else
		 {
			 System.out.println("Search bar dosen't exsist. Please verify once");
		 }
		
		 Reporter.log("Searchbar Testing completed !");

  }
  
  @Test(priority = 4,dependsOnMethods = "searchbarTest")
  public void addToCartTest() {
	     wd.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
	     System.out.println("In add to cart  test");
	     wd.findElement(By.id("twotabsearchtextbox")).clear();
	     wd.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung galaxy M34 5G");
	    
	     wd.findElement(By.id("nav-search-submit-button")).click();
	   
	     wd.findElement(By.linkText("Samsung Galaxy M34 5G (Prism Silver, 8GB, 128GB Storage) | 120Hz sAMOLED Display | 50MP Triple No Shake"
	     		+ " Cam | 6000 mAh Battery | 16GB RAM with RAM Plus | Android 13 | Without Charger")).click();

	     
	    Set<String> handles = wd.getWindowHandles();
        wd.switchTo().window((String) handles.toArray()[handles.size() - 1]);
       JavascriptExecutor js=(JavascriptExecutor)wd;
	 	
	 	js.executeScript("window.scrollBy(0,500)");
	 	
	 	wd.manage().timeouts().implicitlyWait(4000,TimeUnit.MILLISECONDS);
	 	
	 	wd.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	
        
	 	wd.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
	     
	     wd.findElement(By.id("twotabsearchtextbox")).clear();
	     wd.findElement(By.id("twotabsearchtextbox")).sendKeys("lenovo v15 intel celeron n4500");
	  
   
	     wd.findElement(By.id("nav-search-submit-button")).click();
	     
	     wd.findElement(By.linkText("Lenovo V15 Intel Celeron N4500 15.6\" (39.62 cm) FHD (1920x1080) "
	     		+ "Antiglare 250 Nits Thin and Light Laptop (8GB RAM/256GB SSD/Windows "
	     		+ "11 Home/Black/1Y Onsite/1.7 kg), 82QYA00MIN")).click();
	     
	     wd.manage().timeouts().implicitlyWait(7000,TimeUnit.MILLISECONDS);
	     Set<String> handles1 = wd.getWindowHandles();
	     wd.switchTo().window((String) handles1.toArray()[handles1.size() - 1]);
		 wd.manage().timeouts().implicitlyWait(7000,TimeUnit.MILLISECONDS);
		   
	        JavascriptExecutor js1=(JavascriptExecutor)wd;
		 	
		 	js1.executeScript("window.scrollBy(0,500)");
		 	
		 	wd.manage().timeouts().implicitlyWait(7000,TimeUnit.MILLISECONDS);
		 
	     wd.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	    
	     wd.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
	     
	     wd.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
	     
	     
	     
	     Reporter.log("Add to cart Testing completed !");
		     
		 

  }
  
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	 
	  Reporter.log("Testing completed !");
  }

}
