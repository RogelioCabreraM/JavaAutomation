package org.example;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        WebDriver driver;
        By loginTxt = By.name("username");
        By passwordTxt = By.name("password");
        By loginBtn = By.tagName("button");

        @BeforeTest
        public void setUp(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        }

        @Test
        public void testLogin () throws InterruptedException{

            Thread.sleep(2000);
            WebElement loginWebElement = driver.findElement(loginTxt);
            loginWebElement.sendKeys("Admin");
            WebElement passwordWebElement = driver.findElement(passwordTxt);
            passwordWebElement.sendKeys("admin123");
            WebElement loginBtnWebElement = driver.findElement(loginBtn);
            loginBtnWebElement.click();
            Thread.sleep(10000);
            String actualResult = driver.findElement(By.tagName("h6")).getText();
            String expectedResult = "Dashboard";
            Assert.assertEquals(actualResult, expectedResult);


        }

        public static void main(String[] args) {
            Main miprueba = new Main();
            miprueba.setUp();

            try{
                miprueba.testLogin();
            }catch(InterruptedException e){
                e.printStackTrace();
            }



    }
}