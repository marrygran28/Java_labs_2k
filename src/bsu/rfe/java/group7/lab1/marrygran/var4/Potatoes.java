package bsu.rfe.java.group7.lab1.marrygran.var4;

public class Potatoes extends Food{
        private String type;

        public Potatoes(String type) {
        super("Картошка");
        this.type=type;
    }

    public void consume() {
        System.out.println(this + " съедено");
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String toString() {
        return super.toString() + " вида " + type.toUpperCase() + "'";
    }
}
