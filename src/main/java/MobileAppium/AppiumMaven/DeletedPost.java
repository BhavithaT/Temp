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

public class DeletedPost {
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
	  Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@text='Log In']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id='et_phone_number']")).sendKeys("8549817445");
      Thread.sleep(1000);
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='et_password']")));
      driver.findElement(By.xpath("//*[@id='et_password']")).sendKeys("password");
      Thread.sleep(1000);
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
      driver.findElement(By.xpath("//*[@text='Next']")).click();
      Thread.sleep(3000);
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("iv_settings")));
      Thread.sleep(1000);
      driver.findElement(By.id("iv_settings")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@text='Delete Post']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@text='DELETE']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@text='Deleted Posts']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@contentDescription='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']")).click();
      Thread.sleep(1000);
  }

  @AfterMethod
  public void tearDown() {
      //driver.quit();
  }
}
