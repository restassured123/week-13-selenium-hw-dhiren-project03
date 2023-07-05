package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    /**
     * This method will get the text
     */

    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }

    /**
     * This method will select the option by visible value
     */

    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);

        /**
         * Mouse Hover
         */
    }

    public void mouseHover(By by, By by1, By by2) {
        WebElement text = driver.findElement(by);
        WebElement text1 = driver.findElement(by1);
        WebElement text2 = driver.findElement(by2);
        Actions actions = new Actions(driver);
        actions.moveToElement(text).moveToElement(text1).moveToElement(text2).click().build().perform();


    }

    public void mouseHover1(By by, By by1) {
        WebElement text = driver.findElement(by);
        WebElement text1 = driver.findElement(by1);
        Actions actions = new Actions(driver);
        actions.moveToElement(text).moveToElement(text1).click().build().perform();



    }
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
}