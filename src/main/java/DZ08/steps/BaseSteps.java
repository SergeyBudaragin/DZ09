package DZ08.steps;

import DZ08.Init;
import DZ08.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static String baseUrl;
    public static Properties properties = TestProperties.getINSTANCE().getProperties();

    @Before
    public static void testsSetup() {
        switch (properties.getProperty("browser")) {
            case "Chrome": {
                System.out.println("Выбран Chrome");
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                Init.setDriver(new ChromeDriver());
                break;
            }
            case "Firefox": {
                System.out.println("Выбран Firefox");
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                Init.setDriver(new FirefoxDriver());
                break;
            }
            case "IE": {
                System.out.println("Выбран IE");
                System.setProperty("webdriver.ie.driver", properties.getProperty("webdriver.ie.driver"));
                Init.setDriver(new InternetExplorerDriver());
                break;
            }
            default: {
                System.out.println("Выбор браузера некорректен, запускаем в Chrome");
                System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
                Init.setDriver(new ChromeDriver());
                break;
            }
        }
        baseUrl = properties.getProperty("url");
        Init.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Init.getDriver().manage().window().maximize();
        Init.getDriver().get(baseUrl);

    }

    @After
    public static void close() {
        Init.getDriver().quit();
    }

}
