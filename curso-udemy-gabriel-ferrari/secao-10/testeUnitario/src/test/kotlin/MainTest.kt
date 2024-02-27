import org.junit.jupiter.api.*

class MainTest {

    @Test
    @DisplayName("Teste metodo xxoo")
    fun testCountXO(){
        //assert all é pra mesmo se der erro ele rode todos
        Assertions.assertAll(
            {Assertions.assertTrue(countXO("xxoo"))},
            {Assertions.assertTrue(countXO("xXoo"))},
            {Assertions.assertTrue(countXO("xxOo"))},
            {Assertions.assertFalse(countXO("xxoox"))}
        )
    }

    //disabled é para desabilitar algum teste que sera implementado depois
    @Test
    @Disabled
    fun naoImplementado(){

    }

    //Usado para forçar uma falha
    @Test
    fun vaiFalhar(){
        fail("Não posso terminar os testes sem esse metodo")
    }

    @Test
    fun assumption(){
        //rodar o restante do código só se o countXO for true, não falha mas tb, nao testa
        Assumptions.assumeTrue(countXO("xxoo"))
        Assertions.assertTrue(abc())
    }
}