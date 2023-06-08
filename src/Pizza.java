import java.util.ArrayList;

/**
 * class describes particular pizzas and their toppings...
 */
public class Pizza extends Item{
    private static final String[] sauces = {"tomato", "marinara", "garlic parm", "ranch", "alfredo", "mango", "hot buffalo"};
    private static final String[] cheeses = {"cheese", "provolone", "american", "asiago", "sliced provolone", "cheddar"};
    private static final String[] meats = {"pepperoni", "ham", "sausage", "beef", "steak", "chicken", "salami"};
    private static final String[] vegetables = {"onions", "green peppers", "mushrooms", "spinach", "pineapple", "jalapeno", "black olives", "banana peppers", "tomatoes", "red peppers"};
    private static final String[] quantities = {"light", "extra", "double"};
    public static final String[] crusts = {"hand tossed", "thin", "handmade pan", "gluten free"};
    public static final String[] sizes = {"SM", "MD", "LG"};
    public static final String[] specialityPizzas = {"meatzza", "extravaganza", "deluxe", "spinach and feta", "buffalo chicken", "chicken bacon ranch", "philly cheese steak", "honolulu hawaiian"};
    private static final double toppingPrice = 1.50;
    private static final double halfToppingPrice = 0.75;
    private static final double[] quantityPrices = {-0.20, 1.66, 3.20};
    private static final double[] halfQuantityPrices = {-0.10, 0.83, 1.60};
    private ArrayList<String> toppings;
    private static final double removeTopping = -0.50;
    private ArrayList<String> toppingsR;
    private ArrayList<String> toppingsL;

    //special pizza toppings...
    private static final String[] meatzza = {sauces[0], quantities[1] + " " + cheeses[0], meats[0], meats[1], meats[2], meats[3]};
    private static final String[] extravaganza = {sauces[0], cheeses[0], meats[0], meats[1], meats[2], meats[3],
                                                   vegetables[0], vegetables[1], vegetables[2], vegetables[6],
                                                    };
    private static final String[] deluxe = {sauces[0]};

    protected int pizzaLGCounter = 0; //counts the number of large pizza objects created
    protected int pizzaMDCounter = 0; //counts the number of medium pizza objects created
    protected int toppingCounter = 0; //counts the number of toppings added to a pizza
    protected int halfToppingCounter = 0; //counts the number of toppings added to a pizza on one side as 0.5 count and on both sides as 1 count

    public Pizza(int quantity, String name, String size, String crust){//constructor for all attributes of pizza
        super.setItem(quantity, name, size, crust);
        limiter = 1;

        double[] specialPizzaPrice = {15.12, 17.35, 20.65};
        if(size.equals(sizes[0])){//setting pizza crust
            super.cost = specialPizzaPrice[0] * super.quantity;
        }else if(size.equals(sizes[1])){
            super.cost = specialPizzaPrice[1] * super.quantity;
            pizzaMDCounter++;
        }else {
            super.cost = specialPizzaPrice[2] * super.quantity;
            pizzaLGCounter++;
        }
    }

    public Pizza(int quantity, String size, String crust){//constructor for name, size and crust of pizza
        super.setItem(quantity, size, crust);
        limiter = 1;

        double[] normalPizzaPrice = {11.12, 13.35, 16.65};
        if(super.size.equals(sizes[0])){
            super.cost = normalPizzaPrice[0] * super.quantity;
        }else if(super.size.equals(sizes[1])){
            super.cost = normalPizzaPrice[1] * super.quantity;
            pizzaMDCounter++;
        }else {
            super.cost = normalPizzaPrice[2] * super.quantity;
            pizzaLGCounter++;
        }
    }

    public Pizza(){
        limiter = 0;
    }

    public void addPizza(int quantity, String size, String crust){
        if(limiter == 0){
            super.setItem(quantity, size, crust);
            limiter = 1;

            double[] normalPizzaPrice = {11.12, 13.35, 16.65};
            if(super.size.equals(sizes[0])){
                super.cost = normalPizzaPrice[0] * super.quantity;
            }else if(super.size.equals(sizes[1])){
                super.cost = normalPizzaPrice[1] * super.quantity;
                pizzaMDCounter++;
            }else {
                super.cost = normalPizzaPrice[2] * super.quantity;
                pizzaLGCounter++;
            }
        }else {
        }
    }

