package it.corso.selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShot {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	       WebDriver driver;
	        driver = new ChromeDriver();
	        // vai all'URL
	        
	        String[] web_urls = {
	        		
	        };
	        
	        for (int i = 11; i<=200; i++) {
//		        String url_web = "https://automationexercise.com/category_products/" + i;
		        String url_web = "https://picsum.photos/1024/768";
		        driver.get(url_web);
		        // chiama la funzione di acquisizione screenshot
		        String filename = "test" + i + ".png";
		        takeSnapShot(driver, "C:\\Users\\m.bogliaccino\\Pictures\\"+filename);
	        }
	        driver.quit();
	}
    /**
    * Questa funzione catturerà uno screenshot
    * @param webdriver
    * @param fileWithPath
    * @throws Exception
    */
    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        // converte l'oggetto del web driver in TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot)webdriver);
        // chiama il metodo getScreenshotAs per creare un file immagine
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        // sposta il file immagine nella nuova destinazione
        File DestFile = new File(fileWithPath);
        // copia il file nella destinazione
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
