package exercicioProva

import listadinamica.ListavelLIstaDinamica
import provaTest.pilhaDinamicaProva.listaProva.NoDuplo



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
                ponteiroFIM= novoNo
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
        return palavra.lowercase() == palavraDesempilhada.lowercase()
    }


//  3. Implemente o método “Object removeEnd()” de uma Fila Dinâmica Duplamente Encadeada
////que sempre remove um dado do final da Estrutura de Dados.
    override fun desenfileirarFinal(): Any? {     // A B C D ---> A B C
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroFim?.dado
            ponteiroFim = ponteiroFim?.anterior
            quantidade--
            if (!estaVazia()) {
                ponteiroFim?.proximo = null
            } else {
                ponteiroInicio = null
            }
        } else {
            println("Fila esta vazia")
        }
        return aux
    }


//Implemente um método “String decToBin(String data)” que retorne a representação
//Binária de números Decimais, utilizando Pilha Dinâmica.

    override fun decToBin(dado: Int):String {
        var bin = ""
        var numero = dado

        while (numero>0){
            var resto = numero%2
            this.empilhar(resto)
            numero /= 2
        }

        while(!estaVazia()){
            bin += "${this.desempilhar()}"
        }
        return bin
    }

    override fun apagar(posicao: Int): Any? {       // A B C D ----> A B C
        var aux:Any? = null
        if (!estaVazia()) {
            if ((posicao >= 0) && (posicao <= quantidade)) {
                var inicio = ponteiroInicio

                for (i in 0 until posicao) {
                    inicio = inicio?.proximo
                }
                aux = inicio?.dado         // A B C   dadoAux = B
                var ponteiroAnterior = inicio?.anterior   // ponteiroAnterior = A
                var ponteiroProximo = inicio?.proximo       // ponteiroProximo = C

                if (ponteiroAnterior != null) {               // A aponta para C
                    ponteiroAnterior.proximo = ponteiroProximo
                } else {
                    ponteiroInicio = ponteiroInicio?.proximo   // É o primeiro elemento da lista e é movido para o proximo
                }
                if (ponteiroProximo != null) {
                    ponteiroProximo.anterior = ponteiroAnterior      // C aponta para A
                } else {
                    ponteiroFim = ponteiroFim?.anterior  // é o ultimo elemento da lista e recebe  o anterior
                }
                quantidade--
            } else {
                throw Exception("POSICÃO INVÁLIDA!!!")
            }
        } else {
            throw Exception("Lista está vazia!!!")
        }
        return aux
    }

    override fun apagarTodos() {
        if(!estaVazia()){
            var inicio = ponteiroInicio
            while(inicio?.proximo!=null){
                inicio.dado = null
                inicio = inicio.proximo
                quantidade--
            }
        }
    }

    //0. Inserir um dado no início de uma Lista Dinâmica.
    fun inserir(dado: Any?) {
        if (!estaCheia()) {
            var novoNo = NoDuplo(dado)
            novoNo.anterior = ponteiroFim
            if (!estaVazia()) {
                ponteiroFim?.proximo = novoNo
            } else {
                ponteiroInicio = novoNo
            }
            ponteiroFim = novoNo
            quantidade++
        } else {
            println("Fila Cheia!")
        }
    }

    //2. Inserir um dado numa posição lógica específica de uma Lista Dinâmica.
    fun inserirListaPosicaoExpecifica(dado:Any?, posicao:Int){   // A B C D ---> A B C D E   0 1 2 3 4
        if(!estaCheia()){
            if((posicao>=0) && (posicao<=quantidade)){
                var novoNo = NoDuplo(dado)
                var ponteiroAnterior:NoDuplo? = null
                var ponteiroProximo = ponteiroInicio

                for (i in 0 until posicao){
                    ponteiroAnterior = ponteiroProximo
                    ponteiroProximo = ponteiroInicio?.proximo
                }
                if(ponteiroAnterior!=null){
                    ponteiroAnterior.proximo = novoNo
                } else{
                    ponteiroInicio = novoNo
                }
                if(ponteiroProximo!=null){
                    ponteiroProximo.anterior = novoNo
                } else{
                    ponteiroFim = novoNo
                }
                novoNo.anterior = ponteiroAnterior
                novoNo.proximo = ponteiroProximo
                quantidade++
            } else{
                println("Posição inválida")
            }
        } else{
            println("Lista esta cheia!!!")
        }
    }

    // verifica se o dado existe na lista
    override fun verificaExistencia(dado:Any?):Boolean{
        var inicio = ponteiroInicio
        for (i in 0 until quantidade){
            if(inicio?.dado == dado){
                return true
            }
            inicio = inicio?.proximo
        }
        return false
    }

    //Buscar um dado do início de uma Lista Dinâmica.
    override fun buscarInicio(dado:Any?):Any?{
        var aux:Any? = null
        if(!estaVazia()){
            aux = ponteiroInicio?.dado
        }
        return aux
    }

    //4. Buscar um dado do fim de uma Lista Dinâmica.
    fun buscarFim(dado:Any?):Any?{
        var aux:Any? = null
        if(!estaVazia()){
            aux = ponteiroFim?.dado
        }
        return aux
    }

    //5. Buscar um dado de uma posição lógica específica em uma Lista Dinâmica.
   override fun buscarElementoPosicaoLogica(posicao: Int): Any? {
        var aux: Any? = null
        if (!estaVazia()) {
            if ((posicao >= 0) && (posicao <= quantidade)) {
                var inicio = ponteiroInicio
                for (i in 0 .. posicao) {
                    aux = inicio?.dado
                    inicio = inicio?.proximo
                }
            } else {
                println("Posição inválida!!!")
            }
        } else {
            println("Lista está vazia!!!")
        }
        return aux
    }

    override fun buscarTodos(): Array<Any?> {
        var aux: Array<Any?> = arrayOfNulls(quantidade)
        var inicio = ponteiroInicio
        if (!estaVazia()) {
            for (i in 0 until quantidade) {
                aux[i] = inicio?.dado
                inicio = inicio?.proximo
            }
        } else {
            println("Lista está vazia!!!")
        }
        return aux
    }

    //7. Atualizar o dado do início de uma Lista Dinâmica.
    override fun atualizarInicio(dado: Any?) {
        if(!estaVazia()){
            ponteiroInicio?.dado = dado
        } else{
            println("Lista está vazia!!!")
        }
    }

    //8. Atualizar o dado do fim de uma Lista Dinâmica.
    override fun atualizarFim(dado: Any?) {
        if (!estaVazia()) {
            ponteiroFim?.dado = dado
        } else {
            println("Lista está vazia!!!")
        }
    }

