package ej2_oop.properties

class PropertyAccessExample {
    var value: String? = null
        get() {
            println("property get value: $field")
            return field
        }
        set(value: String?) {
            println("property set value from $field to $value")
            field = value
        }

    var anotherValue: String? = null
        get() {
            println("property get value: $field")
            return field
        }
        set(value: String?) {
            println("property set value from $field to $value")
            field = value
        }
}

fun main() {
    val example1 = PropertyAccessExample()
    // property set
    example1.value = "example1"
    // property get
    println(example1.value)
}
