package ListaEstatica

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var lista: Listavel = ListaEstaticaCircular(10)
    
    lista.anexar("Joao")
    lista.anexar("B")
    lista.anexar("C")
    lista.anexar("D")
    lista.inserir(2, "Inserido na posicao 2")
    println(  lista.imprimir() )
}
