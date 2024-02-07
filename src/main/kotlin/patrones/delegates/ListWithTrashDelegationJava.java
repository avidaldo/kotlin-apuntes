package patrones.delegates;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListWithTrashDelegationJava<T> implements Collection<T> {
    private final List<T> innerList = new ArrayList<>();
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
        return innerList.remove(o);
    }

    // Other methods from Collection interface need to be implemented and can delegate to innerList
    @Override
    public int size() {
        return innerList.size();
    }

    @Override
    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return innerList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return innerList.iterator();
    }

    @Override
    public Object[] toArray() {
        return innerList.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return innerList.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return innerList.add(t);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return innerList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return innerList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return innerList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return innerList.retainAll(c);
    }

    @Override
    public void clear() {
        innerList.clear();
    }



    public static void main(String[] args) {
        ListWithTrashDelegationJava<String> list = new ListWithTrashDelegationJava<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove("b");
        System.out.println(list.getDeletedItem()); // b
    }

}
