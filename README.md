# JAdmin

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/Java-21%2B-brightgreen)](https://openjdk.org/)

**JAdmin** — это фреймворк для автоматического создания административных панелей на основе JPA-сущностей для приложений Spring Boot. Вдохновлено Django Admin.

## Возможности

*   **Автоматическая генерация CRUD:** Просто добавьте аннотацию к вашей JPA-сущности — и интерфейс готов.
*   **Интеграция с Spring Boot:** Подключается как стартер за 2 минуты.
*   **Базовая аутентификация и авторизация.**
*   ... (остальное по мере реализации)

## Быстрый старт

1.  Добавьте зависимость в ваш `pom.xml`:
    ```xml
    <dependency>
        <groupId>io.github.yourusername</groupId>
        <artifactId>jadmin-spring-boot-starter</artifactId>
        <version>0.0.1</version>
    </dependency>
    ```
2.  Аннотируйте вашу сущность:
    ```java
    @JAdminEntity // Ваша кастомная аннотация
    @Entity
    public class User { ... }
    ```
3.  Запустите приложение и перейдите по адресу `/admin`.

## Документация

(Ссылка на будущий wiki или сайт)

## Лицензия

Этот проект распространяется под лицензией [Apache License 2.0](LICENSE).