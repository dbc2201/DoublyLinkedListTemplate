/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 13/02/20
 *   Time: 5:38 AM
 */

package main;

import definition.DoublyLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 to print the linked list.");
            System.out.println("Press 2 to add a new item.");
            System.out.println("Press 3 to remove a item.");
            System.out.println("Press 4 to search an item.");
            System.out.println("Press 5 to sort the linked list.");
            System.out.println("Press 6 to exit.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: /*PRINT THE LINKED LIST*/
                    System.out.println(list);
                    break;
                case 2: /*ADD A NEW ITEM*/
                    System.out.println("Please enter an integer to add to the list: ");
                    int number = scanner.nextInt();
                    list.add(number);
                    System.out.println(number + " added to the list!");
                    System.out.println(list);
                    break;
                case 3: /*REMOVE AN ITEM*/
                    break;
                case 4: /*SEARCH AN ITEM*/
                    break;
                case 5: /*SORT THE LINKED LIST*/
                    break;
                case 6: /*EXIT*/
                    System.exit(0);
                default:
                    break;
            }
        }/*
         *//*
         * The list is currently empty, let's print it, it would show
         * []
         * Remember, doing this is only possible because we had overridden the
         * toString() method in the DoublyLinkedList class.
         * *//*
        System.out.println(list);*/
    }
}
