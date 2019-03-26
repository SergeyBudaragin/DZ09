package DZ08.steps;

import DZ08.pages.Calc;
import DZ08.pages.InsuranceGoingAbroad;
import DZ08.pages.MainPage;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class MySteps {
    MainPage mainPage = new MainPage();
    Calc calc = new Calc();
    InsuranceGoingAbroad insuranceGoingAbroad = new InsuranceGoingAbroad();


    @Когда("выбран раздел меню \"Cтрахование\"")
    public void menuInsurance() {
        mainPage.click(mainPage.openInsuranceMenu);
    }

    @Когда("выбран подраздел \"Выезжающим за рубеж\"")
    public void sudMenuGoingObroad() {
        mainPage.click(mainPage.goingAbroad);
    }

    @Тогда("проверка текста в заголовке с \"(.*)\"")
    public void textEqual(String string) {
        calc.waitElement(calc.pageHeader);
        calc.assertPlus(string, calc.pageHeader);
    }

    @Когда("нажата кнопка \"Рассчитать онлайн\"")
    public void buttonPress() {
        insuranceGoingAbroad.scrollAndClick(insuranceGoingAbroad.calcButton);
    }

    @Когда("нажата кнопка \"Несколько поездок в течении года\"")
    public void buttonPress1() {
        calc.scrollAndClick(calc.severalTripsButton);
    }

    @Когда("Заполняются данные")
    public void doWithParam(DataTable param) {
        Map<String, String> dataMap = param.asMap(String.class, String.class);

        // Ввод страны
        calc.scroll(calc.countriesField);
        calc.fillFormCountries(calc.countriesField, dataMap.get("Страна"));

        // Заполнение поля дата первой поездки
        calc.scroll(calc.firstDateField);
        calc.fillForm(calc.firstDateField, calc.dateGenerate());

        // Выбор времени нахождени не боле 90 дней
        calc.scrollAndClick(calc.noMore90Button);

        // Заполнение ФИО
        calc.scroll(calc.nameField);
        calc.fillFormName(calc.nameField, dataMap.get("Имя"));

        // Заполнение даты рождения
        calc.scroll(calc.birthdayField);
        calc.fillForm(calc.birthdayField, dataMap.get("Дата рождения"));

        // Чек-бокс планируется ли активный отдых
        if (dataMap.get("Активный отдых").contains("Да")) {
            calc.checkBoxActive(true, calc.activeSportCheckbox);
        } else calc.checkBoxActive(false, calc.activeSportCheckbox);
    }

    @Когда("нажат чек-бок на согласие на обработку персональных данных")
    public void checkBox() {
        calc.clickCheckBox(calc.agreeheckbox);
    }

    @Когда("нажата кнопка \"Рассчитать\"")
    public void calcuateButton() {
        calc.scrollAndClick(calc.calcuateButton);
    }

    @Тогда("сравниваются значения")
    public void Assert(DataTable param) {
        Map<String, String> dataMap = param.asMap(String.class, String.class);

        calc.assertPlus(dataMap.get("Условия страхования"), calc.insuranceTermsTextField);
        calc.assertPlus(dataMap.get("Территория действия"), calc.territoryTextField);
        calc.assertPlus(dataMap.get("Застрахованный имя"), calc.nameTextField);
        calc.assertPlus(dataMap.get("Застрахованный дата рождения"), calc.birthdayTextField);
        calc.assertPlus(dataMap.get("Активный отдых или спорт"), calc.activeSportIncludeTextField);
    }
}




