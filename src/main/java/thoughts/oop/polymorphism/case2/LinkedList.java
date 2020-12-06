package thoughts.oop.polymorphism.case2;

public class LinkedList implements Iterator {
    private LinkedListNode head;

    public boolean hasNext() { //...
        return false;
    }

    public String next() { //...
        return null;
    }

    public String remove() { //...
        return null;
    }

    private class LinkedListNode {
    }
    //...省略其他方法...
}
