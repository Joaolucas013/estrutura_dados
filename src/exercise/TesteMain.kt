package exercicioProva

fun main() {
   // var exercicio:InterfaceExercicio = ExercicioLista(10)
   var lista: ListavelLIstaDinamica = ListaDinamica(10)

  lista.inserir(0, 10)                         // 0
    lista.inserir(1, 20)                       // 1
    lista.inserir(2, 30)                          // 2
    lista.inserir(3, 40)                           // 3
    lista.inserir(4, 50)                          // 4

    lista.atualizarPosicaoLogica(400, 4)
    println(lista.imprimir()) // 10, 20 , 30 , 40 , 400
//    lista.inserirInicio(300)
//    println(lista.imprimir())

//   println("Elemento existe? " + lista.buscar(50))
//    println(lista.buscarElementoPosicaoLogica(0))  // saida deve ser 300

    //println(lista.buscarTodos().contentToString())

 //  lista.atualizarInicio(100)
     //println(lista.imprimir())

   // lista.atualizarPosicaoLogica(100, 1)
     //println(lista.imprimir())   // 10, 100, 30, 40, 50



//    fila.enfileirar(1)
//    fila.enfileirar(2)
//    fila.enfileirar(3)
//    fila.enfileirar(4)
//    fila.enfileirar(5)
//    println(fila.imprimir()) // 1 2 3 4 5
//    fila.desenfileirarFinal()
//    println(fila.imprimir()) // 1 2 3 4


  //println(pilha.decToBin(20))
   // println(pilha.imprimir())// Vai imprimir o conteúdo da pilha  5 4 3 2 1

}

