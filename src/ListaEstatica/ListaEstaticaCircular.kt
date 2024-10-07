package ListaEstatica

class ListaEstaticaCircular: Listavel {

    private  var ponteiroInicio:Int
    private var ponteiroFim:Int
    private var quantidade:Int
    private val dados:Array<Any?>

    constructor(tamanho:Int){
        quantidade=0
        ponteiroInicio=0
        ponteiroFim=-1
        dados= arrayOfNulls(tamanho)
    }

    override fun inserir(posicao: Int, dado: Any?) {
        if ((posicao >= 0) && (posicao < quantidade)) {
            if (!estaCheia()) {
                val posicaoFisica = (posicao + ponteiroInicio) % dados.size
                for (i in quantidade - posicao..0) {
                    dados[(posicaoFisica + 1 + i)%dados.size] = dados[(posicaoFisica + i) % dados.size]
                }

                dados[posicaoFisica] = dado
                ponteiroFim = (ponteiroFim+1)%dados.size
                quantidade++
            } else {
                println("Lista esta cheia")
            }
        } else{
            println("posicao inválida")
        }
    }

    // anexando na ultima posicao
    override fun anexar(dado: Any?) {
        if (!estaCheia()) {

            ponteiroFim = (ponteiroFim + 1) % dados.size
            dados[ponteiroFim] = dado
            quantidade++
        } else {
            println("list is full")
        }
    }

    override fun selecionar(posicao: Int): Any? {
        var aux: Any? = null
        if ((posicao >= 0) && posicao < quantidade) {
            val posicaoFisica = (ponteiroInicio + posicao) % dados.size
            aux = dados[posicaoFisica]
        } else {
            println("posicao inválida! ")
        }
        return aux
    }

    override fun selecionarTodos(): Array<Any?> {
        var dadosAuxiliar: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until quantidade) {
                dadosAuxiliar[i] = dados[(ponteiroAuxiliar + i)%dados.size]
                ponteiroAuxiliar++
            }

        } else {
            println("lista vazia")
        }
        return dadosAuxiliar
    }


    override fun atualizar(posicao: Int, dado: Any?) {
        if((posicao>=0) && posicao<quantidade){
            val posicaoFisica =(posicao+ponteiroInicio)%dados.size
            dados[posicaoFisica] = dado
        } else{
            println("posicao inválida!")
        }

    }

    override fun apagar(posicao: Int): Any? {
        var elementoRemovido: Any? = null
        if ((posicao >= 0) && (posicao < quantidade)) {
            if (!estaVazia()) {
                val posicaoFisica = (posicao + ponteiroInicio) % dados.size
                for (i in 0 until quantidade - posicao) {
                    dados[posicaoFisica + i] = dados[(posicaoFisica + 1 + i) % dados.size]
                }
                ponteiroFim--
                if (ponteiroFim == -1) {
                    ponteiroFim = dados.size - 1
                }
                quantidade--
            } else {
                println("lista esta vazia")
            }
        } else {
            println("Posicao inválida!!!")
        }
        return elementoRemovido

    }

    override fun limpar() {
        ponteiroFim=-1
        ponteiroInicio=0
        quantidade=0

    }


    override fun estaCheia(): Boolean {
        return quantidade==dados.size

    }

    override fun estaVazia(): Boolean {
        return quantidade==0

    }


    override fun imprimir(): String {
        var resultado = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 until quantidade) {
            resultado += if (i == ponteiroFim)
                "${dados[(ponteiroAux+i) % dados.size]}"
            else
                "${dados[(ponteiroAux+i) % dados.size]}, "
        }
        return "$resultado]"
    }




}
