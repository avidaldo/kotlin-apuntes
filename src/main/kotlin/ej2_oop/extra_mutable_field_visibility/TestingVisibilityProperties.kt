package ej2_oop.extra_mutable_field_visibility

var varForDoingSomethingElse = 0
var varForUsingSetter = 0

class MyClass(var publicConstructorArgument: Int, private val privateConstructorArgument: Int) {

    var publicProperty = 0

    private var privateProperty = 0

    /* Opciones que no tienen sentido:

    private var privatePropertyPublicSetter = 0
        public set(value) { // Getter visibility must be the same as property visibility
            field = value; ej2_oop.extra.getVarForDoingSomethingElse = value
        }

    private var privatePropertyPublicGetter = 0
        public get() { // Getter visibility must be the same as property visibility
            ej2_oop.extra.getVarForDoingSomethingElse = field; return field
        }

    var publicPropertyPrivateGetter = 0
        private get() {  // Getter visibility must be the same as property visibility
            ej2_oop.extra.getVarForDoingSomethingElse = field; return field
        }

    */

    var publicVarPropertyPrivateSetter = 0
        private set(value) {
            field = value
            varForDoingSomethingElse = value
        }

    val publicValPropertyPrivateSetter = 0
/*        private set(value) {  // A 'val'-property cannot have a setter
            field = value
            ej2_oop.extra.getVarForDoingSomethingElse = value
        }*/

}


fun main() {
    val myObject = MyClass(publicConstructorArgument = 0, privateConstructorArgument = 0)
    // TODO: Ejemplo interesante para visibilidad dentro de una scope function

    myObject.publicConstructorArgument = 1
   // myObject.privateConstructorArgument = 1

    varForUsingSetter = myObject.publicValPropertyPrivateSetter
    //myObject.publicVarPropertyPrivateSetter = 1
}
