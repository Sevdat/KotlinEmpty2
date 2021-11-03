/**
 * Решите вот такое задание, пожалуйста. То, что получиться, выложить в репозиторий на GitHub, мне прислать ссылку


В файле с именем inputName заданы результаты игр однокругового

футбольного турнира в виде таблицы в следующем формате:

Арсенал    0  4  1  1

Бавария    1  0  2 (3)

Интер      1  2  0  0

Барселона  3 (8) 0  0

Элемент таблицы чисел из i-й строки и j-го столбца содержит

число голов, забитое командой i в ворота команды j.

Например (см. выделенные элементы) команда 2 (Бавария) и

команда 4 (Барселона) сыграли со счетом 3:8.

Диагональные элементы (i=j) всегда равны 0.

Названия команд не могут содержать пробелы.

Соседние столбцы разделены как минимум двумя пробелами.


За победу в матче (большее количество мячей) команде даётся 3

очка, за ничью (одинаковое количество мячей) - 1 очко.


Написать функцию, определяющую занятые командами

места по количеству набранных ими очков, а при равенстве очков

-- по разности забитых и пропущенных мячей.

Также написать тесты, подтверждающие работоспособность функции.


При нарушении форматов входных данных следует выбрасывать
исключение IllegalArgumentException, при невозможности

прочитать файл выбрасывать исключение IOException.

Арсенал    0  4  1  1

Бавария    1  0  2 (3)

Интер      1  2  0  0

Барселона  3 (8) 0  0
 */

