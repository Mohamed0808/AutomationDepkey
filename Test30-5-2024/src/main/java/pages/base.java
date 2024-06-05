package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class base {
    protected WebDriver driver;
    public base(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void click(By by){
        driver.findElement(by).click();
    }
    public void click(WebElement element){
        element.click();
    }
    public void sendKeys(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public void sendKeys(WebElement element,String text){
        element.sendKeys(text);
    }
    public String getText(By by){
      return  driver.findElement(by).getText();
    }
    public String getText(WebElement element){
        return  element.getText();
    }
}
