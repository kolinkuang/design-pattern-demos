package thoughts.oop.polymorphism.case2;

public class Array implements Iterator {
    private String[] data;

    public boolean hasNext() { //...
        return false;
    }

    public String next() { //...
        return null;
    }

    public String remove() { //...
        return null;
    }
    //...省略其他方法...
}