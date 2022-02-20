@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
<<<<<<< HEAD
=======
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
fun Complex(s: String): Complex = TODO()

/**
>>>>>>> c16a964 (try)
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(TODO(), TODO())

    /**
<<<<<<< HEAD
     * Конструктор из строки вида x+yi
     */
    constructor(s: String) : this(TODO(), TODO())

    /**
=======
>>>>>>> c16a964 (try)
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = TODO()

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = TODO()

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = TODO()

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex = TODO()

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex = TODO()

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = TODO()

    /**
     * Преобразование в строку
     */
    override fun toString(): String = TODO()
}
