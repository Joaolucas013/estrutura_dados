package listadinamica

interface ListavelLIstaDinamica {

    fun inserir(posicao: Int, dado: Any?)
    fun anexar(dado: Any?)
    fun atualizar(posicao: Int, dado: Any?)
    fun apagar(posicao: Int): Any?
    fun limpar()


    fun selecionar(posicao: Int): Any?
    
    fun selecionarTodos(): Array<Any?>



    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String

}