package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

class MyLinkedList {

    int count;
    ListNode head;
    ListNode tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.count = 0;
        this.head = null;
    }

    // I don't know, not working well hear...🤷‍♂️
    public MyLinkedList(int[] arr) {
        this.count = arr.length;
        int i = 0;
        while ( i < this.count) {
            addAtTail(arr[i]);
            i++;
        }
    }

    public void descripetion() {
        ListNode curr = this.head;
        int limit = 30;
        while (curr != null && limit > 0) {
            System.out.print(" -> " + "(" + curr.val + ")");
            curr = curr.next;
            limit--;
        }
    }



    public ListNode forword(int step, ListNode baseNode) {
        int i = step;
        ListNode curr = baseNode;

        while(i > 0 && curr != null) {
            ListNode temp = curr;

            System.out.print(" -> " + temp.val + " ");

            curr = temp.next;
            i--;
        }

        return curr;
    }

    public ListNode getNode(int index) {
        if(index >= 0 && index < this.count) {
            ListNode currentNode = this.head;
            for(int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
        return null;
    }

    public int getNodeVale(int index) {
        if(index < 0 || index >= this.count) return -1;
        ListNode node = this.getNode(index);
        return node.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = this.head;
        this.head = node;
        this.count += 1;
    }

    public void addAtTail(int val) {

        if(this.count  == 0) {
            this.head = new ListNode(val);
            this.tail = head;
        }else  {
            ListNode lastNode = getNode(this.count - 1);
            lastNode.next = new ListNode(val);
            this.tail = lastNode.next;
        }
        this.count += 1;
    }

    public void addAtIndex(int index, int val) {
        if(index > this.count || index < 0) {
            return;
        }else if(index == 0) {
            addAtHead(val);
        }else {
            ListNode node = new ListNode(val);
            ListNode preNode = getNode(index - 1);
            node.next = preNode.next;
            preNode.next = node;
            this.count += 1;
        }
    }

    public void deleteAtIndex(int index) {
        if(index >= this.count || index < 0) {
            return;
        }else {
            if(index == 0) {
                this.head = this.head.next;
            }else {
                ListNode preNode = getNode(index - 1);
                ListNode currentNode = getNode(index);
                preNode.next = currentNode.next;
            }
            this.count -= 1;
        }
    }
}

