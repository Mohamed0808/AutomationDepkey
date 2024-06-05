package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.example.Pages.bookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class booking {
    public bookingPage bookingPage=new bookingPage();
    Hooks hooks=new Hooks();
    WebDriver driver=hooks.driver;
    SoftAssert softAssert=new SoftAssert();
    Faker faker=new Faker();
    @When("user select valid country")
    public void userselectvalidcountry()
    {
        bookingPage.destinationDropDownList.click();
        bookingPage.MeccaDestination.click();

    }

    @And("user select arrival time")
    public void userSelectArrivalTime() {
        bookingPage.calender.click();
        bookingPage.day10.click();

    }

    @And("user select leave time")
    public void userSelectLeaveTime() {

        bookingPage.day17.click();
    }



    @And("add adults")
    public void addAdults() {
        bookingPage.roomsDropDown.click();
        bookingPage.addAdult.click();
    }

    @And("add: {int} children one of age {int} and one of age {int}")
    public void addChildrenOneOfAgeAndOneOfAge(int numberOfChildren, int Age1, int Age2) {
        for (int i = 0; i <numberOfChildren ; i++) {
            bookingPage.addChildButtons.get(0).click();
        }
        bookingPage.childAgesListArrow.get(0).click();
        bookingPage.childrenAges.get(1).click();

        bookingPage.childAgesListArrow.get(1).click();
        bookingPage.childrenAges.get(3).click();

    }

    @And("click on Apply button")
    public void clickOnApplyButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", bookingPage.applyButton);

        //Save the data of booking in public variables
        bookingPage.bookedRoomNumber=Integer.parseInt(bookingPage.roomNumberIndicator.getText().replaceAll("[^0-9]",""));
        bookingPage.bookedCustomerNumber=Integer.parseInt(bookingPage.customerNumberIndicator.getText().replaceAll("[^0-9]",""));
    }

    @And("click on searchOnHotels button")
    public void clickOnSearchOnHotelsButton() {
        bookingPage.searchOnHotelsButton.click();
    }

    @When("User select random destination")
    public void userSelectRandomDestination()
    {
        //open destination list
        bookingPage.destinationDropDownList.click();
        //select random destination from the list
        int options=bookingPage.mostVisitedDestinations.size();
        int randomOption=faker.random().nextInt(0,options);
        WebElement randomDestination=bookingPage.mostVisitedDestinations.get(randomOption);
        randomDestination.click();
    }
    @When("User select random arrival and Departure dates")
    public void userSelectRandomArrivalAndDepartureDates()
    {
        //open calender
        bookingPage.calender.click();

        //select random arrival date
        int numberOfRows=driver.findElements(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][1]//tbody[@class=\"ng-tns-c89-1\"]//tr")).size();
        int randomRow=faker.number().numberBetween(1,numberOfRows+1);
        int randomColumn=faker.number().numberBetween(1,8);
        WebElement arrivalDate=driver.findElement(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][1]//tbody[@class=\"ng-tns-c89-1\"]//tr["+randomRow+"]//td["+randomColumn+"]//span"));
        //check wether  date is disabled or not
        String elementClassValue=arrivalDate.getAttribute("class");
        String elementNotVisible="p-ripple p-element ng-tns-c89-1 p-disabled ng-star-inserted";
        while(elementClassValue.equals(elementNotVisible))
        {
            //select another random date
             randomRow=faker.number().numberBetween(1,numberOfRows+1);
             randomColumn=faker.number().numberBetween(1,8);
             arrivalDate=driver.findElement(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][1]//tbody[@class=\"ng-tns-c89-1\"]//tr["+randomRow+"]//td["+randomColumn+"]//span"));
             elementClassValue=arrivalDate.getAttribute("class");

        }
        arrivalDate.click();

        //select random Departure date
        numberOfRows=driver.findElements(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][2]//tbody[@class=\"ng-tns-c89-1\"]//tr")).size();
        randomRow=faker.number().numberBetween(1,numberOfRows+1);
        randomColumn=faker.number().numberBetween(1,8);
        WebElement departureDate=driver.findElement(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][2]//tbody[@class=\"ng-tns-c89-1\"]//tr["+randomRow+"]//td["+randomColumn+"]//span"));
        //check wether  date is disabled or not
        elementClassValue=departureDate.getAttribute("class");
        while(elementClassValue.equals(elementNotVisible))
        {
            //select another random date
            randomRow=faker.number().numberBetween(1,numberOfRows+1);
            randomColumn=faker.number().numberBetween(1,8);
            departureDate=driver.findElement(By.xpath("//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][2]//tbody[@class=\"ng-tns-c89-1\"]//tr["+randomRow+"]//td["+randomColumn+"]//span"));
            elementClassValue=departureDate.getAttribute("class");

        }
        departureDate.click();


        //Save the arrival and departure dates in a public var
        bookingPage.chosenArrivalDate=bookingPage.selectedArrivalDate.getText();
        bookingPage.chosenDepartureDate=bookingPage.selectedDepartureDate.getText();

    }

    @And("User open rooms dropdown menu")
    public void userOpenRoomsDropdownMenu() {
        bookingPage.roomsDropDown.click();
    }


    @And("User add another room with {int} child")
    public void userAddAnotherRoomWithChild(int childrenNumber) {
        bookingPage.addAnotherRoomButton.click();
        //add one child in the second room
        for (int i = 0; i <childrenNumber ; i++) {
            bookingPage.addChildButtons.get(1).click();
        }


    }

    @Then("check the number of the booked rooms")
    public void checkTheNumberOfTheBookedRooms() {
        int ActualBookedRooms= Integer.parseInt(bookingPage.roomNumberIndicator.getText().replaceAll("[^0-9]",""));
        softAssert.assertEquals(ActualBookedRooms,2,"booked room number isn't correct");

        softAssert.assertAll();

    }

    @When("User select {string}")
    public void UserSelect(String chosenDestination) throws InterruptedException {
        bookingPage.destinationEntryField.clear();
        bookingPage.destinationEntryField.sendKeys(chosenDestination);
        Thread.sleep(3000);
        int destinationNumbers=bookingPage.destinationNames.size();
        int i;
        for (i = 0; i <destinationNumbers ; i++) {
            String destinationName=bookingPage.destinationNames.get(i).getText();
            if(destinationName.contains(chosenDestination))
            {
                bookingPage.destinationNames.get(i).click();
                break;
            }
        }


    }
}
