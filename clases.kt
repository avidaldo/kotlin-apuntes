//https://stackoverflow.com/questions/44368741/expecting-member-declaration-in-kotlin



class Persona(private val nombre: String, var edad: Int?) {

    fun presentacion() {
        println("$nombre tiene $edad años")
    }

}

data class PersonaData(
    val nombre: String,
    var edad: Int?
)

class Persona2(private var data: PersonaData) {

    override fun toString(): String {
        data.edad?.let { return "${data.nombre} tiene ${data.edad} años" }
            ?: run { return "${data.nombre} no tiene edad registrada" }

    }
}

fun pruebasPersona() {
    val persona1 = Persona("Alejandro Vidal", 35)
    persona1.presentacion()
    persona1.edad = 36
    persona1.presentacion()


    val persona2Data = PersonaData("María", 29)
    val persona2 = Persona2(persona2Data)
    println(persona2.toString())
    persona2Data.edad = 30
    println(persona2.toString())
    persona2Data.edad = null
    println(persona2.toString())

}