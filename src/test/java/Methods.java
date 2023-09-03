import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.cache.Cache.copyFile;

public class Methods {

    private WebDriver driver;
    Elements elements = new Elements() ;
    Variables v = new Variables();

    @BeforeMethod
    public void init() {
        //Create driver
        System.setProperty("webdriver.edge.driver","D:\\Java_Workspace\\Amazon_automation\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.amazon.eg/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void setLanguage(EdgeDriver driver){

        Actions actions = new Actions(driver);

        WebElement LanguageList = driver.findElement(By.xpath(elements.languageList));
        actions.moveToElement(LanguageList).build().perform();

        WebElement setLanguage = driver.findElement(By.xpath(elements.SelectLanguage_ENG));
        setLanguage.click();

    }

    public String capture(WebDriver driver,String screenShotName) throws IOException, InterruptedException {
        Thread.sleep(1000);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\Screenshots\\"+screenShotName+".png";
        File destination = new File(dest);
        copyFile(source, destination);

        return dest;
    }

    public void SignIn(EdgeDriver driver){
        Actions actions = new Actions(driver);

        WebElement SignInDropDown = driver.findElement(By.xpath(elements.SignInDropDown));
        actions.moveToElement(SignInDropDown).build().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement SignInBtn = driver.findElement(By.xpath(elements.SignInDropDown));
        SignInBtn.click();

        WebElement EmailField = driver.findElement(By.xpath(elements.EmailField));
        EmailField.sendKeys(v.Email);

        WebElement ContinueBtn = driver.findElement(By.xpath(elements.ContinueButton));
        ContinueBtn.click();

        WebElement ErrorMessage1 = driver.findElement(By.xpath(elements.Message1));
        Assert.assertEquals(ErrorMessage1.getText(),"There was a problem");

        WebElement ErrorMessage2 = driver.findElement(By.xpath(elements.Message2));
        Assert.assertEquals(ErrorMessage2.getText(),"We cannot find an account with that email address");


    }

    public void AddItemsToCart(EdgeDriver driver) throws InterruptedException {

        Thread.sleep(3000);
      /*  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.AllTabMenu)));*/

        WebElement AllTabMenu = driver.findElement(By.xpath(elements.AllTabMenu));
        AllTabMenu.click();

        JavascriptExecutor scrollmenu = (JavascriptExecutor) driver;
        scrollmenu.executeScript("window.scrollBy(0, 600);");


        WebElement TodayDeals = driver.findElement(By.xpath(elements.Deals));
        TodayDeals.click();

        JavascriptExecutor scrollMainPage = (JavascriptExecutor) driver;
        scrollMainPage.executeScript("window.scrollBy(0, 600);");

        WebElement Category = driver.findElement(By.xpath(elements.Category));
        Category.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement Product = driver.findElement(By.xpath(elements.Product));
        Product.click();

        JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
        scrollPage.executeScript("window.scrollBy(0, 500);");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement Quantity = driver.findElement(By.xpath(elements.Quantity));
        Quantity.click();

        WebElement AddToCart = driver.findElement(By.xpath(elements.AddtoCart));
        AddToCart.click();

        WebElement Proceed = driver.findElement(By.xpath(elements.Proceed));
        Proceed.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement Cart = driver.findElement(By.xpath(elements.Cart));
        Cart.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement Item_Name = driver.findElement(By.xpath(elements.Item_Name));
        Assert.assertEquals(Item_Name.getText(),"Superdrive, portable air compressor, tire inflator, 12v,digital display with chargeable battery, 1 cylinder - black,1.07 kg,DIG01");

        WebElement Item_Price = driver.findElement(By.xpath(elements.Item_Price));
        Assert.assertEquals(Item_Price.getText(),"EGP 999.00");

        WebElement Item_Quantity = driver.findElement(By.xpath(elements.Item_Quantity));
        Assert.assertEquals(Item_Quantity.getText(),"Subtotal (2 items):");

        WebElement Item_Subtotal = driver.findElement(By.xpath(elements.Item_Subtotal));
        Assert.assertEquals(Item_Subtotal.getText(),"EGP 1,998.00");

    }

    public void CheckYourOrdersPage(EdgeDriver driver) throws InterruptedException {
        Thread.sleep(3000);

        Actions actions = new Actions(driver);

        WebElement SignInDropDown = driver.findElement(By.xpath(elements.SignInDropDown));
        actions.moveToElement(SignInDropDown).build().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement Orders = driver.findElement(By.xpath(elements.Orders));
        Orders.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement SignInMessage = driver.findElement(By.xpath(elements.SignInMessage));
        Assert.assertEquals(SignInMessage.getText(),"Sign in");


    }

    public void CheckYourAddressesPage(EdgeDriver driver) throws InterruptedException {
        Thread.sleep(3000);

        Actions actions = new Actions(driver);

        WebElement SignInDropDown = driver.findElement(By.xpath(elements.SignInDropDown));
        actions.moveToElement(SignInDropDown).build().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement Addresses = driver.findElement(By.xpath(elements.Addresses));
        Addresses.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement SignInMessage = driver.findElement(By.xpath(elements.SignInMessage));
        Assert.assertEquals(SignInMessage.getText(),"Sign in");

    }

    public void CheckYourListsPage(EdgeDriver driver) throws InterruptedException {
        Thread.sleep(3000);

        Actions actions = new Actions(driver);

        WebElement SignInDropDown = driver.findElement(By.xpath(elements.SignInDropDown));
        actions.moveToElement(SignInDropDown).build().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement Lists = driver.findElement(By.xpath(elements.Lists));
        Lists.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement ListMessage = driver.findElement(By.xpath(elements.ListMessage));
        Assert.assertEquals(ListMessage.getText(),"Lists");
    }



}
