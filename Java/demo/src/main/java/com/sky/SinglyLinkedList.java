package com.sky;

public class SinglyLinkedList {
    SinglyNode head;

    /**
     * 插入到链表后面
     * @param value
     */
    public void add(int value) {
        SinglyNode newNode = new SinglyNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        SinglyNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    /**
     * 打印链表D
     */
    public void printList() {
        SinglyNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}