fun main2() {

    val file1 = mutableMapOf<String, List<Int>>("Арсенал" to listOf<Int>(0, 4, 1, 1))
    var ar = listOf<String>()
    var ar1 = listOf<Int>()
    for ((i, e) in file1) {
        ar = ar + i
        ar1 = ar1 + e
    }
    var ar2 = mutableMapOf<Double, Int>()
    for ((i, e) in ar1.withIndex()) {
        ar2["0.$i".toDouble()] = "$e".toInt()
    }

    val file2 = mutableMapOf<String, List<Int>>("Бавария" to listOf<Int>(1, 0, 2, 3))
    var ba = listOf<String>()
    var ba1 = listOf<Int>()
    for ((i, e) in file2) {
        ba = ba + i
        ba1 = ba1 + e
    }
    var ba2 = mutableMapOf<Double, Int>()
    for ((i, e) in ba1.withIndex()) {
        ba2["1.$i".toDouble()] = "$e".toInt()
    }

    val file3 = mutableMapOf<String, List<Int>>("Интер" to listOf<Int>(1, 2, 0, 0))
    var ini = listOf<String>()
    var ini1 = listOf<Int>()
    for ((i, e) in file3) {
        ini = ini + i
        ini1 = ini1 + e
    }
    var ini2 = mutableMapOf<Double, Int>()
    for ((i, e) in ini1.withIndex()) {
        ini2["2.$i".toDouble()] = "$e".toInt()
    }

    val file4 = mutableMapOf<String, List<Int>>("Барселона" to listOf<Int>(3, 8, 0, 0))
    var bar = listOf<String>()
    var bar1 = listOf<Int>()
    for ((i, e) in file4) {
        bar = bar + i
        bar1 = bar1 + e
    }
    var bar2 = mutableMapOf<Double, Int>()
    for ((i, e) in bar1.withIndex()) {
        bar2["3.$i".toDouble()] = "$e".toInt()
    }

    val cormap = (ar2 + ba2 + ini2 + bar2).filter { (i, s) -> ((i * 10) % 11) != 0.0 }

    val arcor = listOf(
        Pair(cormap[0.1], cormap[1.0]),
        Pair(cormap[0.2], cormap[2.0]),
        Pair(cormap[0.3], cormap[3.0])
    )
    var acor2 = mutableListOf<Int>()
    var acor1 = mutableListOf<Int>(0)
    for ((i, e) in arcor) {
        when (acor1.isNotEmpty()) {
            (i.toString().toInt() > e.toString().toInt()) -> acor1.add(3)
            (i.toString().toInt() < e.toString().toInt()) -> acor1.add(0)
            else -> acor1.add(1)
        }
        acor2 = mutableListOf<Int>(acor1.sum())
    }

    val bacor = listOf(
        Pair(cormap[1.0], cormap[0.1]),
        Pair(cormap[1.2], cormap[2.1]),
        Pair(cormap[1.3], cormap[3.1])
    )
    var bacor2 = mutableListOf<Int>()
    var bacor1 = mutableListOf<Int>(0)
    for ((i, e) in bacor) {
        when (bacor1.isNotEmpty()) {
            (i.toString().toInt() > e.toString().toInt()) -> bacor1.add(3)
            (i.toString().toInt() < e.toString().toInt()) -> bacor1.add(0)
            else -> bacor1.add(1)
        }
        bacor2 = mutableListOf<Int>(bacor1.sum())
    }
    val inicor = listOf(
        Pair(cormap[2.0], cormap[0.2]),
        Pair(cormap[2.1], cormap[1.2]),
        Pair(cormap[2.3], cormap[3.2])
    )
    var inicor2 = mutableListOf<Int>()
    var inicor1 = mutableListOf<Int>(0)
    for ((i, e) in inicor) {
        when (inicor1.isNotEmpty()) {
            (i.toString().toInt() > e.toString().toInt()) -> inicor1.add(3)
            (i.toString().toInt() < e.toString().toInt()) -> inicor1.add(0)
            else -> inicor1.add(1)
        }
        inicor2 = mutableListOf<Int>(inicor1.sum())
    }
    val barcor = listOf(
        Pair(cormap[3.0], cormap[0.3]),
        Pair(cormap[3.1], cormap[1.3]),
        Pair(cormap[3.2], cormap[2.3])
    )
    var barcor2 = mutableListOf<Int>()
    var barcor1 = mutableListOf<Int>(0)
    for ((i, e) in barcor) {
        when (barcor1.isNotEmpty()) {
            (i.toString().toInt() > e.toString().toInt()) -> barcor1.add(3)
            (i.toString().toInt() < e.toString().toInt()) -> barcor1.add(0)
            else -> barcor1.add(1)
        }
        barcor2 = mutableListOf<Int>(barcor1.sum())
    }
    val score = mutableMapOf(ar to acor2, ba to bacor2, ini to inicor2, bar to barcor2)
    print(score)
}
fun main() {
    val map = mutableMapOf<String, String>(
        "Арсенал" to "0, 4, 1, 1,",
        "Бавария" to "1, 0, 2, 3, ",
        "Интер" to "1, 2, 0, 0, ",
        "Барселона" to "3, 8, 0, 0"
    )
    val map2 = mutableMapOf<String, List<Int>>(
        "Арсенал" to listOf(0, 4, 1, 1),
        "Бавария" to listOf(1, 0, 2, 3),
        "Интер" to listOf(1, 2, 0, 0),
        "Барселона" to listOf(3, 8, 0, 0)
    )
    var ar = listOf<String>()
    var ar1 = listOf<Int>()
    for ((i, e) in map2) {
        var ar1 = listOf<Int>()
        ar = ar + i
        ar1 = ar1 + e
        print(ar1[0])
    }

    var ar2 = mutableMapOf<Double, Int>()
    for ((i, e) in ar1.withIndex()) {
        ar2["0.$i".toDouble()] = "$e".toInt()
    }
}
//Coordinate and number
//    var list5 = listOf<Any>()
//    for ((i, e) in list2.withIndex()) {
//        val list3 = mutableListOf<Any>()
//        val list4 = mutableListOf<Any>()
//        list3.add("0.$i".toDouble())
//        list4.add("$e".toInt())
//        list5 = list3 + list4
//        print(list5)
//1, 0, 2, 3,
//        1, 2, 0, 0,
//        3, 8, 0, 0
//println(list.filter { s -> s != "Арсенал (0  4  1  1)" })
/**
 * List: (Арсенал  0  4  1  1), (Бавария  1  0  2 (3)), (Интер  1  2  0  0), (Барселона  3 (8) 0  0)
 * Remove words from List: (0  4  1  1), (1  0  2 (3)), (1  2  0  0), (3 (8) 0  0)
 * Turn it into index.indeces : (0.0  0.1  0.2  0.3), (1.0  1.1  1.2  1.3), (2.0  2.1  2.2  2.3), (3.0  3.1  3.2  3.3)
 * Delete the equals: (0.1  0.2  0.3), (1.0  1.2  1.3), (2.0  2.1  2.3), (3.0  3.1  3.2)
 * Match the opposites: (0.1 : 1.0)  (0.2 : 2.0)  (0.3 : 3.0), (1.2 : 2.1)  (1.3: 3.1), (2.3 : 3.2)
 *
 */