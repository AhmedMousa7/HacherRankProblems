import kotlin.math.pow

fun main() {
    val events = arrayOf(
            arrayOf("setPassword 000A", "authorize 108738450", "authorize 108738449")
            //arrayOf("setPassword d", "authorize 100")
    )
    print(authEvents(events).joinToString("\n"))
}

fun authEvents(events: Array<Array<String>>): Array<Int> {
    // Write your code here
    val outputList = mutableListOf<Int>()
    var password: CharArray?= null
    events.forEach {event ->
        event.forEach {it ->
            val actionSeparated = it.split(" ")
            if (actionSeparated.size >= 2) {
                val action = actionSeparated[0]
                val value = actionSeparated[1]
                if (action == "setPassword"){
                    password = value.toCharArray()
                }else if (action == "authorize"){
                    val passwordHashed = getPasswordHashed(password!!)
                    val diff = value.toLong() - passwordHashed
                    if (diff == 0L){
                        outputList.add(1)
                    }else if (diff > 0L){
                        if (diff >= 32){
                            outputList.add(1)
                        }else {
                            outputList.add(0)
                        }
                    } else {
                        outputList.add(0)
                    }
                }
            }
        }
    }

    return outputList.toTypedArray()
}

private fun getPasswordHashed(charArray: CharArray): Long {
    var outPut = 0.0
    val p = 131.0
    val m = 10.0.pow(9) + 7
    var sum: Double = 0.0
    var i = 1
    charArray.forEach {char ->
        sum += char.toInt() * p.pow(charArray.size - i)
        i++
    }
    outPut = sum.rem(m)

    return outPut.toLong()
}