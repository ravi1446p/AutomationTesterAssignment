// public class Main {
    
// }



package assignment;
//To access the Webdriver classes and methods
import org.openqa.selenium.WebDriver;
//To access the ChromeBrowser
import org.openqa.selenium.chrome.ChromeDriver;
//To access the locators or object identification
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import common.Assert;

public class Ravi {
	public static void main (String args[]) throws Exception{
	             //TASK----1
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.navigate().to("https://fitpeo.com");
		Thread.sleep(3000);
		
		        //TASK----2
		 driver.findElement(By.linkText("/revenue-calculator")).click();
		 Thread.sleep(4000);
		
		        //TASK----3 SCROLL DOWN BY USING JSE CMD
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);
		         		
		        //TASK----4  adjust the slider value change into red color
		WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]/span[1]")); // Replace with the actual slider XPath
        jse.executeScript("arguments[0].style.backgroundColor = 'red'", slider);
		Thread.sleep(5000);
 
		       //TASK----5
        driver.findElement(By.id(":r0:")).click();
	jse = (JavascriptExecutor)driver;
	WebElement num = driver.findElement(By.xpath("//*[@id=\":r0:\"]"));
	jse.executeScript("arguments[0],value='560';, num");
	Thread.sleep(4000);
	
	           //TASK----6
	//Assert.assertEquals("560", slider);
	Assert.assertEquals("560", slider.getAttribute("value"));


	           //TASK----7 scroll down and select the check box
	JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	jse1.executeScript("window.scrollBy(0,400)");
	Thread.sleep(5000);
	
//Define the list of CPT codes
String[] cptCodes = {"99091", "99453", "99454", "99474"};

// Iterate through each CPT code
for (String code : cptCodes) {
    // Find the check box element using CSS selector
    WebElement checkbox = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/label/span[1]/input"));
    
    // Check if the check box is not already selected
    if (!checkbox.isSelected()) {
        // Click the check box to select it
        checkbox.click();
    	Thread.sleep(5000);

    }
}

         //TASK----8 ValidateTotalRecurringReimbursement
//Expected value
double expectedValue = 110700.00;

//Actual value from web page
double actualValue = Double.parseDouble(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[3]/p[2]")).getText().replace("$", ""));

//Validate
Assert.assertEquals(actualValue, expectedValue, 0.01);
Thread.sleep(5000);



        //TASK----9
// header element displaying Total Recurring Reimbursement
WebElement totalRecurringReimbursementHeader = driver.findElement(By.xpath("//header[@xpath='total_recurring_reimbursement_header_xpath']"));
Thread.sleep(4000);
//Get the text of the header element
String totalRecurringReimbursementHeaderText = totalRecurringReimbursementHeader.getText();
Thread.sleep(5000);
//Verify the header text displays the expected value
driver.assertEquals(totalRecurringReimbursementHeaderText, "$110,700.00");
Thread.sleep(5000);
    //it will close the current browser
    //driver.close();
//its will close all browsers open by webdriver instance
driver.quit();


		   
	}
}