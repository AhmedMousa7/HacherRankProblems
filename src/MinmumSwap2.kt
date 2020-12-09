import kotlin.time.measureTimedValue

fun main(){
    val output = measureTimedValue {
        minimumSwaps(arrayOf(3, 7, 6, 9, 1, 8, 10, 4, 2, 5))
    }
    println(output.value)
    println(output.duration)
}

fun minimumSwaps(arr: Array<Int>): Int {
    var swaps = 0
    val copy = arr.toMutableList()
    for (i in arr.indices){
        while (copy[i] != i + 1){
            val newIndex = copy[i] - 1
            val temp = copy[newIndex]
            copy[newIndex] = copy[i]
            copy[i] = temp
            swaps++
        }
    }

    return swaps
}