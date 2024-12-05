package exercicioProva

import listadinamica.ListavelLIstaDinamica
import provaTest.pilhaDinamicaProva.listaProva.NoDuplo


//3. Implemente um método “boolean isPalindrome(String data)” para verificação de
//palíndromos utilizando Pilha Dinâmica.

class ExercicioLista(var tamanho:Int):InterfaceExercicio{

    // fila e lista
    var ponteiroInicio:NoDuplo? = null
    var ponteiroFim:NoDuplo? = null
    var quantidade:Int = 0

    // pilha
    var ponteiroTopo:NoDuplo? = null


    // exercicio 1 - sempre insere no inicio
    override fun InserirInicio(dado: Any?) {  // A B C ----> D A B C
        if (!estaCheia()) {
            var novoNo = NoDuplo(dado)
            if (!estaVazia()) {
                ponteiroInicio?.anterior = novoNo
            } else {
                ponteiroInicio = novoNo
            }
            novoNo.proximo = ponteiroInicio
            ponteiroInicio = novoNo
            quantidade++
        } else {
            println("Lista está cheia!!!")
        }
    }

    // exercicio 2
    override fun isPalindrome(palavra: String): Boolean {
        for (caracter in palavra) {
            this.empilhar(caracter) 
        }
        var palavraDesempilhada = ""
        while (!estaVazia()) {
            palavraDesempilhada += this.desempilhar()
        }
           return palavra.lowercase() == palavraDesempilhada.lowercase() // // algo como ANA retornaria true, mas ANa retornaria falso
    }

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            var novoNo = NoDuplo(dado)
            novoNo.anterior = ponteiroTopo
            if (!estaVazia()) {
                ponteiroTopo?.proximo = novoNo
            }
            ponteiroTopo = novoNo
            quantidade++
        } else {
            println("Pilha está Cheia!")
        }
    }

    override fun desempilhar(): Any? {
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            quantidade--
            if (!estaVazia()) {
                ponteiroTopo?.proximo = null
            }
        } else {
            println("Pilha está vazia!!!")
        }
        return aux
    }



    override fun estaCheia(): Boolean {
        return quantidade==tamanho
    }

    override fun imprimir(): String {
        TODO("Not yet implemented")
    }


   override fun estaVazia(): Boolean {
        return quantidade==0
    }


}
