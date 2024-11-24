package pilha_dinamica

class PilhaDinamica(var tamanho: Int): EmpilhavelDinamica{

    private var ponteiroTopo: NoDuploPilha? = null
    private var quantidade: Int = 0

    override fun estaCheia(): Boolean{
        return(quantidade == tamanho)
    }

    override fun estaVazia(): Boolean{
        return(quantidade == 0)
    }


     override fun empilhar(dado: Any?){
        if(!estaCheia()){
            val novoNo = NoDuploPilha(dado)
            if(!estaVazia()){
                ponteiroTopo?.proximo = novoNo
            }
            novoNo.anterior = ponteiroTopo
            ponteiroTopo  = novoNo
            quantidade++
        } else {
            println("Pilha está Cheia!")
        }
    }

    override fun atualizar(dado: Any?){
        if(!estaVazia()){
            ponteiroTopo?.dado = dado
        } else {
            println("Pilha está vazia !")
        }
    }

    override fun espiar(): Any?{
        var dadoAux: Any? = null
        if(!estaVazia()){
            dadoAux = ponteiroTopo?.dado
        } else {
            println("Pilha está vazia !")
        }
        return dadoAux
    }


    override fun desempilhar(): Any? {
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            if (ponteiroTopo != null) {
                ponteiroTopo?.proximo = null
                quantidade--
            }
        } else {
            println("Pilha esta vazia!!!")
        }
        return aux
    }



    override fun imprimir(): String {
        var aux: NoDuploPilha? = ponteiroTopo
        var retorno = "["
        while (aux != null) {
            retorno += "${aux.dado}"
            aux = aux.anterior
            if (aux != null) retorno += ", "
        }
        return "$retorno]"
    }


}