package com.data_structure.linklist;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SingleList
 * @Description ��������
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

    /**�������**/
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

    /**��ѯ **/
    public void search(int data,boolean b){
        if(head==null){
            System.out.println("link list is empty");
            return;
        }

        var cur = head;

        if(b){
            System.out.println("���������ʼ");
            while (cur!=null){
                System.out.println(cur.getData());
                cur = cur.getNext();
            }
            System.out.println("�������������"+size);
            System.out.println("�����������");
            return;
        }else {
            while (cur!=null){
                if(cur.getData()==data){
                    System.out.println("�ҵ�Ԫ��"+data);
                    return;
                }
                cur = cur.getNext();
            }
            System.out.println("û���ҵ�����"+data);
        }
    }

    /**˳�����Ԫ��**/
    public void add(int data){
        Node node =new Node(data);
        if(head==null){
            head = node;
            size++;
            System.out.println("��һ�β�����Ԫ�سɹ���������"+data);
            return;
        }

        Node pre = new Node(-1);
        pre.setNext(head);
        var cur = head;
        if(cur.getData()>data){
            node.setNext(cur);
            head = node;
            size++;
            System.out.println("�ɹ�����µ�Ԫ�أ�������"+data);
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
        System.out.println("�ɹ�����µ�Ԫ�أ�������"+data);
        search(-1,true);
    }

    /**����**/
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

        System.out.println("����"+data1+"û�б�Ѱ�ҵ��������޷�����"+data2);
    }

    /**ɾ��**/
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
                System.out.println("��ɾ��Ԫ��"+data);
                search(-1,true);
                System.out.println("���ڳ�����"+size);
                return;
            }
            pre=cur;
        }

        System.out.println("û�б�ɾ��������"+data);
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
//
//        singleList.insert(1);
//        singleList.insert(2);
//
//        System.out.println("��ӽ������");
//        var cur = singleList.head;
//        while (cur!=null){
//            System.out.println("Node data = "+cur.getData());
//            System.out.println("link list size "+singleList.size);
//            cur=cur.getNext();
//        }
//
//        System.out.println("���½��");
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
