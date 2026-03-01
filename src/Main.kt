import example.NetworkResult
import example.OrderStatus
import payment.Payment
import payment.CardType
import payment.PaymentProcessor
import gameCharacter.GameCharacter

fun demonstrateNetworkResult() {
    println("=== ДЕМОНСТРАЦИЯ SEALED CLASS: NetworkResult ===")
    val success = NetworkResult.Success("Данные получены")
    val error = NetworkResult.Error("Сервер не отвечает", 500)
    val loading = NetworkResult.Loading

    handleResult(success)
    handleResult(error)
    handleResult(loading)
    println()
}

fun handleResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success -> println("Успех: ${result.data}")
        is NetworkResult.Error -> println("Ошибка ${result.code}: ${result.message}")
        NetworkResult.Loading -> println("Загрузка...")
    }
}

fun demonstrateOrderStatus() {
    println("=== ДЕМОНСТРАЦИЯ SEALED CLASS: OrderStatus ===")
    val statuses = listOf(
        OrderStatus.Created,
        OrderStatus.Paid,
        OrderStatus.Shipped,
        OrderStatus.Cancelled("Нет товара на складе")
    )

    statuses.forEach { status ->
        when (status) {
            OrderStatus.Created -> println("Заказ создан")
            OrderStatus.Paid -> println("Заказ оплачен")
            OrderStatus.Shipped -> println("Заказ отправлен")
            is OrderStatus.Cancelled -> println("Отменён: ${status.reason}")
        }
    }
    println()
}

fun demonstratePaymentSystem() {
    println("=== ДЕМОНСТРАЦИЯ СИСТЕМЫ ПЛАТЕЖЕЙ ===")

    val processor = PaymentProcessor()

    val payments = listOf(
        Payment(card = "4111111111111111", sum = 1000, type = CardType.VISA),
        Payment(card = "5111111111111111", sum = 500, type = CardType.MASTERCARD),
        Payment(card = "2222222222222222", sum = 200, type = CardType.MIR),
        Payment(card = "1234", sum = -100, type = CardType.UNKNOWN)
    )

    payments.forEachIndexed { index, payment ->
        println("Платеж ${index + 1}: карта ${payment.card.take(4)}****, сумма ${payment.sum}, тип ${payment.type}")
        val result = processor.pay(payment)
        processor.show(result)
        println()
    }
}

fun demonstrateGameCharacter() {
    println("=== ДЕМОНСТРАЦИЯ ИГРОВОГО ПЕРСОНАЖА ===")

    val hero = GameCharacter("Артас")

    hero.handleState()
    hero.run()
    hero.handleState()

    hero.attack(25)
    hero.handleState()

    hero.idle()
    hero.handleState()

    hero.takeDamage(30)
    hero.takeDamage(40)
    hero.takeDamage(40)

    hero.run()
    hero.attack(10)
    hero.handleState()
}

fun main() {
    demonstrateNetworkResult()
    demonstrateOrderStatus()
    demonstratePaymentSystem()
    demonstrateGameCharacter()
}