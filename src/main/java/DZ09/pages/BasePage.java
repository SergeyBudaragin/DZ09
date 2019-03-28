package DZ09.pages;

import DZ09.Init;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;

public abstract class BasePage {

    /**
     * Метод проскролливающий до элемента и нажимающий на него
     *
     * @param element веб-элемент
     */
    public void click(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Init.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Метод заполняющий поле
     *
     * @param element поле
     * @param value   значение
     */

    public void fillTerm(WebElement element, String value) throws Exception {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(value);

        } catch (Exception e) {
            throw new Exception("Элемент не найден");
        }
    }

    /**
     * Метод заполняющий поле
     *
     * @param element поле
     * @param value   значение
     */

    public void fillField(WebElement element, String value) {
        scroll(element);
        element.sendKeys(value);    }


    /**
     * Метод нажимающий чек-бокс если он не выбран
     *
     * @param element веб-элемент
     */
    public void clickCheckBox(WebElement element, String set) {
        if (set.contains("Да")) {
            Wait<WebDriver> wait = new WebDriverWait(Init.getDriver(), 10, 1000);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }

    /**
     * Метод сравнивающий реальный и ожидаемый результаты строки
     *
     * @param expected ожидаемый результат
     * @param element  веб-элемент в котором ищем актуальный результат
     */
    public void assertPlus(String expected, WebElement element) {
        scroll(element);
        String actual = element.getText() ;
        assertEquals("Error instead of expected: " + expected + " found: " + actual, expected, actual);
        if (actual.contains(expected)) {
            System.out.println(expected + "  -  found");
        }
    }
    /**
     * Метод ожидающий видимости элемента
     *
     * @param element
     */
    public void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Метод сравнивающий реальный и ожидаемый результаты в цифрах
     *
     * @param expected ожидаемый результат
     * @param element  веб-элемент в котором ищем актуальный результат
     */
    public void assertPlusDigit(String expected, WebElement element) {
        scroll(element);
        waitElement(element);
        String actual = element.getText().replaceAll("%","");
        assertEquals("Error instead of expected: " + expected + " found: " + actual, expected, actual);
        if (actual.contains(expected)) {
            System.out.println(expected + "  -  found");
        }
    }

    /**
     * Метод проскролливающий до элемента
     *
     * @param element веб-элемент
     */
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Init.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}


