
class Arvore: Arborizavel {

    private var raiz: NoTriplo? = null


    override fun getRaiz(): NoTriplo? {
        return raiz
    }

    override fun inserir(dado: Any?) {
        var novoNo = NoTriplo(dado)

        if (raiz == null) {
            raiz = novoNo
        } else {
            var auxiliar = raiz
            while (auxiliar != null) {
                if ((auxiliar.dado) as Int > (dado as Int)) {
                    // vai pra esquerda
                    if (auxiliar.esquerda != null) {
                        auxiliar = auxiliar.esquerda
                    } else {
                        auxiliar.esquerda = novoNo
                        novoNo.genitor = auxiliar
                        break
                    }
                } else{
                    // vai pra direita
                    if(auxiliar.direita!=null){
                        auxiliar = auxiliar.direita
                    } else{
                        auxiliar.direita = novoNo
                        novoNo.genitor = auxiliar
                        break
                    }
                }
            }
        }
    }

    override fun apagar(dado: Any?){
        var no = buscar(dado as Int)
        if(no == null){
            return
        }
        if(no.esquerda == null && no.direita == null){
            removeSemFilhos(no)
        } else if(no.esquerda == null || no.direita == null){
            removeUnicoFilho(no)
        } else{
            apagarDoisFilhos(no)
        }
    }

    private fun apagarDoisFilhos(no: NoTriplo) {
        val sucessor = encontrarSucessor(no)

        if (sucessor != null) {
            no.dado = sucessor.dado  // Copiamos o valor do sucessor para o nó atual

            // Agora removemos o sucessor, que terá no máximo um filho
            if (sucessor.esquerda == null && sucessor.direita == null) {
                removeSemFilhos(sucessor)
            } else {
                removeUnicoFilho(sucessor)
            }
        }
    }

    private fun encontrarSucessor(no: NoTriplo): NoTriplo? {
        var atual = no.direita  // Começamos pela subárvore direita

        while (atual?.esquerda != null) {
            atual = atual.esquerda  // Descemos sempre pela esquerda
        }
        return atual
    }


    private fun removeUnicoFilho(dado: NoTriplo?) {
        var aux = dado?.genitor
        var filho = dado?.esquerda ?: dado?.direita

        if (aux == null) {
            raiz = filho
            filho?.genitor = null
        } else if (aux.esquerda == dado) {
            aux.esquerda = filho
        } else {
            aux.direita = filho
        }
        filho?.genitor = aux
    }

    private fun removeSemFilhos(no: NoTriplo) {
        val aux = no.genitor

            if (aux == null) { // Se não tem genitor, é a raiz
                raiz = null
            } else if (aux.esquerda == no) {
                aux.esquerda = null
            } else if (aux.direita == no) {
                aux.direita = null
            }
        }


    override fun existe(dado: Any?): Boolean {
        var aux = raiz
        while (aux != null) {

            if (aux.dado as Int == dado as Int) {
                return true
            }
            if (aux.dado as Int > dado as Int) {
                aux = aux.esquerda
            } else{
                aux = aux.direita
            }
        }
        return false
    }

    override fun buscar(dado: Any): NoTriplo? {
        var aux = raiz

        while (aux != null) {
            if (aux.dado == dado) {
                return aux
            } else if ((aux.dado as Int) > (dado as Int)) {
                aux = aux.esquerda
            } else {
                aux = aux.direita
            }
        }

        return null
    }

    override fun limpar() {
      raiz = null
    }

    override fun imprimirPreOrdem(): String {
        TODO("Not yet implemented")
    }

    override fun imprimirEmOrdem(): String {
        TODO("Not yet implemented")
    }

    override fun imprimirPosOrdem(): String {
        TODO("Not yet implemented")
    }
}