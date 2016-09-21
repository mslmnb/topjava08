# Онлайн проекта <a href="https://github.com/JavaWebinar/topjava08">Topjava</a>

### <a href="https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFT1NxdTFOQ1dvVnM">Материалы занятия (скачать все патчи можно через Download папки patch)</a>

## Коррекция: 
> добавил `setenv.sh` и `@Override`, пофиксил имя `DATE_TIME_FORMATTER`

- **Apply 0-correction.patch**

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW2

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFdDhnNHFMU2dKQzQ">HW2</a>
> Изменения в проекте:
  - В репозиториях по другому инстанциировал компараторы
  - Пернес обработку пустых дат  в `MealRestController.getBetween()`
  - Зарефакторил `<T extends Comparable<? super T>> TimeUtil.isBetween(T value, T start, T end)`. Дженерики означают, что мы принимаем экземпляры класса, который имплементит компаратор, который умеет сравнивать T или суперклассы от T
  
  - **Apply 1-HW2-repository.patch**

**Внимание: при удалении класса он остается скомпилированный у вас в target (и classpath). В этом случае (или вообще если непонятно почему проект глючит) сделайте в maven clean.**

- **Apply 2-HW2-meal-layers.patch**
- **Apply 3-HW2-optional-MealServlet.patch**
- **Apply 4-HW2-optional-filter.patch**
- **Apply 5-HW2-optional-select-user.patch**

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMGRVM0QyblJtNGc">Вопросы по API и слоям приложения</a>
- <a href="http://stackoverflow.com/questions/21554977/should-services-always-return-dtos-or-can-they-also-return-domain-models">Should services always return DTOs, or can they also return domain models?</a>
- <a href="http://stackoverflow.com/questions/31644131/spring-dto-dao-resource-entity-mapping-goes-in-which-application-layer-cont/35798539#35798539">Mapping Entity->DTO goes in which application layer: Controller or Service?</a>

## Занятие 3:
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFOU8wWlpPVE05STA">Коротко о жизненном цикле Spring контекста.</a>
- **Apply 6-bean-life-cycle.patch**
-  <a href="http://habrahabr.ru/post/222579/">Spring изнутри. Этапы инициализации контекста.</a>
-  Ресурсы:
   -  <a href="http://vk.com/javawebinar?z=video-58538268_169373158%2Fvideos-58538268">Евгений Борисов. Spring, часть 1</a>
   -  <a href="http://vk.com/javawebinar?z=video-58538268_169373162%2Fvideos-58538268">Евгений Борисов. Spring, часть 2</a>
   -  <a href="http://www.slideshare.net/taemonz/spring-framework-core-23721778">Презентация Spring framework core</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png)  4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFODlkU1B0QnNnSGs">Тестирование через JUnit.</a>
> **ВНИМАНИЕ: перед накаткой патча создайте каталог test (из корня проекта путь `\src\test`), иначе часть файлов попадет в `src\main`.**

-  **Apply 7-add-junit.patch**
-  Перенос mock реализации в test.
-  <a href="http://junit.org/">JUnit 4</a>
-  <a href="http://habrahabr.ru/post/120101/">Тестирование в Java. JUnit</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFai1veG9qaFZlZ2s">Spring Test</a>
- **Apply 8-add-spring-test.patch**
-  Интеграция Spring и JUnit.
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#testing">Spring Testing</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVlNYczhnSU9JdXc">Базы данных. Обзор NoSQL и Java persistence solution без ORM.</a>
-  <a href="https://ru.wikipedia.org/wiki/PostgreSQL">PostgreSQL</a>.
-  <a href="http://java-course.ru/begin/postgresql/">Установка PostgreSQL</a>.
-  <a href="http://alexander.holbreich.org/2013/03/nosql-or-rdbms/">NoSQL or RDBMS.</a> <a href="http://habrahabr.ru/post/77909/">Обзор NoSQL систем</a>. <a href="http://blog.nahurst.com/visual-guide-to-nosql-systems">CAP</a>
-  <a href="http://ru.wikipedia.org/wiki/Java_Database_Connectivity">JDBC</a>
-  Обзор Java persistence solution без ORM: <a href="http://commons.apache.org/proper/commons-dbutils/">commons-dbutils</a>,
            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html">Spring JdbcTemplate</a>,
            <a href="http://en.wikipedia.org/wiki/MyBatis">MyBatis</a>, <a href="http://www.jdbi.org/">JDBI</a>, <a href="http://www.jooq.org/">jOOQ</a>
