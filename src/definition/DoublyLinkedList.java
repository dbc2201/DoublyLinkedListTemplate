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

    // we will also store the current size of the linked list in an integer variable
    int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    /**
     * This is a private helper method.
     * This method will add the first node in the linked list when the list is empty.
     *
     * @param item the data that is to be stored in the node.
     * @return true when the node adds in the linked list.
     */
    private boolean addFirst(E item) {
        // create a node that will store the data 'item'
        Node<E> node;
        // check if the linked list is empty
        if (head == null) {
            /*
             * Since this is the first node in the list, and the current values of head and tail are
             * null, the steps are:
             * 1. Create the node with the data 'item'.
             * 2. Set node.previous to null [new Node<>(item, -->null<--, null);].
             * 3. Set node.next to null [new Node<>(item, null, -->null<--);].
             * 4. Make the head refer to this new node [head = node].
             * 5. Make the tail refer to this new node [tail = node].
             * 6. Increase the size of the linked list.
             * */
            node = new Node<>(item, null, null);
            head = node;
            tail = node;
        } else {
            /*
             * In this case, the head is not null, so it means that there are some nodes
             * present in the linked list. The steps are:
             * 1. Create the node with the data 'item'.
             * 2. Set the node.previous to null [new Node<>(item, -->null<--, head)].
             * 3. Set the node.next to head [new Node<>(item, null, -->head<--)].
             * 4. Set the head.previous to this new node [head.previous = node].
             * 5. Make the head refer to this new node [head = node].
             * */
            node = new Node<>(item, null, head);
            head.previous = node;
            head = node;
        }
        size++;
        return true;
    }

    /**
     * This is a private helper method.
     * This method will add a new node after a given node.
     *
     * @param node the after which a new node is to be added.
     * @param item the data which is to be stored in the node.
     * @return true when the node adds to the linked list.
     */
    private boolean addAfter(Node<E> node, E item) {
        /*
         * Fetch the next node of the given node.
         * The current arrangement in the linked list is like this
         * node <--> nextNode
         * We will create a new node [newNode] and add it after 'node' such that the
         * arrangement looks like this
         * node <--> newNode <--> nextNode
         * */
        Node<E> nextNode = node.getNext();

        // check if the 'nextNode' is null, that would mean the 'node' is the last node of the linked list.
        if (nextNode == null) {
            /*
             * create the new node, set the data 'item'
             * set the previous to node [node <-- newNode]
             * set the next to null [newNode --> null]
             * set node.next = newNode [node --> newNode]
             * node <--> newNode --> null
             * make the tail node refer to this node. [tail = newNode;].
             *          tail --|
             *                 V
             * node <-->    newNode <--> null
             * */
            Node<E> newNode = new Node<>(item, node, null);
            node.next = newNode;
            tail = newNode;
        } else {
            /*
             * create the new node, set the data 'item'
             * set the previous to node [node <-- newNode]
             * set the next to nextNode [node --> nextNode]
             * set node.next to newNode [node --> newNode]
             * set nextNode.previous to newNode [newNode <-- nextNode]
             * node <--> newNode <--> nextNode
             * */
            Node<E> newNode = new Node<>(item, node, nextNode);
            node.next = newNode;
            nextNode.previous = newNode;
        }
        // increase the size of the linked list
        size++;
        return true;
    }

    /**
     * This is a private helper method.
     * This method will return a node from the linked list based off of its 'assumed' index.
     *
     * @param index index of the node starting from 0
     * @return the node at the given index
     */
    private Node<E> getNode(int index) {
        Node<E> response = head;
        for (int i = 0; i < index && response != null; i++) {
            response = response.getNext();
        }
        return response;
    }

    /**
     * This is a public helper method, this will be exposed to other classes.
     * This method will add a new node at a specified index.
     *
     * @param index the index at which the new node is to be added.
     * @param item  the data of the node to be added.
     * @return true when the node adds to the linked list.
     * @throws IndexOutOfBoundsException when the index is out of range (index < 0 || index > size).
     */
    public boolean add(int index, E item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return addFirst(item);
        } else {
            return addAfter(getNode(index - 1), item);
        }
    }

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

    /*
     * This toString() method will allow us to print the whole linked list with just
     * sending an object of this list as a parameter to the System.out.print() method.
     * */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        /*
         * Create a temporary node that has the reference value of the head node.
         * This means, temp is now also referring to the node that head was referring earlier.
         * So, we can traverse this linked list without actually disturbing the actual reference of the
         * head node or the references of the data nodes in the list.
         * */
        Node<E> currentNode = head;
        for (int i = 0; i < size && currentNode != null; i++) {
            // fetch the data from the current node.
            E data = currentNode.getData();

            // append the data to the string builder object
            sb.append(data);

            // append the commas after the data
            sb.append(i < size - 1 ? ", " : "");

            // change the reference of the temp variable to the next node.
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
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
