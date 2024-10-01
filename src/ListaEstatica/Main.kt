package ListaEstatica

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var lista: Listavel = ListaEstaticaCircular(10)
    lista.anexar("A")
    lista.anexar("B")
    lista.inserir(2,"C")
    println("${lista.imprimir()}") //[A,B,C]
    lista.anexar("D")
    lista.apagar(0)
    lista.inserir(0,"E")
    lista.inserir(2,"F");
    println("${lista.imprimir()}") //[E,B,F,C,D]
    println("${lista.selecionar(1)}") //B
    lista.atualizar(1,"G")
    println("${lista.imprimir()}") //[E,G,F,C,D]
}