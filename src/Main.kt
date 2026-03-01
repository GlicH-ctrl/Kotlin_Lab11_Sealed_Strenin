import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

fun main() {
    val manager = ResourceManager()

    manager.add(OutpostResource(id = 1, name = "Minerals", amount = 120))
    manager.add(OutpostResource(id = 2, name = "Gas", amount = 40))

    val generator = EnergyGenerator()
    val lab = ResearchLab()

    println("=== Состояние ресурсов ===")
    manager.printAll()

    println("\n=== Работа генератора ===")
    generator.performAction(manager)

    println("\n=== Работа лаборатории ===")
    lab.performAction(manager)

    println("\n=== Состояние после действий ===")
    manager.printAll()

    println("\n=== Улучшение модулей ===")
    generator.upgrade()
    lab.upgrade()

    println("\n=== Работа после улучшения ===")
    generator.performAction(manager)
    lab.performAction(manager)

    println("\n=== Финальное состояние ===")
    manager.printAll()
}