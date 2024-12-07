package heap


class HeapMin(private val tamanho:Int = 10):Amontoavel {

    private var dados = LongArray(tamanho) { 0 }
    private var ponteiroFim:Int = -1
    private var quantidade:Int = 0

    override fun inserir(dado: Long) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
            quantidade++
        } else {
            println("Heap esta cheia!!!")
        }
    }

     override fun ajustarAcima(indice: Int) {
        var indiceFilho = indice
        var indicePai = pai(indiceFilho)

        while (indiceFilho != 0) {
            if (dados[indicePai] > dados[indiceFilho]) {
                troca(indiceFilho, indicePai)
                indiceFilho = indicePai
                indicePai = pai(indiceFilho)
            } else {
                break
            }
        }
    }

    override fun ajustarAbaixo(indice: Int) {
        var pai = indice

        while (pai <= ponteiroFim) {
            var filhoEsquerdo = indiceFilhoEsquerdo(pai)
            var filhoDireito = indiceFilhoDireito(pai)
            var menorNumero = pai

            if (filhoEsquerdo <= ponteiroFim) {
                if (dados[filhoEsquerdo] < dados[menorNumero]) {
                    menorNumero = filhoEsquerdo
                }
            }
            if (filhoDireito <= ponteiroFim) {
                if (dados[filhoDireito] < dados[menorNumero]) {
                    menorNumero = filhoDireito
                }
            }

            if (menorNumero != pai) {
                troca(menorNumero, pai)
                pai = menorNumero
            } else {
                break;
            }
        }

    }

    override fun obter(): Long? {
       var aux:Long? = null
        if(!estaVazia()){
            aux = dados[0]
        } else{
            println("Heap está vazio!!!")
        }
        return aux
    }

    override fun troca(indiceUm: Int, indiceDois: Int) {  // indiceUm = 3, Indice2 = 5
        var aux = dados[indiceUm]   // aux = 3
        dados[indiceUm] = dados[indiceDois]   // indiceUM = 5
        dados[indiceDois] = aux               // IndiceDois = 3
    }


    override fun atualizar(novoDado: Long) {
        if(!estaVazia()){
            dados[0] = novoDado
            ajustarAbaixo(0)
        } else{
            println("Heap esta vazio")
        }
    }

    override fun remover(): Long? {
        var aux: Long? = null
        if (!estaVazia()) {
            aux = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            quantidade--
            ajustarAbaixo(0)
        } else {
            println("Heap está vazio!!!")
        }

        return aux
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == tamanho
    }

    override fun estaVazia(): Boolean {
       return ponteiroFim==-1
    }



    override fun imprimir(): String {
        var resultado = "["
        for (i in 0 until quantidade) {
            resultado += "${dados[i]}"
            if (i < quantidade - 1){
                resultado += ", "
            }
        }
        return "$resultado]"
    }


    override fun pai(indiceFilho: Int): Int {
        return (indiceFilho-1)/2
    }

    override fun indiceFilhoEsquerdo(indicePai: Int): Int { // 1  2  3  4  5  filho esquerdo de 1 = 0*2 + 1 filho = 2
        return (indicePai*2) +1                             // 0  1  2  3  4
    }

    override fun indiceFilhoDireito(indicePai: Int): Int { // 1  2  3  4  5 (filho direito de 1 = 0*2 + 2 - filho= 3
        return (indicePai*2) + 2                           // 0  1  2  3  4
    }

}

