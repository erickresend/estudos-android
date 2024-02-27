fun main() {
    ex01()
    println()
    ex02()
    println()
    ex03()
    println()
    ex04()
    println()
    ex05(5)
}

fun ex01(){
    for(i in 1..50){
        print("$i ")
    }
}

fun ex02(){
    for(i in 50 downTo 1){
        print("$i ")
    }
}

fun ex03(){
    for(i in 1..50){
        if(i % 5 != 0){
            print("$i ")
        }
    }
}

fun ex04(){
    var sum = 0
    for(i in 1..500){
        sum += i
    }
    print(sum)
}

fun ex05(n: Int){
    for(i in 1..n) {
        for (j in 1..i) {
            print("#")
        }
        println()
    }
}