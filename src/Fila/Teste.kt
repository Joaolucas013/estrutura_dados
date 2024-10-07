package Fila
fun main() {
    var fila: Enfileiravel = FilaEstatica()
    fila.enfileirar("Joao")
   // fila.enfileirar("Lucas")
   fila.enfileirar("Flamengo")
    println(fila.frente())  // joao
    println(fila.estaCheia()) // false
   // println(  fila.desenfileirar()) // joao
    println(fila.imprimir()) // lucas, flamengo


}
