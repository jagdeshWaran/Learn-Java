package linkedlist;

import array.MyList;

public class MyLinkedList<T> implements MyList<T> {
    private transient int size = 0;
    private int modCount = 0;
    private transient Node<T> head = null;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    MyLinkedList() {

    }

    private void linkLast(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
        ++this.size;
        ++this.modCount;
    }

    private void linkFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> temp = this.head;
            this.head = newNode;
            newNode.next = temp;
        }
        ++this.size;
        ++this.modCount;
    }

    public void add(T data) {
        this.linkLast(data);
    }

    public boolean add(int position, T data) {
        if (position == 0) {
            System.out.println("WARNING: Invalid Position");
            return false;
        }
        this.insertByPosition(position, data);
        return true;
    }

    public int size() {
        return this.size;
    }

    public void insert(int position, T data) {
        this.insertByPosition(position, data);
        ++this.modCount;
    }

    private void insertByPosition(int position, T data) {
        Node<T> newNode = new Node<T>(data);
        int i = 1;
        Node<T> temp = this.head;
        while (i < position - 1) {
            temp = temp.next;
            i++;
        }
        Node<T> temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
        ++this.size;
        ++this.modCount;
    }

    public void deleteHead() {
        this.head = this.head.next;
        --this.size;
        ++this.modCount;
    }

    public void deleteTail() {
        if (isEmpty()) {
            System.out.println("WARNING: Already This LinkedList Is Empty");
        } else {
            Node<T> temp = this.head;
            int i = 1;
            if (temp.next == null) {
                this.head = null;
            }
            while (i < this.size - 1) {
                assert temp != null;
                temp = temp.next;
                i++;
            }
            assert temp != null;
            temp.next = null;
            --this.size;
            ++this.modCount;
        }
    }

    public void deleteByPosition(int position) {
        Node<T> temp = this.head;
        int i = 0;
        int pre = position - 2;
        Node<T> prev = null;
        while (i < position - 1) {
            if (i == pre) {
                prev = temp;
                i++;
            }
            temp = temp.next;
            i++;
        }
        assert prev != null;
        prev.next = temp.next;
        --this.size;
        ++this.modCount;
    }

    public void remove() {
        this.deleteTail();
        ++this.modCount;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void merge(MyLinkedList<T> linkedList) {
        Node<T> temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (linkedList.head != null) {
            --linkedList.size;
            temp.next = linkedList.head;
            temp = temp.next;
            linkedList.head = linkedList.head.next;
            this.size++;
        }
        ++this.modCount;
    }

    public void show() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void clear() {
        Node<T> var2;
        while (head != null) {
            var2 = head.next;
            head.data = null;
            head.next = null;
            head = var2;
        }
        this.size = 0;
        ++this.modCount;
    }

    public Integer modCount() {
        return this.modCount;
    }

}
