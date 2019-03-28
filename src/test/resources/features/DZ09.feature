#language: ru

Функционал: Cucumber

  @all
  Структура сценария: Rencredit Test

    * выбран калькулятор для вкладов
    * проверка текста в заголовке с "Рассчитайте доходность по вкладу"
    * Заполняются данные
      | Сумма вклада              | <amount>          |
      | Срок                      | <term>            |
      | Ежемесячное пополнение    | <monthly add>     |
      | Ежемесячная капитализация | <monthly capital> |
      | Частичное снятие          | <partial>         |
    * сравниваются значения
#       Поле в котором ищем     Искомое значение
      | Ставка               | <rate>              |
      | Начислено            | <earned>            |
      | Пополнение за период | <money added>       |
      | К снятию             | <money to withdraw> |


    Примеры:
      | amount    | term      | monthly add | monthly capital | partial | rate | earned     | money added | money to withdraw |
      | 3 500 000 | 9 месяцев | 65000       | Да              | Нет     | 6.75 | 192 566,75 | 520 000     | 4 212 566,75      |
      | 2 000 000 | 6 месяцев | 30000       | Да              | Да      | 6.50 | 67 772,63  | 150 000     | 2 217 772,63      |



