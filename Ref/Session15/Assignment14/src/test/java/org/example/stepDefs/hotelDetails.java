package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.A;
import org.example.Pages.bookingPage;
import org.example.Pages.hotelDetailsPage;
import org.example.Pages.hotelsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;



public class hotelDetails {
    hotelDetailsPage hotelDetailsPage=new hotelDetailsPage();
    hotelsPage hotelsPage=new hotelsPage();
    Hooks hooks=new Hooks();
    WebDriver driver=hooks.driver;
    Faker faker=new Faker();

    SoftAssert softAssert=new SoftAssert();

    @Then("Verify that the check in, check out date is correct")
    public void verifyThatTheCheckInCheckOutDateIsCorrect() {
        //Switch to the opened link
        ArrayList<String>windows=  new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

         int options=0,randomOption=0;

        //Check wether there are available rooms or not
         while(driver.findElements(By.xpath("//*[@class=\"sold-out\"]")).size()!=0)
        {
            System.out.println("sold out");
            //close the link of the opened hotel page
            driver.close();
            //back to the hotel list and select another hotel
            driver.switchTo().window(windows.get(0));
            options=hotelsPage.hotelsLinks.size();
            randomOption=faker.number().numberBetween(0,options+1);
            hotelsPage.hotelsLinks.get(randomOption).click();
            windows=  new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(1));
        }
        //retrieve the check in date and time
        String ActualArrivalDate=hotelDetailsPage.arrivalDate.getText();
        String ActualDepartureDate=hotelDetailsPage.departureDate.getText();

        String ExpectedArrivalDate=bookingPage.chosenArrivalDate;
        String ExpectedDepartureDate=bookingPage.chosenDepartureDate;

        softAssert.assertEquals(ActualArrivalDate,ExpectedArrivalDate);
        softAssert.assertEquals(ActualDepartureDate,ExpectedDepartureDate);

        softAssert.assertAll();
    }

    @And("Verify that guests and room numbers are correct")
    public void verifyThatGuestsAndRoomNumbersAreCorrect() {
        int ActualRoomNumbers=Integer.parseInt(hotelDetailsPage.roomNumbers.getText().replaceAll("[^0-9]",""));
        String[] roomsAndCustomerData=hotelDetailsPage.customerNumbers.getText().split(",");
        String customerData=roomsAndCustomerData[1];
        int ActualCustomerNumbers=Integer.parseInt(customerData.replaceAll("[^0-9]",""));

        int ExpectedRoomNumbers=bookingPage.bookedRoomNumber;
        int ExpectedCustomerNumbers=bookingPage.bookedCustomerNumber;
        softAssert.assertEquals(ActualRoomNumbers,ExpectedRoomNumbers);
        softAssert.assertEquals(ActualCustomerNumbers,ExpectedCustomerNumbers);

        softAssert.assertAll();
    }

    @When("User select first room option and continue to checkout")
    public void userSelectFirstRoomOptionAndContinueToCheckout() {
        hotelDetailsPage.continueCheckOutButton.click();
    }

    @Then("Verify that reservation summary is present")
    public void verifyThatReservationSummaryIsPresent() {
        if(driver.findElements(By.xpath("//*[@class=\"almatar-button almatar-button--primary\"]")).size()!=0){
            hotelDetailsPage.continuePaymentButton.click();
        }
        softAssert.assertTrue(hotelDetailsPage.reservationSummary.isDisplayed());
        softAssert.assertAll();
    }
}
