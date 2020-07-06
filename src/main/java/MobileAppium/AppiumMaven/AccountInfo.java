package MobileAppium.AppiumMaven;


//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class AccountInfo {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Untitled";
  protected AndroidDriver<AndroidElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  
  @BeforeMethod
  public void setUp() throws MalformedURLException {
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.UDID, "I7RKTSEYFQLZ4LHM");
      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.handzap.handzap.global");
      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.handzap.handzap.ui.main.splash.SplashScreenActivity");
      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
      driver.setLogLevel(Level.INFO);
  }

  @Test
  public void testUntitled() throws InterruptedException {
	  Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@text='Log In']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id='et_phone_number']")).sendKeys("8549817445");
      Thread.sleep(1000);
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='et_password']")));
      driver.findElement(By.xpath("//*[@id='et_password']")).sendKeys("password");
      Thread.sleep(1000);
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
      driver.findElement(By.xpath("//*[@text='Next']")).click();
      Thread.sleep(1000);
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='Open navigation drawer']")));
      driver.findElement(By.xpath("//*[@contentDescription='Open navigation drawer']")).click();
      driver.findElement(By.xpath("//*[@text='Handzap']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id='tv_name_update']")).click();
      Thread.sleep(1000);
      AndroidElement n1=driver.findElement(By.id("et_title"));
      n1.clear();
      Thread.sleep(1000);
      AndroidElement n2=driver.findElement(By.id("et_title"));
      n2.sendKeys("VNCC");
      Thread.sleep(1000);
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Save']")));
      driver.findElement(By.xpath("//*[@text='Save']")).click();
      Thread.sleep(1000);
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Log Out']")));
      driver.findElement(By.xpath("//*[@text='Log Out']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@text='LOG OUT']")).click();
  }


@AfterMethod
  public void tearDown() {
      //driver.quit();
  }
}


