package gameCharacter

class GameCharacter(val name: String) {
    var health: Int = 100
        private set

    var state: CharacterState = CharacterState.Idle
        private set

    fun run() {
        if (state is CharacterState.Dead) {
            println("$name мёртв и не может бежать")
            return
        }
        state = CharacterState.Running
        println("$name бежит")
    }

    fun attack(damage: Int) {
        if (state is CharacterState.Dead) {
            println("$name мёртв и не может атаковать")
            return
        }
        state = CharacterState.Attacking(damage)
        println("$name атакует с уроном $damage")
    }

    fun idle() {
        if (state is CharacterState.Dead) {
            println("$name мёртв и не может бездействовать")
            return
        }
        state = CharacterState.Idle
        println("$name бездействует")
    }

    fun takeDamage(damage: Int) {
        health -= damage
        println("$name получил урон $damage. Здоровье: $health")

        if (health <= 0) {
            die("получен смертельный урон")
        }
    }

    private fun die(reason: String) {
        state = CharacterState.Dead(reason)
        println("$name погиб: $reason")
    }

    fun handleState() {
        when (val currentState = state) {
            CharacterState.Idle -> println("Персонаж отдыхает")
            CharacterState.Running -> println("Персонаж в движении")
            is CharacterState.Attacking -> println("Атака! Урон: ${currentState.damage}")
            is CharacterState.Dead -> println("Персонаж мёртв. Причина: ${currentState.reason}")
        }
    }
}

fun main() {
    println("=== ИГРОВАЯ СИСТЕМА СОСТОЯНИЙ ===\n")

    val hero = GameCharacter("Артас")

    hero.handleState()
    hero.run()
    hero.handleState()

    hero.attack(25)
    hero.handleState()

    hero.idle()
    hero.handleState()

    println("\n=== БОЕВАЯ СИСТЕМА ===")
    hero.takeDamage(30)
    hero.takeDamage(40)
    hero.takeDamage(40)

    println("\n=== ПОПЫТКИ ДЕЙСТВИЙ ПОСЛЕ СМЕРТИ ===")
    hero.run()
    hero.attack(10)
    hero.idle()
    hero.handleState()
}