package patrones.delegates;

import java.util.*;

public class ListWithTrashInheritanceJava<T> extends ArrayList<T> {
    private T deletedItem;

    public T getDeletedItem() {
        return deletedItem;
    }

    public void setDeletedItem(T deletedItem) {
        this.deletedItem = deletedItem;
    }

    @Override
    public boolean remove(Object o) {
        setDeletedItem((T) o);
        return super.remove(o);
    }

    // No es necesario implementar los métodos de la interfaz Collection, ya que ArrayList ya lo hace

    public static void main(String[] args) {
        ListWithTrashInheritanceJava<String> list = new ListWithTrashInheritanceJava<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.remove("b");
        System.out.println(list.getDeletedItem());
    }

}

