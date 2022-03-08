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
*/
fun main() {
    var x = 0
    var f = 0
    var g = 0
    var r = -1

    var name = mutableListOf<String>("Арсенал", "Бавария", "Интер", "Барселона")
    var list = mutableListOf<List<Int>>(
        listOf(0, 4, 1, 1),
        listOf(1, 0, 2, 3),
        listOf(1, 2, 0, 0),
        listOf(3, 8, 0, 0),
    )
//дает координаты X и Y в формате двойного числа в первом списке, а во втором списке он выдает обратную координату
    var norcor = mapOf<Double, Int>()
    var revnorcor = mapOf<Double, Int>()
    while (x != list.size) {
        var givcor = mutableMapOf<Double, Int>()
        var revgivcor = mutableMapOf<Double, Int>()
        var y = -1
        while (y != list.size - 1) {
            y = y + 1
            givcor["$y.$x".toDouble()] = list[y][x]
            revgivcor["$x.$y".toDouble()] = list[y][x]
            norcor = norcor + givcor
            revnorcor = revnorcor + revgivcor
        }
        x = x + 1;
    }
//Фильтрует совпадающие координаты X и Y, и организует карту от наименьшего индекса до наибольшего индекса.
    val filcor = norcor.filter { (i, s) -> ((i * 10) % 11) != 0.0 }.toSortedMap()
    val revfilcor = revnorcor.filter { (i, s) -> ((i * 10) % 11) != 0.0 }.toSortedMap()
//Соответствует каждому индексу из первого списка и второго списка, потому что числа принадлежат друг другу
    var pair = listOf<Pair<Int?, Int?>>()
    for ((i, e) in revnorcor) {
        var joincor = listOf(Pair(filcor[i], revfilcor[i]))
        pair = pair + joincor
    }
//отфильтровывает null значения
    var nullfil = pair.filter { (i, e) -> i != null && e != null }
//от каждой пары начисляются очки в зависимости от первого номера
    var point = mutableListOf<Int>()
    for ((d, s) in nullfil) {
        when {
            (d.toString().toInt() > s.toString().toInt()) -> point.add(3)
            (d.toString().toInt() < s.toString().toInt()) -> point.add(0)
            else -> point.add(1)
        }
    }
//добавляет значения вместе в зависимости от размера списка
    var unidel = mutableListOf<Int>()
    var score = mutableListOf<Int>()
    while(g != list.size) {
        g = g + 1
        while (f != (list.size -1) * g) {
            unidel = (unidel + point[f]) as MutableList
            f = f + 1
        }
        score = (score + unidel.sum()) as MutableList<Int>
        unidel.clear()
    }
//объединяет имена и добавленные баллы вместе
    var tesco = mutableMapOf<String, Int>()
    while (r != list.size - 1) {
        r = r + 1
        tesco[name[r]] = score[r]

    }
    println(tesco)
}

// fun main() {

//     var name = mutableListOf<String>("Арсенал", "Бавария", "Интер", "Барселона")
//     var list = mutableListOf<List<Int>>(
//         listOf(0, 4, 1, 1),
//         listOf(1, 0, 2, 3),
//         listOf(1, 2, 0, 0),
//         listOf(3, 8, 0, 0),
//     )

//     var x = -1
//     var map2 = mutableMapOf<Int, List<Int>>()
//     while (x != list.size - 1) {
//         x = x + 1
//         map2[x] = list[x]
//     }

//     var map3 = mapOf<Double, Int?>()
//     var map4 = mapOf<Double, Int?>()
//     var k = 0
//     while (k != list.size) {
//         var newlist5 = mutableMapOf<Double, Int?>()
//         var newlist6 = mutableMapOf<Double, Int?>()
//         var y = -1
//         while (y != list.size - 1) {
//             y = y + 1
//             newlist5["$y.$k".toDouble()] = map2[y]?.get(k)
//             newlist6["$k.$y".toDouble()] = map2[y]?.get(k)
//             map3 = map3 + newlist5
//             map4 = map4 + newlist6
//         }
//         k = k + 1;
//     }
//     val map7 = map3.filter { (i, s) -> ((i * 10) % 11) != 0.0 }.toSortedMap()
//     val map8 = map4.filter { (i, s) -> ((i * 10) % 11) != 0.0 }.toSortedMap()

