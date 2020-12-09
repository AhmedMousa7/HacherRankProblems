fun main() {
    val clouds = arrayOf(0, 0, 0, 0, 1, 0)
    print(jumpingOnClouds(clouds))
}

fun jumpingOnClouds(c: Array<Int>): Int {
    var position = 0
    var count = 0

    for (i in c.indices){
        var newPosition = position + 2
        if (newPosition < c.size){
            position = if (c[newPosition] == 0){
                newPosition
            }else {
                newPosition - 1
            }
            count++
        }else{
            newPosition = position + 1
            if (newPosition < c.size){
                if (c[newPosition] == 0){
                    position = newPosition
                    count++
                }
            }
        }
    }

    return count
}