- Основы:
  - <a href="https://ru.wikipedia.org/wiki/Реляционная_СУБД">Реляционная СУБД</a>
  - <a href="http://habrahabr.ru/post/103021/">Реляционные базы</a>
  - <a href="https://www.youtube.com/playlist?list=PLIU76b8Cjem5qdMQLXiIwGLTLyUHkTqi2">Уроки по JDBC</a>
  - <a href="http://postgresguide.com/">Postgres Guide</a>
  - <a href="http://www.postgresqltutorial.com">PostgreSQL Tutorial</a>
  - <a href="http://campus.codeschool.com/courses/try-sql">Try SQL</a>
  - <a href="http://java-course.ru/begin/database01/">Базы данных на Java</a>
  - <a href="http://java-course.ru/begin/database02/">Возможности JDBC — второй этап</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQWtHYU1qTDlMWVE">Настройка Database в IDEA.</a>
- **Apply 9-add-postgresql.patch**
-  <a href="http://habrahabr.ru/company/JetBrains/blog/204064/">Настройка Database в IDEA</a> и запуск SQL.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 8. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMGNWUXhaVzdlU0k">Скрипты инициализации базы. Spring Jdbc Template.</a>
- **Apply 10-populate-and-init-db.patch**
- **Apply 11-impl-JdbcUserRepository.patch**
-  Подключение <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html">Spring Jdbc</a>.
-  Конфигурирование DataSource. <a href="http://www.mkyong.com/spring/spring-propertyplaceholderconfigurer-example/">Property Placeholder</a>

>  **Проверьте, что в <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYThYOFNHbnNzd0E">контекст Spring проекта включены оба файла конфигурации</a>**.

-  Имплементация UserRepository через Spring Jdbc Template.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 9. <a href="https://drive.google.com/open?id=0B4dIHS3wRAhhQUJMMFU0VnRrUUE">Подготовка тестовых данных и тестирование UserService.</a>
- **Apply 12-test-UserService.patch**

> Изменение: обертку для сравнения инстансов при тестировании перенес в сам матчер (`ModelMatcher.Wrapper`). Он сравнивает инстансы по переданному как параметр компаратору. Класс из видео `UserTestData.TestUser` стал не нужен. 

-  Подготовка тестовых данных в UserServiceTest и ModelMatcher
-  Тестирование UserService.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 10. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVmZaSm9UMktXUnc">Логирование тестов.</a>
- **Apply 13-test-logging.patch**
- **Apply 14-fix-servlet.patch**
 
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 11. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNDlOQVpOWF82OTA">Ответы на Ваши вопросы</a>
-  Что такое REST?
-  Зачем нужна сортировка еды?
-  Можно ли обойтись без `MapSqlParameterSource`?
-  Как происходит работа с DB в тестах?
-  Как реализовывать RowMapper?
-  Мои комментарии: решения проблем разработчиком.
-  Нужен ли разработчику JavaScript?

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы
> Какая разница между @BeforeClass and @Before? 

`@BeforeClass` выполняется один раз после загрузки класса (поэтому метод может быть только статический), `@Before` перед каждым тестом. Не ленитесь сходить в исходники по Ctrl+Enter и почитать javadoc.

Дополнение: для чистоты экземпляр тестового класса пересоздается перед каждым тестом: http://stackoverflow.com/questions/6094081/junit-using-constructor-instead-of-before

> Тесты в классе в каком-то определенном порядке выполняются ("сверху вниз" например)?

Порядок по умолчанию неопределен, каждый тест должен быть автономен и не зависеть от других. См. также http://stackoverflow.com/questions/3693626/how-to-run-test-methods-in-specific-order-in-junit4 

> Обязательно ли разворачивать postgreSQL?

Желательно: хорошая и надежная DB:) Если совсем не хочется - можно работать со своей любимой RDBMS (поправить `initDB.sql`) или работать c heroku (креденшелы к нему есть в `postgres.properties`). На следующем уроке добавим HSQLDB, она не требует установки.

> Зачем начали индексацию с 100000?

Тут уже нет "как принято". Так удобно вставлять в базу (если будет потребность) записи вручную , не мешая счетчику.

> Разве не должно быть у каждой роли примари кей id и форин кей user_id ?

Отношение user <-> roles многие ко многим, делается это через таблицу-связку USER_ROLES. Но отдельной таблицы ROLES у нас нет, мы храним значение роли прямо в таблице-связке USER_ROLES. "Примари кей" тут не нужны. Есть еще варианты использовать тип enum у Postgres или хранить там `INTEGER` как `Roles.ordinal()`. При этом нельзя будет менять порядок в enum Role и добавлять новые роли можно будет только в конец: http://stackoverflow.com/questions/6789342/jpa-enum-ordinal-vs-string

> Из 5-го видео - "Логика в базе - большое зло". Можно чуть поподробней об этом?

