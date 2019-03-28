package DZ09.pages;

import DZ09.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    //Выбор калькулятора вкладов
    @FindBy(xpath = "//*[@href='/contributions/']//span[contains( text(), 'Калькулятор')]")
    public WebElement calculator;


    public void goToCalculator() {
        calculator.click();
    }
    public MainPage() {
        PageFactory.initElements(Init.getDriver(), this);
    }

}
