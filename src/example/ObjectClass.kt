package example

object GameSession {
    init {
        println("Игровая сессия создана")
    }

    var isActive: Boolean = false

    fun start() {
        isActive = true
        println("Игра началась")
    }

    fun end() {
        isActive = false
        println("Игра завершена")
    }
}

object Logger {
    var count = 0

    fun log(message: String) {
        count++
        println("[$count] $message")
    }
}

object AppSettings {
    val version = "1.0.0"
    var isDarkMode = true

    fun toggleTheme() {
        isDarkMode = !isDarkMode
        println("Тема изменена: isDarkMode = $isDarkMode")
    }
}

object Constants {
    const val BASE_URL = "https://api.example.com"
    const val TIMEOUT = 5000
}

fun main() {
    println("=== Демонстрация ленивой инициализации ===")
    println("Программа запущена")
    println("Проверяем состояние, но не трогаем GameSession")
    println("Теперь запускаем игру")

    GameSession.start()
    println("Проверяем состояние ещё раз")
    println("Активна ли сессия: ${GameSession.isActive}")

    println("\n=== Демонстрация синглтона ===")
    Logger.log("Первое сообщение")
    Logger.log("Второе сообщение")

    val logger1 = Logger
    val logger2 = Logger
    println("logger1 === logger2: ${logger1 === logger2}")

    println("\n=== Демонстрация настроек ===")
    println("Версия: ${AppSettings.version}")
    println("Темная тема: ${AppSettings.isDarkMode}")
    AppSettings.toggleTheme()
    println("Темная тема после переключения: ${AppSettings.isDarkMode}")

    println("\n=== Демонстрация констант ===")
    println("BASE_URL: ${Constants.BASE_URL}")
    println("TIMEOUT: ${Constants.TIMEOUT}")
}