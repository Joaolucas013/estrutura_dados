package heap

class HeapMin(private val tamanho:Int = 10):Amontoavel {

    private var dados = LongArray(tamanho) { 0 }
    private var ponteiroFim: Int = -1



    override fun inserir(dado: Long) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap esta cheia!!!")
        }
}


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

    private fun ajustarAbaixoRec(indice: Int) {
        val pai = indice
        val filhoEsquerdo = indiceFilhoEsquerda(pai)
        val filhoDireito = indiceFilhoDireita(pai)
        var menor = pai;    // Assume que o pai é o menor inicialmente
    
        if (filhoEsquerdo <= ponteiroFim)  // está dentro dos valores válidos do array (ou seja, o nó pai tem filho esquerdo)?
            if (dados[menor] > dados[filhoEsquerdo])  // filho menor que o pai?
                menor = filhoEsquerdo
    
        if (filhoDireito <= ponteiroFim)  // está dentro dos valores válidos do array (ou seja, o nó pai tem filho direito)?
            if (dados[menor] > dados[filhoDireito])  // filho menor que o pai?
                menor = filhoDireito
                
        // O menor não é o pai? Realiza a troca e continua ajustando para baixo
        if (menor != pai) {
            trocar(pai, menor)
            ajustarAbaixoRec(menor)
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

private fun troca(indice1: Int, indice2: Int) {
    val temp = dados[indice1]
    dados[indice1] = dados[indice2]
    dados[indice2] = temp
}

    override fun atualizar(novoDado: Long) {
        if(!estaVazia()){
            dados[0] = novoDado
            ajustarAbaixo(0)
        } else{
            println("Heap esta vazia!!!")
        }

    }

    override fun remover(): Long? {
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

    private fun filhoEsquerdo(indicePai: Int): Int {
        return (indicePai * 2 + 1)
    }

    private fun filhoDireito(indicePai: Int): Int {
        return (indicePai * 2 + 2)
    }


}
