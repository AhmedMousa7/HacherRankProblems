
fun main() {
    print(repeatedString("x", 970770))
}

fun repeatedString(s: String, n: Long): Long {
    if (s.length == 1 && s[0] == 'a') return n
    var counter: Long = 0
    s.forEach { char ->
        if (char == 'a')
            counter++
    }
    val factor = n / s.length
    counter *= factor
    val rem = n % s.length
    for (i in 0 until rem){
        if (s[i.toInt()] == 'a'){
            counter++
        }
    }

    return counter
}