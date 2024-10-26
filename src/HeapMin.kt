package heap

class HeapMin(private val tamanho:Int = 10):Amontoavel {

    private var dados = LongArray(tamanho) { 0 }
    private var ponteiroFim: Int = -1


    private fun ajustarAcima(indice: Int) {
        var indiceFilho = indice
        var indicePai = pai(indiceFilho)

        while (indiceFilho != 0) {
            if (dados[indicePai] > dados[indiceFilho]) {
                troca(indiceFilho, indicePai)
                indiceFilho = indicePai
                indicePai = indiceFilho
            } else {
                break
            }
        }
    }

    private fun ajustarAbaixo(indice:Int){
        var indicePai = indice
        var indiceFilhoEsquerda = filhoEsquerda(indicePai)
        var indiceFilhoDireita = filhoDireita(indicePai)


    }

    private fun ajustarAcimaRecursivo(indice: Int) {
        if (indice > 0) {
            val indiceFilho = indice
            val indicePai = pai(indiceFilho)
            if (dados[indiceFilho] < dados[indicePai]) {
                troca(indiceFilho, indicePai)
            }
            ajustarAcima(indicePai)
        }
    }

    override fun inserir(dado: Long) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap esta cheia!!!")
        }

    }

    override fun obter(): Long? {
        var aux: Long? = null
        if (!estaVazia()) {
            aux = dados[0]
        } else {
            println("Heap está cheio!!!")
        }
        return aux
    }

    private fun troca(i:Int, j:Int){
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp

    }

    override fun atualizar(novoDado: Long) {
        if(!estaVazia()){
            dados[0] = novoDado
            ajustarAbaixo(0)
        } else{
            println("Heap esta vazia!!!")
        }

    }

    override fun extrair(): Long? {
        var aux: Long? = null
        if (!estaVazia()) {
            aux = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
        } else {
            println("Heap esta vazia!!!")
        }
        return aux

    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == dados.size - 1

    }

    override fun estaVazia(): Boolean {
        return ponteiroFim == -1

    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in 0 until dados.size) {
            resultado += "${dados[i]}"
        }
        return "$resultado]"

    }
    private fun pai(indiceFilho: Int): Int {
        return (indiceFilho-1)/2
    }

    private fun filhoEsquerda(indicePai: Int): Int {
        return (indicePai * 2 + 1)
    }

    private fun filhoDireita(indicePai: Int): Int {
        return (indicePai * 2 + 2)
    }


}