fun main() {
    val arr1 = arrayOf(-1, -1, 0, -9, -2, -2)
    val arr2 = arrayOf(-2, -1, -6, -8, -2, -5)
    val arr3 = arrayOf(-1, -1, -1, -2, -3, -4)
    val arr4 = arrayOf(-1, -9, -2, -4, -4, -5)
    val arr5 = arrayOf(-7, -3, -3, -2, -9, -9)
    val arr6 = arrayOf(-1, -3, -1, -2, -4, -5)
    val array = arrayOf(arr1, arr2, arr3, arr4, arr5, arr6)
    println(hourglassSum(array))
}

fun hourglassSum(arr: Array<Array<Int>>): Int {
    if (arr.isEmpty()) return 0
    val listOfSums = mutableListOf<Int>()
    var sum = 0
    val diff = arr.size - 2
    val hourglassCount = (diff) * (arr[0].size - 2)
    var boundry = Triple(0, 1, 2)
    var mid = boundry.second
    var horizontail = 0
    var vertical = 0
    for (i in 1..hourglassCount) {
        if (horizontail >= diff){
            boundry = boundry.copy(0, 1, 2)
            mid = boundry.second
            horizontail = 0
            vertical++
        }
        sum = arr[vertical][boundry.first] + arr[vertical][boundry.second] + arr[vertical][boundry.third] +
                arr[vertical + 1][mid] +
                arr[vertical + 2][boundry.first] + arr[vertical + 2][boundry.second] + arr[vertical + 2][boundry.third]

        listOfSums.add(sum)
        horizontail++
        boundry = boundry.copy(boundry.first + 1, boundry.second + 1, boundry.third + 1)
        mid++
    }

    return listOfSums.max() ?: 0
}