package objectRepository.mytheresa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BitGoHomePage {

	WebDriver driver;

	@FindBy(xpath = "//h3[text()='25 of 2875 Transactions']")
	WebElement bitgo_title;

	@FindBy(css = ".vout")
	WebElement outputCount;
	
	@FindBy(xpath="(//div[@class='txn']//a)[2]")
	WebElement outPut;
	
	@FindBy(css=".transaction-link")
	List<WebElement> transctions;
	
	@FindBy(css=".vin")
	WebElement inputCount;

	// constructor method
	public BitGoHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement bitGoTitle() {
		return bitgo_title;
	}

	public WebElement outPutTextPath() {
		return outPut;
	}
	
	public List<WebElement> transctionsPath() {
		return transctions;
	}
    		

}
