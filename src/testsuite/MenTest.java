package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openingBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() {
        //Mouse Hover on Men Menu  //* Mouse Hover on Bottom //* Click on Pants
        mouseHover(By.xpath("//span[contains(text(),'Men')]"), By.xpath("//li[@class='level1 nav-3-2 category-item last parent ui-menu-item']//span[contains(text(),'Bottoms')]"), By.xpath("//li[@class='level2 nav-3-2-1 category-item first ui-menu-item']//span[contains(text(),'Pants')]"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHover1(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"), By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        mouseHover1(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"), By.xpath("//div[@id='option-label-color-93-item-49']"));
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHover1(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"), By.xpath("//button[@title='Add to Cart']//span[text()='Add to Cart']"));
        //* Verify the text You added Cronus Yoga Pant to your shopping cart.’
        String expected = "You added Cronus Yoga Pant to your shopping cart.";
        String actual = getTextFromElement(By.xpath("//div[contains(text(),'Cronus Yoga Pant ')]"));
        Assert.assertEquals(expected, actual);
        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //* Verify the text ‘Shopping Cart.’
        String expected1 = "Shopping Cart";
        String actual1 = getTextFromElement(By.xpath("//span[text()='Shopping Cart']"));
        Assert.assertEquals(expected1, actual1);
        //* Verify the product name ‘Cronus Yoga Pant’
        String actual2 = getTextFromElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]"));
        String expected2 = "Cronus Yoga Pant";
        Assert.assertEquals(expected2, actual2);
        //* Verify the product size ‘32’
        String actual3 = getTextFromElement(By.xpath("//dl[@class = 'item-options']"));
        String expected3 =  "Size\n" + "32\n" + "Color\n" + "Black";
        Assert.assertEquals(expected3, actual3);
    }
    @After
    public void tearDown() {

        closingBrowser();
    }

}
