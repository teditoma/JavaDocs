package exercise5;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Theodor.Toma on 7/7/2017.
 */
public class MyImplementedList<E> implements Iterable<E> {

    /**
     * The maximum accepted load property of the data structure.
     */
    private static final double LOAD_FACTOR = 0.75d;

    /**
     * The factor for increasing the size of the data structure.
     */
    private static final int INCREASE_SIZE_FACTOR = 2;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * The array buffer into which the elements of the {@link MyImplementedList} are stored.
     */
    private Object[] elementData;

    public Comparator<E> comparator;
    /**
     * Property to keep the extended capacity.
     * TODO if you choose another way to implement the extending capacity you can define your own properties,
     * TODO but the rest of them must remain as they are.
     */
    private int capacityAfterExtending;

    //TODO a) implement the empty constructor for the your data structure
    public MyImplementedList() {
        //TODO a) HINT - DEFAULT_CAPACITY, capacityAfterExtending and elementData properties
        this.size = 0;
        this.capacityAfterExtending = DEFAULT_CAPACITY;
        this.elementData = new Object[DEFAULT_CAPACITY];
        comparator = new Comparator<E>() {
            public int compare(E o1, E o2) {
                if ( o1.hashCode() == o2.hashCode() )
                    return 0;
                if (o1.hashCode() < o2.hashCode())
                    return -1;
                return 1;
            }
        };
    }

    //TODO b) create the int size() method that returns the size of the data structure
    public int size() {
        return size;
    }

    //TODO c) create the boolean add(E e) method that adds at the end of the data structure an element
    //TODO pay attention to the LOAD_FACTOR of the data structure
    public boolean add(E e) {
        extendCapacity();

        elementData[size] = e;
        size++;
        return true;
    }

    //TODO d) create the boolean isEmpty() method that checks if the data structure have elements
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    //TODO e) create the boolean contains(Object o_O) method that checks if the data structure contains the object o_O
    public boolean contains(Object o) {
        boolean found = false;
//        if (o instanceof E)
//            throw new WrongClassException();
//        else
        for (Object e : elementData)
            if (o.equals(e))
                found = true;
        return found;
    }

    //TODO f) create the int indexOf(Object o_O) method that returns the position in the data structure of the object o_O
    //TODO if exists, otherwise return -1
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (o.equals(elementData[i]))
                return i;
        return -1;
    }

    //TODO g) create the int lastIndexOf(Object o_O) method that returns the last position in the data structure of the object o_O
    //TODO if exists, otherwise return -1
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--)
            if (o.equals(elementData[i]))
                return i;
        return -1;
    }

    //TODO h) create the E get(int index) method that returns the object from the given index
    //TODO pay attention to the size property
    public E get(int index) {
        if (index < size)
            return (E) elementData[index];
        return null;
    }

    //TODO i) create the E set(int index, E element) method that updates the value of the element from the given index
    //TODO pay attention to the size property
    public E set(int index, E element) {
        if (index < size) {
            elementData[index] = element;
            return element;
        }
        return null;
    }

    //TODO j) create the E remove(int index) method that removes the element from the given index
    public E remove(int index) {
        E e = (E) elementData[index];
        for (int i = index; i < size - 1; i++)
            elementData[i] = elementData[i + 1];
        elementData[size - 1] = null;
        size--;
        return e;
    }

    //TODO k) extend the current default capacity, if the number of elements in the data structure is > 75% of it
    //TODO you should name it: void extendCapacity(int capacity) - HINT use capacity, DEFAULT_CAPACITY, LOAD_FACTOR and INCREASE_SIZE_FACTOR
    private void extendCapacity() {
        if (size > LOAD_FACTOR * capacityAfterExtending) {
            Object[] elementAux = new Object[size * INCREASE_SIZE_FACTOR];
            capacityAfterExtending = size * INCREASE_SIZE_FACTOR;
            for (int i = 0; i < size; i++)
                elementAux[i] = elementData[i];
            elementData = elementAux;
        }
    }



    //TODO l) implement the iterator() method in order to use the foreach statement over your data structure - HINT Iterable interface
    //TODO and implement a custom iterator for your custom data structure - methods boolean hasNext(), Object next() and void remove()
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int pos = 0;

            public boolean hasNext() {
                if (pos != size)
                    return true;
                return false;
            }

            public E next() {
                return (E) elementData[pos++];
            }

            public void remove() {

            }
        };
        return iterator;
    }

    //TODO m) implement a method, that uses a Comparator, for your data structure to sort the elements
    //TODO you should name it: void sort(Comparator<? super E> c)
    //TODO create a custom comparator that compares objects by their "what you want" :D - HINT Comparator interface


    public void sort(Comparator<? super E> c) {
        for (int i = 0; i < size-1; i++)
            for (int j = i+1; j < size; j++) {
                if (c.compare((E) elementData[i], (E) elementData[j]) > 0) {
                    E aux = (E) elementData[i];
                    elementData[i] = (E) elementData[j];
                    elementData[j] = aux;
                }
            }
        for (int i = 0; i < size; i++)
            System.out.print(elementData[i].hashCode() + " ");
        System.out.println();
    }

    @Override
    public String toString() {
        String print = "[";
        for (int i = 0; i < size-1; i++)
            print += elementData[i] + ", ";
        print += elementData[size-1] + "]";
        return print;
    }
}
