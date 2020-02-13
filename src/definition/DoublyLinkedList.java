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

    /*
     * The linked list class has two 'extra' nodes at all times that actually do not
     * store any data like the other nodes but are actually necessary for the operations
     * of the linked list class. These nodes are the 'head', and the 'tail' node.
     * They are reference variables and hence only store references to other 'data' nodes.
     * */

    private Node<E> head = null;
    private Node<E> tail = null;

    // we will also store the current size of the linked list in an integer variable
    int size = 0;

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

    /**
     * This is the actual Node class.
     * It is defined generic so that our Node could store a data of 'any' type.
     * This will serve as the blueprint of a node in our double linked list.
     * A node of a double linked list contains three fields:
     * 1. A 'data' variable to store the actual data of the node.
     * 2. A 'previous' reference variable to store the reference of the previous node.
     * 3. A 'next' reference variable to store the reference to the next node.
     */
    private static class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        private Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        private E getData() {
            return data;
        }

        private Node<E> getPrevious() {
            return previous;
        }

        private Node<E> getNext() {
            return next;
        }
    }
}
