package DZ08.pages;

import DZ08.Init;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Calc extends BasePage {

    // Заголовок страницы
    @FindBy(xpath = "//*[contains(@class,'page-header')]/span")
    public WebElement pageHeader;

    // Кнопка несколько поездок
    @FindBy(xpath = "//*[contains(text(), 'Несколько')]")
    public WebElement severalTripsButton;

    // Поле ввода страны
    @FindBy(id = "Countries")
    public WebElement countriesField;

    // Поле ввода первой даты
    @FindBy(xpath = "//*[contains(@data-bind,'FirstD')]")
    public WebElement firstDateField;


    // Кнопкавремени нахождени не более 90 дней
    @FindBy(xpath = "//*[contains(text(), 'Не более 90')]")
    public WebElement noMore90Button;


    // Поле заполнения ФИО
    @FindBy(xpath = "//input[contains(@class,'form-control')][@data-test-name='FullName']")
    public WebElement nameField;

    // Поле заполнения даты рождения
    @FindBy(xpath = "//*[@data-test-name='BirthDate']")
    public WebElement birthdayField;

    // Чек-бокс планируется ли активный отдых
    @FindBy(xpath = "//div[contains(@data-bind,'active')]/div[contains(@class,'toggle')]")
    public WebElement activeSportCheckbox;

    // Чек-бокс согласиz на обработку персональных данных
    @FindBy(xpath = "//input[contains(@data-test-name , 'IsProcessingPersonalDataTo')]")
    public WebElement agreeheckbox;

    // Кнопка рассчитать
    @FindBy(xpath = "//*[@data-test-name='NextButton'][contains(@data-bind,'Misc.NextButton')]")
    public WebElement calcuateButton;

    //  Текст в поле условия страхования
    @FindBy(xpath = "//*[contains(@class,'summary-value')][contains(@data-bind,'Trips')]")
    public WebElement insuranceTermsTextField;

    //  Текст в поле территория страхования
    @FindBy(xpath = "//span/span/strong[contains(@data-bind, 'text: Name')]")
    public WebElement territoryTextField;

    //  Текст в поле застрахованный
    @FindBy(xpath = "//strong[contains(@data-bind, 'text: Last')]")
    public WebElement nameTextField;

    //  Текст в поле дата рождения
    @FindBy(xpath = "//strong[contains(@data-bind, 'text: Birth')]")
    public WebElement birthdayTextField;

    //  Текст в поле активный спорт
    @FindBy(xpath = "//div[contains(@data-bind, 'Актив')]/div[@class='summary-row']/span[@class='summary-value']/span")
    public WebElement activeSportIncludeTextField;


    public Calc() {
        PageFactory.initElements(Init.getDriver(), this);
    }

    /**
     * Метод генерирующий дату в промежутке от завтра до двух недель вперед
     *
     * @return сгенерированная дата
     */
    public String dateGenerate() {
        Random random = new Random();
        Long date = (new Date().getTime()) + ((random.nextInt(13) + 1) * 24 * 3600 * 1000);
        Date Date = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM y");
        return dateFormat.format(Date);

    }

    /**
     * Метод для заполнения фио
     *
     * @param element веб-элемент
     * @param name    фамилия и имя
     */
    public static void fillFormName(WebElement element, String name) {
        JavascriptExecutor jst = (JavascriptExecutor) Init.getDriver();
        jst.executeScript("arguments[1].value = arguments[0]; ", name, element);
        element.sendKeys(Keys.DOWN);
    }

    /**
     * Метод заполняющий поле ввода страны
     *
     * @param element
     * @param text    страна веб-элемент
     */
    public void fillFormCountries(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.DOWN, Keys.RETURN);
    }

    /**
     * Метод нажимающий чек-бокс активный спорт
     *
     * @param active  нужно ли установить чек-бокс
     * @param element веб-элемент
     */
    public static void checkBoxActive(boolean active, WebElement element) {
        if (active & element.getAttribute("class").contains("off")) {
            element.click();
        }
        if (!active & !element.getAttribute("class").contains("off")) {
            element.click();
        }

    }
}
