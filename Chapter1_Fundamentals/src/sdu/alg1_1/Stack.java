package sdu.alg1_1;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;  //栈顶
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
    public void push(Item item) {  //向栈顶添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop() {  //从栈顶弹出元素
        Item item = first.item;
        first = first.next;
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
