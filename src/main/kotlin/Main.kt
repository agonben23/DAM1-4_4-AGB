class Pila<T>(val tamanoMax : Int){
    private var lista: MutableList<T> = mutableListOf()
    fun tope(): Any? = lista.last()
    fun push(anadir: T){
        if (lista.size < tamanoMax){
            lista.add(lista.size,anadir)
        }else
            comprobarTamano()
    }
    fun pop(){
        lista.removeAt(lista.size - 1)
    }
    fun vacia(): Boolean = lista.size == 0 || lista.size == tamanoMax


}


fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbersRev = reverse(numbers)
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
        else
        println("Correcto")
    println(numbersRev)
}
fun comprobarTamano(){
    println("La lista ya tiene el tamaño máximo")
}
fun reverse(listaRev : List<String>): List<String> {
    val pila = Pila<String>(5)
    listaRev.forEach { pila.push(it) }
    val listaRevIterator = listaRev.listIterator()
    val contra : MutableList<String> = mutableListOf()
    while (listaRevIterator.hasNext()) listaRevIterator.next()
    while (listaRevIterator.hasPrevious()) {
        contra.add(listaRevIterator.previous())
    }
    return contra
}