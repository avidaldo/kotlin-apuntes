package ej2_oop.extra_mutable_field_visibility

import java.util.*

class PersonK(val name: String, val birthDate: Date) {
    // El IDE recomienda cambiar name a private, ya que no se está utilizando su getter.

    override fun toString(): String {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}'
    }
}

fun main() {
    val p = PersonK("Pepe", Date(90, Calendar.FEBRUARY, 1))
    println(p)

    //p.name = "Otro" // Error de compilación por ser val
    p.birthDate.date = 22
    println(p)
}
