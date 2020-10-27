
fun main() {
    print(countingValleys(9, "UUUDDD"))
}

fun countingValleys(steps: Int, path: String): Int {
    // Write your code here
    var count = 0
    var surface = 0
    var goingUp = false
    val pathChar = path.toCharArray()
    pathChar.forEach { char ->
        if (char == 'U'){
            if (surface == 0){
                goingUp = true
            }
            surface++
            if (surface == 0 && !goingUp){
                count++
            }
        }else {
            if (surface == 0){
                goingUp = false
            }
            surface--
            if (surface == 0 && !goingUp){
                count++
            }
        }
    }

    return count
}