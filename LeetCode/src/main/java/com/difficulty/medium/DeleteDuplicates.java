package com.difficulty.medium;

import java.util.ArrayList;

/**
 * @ClassName DeleteDuplicates
 * @Description 82题 删除排序链表中的重复元素2  [1,2,3,3,4,4,5]
 * @Author DeleteDuplicates
 * @Data 2022/1/11 11:36
 **/
public class DeleteDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(5);
        ListNode head = insert(arrayList);
//        while (head!=null||head.next!=null){
//            System.out.println(head.val);
//            if(head.next!=null){
//                head=head.next;
//            }else {
//                break;
//            }
//        }

        ListNode cur = deleteDuplicates(head);
        while (cur != null || cur.next != null) {
            System.out.println(cur.val);
            if (cur.next != null) {
                cur = cur.next;
            } else {
                break;
            }
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dd = new ListNode(0, head);
        ListNode cur = dd;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dd.next;
    }

    public static ListNode insert(ArrayList<Integer> arrayList) {
        ListNode x = null;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            ListNode h = new ListNode(arrayList.get(i), x);
            x = h;
        }
        return x;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}