package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openingBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));
        // Click on Bags
        mouseHoverToElementAndClick(By.xpath("//span[normalize-space()='Bags']"));
        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        // Verify the text ‘Overnight Duffle’
        Assert.assertEquals("Overnight Duffle",getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]")));
        //* Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("3");
        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        //* Verify the text‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals("You added Overnight Duffle to your shopping cart.",getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        // Verify the product name ‘Overnight Duffle’
        Assert.assertEquals("Overnight Duffle",getTextFromElement(By.xpath("//td[@class='col item']//a[text()='Overnight Duffle']")));
       //Verify the Qty is ‘3’
        //Assert.assertEquals("3", getTextFromElement(By.xpath("//input[@title='Qty']"), "value"));
        // Verify the product price ‘$135.00’
        Assert.assertEquals("$135.00",
                getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]")));
        // Change Qty to ‘5’
        driver.findElement(By.xpath("(//input[@class='input-text qty'])[1]")).clear();
        sendTextToElement(By.xpath("(//input[@class='input-text qty'])[1]"), "5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        Thread.sleep(1000);
        // Verify the product price ‘$225.00’
        Assert.assertEquals("$225.00",
                getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]")));
    }

    @After
    public void tearDown() {
        closingBrowser();

    }
}
