package com.journaldev.linkedlist.loopDetection;

import com.journaldev.linkedlist.MyLinkedList;
import com.journaldev.linkedlist.MyLinkedList.Node;

public class DetectLinkedListLoop {

	public static void main(String[] args) {

		MyLinkedList myLinkedList = new MyLinkedList();

		myLinkedList.head = new Node(1);
		myLinkedList.head.next = new Node(2);
		Node node = myLinkedList.head.next.next = new Node(3);
		myLinkedList.head.next.next.next = new Node(4);
		myLinkedList.head.next.next.next.next = new Node(5);
		myLinkedList.head.next.next.next.next.next = node;

		System.out.println("Has Loop? " + hasLoop(myLinkedList));
		System.out.println("Start Node data: " + startNode(myLinkedList).data);
		System.out.println("Length of loop: " + lengthOfLoop(myLinkedList));

		myLinkedList.head = removeLoop(myLinkedList);
		System.out.println("Has Loop? " + hasLoop(myLinkedList));
	}

	private static boolean hasLoop(MyLinkedList myLinkedList) {

		Node head = myLinkedList.head;

		Node slow = head;
		Node fast = head;

		boolean loop = false;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				loop = true;
				break;
			}
		}

		return loop;
	}

	private static Node startNode(MyLinkedList myLinkedList) {

		Node head = myLinkedList.head;
		Node slow = head;
		Node fast = head;

		boolean loop = false;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				loop = true;
				break;
			}
		}

		if (loop) {

			slow = head;

			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}

			return fast;

		} else {
			return new Node(Integer.MIN_VALUE);
		}
	}

	private static int lengthOfLoop(MyLinkedList myLinkedList) {
		Node head = myLinkedList.head;
		Node slow = head;
		Node fast = head;

		boolean loop = false;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				loop = true;
				break;
			}
		}

		if (loop) {

			int length = 0;
			slow = head;

			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}

			do {
				fast = fast.next;
				length++;
			} while (fast != slow);

			return length;

		}

		return 0;
	}

	private static Node removeLoop(MyLinkedList myLinkedList) {
		Node head = myLinkedList.head;
		Node slow = head;
		Node fast = head;

		boolean loop = false;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				loop = true;
				break;
			}
		}

		if (loop) {

			slow = head;

			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}

			while (fast.next != slow) {
				fast = fast.next;
			}

			fast.next = null;

			return head;

		}

		return head;
	}

}
