import kotlin.math.abs

fun main(){

    println(rotLeft(arrayOf(1, 2, 3, 4, 5), 20).toList().toString())
}

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    if(d % a.size == 0) return a
    val newArray = a.clone()
    val d_ = if (d > a.size){ d % a.size } else { d }
    for (i in a.indices){
        var newPosition = i - d_
        if (newPosition < 0){
            newPosition = a.size - abs(newPosition)
        }
        newArray[newPosition] = a[i]
    }
    return newArray
}