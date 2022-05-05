package com.data_structure.linklist;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SingleList
 * @Description 单项链表
 * @Author alms
 * @Data 2022/4/24 11:58
 **/
public class SingleList {
    private Node head ;
    private int size ;

    public SingleList() {
    }

    public SingleList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    /**无序插入**/
    public void insert(int data){
        Node node =new Node(data);
        if(head==null){
            head = node;
            size++;
            return;
        }

        var cur =head;

        while (cur!=null&&cur.getNext()!=null){
            cur=cur.getNext();
        }

        cur.setNext(node);
        size++;
    }

    /**查询 **/
    public void search(int data,boolean b){
        if(head==null){
            System.out.println("link list is empty");
            return;
        }

        var cur = head;

        if(b){
            System.out.println("链表遍历开始");
            while (cur!=null){
                System.out.println(cur.getData());
                cur = cur.getNext();
            }
            System.out.println("链表遍历长度是"+size);
            System.out.println("链表遍历结束");
            return;
        }else {
            while (cur!=null){
                if(cur.getData()==data){
                    System.out.println("找到元素"+data);
                    return;
                }
                cur = cur.getNext();
            }
            System.out.println("没有找到数据"+data);
        }
    }

    /**顺序添加元素**/
    public void add(int data){
        Node node =new Node(data);
        if(head==null){
            head = node;
            size++;
            System.out.println("第一次插入新元素成功，数据是"+data);
            return;
        }

        Node pre = new Node(-1);
        pre.setNext(head);
        var cur = head;
        if(cur.getData()>data){
            node.setNext(cur);
            head = node;
            size++;
            System.out.println("成功添加新的元素，数据是"+data);
            search(-1,true);
            return;
        }

        while (cur!=null){
            if(cur.getData()<=data){
                pre = cur;
                cur = cur.getNext();
            }else {
                break;
            }
        }
        node.setNext(cur);
        pre.setNext(node);
        size++;
        System.out.println("成功添加新的元素，数据是"+data);
        search(-1,true);
    }

    /**更新**/
    public void update(int data1 ,int data2){
        if(head==null){
            System.out.println("link list is empty");
            return;
        }

        var cur = head ;

        while (cur != null) {
            if (cur.getData() == data1) {
                cur.setData(data2);
                return;
            }
            cur = cur.getNext();
        }

        System.out.println("数据"+data1+"没有被寻找到，所以无法更新"+data2);
    }

    /**删除**/
    public void delete(int data){
        if(head==null){
            System.out.println("link list is empty");
            return;
        }

        Node pre= new Node(-1);
        pre.setNext(head);

        while (pre.getNext()!=null){
            var cur = pre.getNext();
            if(cur.getData()==data){
                pre.setNext(cur.getNext());
                size--;
                System.out.println("已删除元素"+data);
                search(-1,true);
                System.out.println("现在长度是"+size);
                return;
            }
            pre=cur;
        }

        System.out.println("没有被删除的数据"+data);
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
//
//        singleList.insert(1);
//        singleList.insert(2);
//
//        System.out.println("添加结点无序");
//        var cur = singleList.head;
//        while (cur!=null){
//            System.out.println("Node data = "+cur.getData());
//            System.out.println("link list size "+singleList.size);
//            cur=cur.getNext();
//        }
//
//        System.out.println("更新结点");
//        singleList.update(2,3);
//        singleList.update(2,4);
//        cur = singleList.head;
//        while (cur!=null){
//            System.out.println("Node data = "+cur.getData());
//            System.out.println("link list size "+singleList.size);
//            cur=cur.getNext();
//        }
//        singleList.search(-1,false);
//
//        singleList.delete(3);

        singleList.add(1);
        singleList.add(2);
        singleList.add(0);
        singleList.add(10);
        singleList.add(4);
    }
}
