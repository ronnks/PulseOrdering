import javax.print.attribute.standard.MediaSize;

public class Tester{
    public static void main (String[] args) {

        Service service = new Service("CarryOut");

        Pizza pizza = new Pizza(1, Pizza.specialityPizzas[2], Pizza.sizes[2], Pizza.crusts[0]);

        Bread bread = new Bread(2, Bread.names[2]);

        Others others = new Others(2, Others.names[2]);

        Bread bread2 = new Bread(1, Bread.names[3]);

        Pizza pizza2 = new Pizza(1, Pizza.specialityPizzas[5], Pizza.sizes[0], Pizza.crusts[2]);

        Order order1 = new Order();
        order1.addItem(pizza); order1.addItem(others); order1.addItem(bread); order1.addItem(bread2);
        order1.addItem(pizza2);

        System.out.println(order1.printItems());

    }
}