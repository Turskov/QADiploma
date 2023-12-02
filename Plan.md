# План автоматизации тестирования сценариев покупки тура дебетовой и кредитной картами
## 1. Перечень автоматизируемых сценариев.
***
Валидные данные карты:
- Номер карты - 16 цифр
- Срок действия карты - месяц, год, дата не ранее текущей даты
- Фамилия и имя владельца - латинскими буквами
- Код cvc - 3 цифры

Номера карт: 7777 7777 7777 7777, 8888 8888 8888 8888
***

### Сценарий 1. Успешная оплата по дебетовой карте с валидными данными:
1. Нажать кнопку Купить
2. Ввести валидные данные дебетовой карты
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД появляются данные дебетовой карты с указанием успешной покупки, пользователь видит сообщение "Покупка совершена успешно".
***
### Сценарий 2. Неуспешная оплата по дебетовой карте с неверным номером карты:
1. Нажать кнопку Купить
2. Ввести неверный номер дебетовой карты
3. Ввести валидные данные дебетовой карты: срок действия карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Введены неверные данные карты".
***
### Сценарий 3. Неуспешная оплата по дебетовой карте с неверным сроком действия карты:
1. Нажать кнопку Купить
2. Ввести неверный срок действия дебетовой карты
3. Ввести валидные данные дебетовой карты: номер карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Введены неверные данные карты".
***
### Сценарий 4. Неуспешная оплата по дебетовой карте с неверными фамилией и именем владельца карты:
1. Нажать кнопку Купить
2. Ввести неверные фамилию и имя владельца дебетовой карты
3. Ввести валидные данные дебетовой карты: номер карты, срок действия, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Введены неверные данные карты".
***
### Сценарий 5. Неуспешная оплата по дебетовой карте с неверным кодом cvc карты:
1. Нажать кнопку Купить
2. Ввести неверный код cvc дебетовой карты
3. Ввести валидные данные дебетовой карты: номер карты, срок действия, фамилия и имя владельца
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Введены неверные данные карты".
***
### Сценарий 6. Неуспешная оплата по заблокированной дебетовой карте:
1. Нажать кнопку Купить
2. Ввести валидные данные заблокированной дебетовой карты
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Карта заблокирована".
***
### Сценарий 7. Неуспешная оплата по дебетовой карте, когда во время покупки отключился интернет:
1. Нажать кнопку Купить
2. Ввести валидные данные дебетовой карты
3. Нажать кнопку Оплатить
4. Отключить интернет

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Нет подключения к Интернету".
***
### Сценарий 8. Неуспешная оплата по дебетовой карте с номером карты менее 16 цифр:
1. Нажать кнопку Купить
2. Ввести номер дебетовой карты из 15 цифр
3. Ввести валидные данные дебетовой карты: срок действия карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 9. Неуспешная оплата по дебетовой карте со сроком действия карты с прошедшей датой:
1. Нажать кнопку Купить
2. Ввести срок действия дебетовой карты прошедшую дату
3. Ввести валидные данные дебетовой карты: номер карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 10. Неуспешная оплата по дебетовой карте со сроком действия карты с несуществующим месяцем:
1. Нажать кнопку Купить
2. Ввести срок действия дебетовой карты с месяцем, большим чем 12
3. Ввести валидные данные дебетовой карты: номер карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 11. Неуспешная оплата по дебетовой карте с фамилией и именем владельца карты русскими буквами:
1. Нажать кнопку Купить
2. Ввести фамилию и имя владельца дебетовой карты русскими буквами
3. Ввести валидные данные дебетовой карты: номер карты, срок действия, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 12. Неуспешная оплата по дебетовой карте с фамилией и именем владельца карты цифрами:
1. Нажать кнопку Купить
2. Ввести фамилию и имя владельца дебетовой карты цифрами
3. Ввести валидные данные дебетовой карты: номер карты, срок действия, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 13. Неуспешная оплата по дебетовой карте с фамилией и именем владельца карты спец.символами:
1. Нажать кнопку Купить
2. Ввести фамилию и имя владельца дебетовой карты спец.символами
3. Ввести валидные данные дебетовой карты: номер карты, срок действия, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 14. Неуспешная оплата по дебетовой карте с номером карты буквами:
1. Нажать кнопку Купить
2. Ввести номер дебетовой карты буквами
3. Ввести валидные данные дебетовой карты: срок действия карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 15. Неуспешная оплата по дебетовой карте с номером карты спец.символами:
1. Нажать кнопку Купить
2. Ввести номер дебетовой карты спец.символами
3. Ввести валидные данные дебетовой карты: срок действия карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 16. Неуспешная оплата по дебетовой карте с кодом cvc менее 3 цифр:
1. Нажать кнопку Купить
2. Ввести код cvc дебетовой карты менее 3 цифр
3. Ввести валидные данные дебетовой карты: номер карты, срок действия карты, фамилия и имя владельца
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 17. Неуспешная оплата по дебетовой карте с кодом cvc буквами:
1. Нажать кнопку Купить
2. Ввести код cvc дебетовой карты буквами
3. Ввести валидные данные дебетовой карты: номер карты, срок действия карты, фамилия и имя владельца
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 18. Неуспешная оплата по дебетовой карте с кодом cvc спец.символами:
1. Нажать кнопку Купить
2. Ввести код cvc дебетовой карты спец.символами
3. Ввести валидные данные дебетовой карты: номер карты, срок действия карты, фамилия и имя владельца
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 19. Неуспешная оплата по дебетовой карте с пустым полем номера карты:
1. Нажать кнопку Купить
2. Ввести валидные данные дебетовой карты: срок действия карты, фамилия и имя владельца, код cvc
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 20. Неуспешная оплата по дебетовой карте с пустым полем фамилия и имя владельца карты:
1. Нажать кнопку Купить
2. Ввести валидные данные дебетовой карты: номер карты, срок действия, код cvc
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 21. Неуспешная оплата по дебетовой карте с пустым полем кода cvc:
1. Нажать кнопку Купить
2. Ввести валидные данные дебетовой карты: номер карты, срок действия карты, фамилия и имя владельца
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 22. Успешная оплата по кредитной карте с валидными данными:
1. Нажать кнопку Купить в кредит
2. Ввести валидные данные кредитной карты
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД появляются данные кредитной карты с указанием успешной покупки, пользователь видит сообщение "Покупка совершена успешно".
***
### Сценарий 23. Неуспешная оплата по кредитной карте с неверным номером карты:
1. Нажать кнопку Купить в кредит
2. Ввести неверный номер кредитной карты
3. Ввести валидные данные кредитной карты: срок действия карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Введены неверные данные карты".
***
### Сценарий 24. Неуспешная оплата по кредитной карте с неверным сроком действия карты:
1. Нажать кнопку Купить в кредит
2. Ввести неверный срок действия кредитной карты
3. Ввести валидные данные кредитной карты: номер карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Введены неверные данные карты".
***
### Сценарий 25. Неуспешная оплата по кредитной карте с неверными фамилией и именем владельца карты:
1. Нажать кнопку Купить в кредит
2. Ввести неверные фамилию и имя владельца кредитной карты
3. Ввести валидные данные кредитной карты: номер карты, срок действия, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Введены неверные данные карты".
***
### Сценарий 26. Неуспешная оплата по кредитной карте с неверным кодом cvc карты:
1. Нажать кнопку Купить в кредит
2. Ввести неверный код cvc кредитной карты
3. Ввести валидные данные кредитной карты: номер карты, срок действия, фамилия и имя владельца
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Введены неверные данные карты".
***
### Сценарий 27. Неуспешная оплата по заблокированной кредитной карте:
1. Нажать кнопку Купить в кредит
2. Ввести валидные данные заблокированной кредитной карты
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Карта заблокирована".
***
### Сценарий 28. Неуспешная оплата по кредитной карте, когда баланс меньше суммы покупки:
1. Установить лимит кредитной карты 10 000 руб.
2. Нажать кнопку Купить в кредит
3. Ввести валидные данные кредитной карты
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, лимит остался 10 000 руб., пользователь видит сообщение "Превышен лимит средств".
***
### Сценарий 29. Неуспешная оплата по кредитной карте, когда во время покупки отключился интернет:
1. Нажать кнопку Купить в кредит
2. Ввести валидные данные кредитной карты
3. Нажать кнопку Оплатить
4. Отключить интернет

