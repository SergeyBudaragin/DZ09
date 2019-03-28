package DZ09.pages;

import DZ09.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Calculator extends BasePage {

    // Заголовок страницы
    @FindBy(xpath = "//*[contains(@id, 'section_1')]//div/h2")
    public WebElement pageHeader;

    //Поле суммы вклада
    @FindBy(xpath = "//*[contains(@name, 'amount')]")
    public WebElement amountField;

    //Список сроков вклада
    @FindBy(xpath = "//*[contains(@class,'jq-selectbox__trigger')]")
    public WebElement selectBoxTerm;

    //Список сроков вклада после нажатия
    @FindBy(xpath = "//select[contains(@class, 'calculator__slide-input js-slide-value')]")
    public WebElement selectBoxTermVisable;

    //Поле суммы пополнения вклада
    @FindBy(xpath = "//*[contains(@name,'replenish')]")
    public WebElement moneyAddField;

    //Чекбокс капитализации
    @FindBy(xpath = "//*[contains(@name,'cap')]//parent::div")
    public WebElement capitalizationCheckBox;

    //Чекбокс частичного снятия
    @FindBy(xpath = "//*[contains(@name,'parti')]//parent::div")
    public WebElement partionCheckBox;

    //Cтавкa
    @FindBy(xpath = "//*[contains(@class,'rate')]")
    public WebElement rate;

    //Начислено
    @FindBy(xpath = "//span[contains(@class,'earned')]")
    public WebElement earned;

    //Пополнение
    @FindBy(xpath = "//*[contains(@class,'reple')]")
    public WebElement moneyAdded;

    //К снятию
    @FindBy(xpath = "//*[@class=\"js-calc-result\"]")
    public WebElement moneyToWithdraw;

    public Calculator() {
        PageFactory.initElements(Init.getDriver(), this);
    }
}

