package pilha_dinamica

data class NoDuploPilha(var dado:Any?=null) {


   var  anterior: NoDuploPilha? = null
   var  proximo: NoDuploPilha? = null


}