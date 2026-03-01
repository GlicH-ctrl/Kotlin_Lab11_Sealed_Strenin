# Лабораторная работа №9-10: Продвинутое ООП на Kotlin

**ФИО:** Стренин Денис Олегович  
**Группа:** ИСП-231  
**Дата:** 27 февраля 2026 года

## Описание
Лабораторная работа посвящена изучению продвинутых концепций объектно-ориентированного программирования в Kotlin:
- Геттеры и сеттеры
- Инкапсуляция
- Data-классы
- Абстрактные классы
- Интерфейсы

## Структура проекта
src/
├── actions/ # Интерфейсы действий
├── characters/ # Персонажи и герои
├── example/ # Примеры для изучения
├── modules/ # Модули аванпоста
├── resources/ # Ресурсы и управление ими
└── Main.kt # Главный файл программы


## Примеры

### Геттеры и сеттеры
```kotlin
class Hero(val name: String) {
    var health: Int = 100
        set(value) {
            field = value.coerceIn(0, 100)
        }
}

data class OutpostResource(val id: Int, val name: String, var amount: Int)

abstract class OutpostModule(val name: String, var level: Int = 1) {
    abstract fun performAction(manager: ResourceManager)
}

interface ModuleAction {
    fun execute(manager: ResourceManager)
}
```