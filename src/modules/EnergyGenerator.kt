package modules

import resources.OutpostResource
import resources.ResourceManager

class EnergyGenerator : OutpostModule(name = "Генератор энергии") {

    override fun performAction(manager: ResourceManager) {
        val energy = manager.get("Energy")

        if (energy == null) {
            manager.add(OutpostResource(id = 3, name = "Energy", amount = 20))
            println("Генератор создал первый ресурс: Energy +20")
        } else {
            energy.amount += 10 * level
            println("Генератор произвел ${10 * level} единиц энергии")
        }
    }
}