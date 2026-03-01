# Лабораторная работа №11. Sealed-классы и моделирование состояний

**ФИО:** Стренин Денис Олегович  
**Группа:** ИСП-231  
**Дата:** 1 марта 2026 года  

## Описание

В данной лабораторной работе изучаются sealed-классы и их применение для моделирования состояний в Kotlin.

### Темы:
- ✅ Sealed-классы
- ✅ Object (синглтоны)
- ✅ Enum классы
- ✅ Data классы
- ✅ Безопасная обработка состояний через when

## Структура проекта
src/
├── example/ # Примеры sealed-классов
│ ├── SealedClass.kt # NetworkResult и OrderStatus
│ └── ObjectClass.kt # Примеры object
├── payment/ # Система платежей
│ ├── Payment.kt
│ ├── PaymentValidator.kt
│ └── PaymentProcessor.kt
├── gameCharacter/ # Игровая система
│ ├── CharacterState.kt
│ └── GameCharacter.kt
└── Main.kt # Главный файл с демонстрацией


## Примеры кода

### Sealed-класс для состояний:
```kotlin
sealed class CharacterState {
    object Idle : CharacterState()
    object Running : CharacterState()
    data class Attacking(val damage: Int) : CharacterState()
    data class Dead(val reason: String) : CharacterState()
}

when (state) {
    CharacterState.Idle -> println("Персонаж отдыхает")
    CharacterState.Running -> println("Персонаж в движении")
    is CharacterState.Attacking -> println("Атака! Урон: ${state.damage}")
    is CharacterState.Dead -> println("Персонаж мёртв. Причина: ${state.reason}")
}

Запуск проекта
Запустите файл Main.kt через контекстное меню в IntelliJ IDEA.

GitHub
Репозиторий: https://github.com/GlicH-ctrl/Kotlin_Lab11_Sealed_Strenin