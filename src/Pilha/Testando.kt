package Pilha

fun main(args: Array<String>) {
        var pilha: Empilhavel = PilhaEstatica(100)
          pilha.empilhar("Joao")
    pilha.empilhar("Lucas")
    pilha.empilhar("da")
    pilha.empilhar("Silva")
    pilha.empilhar("Correia")
    pilha.empilhar("Flamengo")
    pilha.empilhar("Palmeiras não tem mundial")
    println(pilha.espiar()) // palmeiras..
     pilha.desempilhar() // palmeiras
    println(pilha.espiar()) // flamengo
     println(  pilha.estaVazia())
    println(pilha.estaCheia())
}
