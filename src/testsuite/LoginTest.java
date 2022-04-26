package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldNavigateToLoginPageSuccessfully(){
        clickOnElement(By.linkText("Sign In"));
        String expectedMessage = "Welcome Back!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome Back!']"));
        Assert.assertEquals("Welcome Back! text is not displayed",expectedMessage , actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        clickOnElement(By.linkText("Sign In"));
        sendTextToElement(By.xpath("//input[@id='user[email]']"),"ab@gmil.com");
        sendTextToElement(By.xpath("//input[@id='user[password]']"),"anand");
        clickOnElement(By.xpath("//input[@value='Sign in']"));
        String expectedMessage = "Invalid email or password.";
        String actualMessage = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        Assert.assertEquals("Error message text is not displayed",expectedMessage , actualMessage);
    }

    @After
    public void closeBrowser(){
    }
}


