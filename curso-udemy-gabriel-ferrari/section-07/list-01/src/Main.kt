fun main() {
    var bonus: Int
    println("Digite o cargo:")
    val cargo = readln().lowercase()
    println("Digite o tempo de experiência em meses")
    val tempo = readln().toInt()
    if(cargo == "gerente") {
        bonus = 2000
        if (tempo > 24) {
            bonus += 1000
            println("Seu cargo é $cargo e seu bônus é de R$${bonus}")
        } else {
            println("Seu cargo é $cargo e seu bônus é de R$${bonus}")
        }
    }
    else if(cargo == "coordenador"){
        bonus = 1500
        if (tempo > 12){
            bonus += 300
            println("Seu cargo é $cargo e seu bônus é de R$${bonus}")
        }else{
            println("Seu cargo é $cargo e seu bônus é de R$${bonus}")
        }
    }
    else if(cargo == "engenheiro de software"){
        bonus = 1000
        println("Seu cargo é $cargo e seu bônus é de R$${bonus}")
    }
    else if(cargo == "estagiario"){
        bonus = 500
        println("Seu cargo é $cargo e seu bônus é de R$${bonus}")
    }
    else{
        println("Cargo não encontrado")
    }
}