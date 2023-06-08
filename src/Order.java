import org.omg.PortableInterceptor.ServerRequestInfo;

import java.util.ArrayList;

/**
 * class describes a particular entire made order
 */
public class Order {
    private int orderNumber = 0; // variable keeps track of the order counts in the System...
    private final ArrayList<Object> orderInfo = new ArrayList<>(); //List storing service and customer details...
    private final ArrayList<Item> orderItems = new ArrayList<>(); //List storing item Objects...

    public Order(){
        orderNumber++;
    }

    public Order(Service service, Customer customer){
        orderInfo.add(service);
        orderInfo.add(customer);

        orderNumber++;
    }

    public Order(Pizza pizza){
        orderNumber++;
        orderItems.add(pizza);
    }

    public Order(Bread bread){
        orderNumber++;
        orderItems.add(bread);
    }

    public Order(Wings wings){
        orderNumber++;
        orderItems.add(wings);
    }

    public Order(Others others){
        orderNumber++;
        orderItems.add(others);
    }

    public Order(Pizza pizza, Bread bread, Wings wings, Others others){
        orderNumber++;
        orderItems.add(pizza); orderItems.add(bread); orderItems.add(wings);
        orderItems.add(others);
    }

    public void addService(Service service){
        orderInfo.add(service);
    }

    public void addCustomer(Customer customer){
        orderInfo.add(customer);
    }

    public void addItem(Item item){
        orderItems.add(item);
    }

    public void addCoupon(Coupons coupons){
        orderItems.add(coupons);
    }

    public String totalClause(double totalCost){
        return String.format("Calc Total  =   %.2f", totalCost);
    }

    public String printItems(){ // prints all items in an order....
        StringBuilder formatString = new StringBuilder("     Order #" + orderNumber + "\n");
        double getTotalCost = 0.0;
        for(Object obj : orderInfo){
            formatString.append(obj).append("\n");
        }
        formatString.append("\nOrder\n");
        for(Item item : orderItems){
            formatString.append(item.toString()).append("\n");
            getTotalCost += + item.cost;
        }
        return formatString + "\n" + totalClause(getTotalCost);
    }
    @Override
    public String toString(){
        return this.printItems();
    }

    public static void main(String[] args) {
        //  TESTS FOR ACCURACY OF CLASSES...
       //order 1
        Service service1 = new Service("Delivery");
        Address address1 = new Address("87", "Lyaman st", "1",
                                   "Waltham", "MA", "02452");
        Customer customer1 = new Customer("671-412-9853", "Ronald",
                                   address1);
        Pizza pizza1 = new Pizza(2, "Meatzza", "LG", "handmade pan");

        Order order1 = new Order(service1, customer1);
        order1.addItem(pizza1);
        System.out.println(order1.printItems());
        System.out.println();

        //order 2
        Service service2 = new Service("CarryOut");
        Address address2 = new Address("71", "Middlesex Rd", "7",
                "Waltham", "MA", "02452");
        Customer customer2 = new Customer("857-412-1027", "Zaak Tim",
                address2);
        Pizza pizza2 = new Pizza(1, "SM", "Thin Crust");
        Pizza pizza3 = new Pizza(1, "X-LG", "HandTossed");

        Order order2 = new Order(service2, customer2);
        order2.addItem(pizza2);
        order2.addItem(pizza3);
        System.out.println(order2.printItems());

    }
}
