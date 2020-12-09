fun main() {
    val socks = arrayOf(1, 2, 1, 2, 1, 3, 2)
    print(sockMerchant(9, socks))
}

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    var count = 0
    val found = mutableListOf<Int>()
    ar.forEach {
        if (found.contains(it)){
            count++
            found.remove(it)
        }else {
            found.add(it)
        }
    }

    return count
}
