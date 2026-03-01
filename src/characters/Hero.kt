package characters

class Hero(val name: String) {
    var health: Int = 100
        set(value) {
            field = value.coerceIn(0, 100)
        }

    var stamina: Int = 50
        get() = field + 10

    var level: Int = 1
        private set

    fun levelUp() {
        level++
        println("$name повысил уровень до $level!")
    }
}

fun main() {
    val hero = Hero("Артас")

    hero.health = 120
    println("Здоровье: ${hero.health}")

    hero.health = -50
    println("Здоровье: ${hero.health}")

    println("Выносливость: ${hero.stamina}")

    hero.levelUp()
    println("Уровень: ${hero.level}")
}