package exercicioProva

interface InterfaceExercicio {

     /////Lista//////
    fun InserirInicio(dado: Any?)


    ////Pilha//////
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun isPalindrome(palavra: String): Boolean
     fun apagar(posicao:Int):Any?
     fun apagarTodos()
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
     fun apagarFimListaDinamica():Any?
     fun apagarPosicaoLogica(posicao:Int):Any?
     fun imprimirInicioFim(): String
     fun inserirSempreInicio(dado: Any?)   // A B C ----> D A B C
       fun verificarPosicao(dado:Any):Int
     fun posicaoUltimaOcorrencia(dado: Any?): Int

    ////auxiliares/////
    fun estaVazia(): Boolean
    fun estaCheia(): Boolean
    //fun imprimir(): String
}
