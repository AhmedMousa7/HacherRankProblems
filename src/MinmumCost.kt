import kotlin.math.abs

fun main(){
    val array = arrayOf(1, 4, 2, 4)
    val array2 = arrayOf(4, 7, 9, 10)
    println(getMinCost(array,array2))
}

fun getMinCost(crew_id: Array<Int>, job_id: Array<Int>): Long {
    // Write your code here
    var count = 0L;

    val crewOrdered = crew_id.sortedArray()
    val jobIdOrdered = job_id.sortedArray()

    for (i in crewOrdered.indices){
        count+= abs(jobIdOrdered[i] - crewOrdered[i])
    }

    return count
}