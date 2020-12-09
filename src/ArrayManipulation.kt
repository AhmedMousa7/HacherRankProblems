import kotlin.time.measureTimedValue
import kotlin.time.seconds

fun main(){
    val (value) = measureTimedValue {
        arrayManipulation(5, arrayOf(
                arrayOf(1,2,100),
                arrayOf(2,5,100),
                arrayOf(3,4,100))
        )
    }
    println(value)
    println(value.seconds)
}

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    if (n <= 0 || queries.isEmpty()) return 0

    val array = LongArray(n)
    for (query in queries){
        val fromIndex = query[0] - 1
        val toIndex = query[1]
        array[fromIndex] = array[fromIndex] + query[2]
        if (toIndex != n){
            array[toIndex] = array[toIndex] - query[2]
        }
    }
    var max = 0L
    var sum = 0L
    array.forEach { item ->
        sum += item
        max = kotlin.math.max(sum, max)
    }

    return max
}

/*
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    if (n <= 0 || queries.isEmpty()) return 0
    val array = LongArray(n)
    queries.forEach { query ->
        var from = query[0]
        val to = query[1]
        val value = query[2]
        while (from <= to){
            array[from - 1] += value.toLong()
            from++
        }
    }

    return array.max() ?: 0
}*/
