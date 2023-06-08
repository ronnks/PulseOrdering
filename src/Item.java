/**
 * class describes the basis of each of the items in an order...
 */
public abstract class Item {

    //protected fields for easy of testing in the same package...
    protected int quantity;
    protected String name;
    protected String size;
    protected String crust;
    protected double cost;
    protected int limiter;//limiting addition of items more than once in specific classes.
    protected int itemCounter = 0;

    //helps easier setting the 4 fields on subclasses in the constructors.....
    public void setItem(int quantity, String name, String size, String crust){
        this.quantity = quantity;
        this.name = name;
        this.size = size;
        this.crust = crust;
        limiter = 1;
        itemCounter++;
    }

    //helps easier setting the 2 fields on subclasses in the constructors.....
    public void setItem(int quantity, String name){
        limiter = 1;
        this.quantity = quantity;
        this.name = name;
        itemCounter++;
    }

    //helps easier setting the 3 fields on subclasses in the constructors.....
    public void setItem(int quantity, String size, String crust){
        limiter = 0;
        this.quantity = quantity;
        this.size = size;
        this.crust = crust;
        itemCounter++;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getCrust() {
        return this.crust;
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString(){
        if(limiter == 1) {
            return this.quantity + " " + this.size + " " + this.crust + " " + this.name + " $" + this.cost;
        }
        return this.quantity + " " + this.size + " " + this.crust + " $" + this.cost;
    }
}
