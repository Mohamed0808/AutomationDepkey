package org.example.Pages;
import com.github.javafaker.Faker;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.ArrayList;

public class P001_Booking_page extends Hooks{
    Faker faker=new Faker();
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));


    public P001_Booking_page(){
        PageFactory.initElements(Hooks.driver,this);}
    @FindBy(xpath = "//*[@class=\"search__destination panel-mobile-overlay\"]//input")
    public WebElement cityName;
    @FindBy(xpath = "//*[@id=\"ngb-typeahead-0-0\"]")
    public WebElement selectCity;
    @FindBy(xpath = "//*[@class=\"almatar-calendar__input almatar-calendar__input--departure ng-star-inserted\"]")
    public WebElement clickOnDate;
    public void selectCheckInDate(){

        int num=driver.findElements(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][2]//tr")).size();
        int random=faker.number().numberBetween(2,num+1);
        int random1=faker.number().numberBetween(1,8);
        driver.findElement(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][1]//tr[" + random + "]//td[" + random1 + "]")).click();
    }

    public void selectCheckOutDate(){
        int num=driver.findElements(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][2]//tr")).size();
        int random=faker.number().numberBetween(2,num+1);
        int random1=faker.number().numberBetween(1,8);
        driver.findElement(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][2]//tr["+random+"]//td["+random1+"]")).click();
        driver.findElement(By.xpath("//*[@class=\"slick-carousel--header\"]")).click();
    }
    public String getCheckInDateInHomePage() {
        String text = driver.findElement(By.xpath("//*[@class=\"almatar-calendar__input almatar-calendar__input--departure ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")).getText();
        return text;
    } public String getCheckOutDateInHomePage() {
        String text = driver.findElement(By.xpath("//*[@class=\"almatar-calendar__input almatar-calendar__input--return ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")).getText();
        return text;
    }

    @FindBy(xpath = "//*[@class=\"search__passengers-dropdown\"]")
    public WebElement guestsDropDown;
    @FindBy(xpath = "//*[@class=\"slick-carousel--next\"]")
    public WebElement guestsDropDown1;
    @FindBy(xpath = "//*[@class=\"increase-2 passenger-control__button decrement ng-star-inserted\"]//*[@class=\"icon\"]")
    public WebElement increaseINTheNumbersOfChildren;
    @FindBy(xpath = "//*[@class=\"room-control\"]//button")
    public WebElement addRoom;
    @FindBy(xpath = "//*[@class=\"edit-search-sheet__action\"]//button")
    public WebElement applyButton;

    public String verifyNumberOfRoomsIs2(){
        String text=driver.findElement(By.xpath("//*[@class=\"search__passengers-dropdown\"]//span[2]")).getText();
        return text;
    }
    @FindBy(xpath = "//*[@class=\"search__action\"]")
    public WebElement searchButton;
    public void numberOfAvailableHotels(){
        int num=driver.findElements(By.xpath("//*[@class=\"pt-4 col-lg-9 col-md-8 col-sm-12 col-12 all-hotels ng-star-inserted\"]//a")).size();
        System.out.println("The number of available hotels is "+num);
        for (int i = 1; i <=num; i++) {
            String hotelsName=driver.findElement(By.xpath("//*[@class=\"pt-4 col-lg-9 col-md-8 col-sm-12 col-12 all-hotels ng-star-inserted\"]//a["+i+"]//h3")).getText();
            System.out.println(i+"- "+hotelsName);

        }
    }
    @FindBy(xpath = "//*[@class=\"rating ng-star-inserted\"]//div[3]//*[@class=\"checkmark\"]")
    public WebElement threeStars;
    @FindBy(xpath = "//*[@role=\"button\"]")
    public WebElement sortDropDown;
    @FindBy(xpath = "//*[@class=\"p-dropdown-items ng-star-inserted\"]//*[@class=\"p-element ng-star-inserted\"][2]")
    public WebElement cheapest;
    @FindBy(xpath = "//*[@class=\"pt-4 col-lg-9 col-md-8 col-sm-12 col-12 all-hotels ng-star-inserted\"]//a[1]//button")
    public WebElement clickOnRoom;

    public String getRoomsAndGuestInfo() {
        String text = driver.findElement(By.xpath("//*[@class=\"content\"]//*[@class=\"search__item__input\"]")).getText();
        return text;

    }   public String getCheckInDate() {
        String text = driver.findElement(By.xpath("//*[@class=\"almatar-calendar__input almatar-calendar__input--departure ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")).getText();
        return text;
    } public String getCheckOutDate() {
        String text = driver.findElement(By.xpath("//*[@class=\"almatar-calendar__input almatar-calendar__input--return ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")).getText();
        return text;
    }

    @FindBy(xpath = "//*[@id=\"packages-0\"]//*[@class=\"price\"]//button")
    public WebElement customizeButton;

    public void setWait() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(customizeButton));
    }

    public void switchTaps() throws InterruptedException {
        ArrayList<String> tabs=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1500);
    }
    @FindBy(xpath = "//*[@class=\"room-modal__footer\"]//button")
    public WebElement continueButton;
    @FindBy(xpath = "//*[@class=\"hotel-summary ng-star-inserted\"]//*[@class=\"hotel-summary__header\"]")
    public WebElement summaryHeader;
    @FindBy(xpath = "//*[@class=\"hotel-summary ng-star-inserted\"]//*[@class=\"hotel-summary__content\"]")
    public WebElement summaryContent;
    public void setWait1() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(summaryHeader));
        wait.until(ExpectedConditions.visibilityOf(summaryContent));
    }
}