//   9. Atualizar uma posição lógica específica de uma Lista Dinâmica.
    override fun atualizarPosicaoLogica(dado: Any?, posicao: Int) {
        if(!estaVazia()){
            if((posicao>=0) && (posicao<=quantidade)){
                var ponteiroAnterior:NoDuplo?=null
                var ponteiroProximo = ponteiroInicio
                var novoNo = NoDuplo(dado)

                for (i in 0 until posicao){
                    ponteiroAnterior = ponteiroProximo
                    ponteiroProximo = ponteiroProximo?.proximo
                }
                if(ponteiroAnterior!=null){
                    ponteiroAnterior.proximo = novoNo
                } else{
                    ponteiroInicio = novoNo
                }
                if(ponteiroProximo!=null){
                    ponteiroProximo.anterior = novoNo
                } else{
                    ponteiroFim = novoNo
                }

            } else{
                println("Posição inválida!!!")
            }
        } else{
            println("Posição inválida!!!")
        }
    }

    //11. Apagar um dado do início de uma Lista Dinâmica.
    override fun apagarInicioListaDinamica(): Any? {
        var aux:Any? = null
        if(!estaVazia()){
             aux = ponteiroInicio?.dado
            ponteiroInicio = ponteiroInicio?.proximo
            quantidade--
            if(!estaVazia()){
                ponteiroInicio?.anterior = null
            } else{
                ponteiroFim = null
            }
        } else{
            println("Lista está vazia!!!")
        }
        return aux
    }

    override fun apagarFimListaDinamica(): Any? {
        var aux:Any? = null
        if(!estaVazia()){
            aux = ponteiroFim?.dado
            ponteiroFim = ponteiroFim?.anterior
            quantidade--
            if(!estaVazia()){
                ponteiroFim?.proximo = null
            } else{
                ponteiroInicio = null
            }
        }
        return aux
    }

    override fun apagarPosicaoLogica(posicao: Int): Any? {  // A B C ---> A C
            var aux: Any? = null
            if (!estaVazia()) {
                if ((posicao >= 0) && (posicao <= quantidade)) {
                    var inicio = ponteiroInicio

                    for (i in 0 until posicao) {
                        inicio = inicio?.proximo
                    }
                    aux = inicio?.dado         // A B C   dadoAux = B
                    var ponteiroAnterior = inicio?.anterior   // ponteiroAnterior = A
                    var ponteiroProximo = inicio?.proximo       // ponteiroProximo = C

                    if (ponteiroAnterior != null) {               // A aponta para C
                        ponteiroAnterior.proximo = ponteiroProximo
                    } else {
                        ponteiroInicio = ponteiroInicio?.proximo   // É o primeiro elemento da lista e é movido para o proximo
                    }
                    if (ponteiroProximo != null) {
                        ponteiroProximo.anterior = ponteiroAnterior      // C aponta para A
                    } else {
                        ponteiroFim = ponteiroFim?.anterior  // é o ultimo elemento da lista e recebe  o anterior
                    }
                    quantidade--
                } else {
                    throw Exception("POSICÃO INVÁLIDA!!!")
                }
            } else {
                throw Exception("Lista está vazia!!!")
            }
            return aux
        }

    override fun imprimirInicioFim(): String {
        var saida = "["
        if (!estaVazia()) {
            var fim = ponteiroFim
            for (i in 0 until quantidade) {
                saida += "${fim?.dado}"
                if (i != quantidade - 1) {
                    saida += ","
                }
                fim = fim?.anterior
            }
        } else {
            println("Lista esta vazia")
        }
        return "${saida}]"
    }

    /////////// metodos auxiliares //////////////
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

   override fun estaVazia(): Boolean {
        return quantidade==0
    }

    //0. Inserir um dado no início de uma Lista Dinâmica.                           //  feito

