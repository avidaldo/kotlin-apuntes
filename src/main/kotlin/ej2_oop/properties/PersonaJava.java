package ej2_oop.properties;

public class PersonaJava {
    private final String nombre;
    private int edad;  // (1)

    public PersonaJava(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0) this.edad = edad;
        else throw new RuntimeException("Edad no válida");
    }

}

/*
(1) Es un mal diseño, forzado para ver la conversión a Kotlin. No tiene
sentido asignar una edad 0 por defecto al instanciar el objeto, pero
si metemos int en el constructor (probadlo), se convierte a Kotlin con
un setter de propiedad.
 */
