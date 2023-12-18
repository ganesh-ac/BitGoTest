package testcases.mytheresa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository.mytheresa.BitGoHomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BitGoTest1 {
	
@Test
public  void bitGoStep1(){

		BrowserSetting bs = new BrowserSetting();

		WebDriver driver = bs.BrowserSettings();
		BitGoHomePage bitGo = new BitGoHomePage(driver);
		//bitGo.bitGoTitle().getText();
		
	    String expectedTitle = "25 of 2875 Transactions";
        String originalTitle = bitGo.bitGoTitle().getText();
        Assert.assertEquals(originalTitle, expectedTitle);
        
        //TestCase2
        bitGo.outPutTextPath().getText();
        
        System.out.println(bitGo.outPutTextPath().getText());        

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  
            List<WebElement> transactions = bitGo.transctionsPath();

            
            for (int i = 0; i < Math.min(25, transactions.size()); i++) {
                transactions.get(i).click();

                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".txid")));
               
                int inputCount = driver.findElements(By.cssSelector(".vin")).size();
                		
                int outputCount = driver.findElements(By.cssSelector(".vout")).size();
                		

                //checking if input count is 1 and output count is 2
                if (inputCount == 1 && outputCount == 2) {
                  
                    String transactionHash = driver.findElement(By.cssSelector(".txid")).getText();
                    System.out.println("Transaction Hash: " + transactionHash);
                }

                // Go back to the main page
                driver.navigate().back();

            }

        } finally {
            
            driver.quit();
        }
    }
}