    public void addPizza(int quantity, String name, String size, String crust){
        if(limiter == 0){
            super.setItem(quantity, name, size, crust);
            limiter = 1;

            double[] specialPizzaPrice = {15.12, 17.35, 20.65};
            if(super.size.equals(sizes[0])){//setting pizza crust
                super.cost = specialPizzaPrice[0] * super.quantity;
            }else if(super.size.equals(sizes[1])){
                super.cost = specialPizzaPrice[1] * super.quantity;
                pizzaMDCounter++;
            }else {
                super.cost = specialPizzaPrice[2] * super.quantity;
                pizzaLGCounter++;
            }
        }
    }

    public void addTopping(String topping, String quantity){//adding topping on pizza
        toppings = new ArrayList<>();
        toppings.add(topping);
        if(quantity.equals(quantities[0])){
            super.cost = super.cost + quantityPrices[0] + toppingPrice;
        }else if(quantity.equals(quantities[1])){
            super.cost = super.cost + quantityPrices[1] + toppingPrice;
        }else {
            super.cost = super.cost + quantityPrices[2] + toppingPrice;
        }
        toppingCounter++;
    }

    public void removeTopping(String topping, String quantity){//adding topping on pizza
        toppings = new ArrayList<>();
        toppings.remove(topping);
        if(quantity.equals(quantities[0])){
            super.cost = super.cost + quantityPrices[0] + removeTopping;
        }else if(quantity.equals(quantities[1])){
            super.cost = super.cost + quantityPrices[1] + removeTopping;
        }else {
            super.cost = super.cost + quantityPrices[2] + removeTopping;
        }
    }

    public void addToppingR(String topping, String quantity){//adding topping on pizza
        toppingsR = new ArrayList<>();
        toppingsR.add(topping);
        if(quantity.equals(quantities[0])){
            super.cost = super.cost + quantityPrices[0] + toppingPrice;
        }else if(quantity.equals(quantities[1])){
            super.cost = super.cost + quantityPrices[1] + toppingPrice;
        }else {
            super.cost = super.cost + quantityPrices[2] + toppingPrice;
        }
        halfToppingCounter++;
    }

    public void removeToppingR(String topping, String quantity){//adding topping on pizza
        toppingsR = new ArrayList<>();

        if(quantity.equals(quantities[0])){
            super.cost = super.cost + quantityPrices[0] + removeTopping;
        }else if(quantity.equals(quantities[1])){
            super.cost = super.cost + quantityPrices[1] + removeTopping;
        }else {
            super.cost = super.cost + quantityPrices[2] + removeTopping;
        }
        toppingsR.remove(topping);
    }

    public void addToppingL(String topping, String quantity){//adding topping on pizza
        toppingsL = new ArrayList<>();
        toppingsL.add(topping);
        if(quantity.equals(quantities[0])){
            super.cost = super.cost + quantityPrices[0] + toppingPrice;
        }else if(quantity.equals(quantities[1])){
            super.cost = super.cost + quantityPrices[1] + toppingPrice;
        }else {
            super.cost = super.cost + quantityPrices[2] + toppingPrice;
        }
        halfToppingCounter++;
    }

    public void removeToppingL(String topping, String quantity){//adding topping on pizza
        toppingsL = new ArrayList<>();
        toppingsL.remove(topping);
        if(quantity.equals(quantities[0])){
            super.cost = super.cost + quantityPrices[0] + removeTopping;
        }else if(quantity.equals(quantities[1])){
            super.cost = super.cost + quantityPrices[1] + removeTopping;
        }else {
            super.cost = super.cost + quantityPrices[2] + removeTopping;
        }
    }
    @Override
    public String toString(){
        if(this.name != null){
            return this.quantity +" "+ this.size +" "+ this.name +" "+ this.crust +" "+this.cost;
        }
        return this.quantity +" "+ this.size +" "+ this.crust +" "+this.cost;
    }

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza(1, specialityPizzas[2], sizes[2], crusts[0]);
        pizza1.addPizza(1, sizes[2], crusts[2]);
        pizza1.addTopping(vegetables[2], quantities[1]);
        System.out.println(pizza1);

    }
}