//1. Inserir um dado no fim de uma Lista Dinâmica.

//2. Inserir um dado numa posição lógica específica de uma Lista Dinâmica.         // feito

//3. Buscar um dado do início de uma Lista Dinâmica.                              // feito

//4. Buscar um dado do fim de uma Lista Dinâmica.                                 // feito

//5. Buscar um dado de uma posição lógica específica em uma Lista Dinâmica.     // feito

//6. Buscar todos os dados de uma Lista Dinâmica.                         // feito

//7. Atualizar o dado do início de uma Lista Dinâmica.           // feito

//8. Atualizar o dado do fim de uma Lista Dinâmica.           // feito

//9. Atualizar uma posição lógica específica de uma Lista Dinâmica.    // feito

//10. Atualizar todos os dados de uma Lista Dinâmica.

//11. Apagar um dado do início de uma Lista Dinâmica.           // feito

//12. Apagar um dado do fim de uma Lista Dinâmica.     // feito

//13. Apagar um dado uma posição lógica específica de uma Lista Dinâmica. // feito

//14. Apagar todos os dados de uma Lista Dinâmica. // feito

//15. Ordenar os dados de forma crescente de uma Lista Dinâmica.

//16. Ordenar os dados de forma decrescente de uma Lista Dinâmica.

//17. Inverter os dados de uma Lista Dinâmica.

//18. Imprimir os dados do início ao fim de uma Lista Dinâmica.    // feito

//19. Imprimir os dados do fim ao início de uma Lista Dinâmica.        // feito

//20. Verificar se um determinado dado existe em uma Lista Dinâmica.           // feito

//21. Verificar a posição lógica da primeira ocorrência de um determinado dado em uma Lista Dinâmica.

//22. Verificar a posição lógica da última ocorrência de um determinado dado em uma Lista Dinâmica