*Ожидаемый результат:* в БД не появилочь новых записей, покупка прервалась, пользователь видит сообщение "Нет подключения к Интернету".
***
### Сценарий 30. Неуспешная оплата по кредитной карте с номером карты менее 16 цифр:
1. Нажать кнопку Купить в кредит
2. Ввести номер кредитной карты из 15 цифр
3. Ввести валидные данные кредитной карты: срок действия карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 31. Неуспешная оплата по кредитной карте со сроком действия карты с прошедшей датой:
1. Нажать кнопку Купить в кредит
2. Ввести срок действия кредитной карты прошедшую дату
3. Ввести валидные данные кредитной карты: номер карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 32. Неуспешная оплата по кредитной карте со сроком действия карты с несуществующим месяцем:
1. Нажать кнопку Купить в кредит
2. Ввести срок действия кредитной карты с месяцем, большим чем 12
3. Ввести валидные данные кредитной карты: номер карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 33. Неуспешная оплата по кредитной карте с фамилией и именем владельца карты русскими буквами:
1. Нажать кнопку Купить в кредит
2. Ввести фамилию и имя владельца кредитной карты русскими буквами
3. Ввести валидные данные кредитной карты: номер карты, срок действия, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 34. Неуспешная оплата по кредитной карте с фамилией и именем владельца карты цифрами:
1. Нажать кнопку Купить в кредит
2. Ввести фамилию и имя владельца кредитной карты цифрами
3. Ввести валидные данные кредитной карты: номер карты, срок действия, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 35. Неуспешная оплата по кредитной карте с фамилией и именем владельца карты спец.символами:
1. Нажать кнопку Купить в кредит
2. Ввести фамилию и имя владельца кредитной карты спец.символами
3. Ввести валидные данные кредитной карты: номер карты, срок действия, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 36. Неуспешная оплата по кредитной карте с номером карты буквами:
1. Нажать кнопку Купить в кредит
2. Ввести номер кредитной карты буквами
3. Ввести валидные данные кредитной карты: срок действия карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 37. Неуспешная оплата по кредитной карте с номером карты спец.символами:
1. Нажать кнопку Купить в кредит
2. Ввести номер кредитной карты спец.символами
3. Ввести валидные данные кредитной карты: срок действия карты, фамилия и имя владельца, код cvc
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 38. Неуспешная оплата по кредитной карте с кодом cvc менее 3 цифр:
1. Нажать кнопку Купить в кредит
2. Ввести код cvc кредитной карты менее 3 цифр
3. Ввести валидные данные кредитной карты: номер карты, срок действия карты, фамилия и имя владельца
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 39. Неуспешная оплата по кредитной карте с кодом cvc буквами:
1. Нажать кнопку Купить в кредит
2. Ввести код cvc кредитной карты буквами
3. Ввести валидные данные кредитной карты: номер карты, срок действия карты, фамилия и имя владельца
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 40. Неуспешная оплата по кредитной карте с кодом cvc спец.символами:
1. Нажать кнопку Купить в кредит
2. Ввести код cvc кредитной карты спец.символами
3. Ввести валидные данные кредитной карты: номер карты, срок действия карты, фамилия и имя владельца
4. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 41. Неуспешная оплата по кредитной карте с пустым полем номера карты:
1. Нажать кнопку Купить в кредит
2. Ввести валидные данные кредитной карты: срок действия карты, фамилия и имя владельца, код cvc
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 42. Неуспешная оплата по кредитной карте с пустым полем фамилия и имя владельца карты:
1. Нажать кнопку Купить в кредит
2. Ввести валидные данные кредитной карты: номер карты, срок действия, код cvc
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, покупка прервалась, пользователь видит сообщение "Неверный формат данных".
***
### Сценарий 43. Неуспешная оплата по кредитной карте с пустым полем кода cvc:
1. Нажать кнопку Купить в кредит
2. Ввести валидные данные кредитной карты: номер карты, срок действия карты, фамилия и имя владельца
3. Нажать кнопку Оплатить

