package exercicioProva

interface InterfaceExercicio {

 
    /////Lista//////
    fun InserirInicio(dado: Any?)


    ////Pilha//////
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun isPalindrome(palavra: String): Boolean

    ///Fila///
   // fun enfileirar(dado: Any?)
    fun desenfileirarFinal():Any?

    fun decToBin(dado:Int):Any?
     fun verificaExistencia(dado:Any?):Boolean
     fun buscarInicio(dado:Any?):Any?
     fun buscarElementoPosicaoLogica(posicao: Int): Any?
     
     fun buscarTodos(): Array<Any?>
     fun atualizarInicio(dado:Any?)
     fun atualizarFim(dado:Any?)
     fun atualizarPosicaoLogica(dado:Any?, posicao: Int)
     fun apagarInicioListaDinamica():Any?

    ////auxiliares/////
    fun estaVazia(): Boolean
    fun estaCheia(): Boolean
    //fun imprimir(): String
}
}