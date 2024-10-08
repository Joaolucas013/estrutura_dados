package Fila

class FilaEstatica(private val tamanho: Int = 10) : Enfileiravel {

    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)

    override fun atualizar(dado: Any?) {
        if (!estaVazia())
            dados[ponteiroInicio] = dado
        else
            println("Fila esta vazia!")
    }

    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
        } else {
            println("Fila esta vazia!")
        }
    }

    override fun desenfileirar(): Any? {
        var dadoInicio: Any? = null
        if (!estaVazia()) {
            dadoInicio = dados[ponteiroInicio]
            ponteiroInicio++
        } else {
            println("Fila esta vazia!")
        }
        return dadoInicio
    }

    override fun frente(): Any? {
        var dadoInicio: Any? = null
        if (!estaVazia()) {
            dadoInicio = dados[ponteiroInicio]
        } else {
            println("Fila esta vazia!")
        }
        return dadoInicio
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == dados.size - 1
    }

    override fun estaVazia(): Boolean {
        return ponteiroInicio == ponteiroFim + 1
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in ponteiroInicio..ponteiroFim) {
            if (i == ponteiroFim)
                resultado += "${dados[i]}"
            else
                resultado += "${dados[i]},"
        }
        return "$resultado]"
    }
}
