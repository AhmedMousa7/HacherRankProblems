
fun main(){
    val array = listOf<Int>(1)
    print(findMissingLog(array))
}

fun findMissingLog(sortedLogIds: List<Int>): Int {
    var missedId = sortedLogIds[sortedLogIds.size - 1] + 1
    var preId = 0

    sortedLogIds.forEach { id ->
        val diff = id - preId
        if (diff > 1){
             missedId = id - 1

            return missedId
        }
        preId = id
    }

    return missedId
}