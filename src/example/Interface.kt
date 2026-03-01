package example

interface Movable {
    var speed: Int
    val model: String
    val number: String

    fun move()

    fun stop() {
        println("Останавливаемся...")
    }
}

class Car(override val model: String, override val number: String) : Movable {
    override var speed: Int = 60

    override fun move() {
        println("Едем на машине $model со скоростью $speed км/ч")
    }
}

class Aircraft(override val model: String, override val number: String) : Movable {
    override var speed: Int = 600

    override fun move() {
        println("Летим на самолете $model со скоростью $speed км/ч")
    }

    override fun stop() {
        println("Приземляемся...")
    }
}

interface Worker {
    fun doWork()
}

interface Student {
    fun study()
}

class WorkingStudent(val name: String) : Worker, Student {
    override fun doWork() {
        println("$name работает")
    }

    override fun study() {
        println("$name учится")
    }
}

interface VideoPlayable {
    fun play() {
        println("Воспроизведение видео")
    }
}

interface AudioPlayable {
    fun play() {
        println("Воспроизведение аудио")
    }
}

class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}

fun travel(obj: Movable) = obj.move()

fun main() {
    val car = Car("Toyota", "A123BC")
    val aircraft = Aircraft("Boeing", "B789CD")

    travel(car)
    travel(aircraft)
    car.stop()
    aircraft.stop()

    val workingStudent = WorkingStudent("Петр")
    workingStudent.doWork()
    workingStudent.study()

    val mediaPlayer = MediaPlayer()
    mediaPlayer.play()
}