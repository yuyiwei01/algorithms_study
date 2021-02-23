package sdu.alg1_3;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first;  //队列头结点
    private Node last;  //队列尾结点
    private int N = 0;  //队列长度
    private class Node {  //定义节点类
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void enqueue(Item item) {  //向队尾添加结点
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }
    public Item dequeue() {  //从队头删除结点
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() { }
    }
}
