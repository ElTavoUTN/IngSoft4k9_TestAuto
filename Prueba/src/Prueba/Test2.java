package Prueba;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Gustavo\\eclipse-workspace\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://newtours.demoaut.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test2() throws Exception {
	  
	  
    driver.get(baseUrl + "/");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("", driver.findElement(By.name("userName")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("ingsoftware");
    try {
      assertEquals("", driver.findElement(By.name("password")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("ingsoftware");
    try {
      assertEquals("Login", driver.findElement(By.name("login")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
    try {
      assertTrue(isElementPresent(By.linkText("SIGN-OFF")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("SIGN-OFF")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}