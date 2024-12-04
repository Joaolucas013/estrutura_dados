package listadinamica

class ListaDinamicaProva(private val tamanho:Int):ListavelLIstaDinamica{

    var ponteiroInicio:NoDuploListaDinamica? = null
    var ponteiroFim:NoDuploListaDinamica? = null
    var quantidade:Int= 0


    override fun inserir(posicao: Int, dado: Any?) {
        if (!estaCheia()){
            if ((posicao>=0) && (posicao<=quantidade)){

                val novoNo = NoDuploListaDinamica(dado)
                var anterior: NoDuploListaDinamica? = null
                var proximo = ponteiroInicio

                for (i in 0 until posicao) {
                    anterior = proximo
                    proximo = proximo?.proximo
                }

                if (anterior != null) {
                    anterior.proximo = novoNo
                } else {
                    ponteiroInicio = novoNo
                }
                if (proximo != null) {
                    proximo.anterior = novoNo
                } else {
                    ponteiroFim = novoNo
                }
                novoNo.proximo = proximo
                novoNo.anterior = anterior
                quantidade++
            } else {
                println("Posição Inválida!")
            }
        } else {
            println("Lista Cheia!")
        }
    }
    
  override fun apagar(posicao: Int): Any? { // remover B
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if ((posicao >= 0) && (posicao <= quantidade)) {
                var inicio = ponteiroInicio

                for (i in 0 until posicao) {
                    inicio = inicio?.proximo
                }
                dadoAux = inicio?.dado         // A B C   dadoAux = B
                var ponteiroAnterior = inicio?.anterior   // ponteiroAnterior = A
                var ponteiroProximo = inicio?.proximo       // ponteiroProximo = C

                if (ponteiroAnterior != null) {               // A aponta para C
                    ponteiroAnterior.proximo = ponteiroProximo
                } else {
                    ponteiroInicio =
                        ponteiroInicio?.proximo   // É o primeiro elemento da lista e é movido para o proximo
                }
                if (ponteiroProximo != null) {
                    ponteiroProximo.anterior = ponteiroAnterior      // C aponta para A
                } else {
                    ponteiroFim = ponteiroFim?.anterior  // é o ultimo elemento da lista e é movido para o anterior
                }
                quantidade--
            } else {
                throw Exception("POSICÃO INVÁLIDA!!!")
            }
        } else {
            throw Exception("Lista está vazia!!!")
        }

        return dadoAux
    }
    override fun limpar() {
        quantidade=0
        ponteiroFim= null
        ponteiroInicio = null
    }


    override fun anexar(dado: Any?) {
        if (!estaCheia()) {
            val novoNo = NoDuploListaDinamica(dado)
            novoNo.anterior = ponteiroFim
            if (!estaVazia()) {
                ponteiroFim?.proximo = novoNo
            } else {
                ponteiroInicio = novoNo
            }
            ponteiroFim = novoNo
            quantidade++
        } else{
            throw  NoSuchElementException("Lista vazia!!!")
        }

    }

    override fun atualizar(posicao: Int, dado: Any?) {
        if (!estaVazia()) {
            if (posicao >= 0 || posicao < quantidade) {
                var aux = ponteiroInicio
                for (i in 0 until posicao) {
                    aux = aux?.proximo
                    aux?.dado = dado
                }
            } else {
                throw IndexOutOfBoundsException("Posicão inválida!!!!")
            }
        }
    }



    override fun selecionar(posicao: Int): Any? {
        var dadoTemp:Any? = null

        if (!estaVazia()) {
            if ((posicao >= 0) || (posicao < quantidade)) {
                var aux = ponteiroInicio
                for (i in 0 until posicao) {
                    aux = aux?.proximo
                }
                dadoTemp = aux?.dado
            } else{
                throw IndexOutOfBoundsException("Posicão inválida!!!!")
            }
        } else{
            throw NoSuchElementException("Lista vazia")
        }
        return dadoTemp
    }

   override fun selecionarTodos(): Array<Any?> {

        val arrayDados: Array<Any?> = arrayOfNulls(quantidade)
        var aux = ponteiroInicio
        if (!estaVazia()) {
            for (i in 0 until quantidade) {
                arrayDados[i] = aux?.dado
                aux = aux?.proximo
            }
        } else {
            println("Lista esta vazia!!!")
        }
        return arrayDados
    }

   override fun imprimir(): String {
       var aux = ponteiroInicio
        var saida = "["

       for (i in 0 until  quantidade){
            saida+= aux?.dado
            if(i!=quantidade-1){
                saida+=","
            }
            aux = aux?.proximo
        }
        return "${saida}]"
    }

  override fun estaCheia(): Boolean {
        return quantidade==tamanho
    }

  override  fun estaVazia(): Boolean {
        return quantidade==0
    }


}
