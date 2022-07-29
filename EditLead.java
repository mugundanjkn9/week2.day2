package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElement(By.xpath("(//div[@class='x-form-element'])[19]/input")).sendKeys("Priya");
		driver.findElement(By.xpath("(//div[@class='x-form-element'])[20]/input")).sendKeys("Vaidy");
		driver.findElement(By.xpath("(//td[@class='x-btn-center'])[7]//button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Verified title");
		}
		else {
			System.out.println("title not found");
		}
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra'])[2]//a[3]")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TATA");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		WebElement element1=driver.findElement(By.id("viewLead_companyName_sp"));
		String text=element1.getText();
		if(text.contains("TATA")) {
			System.out.println("updated successfully");
		}
		else {
			System.out.println("not updated");
		}
	}

}
