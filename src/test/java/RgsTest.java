import DZ07.pages.Calc;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class RgsTest extends BaseTest {

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"PETR PETROV", "07081987", false, "Швеция"},
                {"NIKOVAI NIKOLAEV", "10102000", false, "Греция"},
                {"IVAN IVANOV", "11121998", true, "Испания"}});
    }

    @Parameterized.Parameter
    public String name;
    @Parameterized.Parameter(1)
    public String birthday;
    @Parameterized.Parameter(2)
    public boolean active;
    @Parameterized.Parameter(3)
    public String country;

    @Test
    public void rgsTest() {
        Calc calc = new Calc();

        // Ввод страны
        calc.scroll(calc.countriesField);
        calc.fillFormCountries(calc.countriesField,country);

        // Заполнение поля дата первой поездки
        calc.scroll(calc.firstDateField);
        calc.fillForm(calc.firstDateField, calc.dateGenerate());

        // Выбор времени нахождени не боле 90 дней
        calc.scrollAndClick(calc.noMore90Button);

        // Заполнение ФИО
        calc.scroll(calc.nameField);
        calc.fillFormName(calc.nameField,name);

        // Заполнение даты рождения
        calc.scroll(calc.birthdayField);
        calc.fillForm(calc.birthdayField, birthday);

        // Чек-бокс планируется ли активный отдых
        calc.checkBoxActive(active, calc.activeSportCheckbox);

        // Чек-бокс согласие на обработку персональных данных
        calc.clickCheckBox(calc.agreeheckbox);
    }

    @AfterClass
    public static void check() {
        Calc calc = new Calc();

        // Нажатие кнопки рассчитать
        calc.scrollAndClick(calc.calcuateButton);

        //Проверка значений
        calc.assertPlus("Многократные поездки в течение года",calc.insuranceTermsTextField);
        calc.assertPlus("Шенген",calc.territoryTextField);
        calc.assertPlus("IVAN IVANOV",calc.nameTextField);
        calc.assertPlus("11.12.1998",calc.birthdayTextField);
        calc.assertPlus("Включен",calc.activeSportIncludeTextField);

    }
}

