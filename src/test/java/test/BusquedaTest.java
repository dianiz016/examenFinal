package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BusquedaTest{
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
	public void searchWithResult () {

		driver.findElement(By.id("search_query_top")).sendKeys("Dresses");
		driver.findElement(By.name("submit_search")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath(("//span[@class ='lighter']"))).getText().contains("DRESSES"));
}
	@Test
	public void searchWithNoResult () {
		driver.findElement(By.id("search_query_top")).sendKeys("sadysyad");
		driver.findElement(By.name("submit_search")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String noElements = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
		Assert.assertTrue(noElements.contains("sadysyad"));
}
	@Test
	public void auteticacionErronea() {
	driver.findElement(By.linkText("Sign in")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("email")).sendKeys("dianiz2003@gmail.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("passwd")).sendKeys("123456");
	driver.findElement(By.name("SubmitLogin")).click();
}
}