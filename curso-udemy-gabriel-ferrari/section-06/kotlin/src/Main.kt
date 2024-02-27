import kotlin.math.cbrt

fun main() {
    println("Digite a quantidade de anos: ")
    val num = readln().toInt()
    transformYear(num)
    println()

    println("Digite um texto para saber o tamanho: ")
    val text = readln()
    println("O tamanho da string é ${textSize(text)}")
    println()

    println("Digite um numero para calcular o cubo: ")
    val num2 = readln().toInt()
    cube(num2)
    println()

    println("Digite a quantidade em milhas para converter em km: ")
    val num3 = readln().toDouble()
    println("${num3} em km é ${num3 * 1.6}")
    println()

    println("Digite um texto: ")
    val text2 = readln()
    println("Texto convertido: ${convertToX(text2)}")
}

fun transformYear(num: Int){
    println("$num anos equivalem a:")
    println("${num * 12} meses")
    println("${num * 365} dias")
    println("${num * 8760} horas")
    println("${num * 525600} minutos")
    println("${num * 31536000} segundos")
}

fun textSize(text: String) = text.length

fun cube(num: Int){
    println("$num ao cubo é: ${num * num * num}")
}

fun convertMiles(num: Double): Double{
    return num * 1.6
}

fun convertToX(text: String): String {
    val newText = text.replace("a", "x", ignoreCase = true).uppercase()
    return newText
}