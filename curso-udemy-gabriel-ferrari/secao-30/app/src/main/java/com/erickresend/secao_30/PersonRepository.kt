package com.erickresend.secao_30

class PersonRepository {

    fun login(email: String, password: String): Boolean {
        return (email != "" && password != "")
    }
}