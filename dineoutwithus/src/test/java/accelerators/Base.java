	package accelerators;
	import java.io.File;
	import java.sql.DriverManager;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.ITestContext;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import utilities.Accessories;
	import utilities.Property;
	
	

	//import com.relevantcodes.extentreports.ExtentReports;
	//import com.relevantcodes.extentreports.ExtentTest;

	public class Base {
	 public static String timeStamp = Accessories.timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
	 public static Property configProps = new Property("config.properties");
	 //public static ExtentReports extent;
	 public static String URL = null;
	 public static WebDriver driver;
	 static String driverPath = System.getProperty("user.dir") + "\\Drivers\\";

	 // Parameters need to starup the 
	 static String browser = null;
	 static int len = 0;
	 static int i = 0;
	 static int j = 0;
	 
	 // Extent Reports
	 public static ExtentHtmlReporter reporter;
	 public static ExtentReports extent;
	 
	 /**
	  *Initializing browser requirements, Test Results file path and Database requirements from the configuration file
	  * @Date  19/02/2013
	  * @Revision History
	  * 
	  */

	 @BeforeSuite(alwaysRun = true)
	 public static void setupSuite() throws Throwable {
    	// Initializing reporter paths and tests
		 intializeextentReport();
		 String strBrowserType[];
	  browser = configProps.getProperty("browserType");

	  if (!(browser.toString().contains(","))) {
	   strBrowserType = new String[] {
	    browser
	   };
	  } else {
	   strBrowserType = browser.split("\\,");
	  }
	  len = strBrowserType.length;
	  while (i < len) {
	   String browserType = strBrowserType[i];
	   if (strBrowserType[i].toString().equalsIgnoreCase("firefox")) {
	    //driver= new FirefoxDriver();
	    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
	    DesiredCapabilities dc = DesiredCapabilities.firefox();
	    dc.setCapability("marionette", true);
	    System.out.println("We are in invoke driver method");
	    driver = new FirefoxDriver(dc);
	    i = i + 1;
	    break;
	   } else if (strBrowserType[i].toString().equalsIgnoreCase("ie")) {
	    File file = new File("Drivers\\IEDriverServer_32.exe");
	    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	    driver = new InternetExplorerDriver();
	    i = i + 1;
	    break;
	   } 
	 else if (strBrowserType[i].toString().equalsIgnoreCase("chrome")) {
	    System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    i = i + 1;
	    break;
	   }
	  }

	  try {
	   driver.get(configProps.getProperty("URL"));
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	  } catch (Exception e1) {
	   System.out.println(e1);
	  }
	 }

	 public static void intializeextentReport ()
	 {
		  reporter = new ExtentHtmlReporter(Base.filePath()+"Results_"+Base.timeStamp+".html");
		  extent = new ExtentReports();
		  extent.attachReporter(reporter);
	 }
	 
	 /**
	  * Write results to Browser specific path
	  * @Date  19/02/2013
	  * @Revision History
	  * 
	  */
	 //@Parameters({"browserType"})
	 public static String filePath() {
	  String strDirectoy = "";
	  if (configProps.getProperty("browserType").equalsIgnoreCase("ie")) {
	   //strDirectoy="IE\\IE";
	   strDirectoy = "IE";
	  } else if (configProps.getProperty("browserType").equalsIgnoreCase("firefox")) {
	   //strDirectoy="Firefox\\Firefox";
	   strDirectoy = "Firefox";
	  } else {
	   strDirectoy = "Chrome\\Chrome";
	   strDirectoy = "Chrome";
	  }

	  if (strDirectoy != "") {
	   new File(configProps.getProperty("extentresultspath") + strDirectoy).mkdirs();
	  }
	  return configProps.getProperty("extentresultspath") + strDirectoy + "\\";
	 }

	 /**
	  *  De-Initializing and closing all the connections
	  * @throws Throwable
	  */

	 @AfterSuite(alwaysRun = true)
	 public void tearDown(ITestContext ctx) throws Throwable {
	  Accessories.calculateSuiteExecutionTime();
	  driver.quit();
	 }
	 
	 @AfterTest(alwaysRun = true)
	 public void startTest() throws Throwable
	 {
		 extent.flush();
	 }
	}