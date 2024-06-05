package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P001_test extends base{
Faker fake=new Faker();
    public P001_test(WebDriver driver) {
        super(driver);
    }

    public final By leavingLocator=By.id("travelFromTag");
    public final By arriveLocator=By.id("travelToTag");
    @FindBy (xpath = "//div[@class=\"tab-pane fade show active\"]//div[@class=\"col-lg-1 col-12 pl-sm-12 ml-auto pl-2 pr-0 search-btn\"]//button")
    public WebElement searchLocator;
    @FindBy (id = "flight-dateRange")
    public WebElement clickOnDateLocator;
    @FindBy (xpath = "//div[@class=\"w-100 position-relative\"]//a[@class=\"btn btn-secondary btn-lg form-control dropdown-toggle search-dropdown p-0 py-2 btn-hover-generce\"]")
    public WebElement passengerLocator;
    @FindBy (xpath = "//div[@class=\"dropdown-menu notclose show\"]//div[@class=\"dropdown-item\"]//div[@class=\"col-12 pt-2 px-0\"][1]//div[@class=\"ddlBox ddlPaxSelection\"]//a[@onclick=\"incrementAdultsCount()\"]")
    public WebElement adultIncreaseLocator;
    @FindBy (xpath = "//div[@class=\"dropdown-menu notclose show\"]//div[@class=\"dropdown-item\"]//div[@class=\"col-12 pt-2 px-0\"][2]//div[@class=\"ddlBox ddlPaxSelection\"]//a[@onclick=\"incrementChildCount()\"]")
    public WebElement childIncreaseLocator;
    @FindBy (xpath = "//div[@class=\"dropdown-menu notclose show\"]//div[@class=\"dropdown-item\"]//div[@class=\"col-12 pt-2 px-0\"][3]//div[@class=\"ddlBox ddlPaxSelection\"]//a[@onclick=\"incrementInfantCount()\"]")
    public WebElement infantIncreaseLocator;
    @FindBy(xpath = "//div[@id=\"advanced-search\"]//div[@class=\"search-box d-flex align-items-center search-controller-box\"][2]")
    public WebElement airPreferredLocator;
    @FindBy (id = "preferredAirLine")
    public WebElement airTypeLocator;
    @FindBy(xpath = "//div[@id=\"advanced-search\"]//div[@class=\"search-box d-flex align-items-center search-controller-box\"][1]")
    public WebElement levelLocator;
    @FindBy (id="isDirect")
    public WebElement directOnlyLocator;




public void departure() throws InterruptedException {
    sendKeys(leavingLocator,fake.letterify("?"));
    Thread.sleep(5000);
    sendKeys(leavingLocator, String.valueOf(Keys.ARROW_DOWN));
    Thread.sleep(5000);
    sendKeys(leavingLocator, String.valueOf(Keys.ENTER));
}
    public void arrival() throws InterruptedException {
        sendKeys(arriveLocator,fake.letterify("?"));
        Thread.sleep(2000);
        sendKeys(arriveLocator, String.valueOf(Keys.ARROW_DOWN));
        Thread.sleep(5000);
        sendKeys(arriveLocator, String.valueOf(Keys.ENTER));
    }
public void search(){
    click(searchLocator);
}

public void selectCheckInDate(){
    click(clickOnDateLocator);
   int num= driver.findElements(By.xpath("//div[@class=\"drp-calendar right\"]//div//table//tbody//tr")).size();
    int rand=fake.number().numberBetween(3,num+1);
    int rand1=fake.number().numberBetween(1,8);
    driver.findElement(By.xpath("//div[@class=\"drp-calendar right\"]//div//table//tbody//tr["+rand+"]//td["+rand1+"]")).click();
}

public void selectCheckOutDate(){
    int num=driver.findElements(By.xpath("//div[@class=\"drp-calendar right\"]//div//table//tbody//tr")).size();
    int rand=fake.number().numberBetween(3,num+1);
    int rand1=fake.number().numberBetween(1,8);
    driver.findElement(By.xpath("//div[@class=\"drp-calendar right\"]//div//table//tbody//tr["+rand+"]//td["+rand1+"]")).click();
}
public void passenger() throws InterruptedException {
    click(passengerLocator);
    click(adultIncreaseLocator);
    click(childIncreaseLocator);
    click(infantIncreaseLocator);
    Thread.sleep(2000);
}

public void levelOfClass(){
    click(levelLocator);
    driver.findElement(By.xpath("//div[@class=\"dropdown-menu show\"]//span["+fake.number().numberBetween(1,5)+"]")).click();
}
public void airPreferred() throws InterruptedException {
    click(airPreferredLocator);
    Thread.sleep(2000);
    sendKeys(airTypeLocator,fake.letterify("?"));
    Thread.sleep(3000);
    sendKeys(airTypeLocator, String.valueOf(Keys.ARROW_DOWN));
    Thread.sleep(3000);
    sendKeys(airTypeLocator, String.valueOf(Keys.ENTER));

}

public void directOnly(){
    click(directOnlyLocator);
}

}
