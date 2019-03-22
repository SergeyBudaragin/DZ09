import DZ07.Init;
import DZ07.pages.Calc;
import DZ07.pages.InsuranceGoingAbroad;
import DZ07.pages.MainPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static String baseUrl;
    public static Properties properties = TestProperties.getINSTANCE().getProperties();

    @BeforeClass
    public static void testsSetup() {
        switch (properties.getProperty("browser")) {
            case "Chrome": {
                System.out.println("Выбран Chrome");
                System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
                Init.setDriver(new ChromeDriver());
                break;
            }
            case "Firefox": {
                System.out.println("Выбран Firefox");
                System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
                Init.setDriver(new FirefoxDriver());
                break;
            }
            case "IE": {
                System.out.println("Выбран IE");
                System.setProperty("webdriver.ie.driver", "drv/IEDriverServer.exe");
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

        MainPage mainPage = new MainPage();
        InsuranceGoingAbroad insuranceGoingAbroad = new InsuranceGoingAbroad();
        Calc calc = new Calc();

        //Выбор Страхования
        mainPage.click(mainPage.openInsuranceMenu);

        // Выбор пункта Страхование выезжающих за рубеж
        mainPage.click(mainPage.goingAbroad);

        // Нажатие кнопки рассчитат онйлан
        insuranceGoingAbroad.scrollAndClick(insuranceGoingAbroad.calcButton);

        // Сравнение текста в заголовке
        calc.waitElement(calc.pageHeader);
        calc.assertPlus("Страхование выезжающих за рубеж", calc.pageHeader);

        // Выбор нескольких поездок в течении года
        calc.scrollAndClick(calc.severalTripsButtob);
    }

    @AfterClass
    public static void close() {
        Init.getDriver().quit();
    }

}
