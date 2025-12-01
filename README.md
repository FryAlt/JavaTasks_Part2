# Задания по Программной инженерии на языке Java (часть 2)

## Студент

**ФИО:** Власов Данила Игоревич

**Группа:** АУБПоз-23

<h2><a href="https://drive.google.com/file/d/1vn0yKfdKDfvVHF0zYCClvu_EH6I7htdg/view?usp=sharing">Демонстрационное видео проекта</a></h2>

## Структура Базы Данных

<a href="https://drive.google.com/uc?export=view&id=1g74LX3yXnmBAU7GK8UaSLRjto9gA83k8"><img src="https://drive.google.com/uc?export=view&id=1g74LX3yXnmBAU7GK8UaSLRjto9gA83k8" style="width: auto; max-width: 100%; height: auto" title="ERD"/>

>В поле password у сущности users храниться hash пароля

## Функционал по заданиям
### Задание 1:
- Реализованы сущности ([@Entity](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/java/com/javaspring/Tasks14/library/entity))
- Реализованы репозитории ([JpaRepository](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/java/com/javaspring/Tasks14/library/repository))
- Реализованы сервисы ([@Service](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/java/com/javaspring/Tasks14/library/service))
- Реализована Главная страница ([index.html](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/index.html), [@GetMapping("/")](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/java/com/javaspring/Tasks14/library/controller/HomeController.java))
### Задание 2:
- Реализованы страницы для просмотра списков всех записей сущностей ([/authors](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/authors/list.html) и [/books](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/books/list.html))
- Реализованы страницы для просмотра конкретной записи (`/authors/{id}`, `/books/{id}`)
### Задание 3:
- Настроена Spring Security ([SecurityConfig](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/java/com/javaspring/Tasks14/library/config/SecurityConfig.java))
- Реализована регистрация и вход ([/login](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/login.html), [/register](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/register.html))
- Хранение паролей — через PasswordEncoder
- Сохранение авторизированного пользователя
### Задание 4:
- Реализован функционал администратора CRUD:
  - добавление записей ([/authors/create](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/authors/create.html), [/books/create](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/books/create.html));
  - просмотр записей ([/authors/view](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/authors/view.html), [/books/view](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/books/view.html));
  - редактирование записей ([/authors/edit](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/authors/edit.html), [/books/edit](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/templates/books/edit.html));
  - удаление записей.
- Реализован минимальный CSS стиль ([styles.css](https://github.com/FryAlt/JavaTasks_Part2/blob/main/src/main/resources/static/css/styles.css))