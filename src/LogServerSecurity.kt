
fun main(){
    val array = IntArray(6)
    array[0] = 200
    array[1] = 100
    array[2] = 200
    array[3] = 500
    array[4] = 100
    array[5] = 500
    print(maxLogs(array))
}

fun maxLogs(logsCount: IntArray): Int {
    var count = 0

    if (logsCount.size == 1) return logsCount[0]

    val hashLogs = hashMapOf<Int, Int>()
    logsCount.forEachIndexed { index, value ->
        hashLogs[index] = value
    }

    var index = 0
    var lastIndex = -1
    val sortedMap = hashLogs.entries.sortedBy { it.value }.asReversed().associate { it.toPair() }
    sortedMap.forEach{ (key, value) ->
        if (index == 0){
            count = value
            lastIndex = key
        }else {
            val diff = lastIndex - key
            if (diff > 1){
                count += value
                lastIndex = key
            }
        }
        index++
    }

    return count
}
