package com.company;

public class Main {

    public static void main(String[] args) {

        // A. creat a list
        int[] arr = {100,200,300,400};
        MyLinkedList list = new MyLinkedList();
        int count = arr.length;
        int i = 0;
        while ( i < count) {
            list.addAtTail(arr[i]);
            i++;
        }

        // B. make circle
        ListNode tail = list.tail;
        tail.next = list.head;
//        list.descripetion();

        // C. checkout circle
        ListNode curr = list.head;
        ListNode fast = null;
        if(curr == null) {
            System.out.println("  false here , because empty list ...");
            return;
        }

        int tt = 0;
        while (curr != null && tt <= 20) {



            tt++;
            fast = forword(tt,curr);

            System.out.println("\n fast: " + fast.val + " & slow: " + curr.val);
            if(curr == fast) {
                System.out.println("  circle here with value " + curr.val);
                break;
            }

            curr = curr.next;
        }

    }

    static ListNode forword(int step, ListNode baseNode) {
        int i = step;
        ListNode curr = baseNode;

        while(i > 0 && curr != null) {
            ListNode temp = curr;

//            System.out.print(" -> " + temp.val + " ");

            curr = temp.next;
            i--;
        }

        return curr;
    }

    void test001() {
//        int[] arr = {100,200,300,400};
//        MyLinkedList list = new MyLinkedList();
//
//        int count = arr.length;
//        int i = 0;
//        while ( i < count) {
//            list.addAtTail(arr[i]);
//            i++;
//        }
//        list.descripetion();
//
//        ListNode aaa = list.forword(2,list.head);
//        System.out.println("\n -->> " + aaa.val);
    }
}
