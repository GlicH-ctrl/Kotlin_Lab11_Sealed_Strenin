package example

data class Item(val id: Int, val name: String, var quantity: Int) {
    override fun toString(): String {
        return "Предмет: $name | ID: $id | Количество: $quantity"
    }
}

class User {
    var age: Int = 0
        set(value) {
            if (value in 0..150) {
                field = value
            } else {
                println("Ошибка: возраст должен быть от 0 до 150")
            }
        }
}

abstract class Human(val name: String) {
    fun hello() {
        println("Привет, я $name")
    }

    abstract fun work()
}

class Programmer(name: String) : Human(name) {
    override fun work() {
        println("$name пишет код")
    }
}

class Teacher(name: String) : Human(name) {
    override fun work() {
        println("$name учит студентов")
    }
}

abstract class Figure {
    abstract fun perimeter(): Float
    abstract fun area(): Float
}

class Rectangle(val width: Float, val height: Float) : Figure() {
    override fun perimeter(): Float {
        return 2 * (width + height)
    }

    override fun area(): Float {
        return width * height
    }
}

class Circle(val radius: Float) : Figure() {
    override fun perimeter(): Float {
        return 2 * 3.14f * radius
    }

    override fun area(): Float {
        return 3.14f * radius * radius
    }
}

fun main() {
    val item1 = Item(1, "Меч", 5)
    val item2 = item1.copy(quantity = 10)

    println(item1)
    println(item2)

    val (id, name, quantity) = item1
    println("Декомпозиция: id=$id, name=$name, quantity=$quantity")

    val user = User()
    user.age = 25
    println("Возраст: ${user.age}")
    user.age = 200
    println("Возраст: ${user.age}")

    val programmer = Programmer("Анна")
    programmer.hello()
    programmer.work()

    val teacher = Teacher("Олег")
    teacher.hello()
    teacher.work()

    val rect = Rectangle(5f, 3f)
    println("Прямоугольник: периметр = ${rect.perimeter()}, площадь = ${rect.area()}")

    val circle = Circle(4f)
    println("Круг: периметр = ${circle.perimeter()}, площадь = ${circle.area()}")
}