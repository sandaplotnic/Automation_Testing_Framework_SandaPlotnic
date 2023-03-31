import Managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager webDriverManager = new WebDriverManager("CHROME");

        webDriverManager.getDriver().get("https://demo.opencart.com/");
        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();
        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver());
        registerPage.fillInTheRegisterForm("Sanda", "Plotnic", "sanda.plotnic@yahoo.com","1245");
        Thread.sleep(3000);

        webDriverManager.getDriver().close();
    }
}