//     var listnew = listOf<Pair<Int?, Int?>>()
//     for ((i, e) in map4) {
//         var newlist = listOf(Pair(map7[i], map8[i]))
//         listnew = listnew + newlist
//     }
//     var listinew = listnew.filter { (i, e) -> i != null && e != null }


//     var listi = mutableListOf<Int>()
//     for ((d, s) in listinew) {
//         when {
//             (d.toString().toInt() > s.toString().toInt()) -> listi.add(3)
//             (d.toString().toInt() < s.toString().toInt()) -> listi.add(0)
//             else -> listi.add(1)
//         }
//     }

//     var f = 0
//     var g = 0
//     var addlist = mutableListOf<Int>()
//     var addlist1 = mutableListOf<Int>()
//     while(g != list.size) {
//         g = g + 1
//         while (f != (list.size -1) * g) {
//             addlist = (addlist + listi[f]) as MutableList
//             f = f + 1
//         }
//         addlist1 = (addlist1 + addlist.sum()) as MutableList<Int>
//         addlist.clear()
//     }

//     var score = mutableMapOf<String, Int>()
//     var d = -1
//     while (d != list.size - 1) {
//         d = d + 1
//         score[name[d]] = addlist1[d]

//     }
//     println(score)
// }

// fun main() {

//     var name = mutableListOf<String>("Арсенал", "Бавария", "Интер", "Барселона")
//     var list = mutableListOf<List<Int>>(
//         listOf(0, 4, 1, 1),
//         listOf(1, 0, 2, 3),
//         listOf(1, 2, 0, 0),
//         listOf(3, 8, 0, 0),
//     )

//     var map2 = mutableMapOf<Int, List<Int>>()
//     var x = -1
//     for (i in list) {
//         var map1 = mutableMapOf<Int, List<Int>>()
//         while (x != list.size - 1) {
//             x = x + 1
//             map1[x] = list[x]
//             map2 = map1
//         }
//     }

//     var map3 = mapOf<Double, Int?>()
//     for ((i, e) in map2) {
//         var newlist5 = mutableMapOf<Double, Int?>()
//         var y = -1
//         while (y != list.size - 1) {
//             y = y + 1
//             newlist5["$y.$i".toDouble()] = map2[y]?.get(i)
//             map3 = map3 + newlist5
//         }
//     }

//     val map4 = map3.filter { (i, s) -> ((i * 10) % 11) != 0.0 }

//     var listnew = listOf<Pair<Int?, Int?>>()
//     for ((i, e) in map4) {
//         var newlist = listOf(Pair(map4[(i * 10 % 10) + (i).toInt().toDouble() / 10], map4[i]))
//         listnew = listnew + newlist
//     }
//     var listi = mutableListOf<Int>(0)
//     for ((d, s) in listnew) {
//         when (listi.isNotEmpty()) {
//             (d.toString().toInt() > s.toString().toInt()) -> listi.add(3)
//             (d.toString().toInt() < s.toString().toInt()) -> listi.add(0)
//             else -> listi.add(1)
//         }
//     }
//     listi.removeAt(0)
//     var list3 = mutableListOf<Int>(
//         listi[0] + listi[1] + listi[2],
//         listi[3] + listi[4] + listi[5],
//         listi[6] + listi[7] + listi[8],
//         listi[9] + listi[10] + listi[11]
//     )

//     var score = mutableMapOf<String, Int>()
//     var d = -1
//     while(d != list.size - 1){
//         d = d + 1
//         score[name[d]] = list3[d]

//     }

//     print(score)
// }
