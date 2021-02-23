package sdu.alg1_4;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;  //首节点
    private int N = 0;  //元素数量
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
    public void add(Item item) {  //添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
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
