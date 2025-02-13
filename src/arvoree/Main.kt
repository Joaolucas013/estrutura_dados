fun main() {

    var arvor = Arvore()
    arvor.inserir(10)
    arvor.inserir(11)
    arvor.inserir(12)
    arvor.inserir(13)
    arvor.inserir(14)
    print(arvor.buscar(12))
    print(arvor.buscar(10))
    arvor.apagar(10)
    println(arvor.imprimirEmOrdem())
}
