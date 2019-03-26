package DZ08.pages;

import DZ08.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    //Выбор Страхования
    @FindBy(xpath = "//ol/li/a[contains(text(),'Страхование')]")
    public WebElement openInsuranceMenu;

    // Выбор пункта Страхование выезжающих за рубеж
    @FindBy(xpath = "//*[contains(text(),'Выезжающим')]")
    public WebElement goingAbroad;

    public MainPage() {
        PageFactory.initElements(Init.getDriver(), this);
    }

}
