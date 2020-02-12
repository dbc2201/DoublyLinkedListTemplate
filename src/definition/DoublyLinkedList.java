/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 13/02/20
 *   Time: 5:20 AM
 */

package definition;

import adt.ListADT;

/**
 * This is our definition class for a Double Linked List.
 * The actual Node class (generic) and all the methods (API) of the linked list will
 * be implemented here.
 */
public class DoublyLinkedList<E> implements ListADT<E> {
    @Override
    public boolean add(E item) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public int search(E item) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
