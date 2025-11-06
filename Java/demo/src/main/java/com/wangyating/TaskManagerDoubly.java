package com.wangyating;

public class TaskManagerDoubly {
    TaskNode head=null;
    TaskNode tail=null;

    /**
     * 添加任务
     * @param id
     * @param description
     */
    public void addTask(int id, String description){
        TaskNode newNode = new TaskNode(id, description);
        if (head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    /**
     * 删除任务
     * @param id
     */
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("任务列表为空，无法删除");
            return;
        }

        TaskNode curr = head;

        // 找到要删除的节点
        while (curr != null && curr.id != id) {
            curr = curr.next;
        }

        // 未找到
        if (curr == null) {
            System.out.println("未找到ID为 " + id + " 的任务");
            return;
        }

        // 情况1：删除头结点
        if (curr == head) {
            head = curr.next;     // 头向后移
            if (head != null) {   // 防止链表变空
                head.prev = null;
            }
        }
        // 情况2：删除尾结点
        else if (curr.next == null) {
            curr.prev.next = null;
        }
        // 情况3：删除中间节点
        else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        System.out.println("已删除任务ID: " + id);
    }
    public void printTasks(){
        TaskNode curr = head;
        while (curr != null){
            System.out.println("任务ID: " + curr.id + ", 描述: " + curr.description);
            curr = curr.next;
        }
    }

}
