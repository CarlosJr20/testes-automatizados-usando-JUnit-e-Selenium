package br.com.testautomacao;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class testeWeb {
	
	String url;
	WebDriver driver;

	@Before
	public void start() {
		
		url = "https://www.saucedemo.com";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\webca\\OneDrive\\Documentos\\UNICAP\\ENGENHARIA DE SOFTWARE\\chromedrive.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void end() {

		driver.close();
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
	driver.get(url);
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Bolt T-Shirt"));
	Assert.assertFalse("Título da página corresponde o esperado", driver.getTitle().contentEquals("Desenvolvimento Web - Personaltech"));
	Assert.assertEquals(driver.getPageSource().contains("$29.99"), "$29.99");
	
	Thread.sleep(5000);
	
	
	}
	
}
