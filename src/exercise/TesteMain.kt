package exercicioProva

fun main() {
    var exercicio:InterfaceExercicio = ExercicioLista(10)


    println(exercicio.isPalindrome("Joao")) // false
    println(exercicio.isPalindrome("NATAn")) // true
    println(exercicio.isPalindrome("ANA")) // true

}

