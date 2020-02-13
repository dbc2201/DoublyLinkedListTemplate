/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 13/02/20
 *   Time: 5:38 AM
 */

package main;

import definition.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        /*
         * The list is currently empty, let's print it, it would show
         * []
         * Remember, doing this is only possible because we had overridden the
         * toString() method in the DoublyLinkedList class.
         * */
        System.out.println(list);
    }
}
