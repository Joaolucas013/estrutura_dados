package pilha_dinamica

fun main(){
    var pilha: EmpilhavelDinamica = PilhaDinamica(8)

    pilha.empilhar("Instituto")
    pilha.empilhar("Federal")
    println(pilha.imprimir()) // Vai imprimir o conteúdo da pilha
    println(pilha.espiar())
}