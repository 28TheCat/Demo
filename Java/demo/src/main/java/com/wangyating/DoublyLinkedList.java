package com.wangyating;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;

    /**
     * 添加元素
     * @param value
     */
    public void add(int value){
        DoublyNode newNode = new DoublyNode(value);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    /**
     * 打印链表
     */
    void print(){
        DoublyNode curr=head;
        while(curr!=null){
            System.out.print(curr.value+"<->");
            curr=curr.next;
        }
        System.out.println();
    }

    /**
     * 打印链表（前）
     */
    public void printForward() {
        DoublyNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

     /**
     * 打印链表（后->前）
     */
     public void printBackward() {
        DoublyNode curr = tail;
        while (curr != null) {
            System.out.print(curr.value + " <-> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }
}
