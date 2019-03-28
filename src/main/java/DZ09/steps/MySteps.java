package DZ09.steps;

import DZ09.pages.Calculator;
import DZ09.pages.MainPage;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class MySteps {
    MainPage mainPage = new MainPage();
    Calculator calculator = new Calculator();


    @Когда("выбран калькулятор для вкладов")
    public void openCalculatorForDeposit() {
        mainPage.goToCalculator();
    }


    @Тогда("проверка текста в заголовке с \"(.*)\"")
    public void textEqual(String expected) {
        calculator.assertPlus(expected, calculator.pageHeader);
    }

    @Когда("Заполняются данные")
    public void doWithParam(DataTable param) throws Exception {
        Map<String, String> dataMap = param.asMap(String.class, String.class);

        // Ввод cуммы
        calculator.fillField(calculator.amountField, dataMap.get("Сумма вклада"));

        // Выбор срока вклада
        calculator.selectBoxTerm.click();
        calculator.fillTerm(calculator.selectBoxTermVisable, dataMap.get("Срок"));

        // Ввод cуммы ежемесяыного пополнения
        calculator.fillField(calculator.moneyAddField, dataMap.get("Ежемесячное пополнение"));

        // Нажатие чекбокса ежемячная капитализация
        calculator.clickCheckBox(calculator.capitalizationCheckBox, dataMap.get("Ежемесячная капитализация"));

        // Нажатие чекбокса частичное снятие
        calculator.clickCheckBox(calculator.partionCheckBox, dataMap.get("Частичное снятие"));

    }

    @Тогда("сравниваются значения")
    public void Assert(DataTable param) {
        Map<String, String> dataMap = param.asMap(String.class, String.class);

        calculator.assertPlusDigit(dataMap.get("Ставка"), calculator.rate);
        calculator.assertPlusDigit(dataMap.get("Начислено"), calculator.earned);
        calculator.assertPlusDigit(dataMap.get("Пополнение за период"), calculator.moneyAdded);
        calculator.assertPlusDigit(dataMap.get("К снятию"), calculator.moneyToWithdraw);

    }
}




