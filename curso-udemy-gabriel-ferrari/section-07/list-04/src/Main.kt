fun main() {
    ex01()
    ex02()
    ex03()
    ex04("xxooox")
    ex04("xxxxo")
    ex04("bdefghjij")
    ex04("oooxzzzzz")
    desafio()
}

fun ex01(){
    var cont: Int = 0
    var res: Int = 0
    while(cont <= 1993){
        cont += 7
        res++
    }
    println("Foram usados $res baloes")
}

fun ex02(){
    for(i in 1..50){
        if(i % 3 == 0 && i % 5 == 0){
            println("$i = FizzBuzz")
        } else if(i % 3 == 0){
            println("$i = Buzz")
        } else if(i % 5 == 0){
            println("$i = Fizz")
        }
    }
}

fun ex03(){
    val text: String = "Meu nome é Julios."
    var cont: Int = text.length - 1
    while(cont >= 0){
        print(text[cont])
        cont--
    }
    println()
}

fun ex04(text: String){
    var cont: Int = 0
    var x: Int = 0
    var o: Int = 0
    while(cont < text.length){
        if(text[cont] == 'x'){
            x++
        } else if(text[cont] == 'o'){
            o++
        }
        cont++
    }
    if(x == o && x != 0){
        println("$text -> true")
    }else{
        println("$text -> false")
    }
}

fun desafio(){
    val salary = 10000 * 5 / 100
    var ana: Double = 0.0
    var paula: Double = 0.0
    var cont: Int = 0
    do{
        ana += salary + salary + (ana * 0.002)
        paula += salary + (paula * 0.008)
        cont++
    }while(ana > paula)
    println("Em $cont meses Ana acumulou R$$ana e Paula acumulou R$$paula")
}