package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        clickOnElement(By.partialLinkText("Sign In"));
        //Verify the text ‘Welcome Back!’
        WebElement welcome = driver.findElement(By.className("page__heading"));
        Assert.assertEquals("Wrong font style", "Welcome Back!", welcome.getText());

    }
    @Test
    public void verifyTheErrorMessage() {
        // click on the ‘Sign In’ link
        clickOnElement(By.partialLinkText("Sign In"));
        // Enter invalid username
        sendTexttoElement(By.id("user[email]"),"hey124@yahoo.com");
        //Enter invalid password
      sendTexttoElement(By.id("user[password]"),"hey45");
        //Click on Login button
       clickOnElement(By.xpath("//input[@value='Sign in']"));
        // Verify the error message ‘Invalid email
        WebElement invalidEmailOrPassword = driver.findElement(By.className("form-error__list-item"));
        Assert.assertEquals("Invalid Email and Password", "Invalid email or password.", invalidEmailOrPassword.getText());
    }
    @After
    public void tearDown() {
        closeBrowsers();
    }

}
