package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleccionTest{
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty ("webdriver.chrome.driver","Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
}
	@Test
	public void seleccionDresses() {
		driver.findElement(By.linkText("DRESSES")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Summer Dresses")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String sectionTitle = driver.findElement(By.xpath(("//span[@class='cat-name']"))).getText();
		Assert.assertEquals(sectionTitle, "SUMMER DRESSES ");	
		driver.findElement(By.linkText("Printed Summer Dress")).click();
		driver.findElement(By.id("color_14")).click();
}
	@Test
		public void seleccionWomen() {
			driver.findElement(By.linkText("WOMEN")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Tops")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String sectionTitle = driver.findElement(By.xpath("//span[@class='cat-name']")).getText();
			Assert.assertEquals(sectionTitle, "TOPS ");
			driver.findElement(By.linkText("Blouse")).click();
			driver.findElement(By.id("color_8")).click();
}		
	@Test
	public void seleccionDropdowns() {
		driver.findElement(By.linkText("T-SHIRTS")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select order = new Select(driver.findElement(By.id("selectProductSort")));
		order.selectByVisibleText("Price: Lowest first");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select order1 = new Select(driver.findElement(By.id("selectProductSort")));
		order1.selectByVisibleText("Price: Highest first");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select order2 = new Select(driver.findElement(By.id("selectProductSort")));
		order2.selectByVisibleText("Product Name: A to Z");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select order3 = new Select(driver.findElement(By.id("selectProductSort")));
		order3.selectByVisibleText("Product Name: Z to A");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select order4 = new Select(driver.findElement(By.id("selectProductSort")));
		order4.selectByVisibleText("In stock");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select order5 = new Select(driver.findElement(By.id("selectProductSort")));
		order5.selectByVisibleText("Reference: Lowest first");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select order6 = new Select(driver.findElement(By.id("selectProductSort")));
		order6.selectByVisibleText("Reference: Highest first");
}

}