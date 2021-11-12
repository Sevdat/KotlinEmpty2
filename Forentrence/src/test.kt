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

fun main0() {

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
            (((i ?: throw IllegalArgumentException())) > (e ?: throw IllegalArgumentException())) -> bacor1.add(3)
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

fun main12() {
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
    val list = mutableListOf<List<Int>>(
        listOf(0, 4, 1, 1),
        listOf(1, 0, 2, 3),
        listOf(1, 2, 0, 0),
        listOf(3, 8, 0, 0),
    )
    val pairlist = mutableListOf(
        Pair(list[0][1], list[1][0]),
        Pair(list[0][2], list[2][0]),
        Pair(list[0][3], list[3][0]),

        Pair(list[1][0], list[0][1]),
        Pair(list[1][2], list[2][1]),
        Pair(list[1][3], list[3][1]),

        Pair(list[2][0], list[0][2]),
        Pair(list[2][1], list[1][2]),
        Pair(list[2][3], list[3][2]),

        Pair(list[3][0], list[0][3]),
        Pair(list[3][1], list[1][3]),
        Pair(list[3][2], list[2][3]),
    )

    val list1 = mutableListOf<List<Int>>(
        listOf(0, 4, 1, 1),
        listOf(1, 0, 2, 3),
        listOf(1, 2, 0, 0),
        listOf(3, 8, 0, 0),
    )
    var newlist = mutableMapOf<Int, List<Int>>()
    var newlist4 = mutableMapOf<Int, List<Int>>()
    var x = -1
    for (i in list1) {
        var newlist = mutableMapOf<Int, List<Int>>()
        while (x != list1.size - 1) {
            x = x + 1
            newlist[x] = list1[x]

            newlist4 = newlist
        }
    }
    var newlist6 = mutableMapOf<Double, Int?>()
    var newlist5 = mutableMapOf<Double, Int?>()
//    var y = -1
    for ((i, e) in newlist4) {
//        var x = list.size - 1 - i
//        var newlist5 = mutableMapOf<Double, Int?>()
//        while (y != 3){
//            y = y + 1
//            newlist5["$y.$i".toDouble()] = newlist4[y]?.get(i)
//            newlist6 = newlist5
//        }
        newlist5["0.$i".toDouble()] = newlist4[0]?.get(i)
        newlist5["1.$i".toDouble()] = newlist4[1]?.get(i)
        newlist5["2.$i".toDouble()] = newlist4[2]?.get(i)
        newlist5["3.$i".toDouble()] = newlist4[3]?.get(i)
    }
    print(newlist5)
}
///var newlist2 = list1[0] + list1[1] + list1[2] + list1[3]
//var newlist3 = mutableMapOf<Int, Int>()
//    (0) (4) (1) (1) | (0.0) (0.1) (0.2) (0.3)
//    (1) (0) (2) (3) | (1.0) (1.1) (1.2) (1.3)
//    (1) (2) (0) (0) | (2.0) (2.1) (2.2) (2.3)
//    (3) (8) (0) (0) | (3.0) (3.1) (3.2) (3.3)

//    (0) (4) (1) (1) | (0) (1) (2) (3)
//    (1) (0) (2) (3) | (4) (5) (6) (7)
//    (1) (2) (0) (0) | (8) (9) (10)(11)
//    (3) (8) (0) (0) | (12)(13)(14)(15)
//println(newlist4[0]?.get(1) ?: -1)
//        when (newlist3.isNotEmpty()) {
//            (i == 0 || i == 1 || i == 2 || i == 3) -> newlist3["0.$i".toDouble()] = "$e".toInt()
//            (i == 4 || i == 5 || i == 6 || i == 7) -> newlist3["1.$i".toDouble()] = "$e".toInt()
//            (i == 8 || i == 9 || i == 10 || i == 11) -> newlist3["2.$i".toDouble()] = "$e".toInt()
//            (i == 12 || i == 13 || i == 14 || i == 15) -> newlist3["3.$i".toDouble()] = "$e".toInt()
//        }
//var newlist2 = list1[0] + list1[1] + list1[2] + list1[3]
//var newlist3 = mutableMapOf<Int, Int>()
//var newlist4 = mutableMapOf<Int, List<Int>>()
//var x = -1
//for (i in list1) {
//    while (x != list1.size - 1) {
//        var newlist = mutableMapOf<Int, List<Int>>()
//        x = x + 1
//        newlist[x] = list1[x]
//
//        newlist = newlist4
//    }
//    println(newlist4)
//
//}

//    for ((i, e) in list1.withIndex()) {
//        var x = 1
//        x = x + 1
//
//        while (x != y)
//            newlist = newlist + list1[x]
//
//
//        println(newlist)

//        println(list1[y])


//    val map4 = mutableMapOf<Int, Int>()
//    var x: Int = 1
//    for ((i, e) in map3) {
//        x = x + 1
//        for (i in 0..x - 1) {
//            println(x)
//        }
//
//
//    }


//    var ar2 = mutableMapOf<Double, Int>()
//    for ((i, e) in map2.withIndex()) {
//        ar2["0.$i".toDouble()] = "$e".toInt()

//    var ar = listOf<String>()
//    var ar1 = listOf<Int>()
//    for ((i, e) in map2) {
//        var ar1 = listOf<Int>()
//        ar = ar + i
//        ar1 = ar1 + e
//        print(ar1[0])
//    }
//
//    }
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

fun main3() {

    var name = mutableListOf<String>("Арсенал", "Бавария", "Интер", "Барселона")
    var list = mutableListOf<List<Int>>(
        listOf(0, 4, 1, 1),
        listOf(1, 0, 2, 3),
        listOf(1, 2, 0, 0),
        listOf(3, 8, 0, 0),
    )

    var map2 = mutableMapOf<Int, List<Int>>()
    var x = -1
    for (i in list) {
        var map1 = mutableMapOf<Int, List<Int>>()
        while (x != list.size - 1) {
            x = x + 1
            map1[x] = list[x]
            map2 = map1
        }
    }

    var map3 = mapOf<Double, Int?>()
    for ((i, e) in map2) {
        var newlist5 = mutableMapOf<Double, Int?>()
        var y = -1
        while (y != list.size - 1) {
            y = y + 1
            newlist5["$y.$i".toDouble()] = map2[y]?.get(i)
            map3 = map3 + newlist5
        }
    }

    val map4 = map3.filter { (i, s) -> ((i * 10) % 11) != 0.0 }

    var listnew = listOf<Pair<Int?, Int?>>()
    for ((i, e) in map4) {
        var newlist = listOf(Pair(map4[(i * 10 % 10) + (i).toInt().toDouble() / 10], map4[i]))
        listnew = listnew + newlist
    }
    var listi = mutableListOf<Int>(0)
    for ((d, s) in listnew) {
        when (listi.isNotEmpty()) {
            (d.toString().toInt() > s.toString().toInt()) -> listi.add(3)
            (d.toString().toInt() < s.toString().toInt()) -> listi.add(0)
            else -> listi.add(1)
        }
    }
    listi.removeAt(0)
    var list3 = mutableListOf<Int>(
        listi[0] + listi[1] + listi[2],
        listi[3] + listi[4] + listi[5],
        listi[6] + listi[7] + listi[8],
        listi[9] + listi[10] + listi[11]
    )


    var h = (list.size - 1) * list.size
    var t = -1
    while (h != 0) {
        var list34 = mutableListOf<Int>()
        var list35 = mutableListOf<Int>()
        h = h - 1
        t = t + 1
        if (t % 3 == 0) list34 = (list34 + list35.sum()) as MutableList<Int>
        if (t % 3 == 0) list35.clear()

        list35 = (list35 + listi[t]) as MutableList<Int>

        println(list34)
    }
//    print((list.size - 1)* list.size )

    var score = mutableMapOf<String, Int>()
    var d = -1
    while (d != list.size - 1) {
        d = d + 1
        score[name[d]] = list3[d]

    }
//    10 11 (12) 13 14 15 16 17 18 19 20 (21) 22
//    11 (12) 13 14 15 16 17 18 19 20 (21) 22 23
//    (12) 13 14 15 16 17 18 19 20 (21) 22 23 24
//    13 14 15 16 17 18 19 20 (21) 22 23 24 25
//
//    10.11 10.12 10.13 10.14 10.15 10.16 10.17 10.18
//    11.11 11.12 11.13 11.14 11.15 11.16 11.17 11.18
//    12.11 12.12 12.13 12.14 12.15 12.16 12.17 12.18


}

//var list34 = mutableListOf<Int>()
//var h = (list.size - 1) * list.size
//var t = -1
//while (h != 0) {
//    h = h - 1
//    t = t + 1
//    var list35 = mutableListOf<Int>()
//    var list36 = mutableListOf<Int>()
//
//    list35 = (list35 + listi[t]) as MutableList<Int>
//
//    if (list35[list.size - 1] == Any()) list36.add(list35.sum())
//    if (list35[list.size - 1] == Any()) list35.clear()
//
//    list34 = (list34 + list36) as MutableList<Int>
//}
//println(list34)
//var score = mutableMapOf<String, Int>(
//        name[0] to list3[0],
//        name[1] to list3[1],
//        name[2] to list3[2],
//        name[3] to list3[3]
//    )
//    (0) (4) (1) (1) | (0.0) (0.1) (0.2) (0.3)
//    (1) (0) (2) (3) | (1.0) (1.1) (1.2) (1.3)
//    (1) (2) (0) (0) | (2.0) (2.1) (2.2) (2.3)
//    (3) (8) (0) (0) | (3.0) (3.1) (3.2) (3.3)
//        val arcor = listOf(
//            Pair(map4[0.1], map4[1.0]),
//            Pair(map4[0.2], map4[2.0]),
//            Pair(map4[0.3], map4[3.0])
//        )
//        val bacor = listOf(
//            Pair(map3[1.0], map3[0.1]),
//            Pair(map3[1.2], map3[2.1]),
//            Pair(map3[1.3], map3[3.1])
//        )
//        val inicor = listOf(
//            Pair(map3[2.0], map3[0.2]),
//            Pair(map3[2.1], map3[1.2]),
//            Pair(map3[2.3], map3[3.2])
//        )
//        val barcor = listOf(
//            Pair(map3[3.0], map3[0.3]),
//            Pair(map3[3.1], map3[1.3]),
//            Pair(map3[3.2], map3[2.3])
//        )
fun main() {

    var name = mutableListOf<String>("Арсенал", "Бавария", "Интер", "Барселона")
    var list = mutableListOf<List<Int>>(
        listOf(0, 4, 1, 1),
        listOf(1, 0, 2, 3),
        listOf(1, 2, 0, 0),
        listOf(3, 8, 0, 0),
    )

    var x = -1
    var map2 = mutableMapOf<Int, List<Int>>()
    while (x != list.size - 1) {
        x = x + 1
        map2[x] = list[x]
    }

    var map3 = mapOf<Double, Int?>()
    var map4 = mapOf<Double, Int?>()
    var k = 0
    while (k != list.size) {
        var newlist5 = mutableMapOf<Double, Int?>()
        var newlist6 = mutableMapOf<Double, Int?>()
        var y = -1
        while (y != list.size - 1) {
            y = y + 1
            newlist5["$y.$k".toDouble()] = map2[y]?.get(k)
            newlist6["$k.$y".toDouble()] = map2[y]?.get(k)
            map3 = map3 + newlist5
            map4 = map4 + newlist6
        }
        k = k + 1;
    }
    val map7 = map3.filter { (i, s) -> ((i * 10) % 11) != 0.0 }.toSortedMap()
    val map8 = map4.filter { (i, s) -> ((i * 10) % 11) != 0.0 }.toSortedMap()

    var listnew = listOf<Pair<Int?, Int?>>()
    for ((i, e) in map4) {
        var newlist = listOf(Pair(map7[i], map8[i]))
        listnew = listnew + newlist
    }
    var listinew = listnew.filter { (i, e) -> i != null && e != null }


    var listi = mutableListOf<Int>()
    for ((d, s) in listinew) {
        when {
            (d.toString().toInt() > s.toString().toInt()) -> listi.add(3)
            (d.toString().toInt() < s.toString().toInt()) -> listi.add(0)
            else -> listi.add(1)
        }
    }
    var f = 0
    var g = 0
    var addlist = mutableListOf<Int>()
    var addlist1 = mutableListOf<Int>()
    while(g != list.size) {
        g = g + 1
        while (f != (list.size -1) * g) {
            addlist = (addlist + listi[f]) as MutableList
            f = f + 1

        }
        addlist1 = (addlist1 + addlist.sum()) as MutableList<Int>
        addlist.clear()
    }
    var score = mutableMapOf<String, Int>()
    var d = -1
    while (d != list.size - 1) {
        d = d + 1
        score[name[d]] = addlist1[d]

    }
    println(score)
}

//    var score = mutableMapOf<String, Int>()
//    var d = -1
//    while (d != list.size - 1) {
//        d = d + 1
//        score[name[d]] = list3[d]
//
//    }
//    println(score)
//    }
