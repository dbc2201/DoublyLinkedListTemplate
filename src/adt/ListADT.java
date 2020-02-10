/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 10/02/20
 *   Time: 5:21 PM
 */

package adt;

/**
 * This is the Interface for the List ADT.
 * This will serve as the template for the Doubly-Linked List.
 */
public interface ListADT<E> {
    boolean add(E item);

    E remove();

    int search(E item);

    void sort();
}
