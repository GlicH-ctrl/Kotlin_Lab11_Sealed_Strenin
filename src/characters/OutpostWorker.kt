package characters

class OutpostWorker(val name: String) {
    var energy: Int = 100
        set(value) {
            field = value.coerceIn(0, maxEnergy)
        }

    val mood: Int
        get() = 50 + (energy / 10)

    var level: Int = 1
        private set

    private val maxEnergy: Int
        get() = 100 + (level - 1) * 10

    fun work() {
        println("$name начинает работу...")
        energy -= 15
        println("$name работал. Энергия: $energy")
        if (energy < 20) {
            println("Внимание! У $name критически низкий уровень энергии!")
        }
    }

    fun rest() {
        println("$name отдыхает...")
        energy += 20
        println("$name отдохнул. Энергия: $energy")
    }

    fun levelUp() {
        level++
        println("$name повысил уровень до $level!")
        println("Максимальная энергия увеличена до $maxEnergy")
    }
}

fun main() {
    val worker = OutpostWorker("Алекс")

    println("Имя: ${worker.name}")
    println("Энергия: ${worker.energy}")
    println("Настроение: ${worker.mood}")

    worker.work()
    worker.work()
    worker.rest()

    worker.levelUp()

    worker.work()
    worker.work()
    worker.work()
    worker.rest()

    println("Финальное состояние - Энергия: ${worker.energy}, Настроение: ${worker.mood}, Уровень: ${worker.level}")
}