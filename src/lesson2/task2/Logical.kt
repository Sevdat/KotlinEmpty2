@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
<<<<<<< HEAD
=======
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
>>>>>>> c16a964 (try)

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
<<<<<<< HEAD
fun isNumberHappy(number: Int): Boolean = TODO()
=======
fun isNumberHappy(number: Int): Boolean {
    val firstNumber = number / 1000
    val lastNumber = number % 10
    val secondNumber = number / 100 % 10
    val thirdNumber = number / 10 % 10
    return firstNumber + secondNumber == thirdNumber + lastNumber
}
>>>>>>> c16a964 (try)

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
<<<<<<< HEAD
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = TODO()
=======
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
    (abs(y1 - y2) == abs(x1 - x2)) || (x1 == x2 || y1 == y2)
>>>>>>> c16a964 (try)


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
<<<<<<< HEAD
fun daysInMonth(month: Int, year: Int): Int = TODO()
=======
fun daysInMonth(month: Int, year: Int): Int {
    if (month == 2) {
        return if (((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))) 29
        else 28
    }
    return if ((month == 1) || (month == 3) || (month == 5) || (month == 7) ||
        (month == 8) || (month == 10) || (month == 12)
    ) 31
    else 30
}
>>>>>>> c16a964 (try)

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = TODO()

/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
<<<<<<< HEAD
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean = TODO()
=======
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {

    return when {
        max(a, b) <= max(r, s) && min(a, b) <= min(r, s) -> true
        max(a, c) <= max(r, s) && min(a, c) <= min(r, s) -> true
        max(b, c) <= max(r, s) && min(b, c) <= min(r, s) -> true
        else -> false

    }
}
>>>>>>> c16a964 (try)
