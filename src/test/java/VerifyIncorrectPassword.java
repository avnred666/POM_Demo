import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyIncorrectPassword extends BaseTests{

    @Test
    public void verifyIncorrectPassword(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin12$");
        loginPage.submitLoginCreds();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spanMessage")));
        WebElement errorMessage =  driver.findElement(By.id("spanMessage"));

        Assert.assertEquals(errorMessage.getText(),"Invalid credentials");
    }
}
