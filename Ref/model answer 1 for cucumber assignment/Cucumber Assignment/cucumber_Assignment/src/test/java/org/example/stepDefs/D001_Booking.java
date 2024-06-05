package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P001_Booking_page;

import org.testng.asserts.SoftAssert;



public class D001_Booking  {




    SoftAssert soft=new SoftAssert();
    P001_Booking_page book=new P001_Booking_page();
    @Given("User should fill the destination")
    public void UserShouldFillTheDestination(){

        book.cityName.sendKeys("alexandria");
        book.selectCity.click();

    }

    @When("user should fill check in and check out dates")
    public void userShouldFillCheckInAndCheckOutDates() throws InterruptedException {
        book.clickOnDate.click();
       book.selectCheckInDate();
       book.selectCheckOutDate();

        book.getCheckInDateInHomePage();
        book.getCheckOutDateInHomePage();
    }


    @And("select room with a child")
    public void selectRoomWithAChild() {
        book.guestsDropDown.click();
        book.increaseINTheNumbersOfChildren.click();
    }

    @And("select room without children")
    public void selectRoomWithoutChildren() {
        book.addRoom.click();
    }

    @Then("click on apply button")
    public void clickOnApplyButton() {
        book.applyButton.click();
    }

    @And("The number of rooms chosen must be two")
    public void theNumberOfRoomsChosenMustBeTwo() {
        soft.assertEquals(book.verifyNumberOfRoomsIs2(),"2 HOTEL.two-rooms");
        soft.assertAll();

    }

    @When("click on search hotels button")
    public void clickOnSearchHotelsButton() {
        book.searchButton.click();
    }

    @And("print the number of available hotels")
    public void printTheNumberOfAvailableHotels() {
        book.numberOfAvailableHotels();
        book.sortDropDown.click();
        book.cheapest.click();
    }

    @Then("user go to the star rating and choose three stars")
    public void userGoToTheStarRatingAndChooseThreeStars() {
        book.threeStars.click();

    }


    @When("user Sorts the hotels by cheapest and select the cheapest")
    public void userSortsTheHotelsByCheapestAndSelectTheCheapest()  {
        book.clickOnRoom.click();

    }

    @And("verify that the chosen data")
    public void verifyThatTheChosenData() throws InterruptedException {
        book.switchTaps();

        soft.assertEquals(book.getRoomsAndGuestInfo(),"2 Rooms , 3 Guest");
        String checkInDateBeforeSwitch=book.getCheckInDateInHomePage();
        String checkOutDateBeforeSwitch=book.getCheckOutDateInHomePage();
        book.switchTaps();
        String checkInDateAfterSwitch=book.getCheckInDate();
        String checkOutDateAfterSwitch=book.getCheckOutDate();
        soft.assertEquals(checkInDateBeforeSwitch,checkInDateAfterSwitch);
        soft.assertEquals(checkOutDateBeforeSwitch,checkOutDateAfterSwitch);
        soft.assertAll();

    }

    @And("click on customize room and continue to checkout")
    public void clickOnCustomizeRoomAndContinueToCheckout() throws InterruptedException {
        book.setWait();
        book.customizeButton.click();
        book.continueButton.click();




    }

    @Then("make sure reservation summary is present.")
    public void makeSureReservationSummaryIsPresent() throws InterruptedException {
        book.setWait1();
        soft.assertTrue(book.summaryHeader.isDisplayed());
        soft.assertTrue(book.summaryContent.isDisplayed());
        soft.assertAll();
    }
}
