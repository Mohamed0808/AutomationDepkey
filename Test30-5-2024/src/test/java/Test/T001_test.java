package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P001_test;

import java.time.Duration;

public class T001_test extends baseTest{

    SoftAssert soft=new SoftAssert();

    P001_test test;
    @Test
    public void KWT() throws InterruptedException {
        test=new P001_test(driver);
        test.departure();
        test.arrival();
        test.selectCheckInDate();
        test.selectCheckOutDate();
        test.passenger();
        test.levelOfClass();
        test.airPreferred();
        test.search();

    }
    @Test
    public void KWTDirectOnly() throws InterruptedException {
        test=new P001_test(driver);
        test.departure();
        test.arrival();
        test.selectCheckInDate();
        test.selectCheckOutDate();
        test.passenger();
        test.levelOfClass();
        test.airPreferred();
        test.directOnly();
        test.search();
    }
    @Test
    public void errorPopUpIfEmptyAllFields() throws InterruptedException {
        test=new P001_test(driver);

        Thread.sleep(2000);
        test.search();
        soft.assertEquals(driver.findElement(By.id("swal2-html-container")).getText(),"please Select Departure & Arrival");
    }
    @Test
    public void errorPopUpIfEmptyArrivalField() throws InterruptedException {
        test=new P001_test(driver);
        test.departure();
        test.search();
        soft.assertEquals(driver.findElement(By.id("swal2-html-container")).getText(),"please Select Departure & Arrival");
    }

    @Test
    public void errorPopUpIfEmptyDepartureField() throws InterruptedException {
        test=new P001_test(driver);
        test.arrival();
        test.search();
        soft.assertEquals(driver.findElement(By.id("swal2-html-container")).getText(),"please Select Departure & Arrival");
    }
}
