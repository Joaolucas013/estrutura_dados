package fila_dinamica

class Fila_Dinamica(var tamanho:Int = 10):EnfileiravelDinamica {

    var ponteiroFim: NoDuplo? = null
    var ponteiroInicio: NoDuplo? = null
    var quantidade: Int = 0


override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            var novoNo = NoDuplo(dado)
            novoNo.anterior = ponteiroFim
            if (!estaVazia()) {
                ponteiroFim?.proximo = novoNo
            } else {
                ponteiroInicio = novoNo
            }
            ponteiroFim = novoNo
            quantidade--
        } else {
            println("Fila Cheia!")
        }
    }

	override fun desenfileirar(): Any? {
		var dadoAux: Any? = null
		if (!estaVazia()) {
			dadoAux = ponteiroInicio?.dado
			ponteiroInicio = ponteiroInicio?.proximo
			quantidade = quantidade.dec()
			if (!estaVazia())
				ponteiroInicio?.anterior = null
			else
				ponteiroFim = null
		} else {
			println("Fila Vazia!")
		}
		return dadoAux
	}
	
	override fun frente(): Any? {
		var dadoAux: Any? = null
		if (!estaVazia())
			dadoAux = ponteiroInicio?.dado
		else
			println("Fila Vazia!")
		
		return dadoAux
	}

    override fun atualizar(dado: Any?) {
		if (!estaVazia())
			ponteiroInicio?.dado = dado 
		else
			println("Fila Vazia!")

	}	

	override fun estaCheia(): Boolean {
		return quantidade == tamanho
	}
	
	override fun estaVazia(): Boolean {
		return quantidade == 0
	}
	
	override fun imprimir(): String {
		var ponteiroAuxiliar = ponteiroInicio
		var resultado = "["
		for (i in 0 until quantidade) {
			resultado += "${ponteiroAuxiliar?.dado}"
			if (i != quantidade-1)
				resultado += ","
			
			ponteiroAuxiliar = ponteiroAuxiliar?.proximo
		}
		return "$resultado]"
	}

}
