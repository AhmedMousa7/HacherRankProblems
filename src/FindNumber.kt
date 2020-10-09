
fun main(){
    val array = listOf<Int>(1,2,3,4,5,6)
    print(findNumber(array,2))
}

fun findNumber(arr: List<Int>, k: Int): Int {
    var low = 0
    var mid: Int
    var high = arr.size - 1

    while (low <= high){
        mid = (low + high) / 2
        when{
            k > arr[mid] -> low = mid + 1 // element is greater than middle element of array, so it will be in right half of array
            k == arr[mid] -> return mid
            k < arr[mid] -> high = mid - 1 // element is less than middle element of array, so it will be in left half of array
        }
    }

    return -1
}