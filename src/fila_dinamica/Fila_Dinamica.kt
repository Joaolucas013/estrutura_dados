package fila_dinamica

class Fila_Dinamica(var tamanho:Int = 10):EnfileiravelDinamica {

    var ponteiroFim: NoDuplo? = null
    var ponteiroInicio: NoDuplo? = null
    var quantidade: Int = 0


//

    override fun enfileirar(dado: Any?) {


    }

    override fun atualizar(dado: Any?) {

    }

    override fun frente(): Any? {
        var aux:Any? = null
        if(!estaVazia()){
            aux = ponteiroInicio?.dado
        } else{
            println("Fila esta vazia!!!")
        }
        return aux
    }

    override fun desenfileirar(): Any? {
       var aux:Any? = null
        if(!estaVazia()){
            aux = ponteiroInicio?.dado
            if(ponteiroInicio!=null){
                ponteiroInicio?.anterior= null
            } else{
                ponteiroFim
            }
        }

    }

    override fun estaCheia(): Boolean {
      return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
       return quantidade==0
    }

    override fun imprimir(): String {

    }

}