fun main() {
    val array = arrayOf(63,50,10,10)
    print(filledOrders(array, 70))
}

fun filledOrders(orders: Array<Int>, k: Int): Int {
    // Write your code here
    var count = 0
    var availableAmount = k

    val sortedArray = orders.sortedArray()
    sortedArray.forEachIndexed{ index, order ->
        if (order <= availableAmount){
            count++
            availableAmount -= order
            val nextIndex = index + 1
            if (nextIndex != sortedArray.size){
                if (sortedArray[nextIndex] > availableAmount) {
                    return count
                }
            }
        }
    }

    return count
}