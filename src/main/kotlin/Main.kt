class Pila<T>(val tamanoMax : Int, val list: List<T>){
    private var lista: MutableList<T> = list as MutableList<T>
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

    fun reverse(): List<T> {
        val listaRev : List<T> = lista
        val listaRevIterator = listaRev.listIterator()
        val contra : MutableList<T> = mutableListOf()
        while (listaRevIterator.hasNext()) listaRevIterator.next()
        while (listaRevIterator.hasPrevious()) {
            contra.add(listaRevIterator.previous())
        }
        return contra
    }
}


fun main() {
    val numbers = Pila(5, arrayListOf("one", "two", "three", "four"))
    val numbersRev = numbers.reverse()
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
        else
        println("Correcto")
    println(numbersRev)
    numbers.push("five")
    println(numbers.list)
    println(numbers.vacia())
    numbers.pop()
    println(numbers.list)
}
fun comprobarTamano(){
    println("La lista ya tiene el tamaño máximo")
}