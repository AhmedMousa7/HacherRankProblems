import kotlin.time.measureTimedValue

fun main(){
    val (value, duration) = measureTimedValue {
        minimumBribes(arrayOf(1, 2, 5, 3, 7, 8, 6, 4))
    }
    println(value)
    println(duration)
}

fun minimumBribes(q: Array<Int>): Unit {
    var bribes = 0
    var expectedFirst = 1
    var expectedSec = 2
    var expectedThird = 3
    for (element in q){
        when (element) {
            expectedFirst -> {
                expectedFirst = expectedSec
                expectedSec = expectedThird
                expectedThird++
            }
            expectedSec -> {
                bribes++
                expectedSec = expectedThird
                expectedThird++
            }
            expectedThird -> {
                bribes += 2
                expectedThird++
            }
            else -> {
                println("Too chaotic")
                return
            }
        }
    }
    println(bribes)
}