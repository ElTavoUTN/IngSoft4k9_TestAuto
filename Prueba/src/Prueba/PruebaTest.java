package Prueba;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;

public class PruebaTest {

	  private WebDriver driver;

	  @Test
	  public void testCaseJavaReservavuelos() throws Exception {
		  
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Gustavo\\eclipse-workspace\\geckodriver.exe");
		driver = new FirefoxDriver();
	    driver.get("http://newtours.demoaut.com/");
	    driver.findElement(By.name("userName")).clear();
	    driver.findElement(By.name("userName")).sendKeys("ingsoftware");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("ingsoftware");
	    driver.findElement(By.name("login")).click();
	    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
	    new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("22");
	    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Paris");
	    new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("27");
	    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
	    driver.findElement(By.name("findFlights")).click();
	    driver.findElement(By.name("reserveFlights")).click();
	    driver.findElement(By.name("passFirst0")).clear();
	    driver.findElement(By.name("passFirst0")).sendKeys("EsPrueba");
	    driver.findElement(By.name("passLast0")).clear();
	    driver.findElement(By.name("passLast0")).sendKeys("DeIngenieriaSoft");
	    driver.findElement(By.name("creditnumber")).clear();
	    driver.findElement(By.name("creditnumber")).sendKeys("445545121887");
	    driver.findElement(By.name("buyFlights")).click();
	    driver.findElement(By.xpath("//td[3]/a/img")).click();
	  


	}

	
}
