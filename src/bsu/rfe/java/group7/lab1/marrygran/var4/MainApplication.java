package bsu.rfe.java.group7.lab1.marrygran.var4;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        int CheeseType = 0, AppleType = 0, PotatoesType = 0;
        Cheese CompC = new Cheese(); // Создаем экземпляры класса, чтобы найти кол-во продуктов по типам
        Potatoes CompB = new Potatoes(null);
        Apple CompA = new Apple(null);

        Food[] breakfast = new Food[20];

        int itemsSoFar = 0;
        
        for (String arg: args) {
            String[] parts = arg.split(",");
            if (parts[0].equals("Cheese")) {
                breakfast[itemsSoFar] = new Cheese();
            }
            else if (parts[0].equals("Potatoes")) {
                breakfast[itemsSoFar] = new Potatoes(parts[1]);
            }
            else if (parts[0].equals("Apple")) {
                breakfast[itemsSoFar] = new Apple(parts[1]);
            }
            itemsSoFar++;
        }

        System.out.println("Посчитаем количество продуктов разного типа.");
        for (int i=0; i<20; i++) {
            if (breakfast[i] != null) {
                if (breakfast[i].equals(CompC)) {
                    CheeseType++;
                }
                else if (breakfast[i].equals(CompB)) {
                    PotatoesType++;
                }
                else if (breakfast[i].equals(CompA)) {
                    AppleType++;
                }
            }
            else break;
        }
        System.out.println("Ваш завтрак состоит из "+AppleType+" яблок, "+PotatoesType+" порций картошки и "+CheeseType+ " сыров.");

        for (Food item: breakfast) {
            if (item != null) {
                item.consume();
            }
            else break;
        }
        System.out.println("Спасибо, что выбрали наше заведение!");
    }
}