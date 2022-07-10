import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyCorrectLogin extends BaseTests{
    @Test
    public void verifyCorrectLogin(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        HomePage homePage = loginPage.submitLoginCreds();
        String pageTitle = homePage.getPageTitle();

        Assert.assertEquals(pageTitle,"OrangeHRM");
    }
}
