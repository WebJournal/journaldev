package com.journaldev.linkedlist;

/**
 * A very simple linked list implementation
 * Not to use in application, created to show the linked list 
 * operations, hence very minimal features
 * 
 * @author pankaj
 *
 */
public class MyLinkedList {

	public Node head;

	public static class Node {

		public Node next;

		public Object data;

		public Node(Object data) {
			this.data = data;
			next = null;
		}
	}
}

