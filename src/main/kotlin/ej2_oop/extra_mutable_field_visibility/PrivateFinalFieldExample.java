package ej2_oop.extra_mutable_field_visibility;

import java.util.Calendar;
import java.util.Date;

class Person {  // Desde Java 14 podría sustiturse por un record (https://www.baeldung.com/java-record-keyword)
    final String name;
    final Date birthDate;  // Debería ser también private para evitar el problema

    String getName() {
        return name;
    }

    Date getBirthDate() {
        return birthDate;
    }

    Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }


    public static void main(String[] args) {
        Person p = new Person("Pepe", new Date(90, Calendar.FEBRUARY, 1));
        System.out.println(p);

        //p.name = "Otro"; // Error de compilación por ser final
        p.birthDate.setDate(22);
        /* Permite cambiar el día por ser el tipo Date mutable. El campo no se reasigna (apunta al mismo
        objeto) así que no incumple ser final, pero el objeto se ha modificado. */

        System.out.println(p);
    }
}

/* La clase Date está deprecated, y debe utilizarse LocalDate, que ya es inherentemente inmutable, evitando este
problema. */
