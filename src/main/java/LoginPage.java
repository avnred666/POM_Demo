import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (id = "txtUsername")
    private WebElement usernameInput;

    @FindBy(id = "txtPassword")
    private WebElement passwordInput;

    @FindBy(id= "btnLogin")
    private WebElement submitBtn;

    public void enterUsername (String username){
        usernameInput.sendKeys(username);
    }

    public void enterPassword (String password){
        passwordInput.sendKeys(password);
    }

    public HomePage submitLoginCreds(){
        submitBtn.click();
        return PageFactory.initElements(driver,HomePage.class);
    }


}
