import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class testcases {

    public WebDriver driver;

    Elements elements = new Elements();
    Methods methods = new Methods();
    Variables v = new Variables();


    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.edge.driver","D:\\Java_Workspace\\Amazon_automation\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.amazon.eg/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        methods.setLanguage((EdgeDriver) driver);


    }

    @Test
    public void Scenario_one() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        methods.SignIn((EdgeDriver) driver);

    }

    @Test
    public void Scenario_two() throws InterruptedException {

        methods.AddItemsToCart((EdgeDriver) driver);

    }

    @Test
    public void Scenario_three() throws InterruptedException {


        methods.CheckYourOrdersPage((EdgeDriver) driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().back();

        methods.CheckYourAddressesPage((EdgeDriver) driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().back();

        methods.CheckYourListsPage((EdgeDriver) driver);

    }

    @Test
    public void Scenario_FailedForScreenshot() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        methods.SignIn((EdgeDriver) driver);

        methods.capture(driver,v.screenshot);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
