# Nds-Verificatior
Приложение выполняющее запрос к SOAP API

## Описание
На вход приложению подается ИНН ЮЛ/ФЛ приложение возвращает один из возможных
вариантов признака состояния описанных в [документации](http://npchk.nalog.ru/ws2.doc)

***

**Запуск**

inn_number - число формата 12 цифр
```
java -jar target/nds-verification-0.0.1-SNAPSHOT.jar inn_number
```
