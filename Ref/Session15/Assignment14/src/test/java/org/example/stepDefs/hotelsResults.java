package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.bookingPage;
import org.example.Pages.hotelsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class hotelsResults {
    org.example.Pages.hotelsPage hotelsPage=new hotelsPage();
    Hooks hooks=new Hooks();
    WebDriver driver=hooks.driver;
    SoftAssert softAssert=new SoftAssert();


    @Then("print the number of available hotels and their data")
    public void printTheNumberOfAvailableHotelsAndTheirData() throws InterruptedException {
        Thread.sleep(3000);
        //print hotel numbers
        int numberOfMatchedHotels=hotelsPage.hotelsLinks.size();
        System.out.println("Number of Matched Hotels: "+numberOfMatchedHotels);

        //print each hotel data
        for (int i = 0; i <numberOfMatchedHotels ; i++) {
            System.out.println("Data of hotel "+(i+1));
            System.out.println("اسم الفندق هو "+hotelsPage.hotelNames.get(i).getText());
            System.out.println("hotel price is: "+hotelsPage.hotelPrices.get(i).getText());

            System.out.println("*********************");
        }
    }

    @When("Go to the star rating and choose {string} stars.")
    public void goToTheStarRatingAndChooseStars(String starsRating) {
        //Get all the existing rating in that time period
        List<WebElement> ratings=hotelsPage.hotelRatings;
        //Loop until you find the desired rate
        for (int i = 0; i <ratings.size() ; i++) {
            if(ratings.get(i).getText().equals(starsRating))
            {
                hotelsPage.hotelRatingsCheckMark.get(i).click();
                break;
            }
        }
    }
    @And("Sort hotels by cheapest")
    public void sortHotelsByCheapest() {
        //open sorting menu
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", hotelsPage.sortingDropDownMenu);
        //select the sorting option "cheapest"
        hotelsPage.sortingOptions.get(1).click();
    }


    @And("Peak hotel number {int} from the list")
    public void peakHotelNumberFromTheList(int hotelIndex) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElements(By.xpath("//*[@class=\"hotel-item ng-star-inserted\"]")).get(hotelIndex-1).click();
    }
}
