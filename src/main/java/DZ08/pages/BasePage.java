package DZ08.pages;

import DZ08.Init;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;

public abstract class BasePage {

    /**
     * Метод находящий кликающий на элемент
     *
     * @param element веб-элемент
     */
    public static void click(WebElement element) {
        element.click();
    }

    /**
     * Метод проскролливающий до элемента и нажимающий на него
     *
     * @param element веб-элемент
     */
    public static void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Init.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Метод проскролливающий до элемента
     *
     * @param element веб-элемент
     */
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Init.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Метод ожидающий видимости элемента
     *
     * @param element
     */
    public void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Метод заполняющий поле ввода
     *
     * @param element веб-элемент
     * @param text    текст для заполнения
     */
    public void fillForm(WebElement element, String text) {
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        element.sendKeys(text);
    }

    /**
     * Метод нажимающий чек-бокс если он не выбран
     *
     * @param element веб-элемент
     */
    public static void clickCheckBox(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Init.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        if (!element.isSelected()) {
            element.click();
        }
    }

    /**
     * Метод сравнивающий реальный и ожидаемый результаты
     *
     * @param expected ожидаемый результат
     * @param element  веб-элемент в котором ищем актуальный результат
     */
    public static void assertPlus(String expected, WebElement element) {
        scroll(element);
        String actual = element.getText();
        assertEquals("Error instead of expected: " + expected + " found: " + actual, expected, actual);
        if (actual.contains(expected)) {
            System.out.println(expected + "  -  found");
        }
    }

}
