package bsu.rfe.java.group7.lab1.marrygran.var4;

public class Apple extends Food {
    private String size;
    public Apple(String size) {
        super("Яблоко");
        this.size = size;
    }

    public void consume() {

        System.out.println(this + " съедено");
    }
    public String getSize() {

        return size;
    }
    public void setSize(String size) {

        this.size = size;
    }
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}