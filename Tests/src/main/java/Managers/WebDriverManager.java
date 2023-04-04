package Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    public WebDriverManager(String webDriverType) {
        this.webDriverType = webDriverType;
    }

    private WebDriver driver;

    private String webDriverType;

    private WebDriver createDriver() {
        switch (webDriverType) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;

            default:
                System.out.println("Invalid input");
        }
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }

        return driver;

    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            System.out.println("CLose driver");
        }
    }

}