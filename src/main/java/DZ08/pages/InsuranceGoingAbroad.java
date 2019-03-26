package DZ08.pages;

import DZ08.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceGoingAbroad extends BasePage {

    // Кнопка рассчитать
    @FindBy(xpath = "//a[contains(text(),'Рассчитать')]")
    public WebElement calcButton;

    public InsuranceGoingAbroad() {
        PageFactory.initElements(Init.getDriver(), this);
    }
}
