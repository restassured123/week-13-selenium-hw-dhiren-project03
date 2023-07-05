package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setUp() {
        openingBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //* Mouse Hover on Women Menu//* Mouse Hover on Tops//* Click on Jackets
        mouseHover(By.xpath("//span[contains(text(),'Women')]"), By.xpath("//a[@id='ui-id-9']"), By.xpath("//span[text()='Jackets']"));
        selectByValueFromDropDown(By.id("sorter"), "name");

        List<WebElement> items = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']/a"));

        //verify  order
        boolean isOrdered = true;
        for (int i = 0; i < items.size() - 1; i++) {
            String currentElement = items.get(i).getText();
            String nextElement = items.get(i + 1).getText();
            if (currentElement.compareTo(nextElement) > 0) {
                isOrdered = false;
                break;
            }
        }

        if (isOrdered == true) {
            System.out.println("Elements are oredered by ProductName");
        } else {
            System.out.println("Elements are not in order.");
        }
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //* Mouse Hover on Women Menu//* Mouse Hover on Tops//* Click on Jackets
        mouseHover(By.xpath("//span[contains(text(),'Women')]"), By.xpath("//a[@id='ui-id-9']"), By.xpath("//span[text()='Jackets']"));
        selectByValueFromDropDown(By.id("sorter"), "price");

        List<WebElement> prices = driver.findElements(By.xpath("//span[@class = 'normal-price']//span[@class = 'price']"));
        List<Double> doublePrice = new ArrayList<>();
        for(WebElement element : prices){
            String priceText = element.getText().replace("$","");
            Double priceValue = Double.parseDouble(priceText);
            doublePrice.add(priceValue);
        }

        Boolean isSorted = true;
        for(int i = 0;i<doublePrice.size()-1;i++){
            if(doublePrice.get(i) > doublePrice.get(i+1)){
                isSorted = false;
                break;
            }
        }

        if(isSorted){
            System.out.println("Products price sorted in low to high.");
        }else {
            System.out.println("Products price not sorted.");
        }

    }

    @After
    public void tearDown() {

        closingBrowser();


    }
}


