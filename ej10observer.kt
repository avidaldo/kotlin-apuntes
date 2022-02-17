import java.util.*

/***************************************************************************
 ** Patrón observer ********************************************************
 ***************************************************************************
 *
 * https://www.baeldung.com/kotlin/observer-pattern
 *
 */

interface IObserver {
    fun update(estado: String)
}
class Observer1(var state: String) : IObserver {
    override fun update(newState: String) {
        state=newState
    }
}
class Observer2(var state: String) : IObserver {
    override fun update(newState: String) {
        state=newState
        println("Log: cambio de estado del Observer 1 a $state")
    }
}

/** Fuente de eventos */
class Subject() {
    var estado = "E0"   // Estado de la fuente de eventos (modelo?)
        set(value) {field=value; notifyObservers(field)} // Automatizamos la notificación de eventos a los suscriptores

    private var observers = mutableListOf<IObserver>() // Lista de observadores suscritos a la fuente de eventos

    private fun notifyObservers(event: String) {
        observers.forEach { it.update(event)}
    }

    fun addObserver(observer: IObserver) {
        observers.add(observer)
    }

}

fun main() {

    val vista = Observer2("Vista 0");

    val subject = Subject().apply {
        addObserver(vista)  // Suscribimos el observer a la fuente de eventos
    }

    subject.estado = "E1"
    subject.estado = "E2"

}




/** typealias permite crear un nombre alternativo para un tipo existente. En este caso nos permite
 * concretar un nombre que identifica una lambda que recibe un String como entrada.
 * En Kotlin nos puede permitir sustituir a la interfaz*/
typealias Observer = (event: String) -> Unit;

class EventSource {
    private var observers = mutableListOf<Observer>()

    private fun notifyObservers(event: String) {
        observers.forEach { it(event) }
    }

    fun addObserver(observer: Observer) {
        observers += observer
    }

    fun scanSystemIn() {
        val scanner = Scanner(System.`in`)
        while (scanner.hasNext()) {
            val line = scanner.nextLine()
            notifyObservers(line)
        }
    }
}

fun test() {
    println("Enter Text: ")
    val eventSource = EventSource()

    eventSource.addObserver { event ->
        println("Received response: $event")
    }

    eventSource.scanSystemIn()
}