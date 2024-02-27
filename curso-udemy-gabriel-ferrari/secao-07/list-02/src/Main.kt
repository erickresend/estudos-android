fun main() {
    println("Digite o primeiro número:")
    val num1 = readln().toInt()
    println("Digite o segundo número:")
    val num2 = readln().toInt()
    if(itsSquare(num1, num2)){
        println("Formam um quadrado")
    } else{
        println("Não formam um quadrado")
    }

    println("Digite o primeiro número:")
    val num3 = readln().toInt()
    println("Digite o segundo número:")
    val num4 = readln().toInt()
    println("Digite o terceiro número:")
    val num5 = readln().toInt()
    if(equilateralTriangle(num3, num4, num5)){
        println("Formam um triângulo equilátero")
    } else{
        println("Não formam um triângulo equilátero")
    }

    qualASaida(4)

    println("Digite sua idade: ")
    val age = readln().toInt()
    if(age < 18){
        return println("Negado. Menores de idade não são permitidos")
    }
    println("Qual seu tipo de convite:")
    val invite = readln().lowercase()
    if(invite == "comum" || invite == "premium" || invite == "luxo"){
        println("Qual o código do convite")
        val code = readln().lowercase().trim()
        if(code[0] == 'x'){
            if(code[1] == 'l' || code[1] == 't'){
                return println("Welcome")
            } else{
                return println("Negado. Convite inválido")
            }
        } else{
            return println("Negado. Convite inválido")
        }
    }
    else{
        return println("Negado. Convite inválido")
    }
}

fun itsSquare(num1: Int, num2: Int): Boolean{
    return num1 == num2
}

fun equilateralTriangle(num3: Int, num4: Int, num5: Int): Boolean{
    return (num3 == num4) && (num4 == num5)
}

fun qualASaida(num6: Int){
    if(num6 >= 0){
        if(num6 == 0)
            println("Primeira string")
        else println("Segunda string")
    }
    println("Terceira string")
}