*Ожидаемый результат:* в БД не появилось новых записей, пользователь видит сообщение "Неверный формат данных".
***

Окружение:  
*Устройство:* Acer Swift 
*Операционная система:* Windows 11.  
*IDE:* IntelliJ IDEA 2023.2.1 (Community Edition).  
*Java:* OpenJDK 11.
***

## 2. Перечень используемых инструментов с обоснованием выбора.
***Java***. Java, как язык программирования с открытым исходным кодом, имеет ряд преимуществ. Одним из них является снижение затрат на разработку приложений. Кроме того, его открытый код позволяет разработчикам легко изменять язык и часто обновлять его. Плюс к этому, Java обладает простым для чтения синтаксисом, что упрощает разработку приложений для интернета и мобильных устройств.

***JUnit5***. Предлагает мгновенные и простые обновления, обработку исключений и параметризированные тесты.

***Gradle***. Gradle - это гибкий и высокопроизводительный инструмент для сборки с открытым исходным кодом.

***Git***. Git - это консольная утилита для отслеживания изменений файлов в проекте и ведения истории этих изменений. Она позволяет откатить проект до более ранней версии, сравнивать изменения, анализировать их и объединять изменения с другими пользователями в репозитории.

***Selenide***. Selenide - библиотека с открытым исходным кодом для создания коротких и стабильных пользовательских интерфейсов (UI). Идеально подходит для разработчиков, так как требует минимальных усилий для изучения.

***IntelliJ IDEA***. IntelliJ IDEA - ведущая среда разработки (IDE) для языков Java и Kotlin, которая помогает повысить производительность благодаря интеллектуальному автодополнению кода, надежным рефакторинговым действиям, быстрой навигации по коду и широкому набору встроенных инструментов для разработчиков. Она также поддерживает веб- и корпоративную разработку и обладает многими другими полезными функциями.

***Postman***. Это сервис для создания, тестирования, документирования, развертывания и поддержки API. Он позволяет создавать наборы запросов к любому API, применять различные окружения к ним, настраивать фиктивные серверы, писать автоматические тесты на JavaScript, анализировать и визуализировать результаты запросов.

***DBeaver***. Бесплатная система управления базами данных, которая позволяет создавать новые базы данных, изменять данные в существующих и выполнять SQL-запросы. Она совместима со многими популярными СУБД, включая MySQL и PostgreSQL.

## 3. Перечень и описание возможных рисков при автоматизации.
- высокие затраты времени, в следствие высокая стоимость;
- если приложение обновится, некоторые тесты не будут работать;
- если приложение упадёт, не будет возможности автоматизировать.

## 4. Интервальная оценка с учётом рисков в часах.
***Без учёта рисков:*** 48 часов  
***С учётом рисков:*** 60 часов

## 5. План сдачи работ.
Автотесты и результаты их прогона будут готовы к 28.11.2023.