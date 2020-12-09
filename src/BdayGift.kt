
fun main(){

    println(solve(arrayOf(1,1,2)))
}


fun solve(balls: Array<Int>): Double {

    return balls.sum().toDouble() / 2.0
}
