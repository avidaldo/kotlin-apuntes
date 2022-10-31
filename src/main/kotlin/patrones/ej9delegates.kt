
/***************************************************************************
 ** Delegación de clases **********************************
 **************************************************************************
 *
 * https://medium.com/androiddevelopers/delegating-delegates-to-kotlin-ee0a0b21c52b
 *
 */


/** Caso de uso: queremos poder recuperar el último item eliminado de un ArrayList */


/** Con herencia */
class ListWithTrashInheritance<T> : ArrayList<T>() {
    var deletedItem: T? =null

    override fun remove(element: T): Boolean {
        deletedItem = element
        return super.remove(element)
    }

}

/** Con delegación */
class ListWithTrashDelegation <T>(
    val innerList: MutableList<T> = ArrayList<T>()
) : MutableCollection<T> by innerList {
    var deletedItem : T? = null

    override fun remove(element: T): Boolean {
        deletedItem = element
        return innerList.remove(element)
    }
}


fun main(){
    var lista1 = ListWithTrashInheritance<String>().apply {
        addAll(arrayListOf("one","two", "three", "four"))
    }
    val lista2 = arrayOf("one","two", "three", "four").toCollection(ListWithTrashInheritance())

    println(lista1)
    println(lista2)

    println(lista1.apply { remove("two")  }.deletedItem)
    println(lista1.apply { remove("two") }.deletedItem)



    var lista3 = ListWithTrashDelegation<String>().apply {
        addAll(arrayListOf("one","two", "three", "four"))
    }
    val lista4 = arrayOf("one","two", "three", "four").toCollection(ListWithTrashDelegation())

    println(lista3.innerList)
    println(lista4.innerList)

    println(lista3.apply { remove("two")  }.deletedItem)
    println(lista4.apply { remove("two") }.deletedItem)

}






