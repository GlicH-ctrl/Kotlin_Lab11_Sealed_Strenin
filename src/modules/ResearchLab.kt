package modules

import resources.OutpostResource
import resources.ResourceManager

class ResearchLab : OutpostModule(name = "Исследовательская лаборатория") {

    override fun performAction(manager: ResourceManager) {
        val minerals = manager.get("Minerals")

        if (minerals == null || minerals.amount < 30) {
            println("Недостаточно минералов для исследования")
            return
        }

        minerals.amount -= 30
        println("Лаборатория проводит исследование (минералы -30)")

        val researchPoints = manager.get("ResearchPoints")
        if (researchPoints == null) {
            manager.add(OutpostResource(id = 4, name = "ResearchPoints", amount = 10))
        } else {
            researchPoints.amount += 10
        }
    }
}