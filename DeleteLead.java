package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-inner']/span)[2]")).click();

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9009008080");

		driver.findElement(By.xpath("(//td[@class='x-btn-center']//button)[7]")).click();
		Thread.sleep(3000);
		//find the lead
		WebElement element1=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		//get id of the lead
		String str=element1.getText();
		element1.click();
		//click delete
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra'])[2]//a[4]")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input)[13]")).sendKeys(str);
		driver.findElement(By.xpath("(//td[@class='x-btn-center']//button)[7]")).click();
		Thread.sleep(3000);
		String str2=driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']/div")).getText();
		if(str2.equalsIgnoreCase("No records to display")) {
			System.out.println("id deleted");
		}
		else {
			System.out.println("id not deleted");
		}
		driver.close();
	}

}
