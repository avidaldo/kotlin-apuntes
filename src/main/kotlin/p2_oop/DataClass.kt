/**
 * Partimos de la clase Question que tiene tres propiedades, si queremos hacer un print directamente 
 * en el main de objetos de esta clase tenemos el problema de que se imprime el nombre de la clase
 * y el identificador del objeto, si quisieramos imprimir sus propiedades habría que reescribir
 * el toString(), sin embargo, hay una forma más rápida de hacer esto en kotlin a través de la 
 * definición de dicha clase con una data class */

class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

/**
 * Esta clase es idéntica a la anterior pero la hemos definido como data class, esto hace que kotlin
 * por detrás genere directamente en tiempo de compilaciónuna serie de métodos muy utilizados en las
 * clases que representan modelos de datos, como por ejemplo el toString() entre otros.
 */

data class QuestionDataClass<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

/**
 * Los métodos que se implementan directamente son los siguientes:
 * equals() :  para poder comparar dos objetos
	hashCode() (verás este método cuando trabajes con ciertos tipos de colecciones)
	toString()
	componentN(): component1(), component2(), etc.
	copy() :  para poder realizar una copia de un objeto en otra variable en lugar de un alias
 */



fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    println(question1.toString()) // prints : Question@3941a79c

    val questionData1 = QuestionDataClass<String>("Quoth the raven ___", "nevermore", "medium")
	println(questionData1.toString()) // prints : QuestionDataClass(questionText=Quoth the raven ___, answer=nevermore, difficulty=medium)
}
