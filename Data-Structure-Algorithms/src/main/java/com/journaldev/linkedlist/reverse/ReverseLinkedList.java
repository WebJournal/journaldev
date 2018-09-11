package com.journaldev.linkedlist.reverse;

import com.journaldev.linkedlist.MyLinkedList;
import com.journaldev.linkedlist.MyLinkedList.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.head = new Node(1);
		myLinkedList.head.next = new Node(2);
		myLinkedList.head.next.next = new Node(3);

		printLinkedList(myLinkedList);
		// recursive reverse
		myLinkedList.head = recursiveReverse(myLinkedList.head);
		printLinkedList(myLinkedList);
		
		//iterative reverse
		reverseLinkedList(myLinkedList);
		printLinkedList(myLinkedList);

	}

	/**
	 * utility method to print linked list elements
	 * @param linkedList
	 */
	public static void printLinkedList(MyLinkedList linkedList) {
		Node h = linkedList.head;
		while (linkedList.head != null) {
			System.out.print(linkedList.head.data + " ");
			linkedList.head = linkedList.head.next;
		}
		System.out.println();
		linkedList.head = h;
	}

	/**
	 * reversing a linked list using iterative approach
	 * @param linkedList
	 */
	public static void reverseLinkedList(MyLinkedList linkedList) {
		Node previous = null;
		Node current = linkedList.head;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		linkedList.head = previous;
	}

	/**
	 * reverse a linked list using recursion
	 * @param head
	 * @return
	 */
	public static Node recursiveReverse(Node head) {
		Node first;

		if (head.next == null)
			return head;

		first = recursiveReverse(head.next);
		head.next.next = head;
		head.next = null;

		return first;
	}
}
