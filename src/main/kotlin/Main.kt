class Pila(val tamanoMax : Int, val list: ArrayList<Any>){
    init {
        list.forEach { lista[lista.indexOfFirst { it == null }] = it }
    }
    private var lista= arrayOfNulls<Any>(tamanoMax)
    fun tope(): Any? = lista.last { it != null }
    fun push(anadir: String){
        lista[lista.indexOfFirst { it == null }] = anadir
    }
    fun pop(){
        lista[lista.indexOfLast { it != null }] = null
    }
    fun vacia(): Boolean = lista.all { it == null } || lista.all { it != null }

    fun reverse(): List<Any> {
        val listaRev : List<Any?> = lista.filterNotNull()
        val listaRevIterator = listaRev.listIterator()
        val contra : ArrayList<Any> = arrayListOf()
        while (listaRevIterator.hasNext()) listaRevIterator.next()
        while (listaRevIterator.hasPrevious()) {
            contra.add("${listaRevIterator.previous()}")
        }
        return contra
    }
}


fun main() {
    val numbers = Pila(4, arrayListOf("one", "two", "three", "four"))
    val numbersRev = numbers.reverse()
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
    else
        println("Correcto")
    println(numbersRev)
}