- Есть успешные проекты с логикой в базе. Те все относительно.
- Логика в базе - это процедуры и триггеры. Нет никакого ООП, переиспользовать код достаточно сложно, никагого рефакторинга, поиска по коду и других плюшек IDE. Нельзя делать всякие вещи типа кэширования, хранения в сесии - это все для логики на стороне java. Например json можно напрямую отдать в процедуру и там парсить и вставлять в таблицы или наоборот - собирать из таблиц и возвращать.
А затем потребуется некоторая логика на стороне приложения и все равно придется этот json дополнительно разпарсивать в java.
Я на таком проекте делал специальную миграцию, чтобы процедуры мигрировать не как sql скрипты, а каждую процедуру хранить как класс с историей изменений. Если логика: триггеры и простые процедуры записи-чтения, которые не требуют переиспользования кода или
проект небольшой это допустимо, иначе проект становится очень трудно поддерживать.

> У JUnit есть ассерты и у спринга тоже. Можно ли обойтись без JUnit?

Предусловия и JUnit-тесты совершенно разные вещи. Один другого не заменит, у нас будут предусловия в следующем уроке.

> Я так понял VARCHAR быстрее, чем TEXT, когда мы работаем с небольшими записями. Наши записи будут небольшими (255). Почему вы приняли решение перейти на TEXT?

В отличие от MySql в Postgres  VARCHAR и TEXT - тоже самое: http://stackoverflow.com/questions/4848964/postgresql-difference-between-text-and-varchar-character-varying

> Зачем при создании таблицы мы создаем `CREATE UNIQUE INDEX` и `CREATE INDEX`. При каких запросах он будет использоваться?

UNIQUE индекс нужен для обеcпечения уникальности, DB не даст сделать одинаковый индекс. Индексы используется для скорости выполнения запросов. Обычно они задействуются, когда в запросе есть условия, на которые сделан индекс. Узнать по конкретному запросу можно  запросив план запроса: см. <a href="https://habrahabr.ru/post/203320">Оптимизация запросов. Основы EXPLAIN в PostgreSQL</a>. На измерение производительности с индексами посмотрим в следующем уроке.

> А это нормально, что у нас в базе у meals есть userId, а в классе - нет?

Что значит - "нормально"? Приложение работает. Ненормально, когда в приложении есть "лишний" код, который не используется. Для ORM он нам понадобится- мы ссылку на User добавим.

> Почему мы использует 1 БД sequence на разные сущности?

Мы будем использовать Hibernate, по умолчанию он делает глобальный sequence на все таблицы. В этом подходе есть <a href="http://stackoverflow.com/questions/1536479/asking-for-opinions-one-sequence-for-all-tables">как плюсы, так и минусы</a>, из плюсов - удобно делать ссылки в коде и в таблицах на при наследовании и мапы в коде. В дополнение: <a href="http://stackoverflow.com/questions/6633384/can-i-configure-hibernate-to-create-separate-sequence-for-each-table-by-default">Configure Hibernate to create separate sequence for each table by default</a>.

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW03
- Понять, почему перестали работать `SpringMain/InMemoryAdminRestControllerTest/ InMemoryAdminRestControllerSpringTest`
- Дополнить скрипты создания и инициализации базы таблицой MEALS. Запустить скрипты на вашу базу (через Run). Порядок таблиц при DROP и DELETE важен, если они связаны fk. Проверьте, что ваши скрипты работают
- Реализовать через Spring JDBC Template `JdbcMealRepositoryImpl`
  - сделать каждый метод за один SQL запрос
  - `userId` в класс `Meal` вставлять НЕ надо (для UI и REST это лишние данные, userId это id залогиненного пользователя)
  - `JbdcTemplate` работает через сеттеры. Вместе с конструктором по умолчанию их нужно добавить в `Meal` 
  - Cписок еды должен быть отсортирован (тогда мы его сможем сравнивать с тестовыми данными). Кроме того это требуется для UI и API: последняя еда наверху.
- Проверить работу MealServlet, запустив приложение

#### Optional

- Сделать тестовые данные `MealTestData`, АНАЛОГИЧНЫЕ пропопулированным в `populateDB.sql`. Тестовый класс-обертка к `Meal` не требуется, сравниваем данные через готовый MATCHER (по умолчанию)
- Сделать `MealServiceTest` из `MealService` (`Ctrl+Shift+T` и выбрать JUnit4) и реализовать тесты.
- Сделать тесты на чужих юзеров (delete, get, update) с тем чтобы получить `NotFoundException` и тесты на `update` чужой еды.
- Предложить решение, как почнинить `SpringMain/ InMemory*Test`. `InMemory*Test` предполагает использовать нашу реализацию репозитория в памяти
- Сделать индексы к таблице `Meals`.
- <a href="http://stackoverflow.com/questions/970562/postgres-and-indexes-on-foreign-keys-and-primary-keys">Postgres and Indexes on Foreign Keys and Primary Keys</a>
- <a href="http://postgresguide.com/performance/indexes.html">Postgres Guide: Indexes</a>