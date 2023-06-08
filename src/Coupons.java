/**
 * class describes the different discount types for both special categories, customers and employees..
 */
public class Coupons extends Pizza {

    public Coupons(){

    }

    public String mixAndMatch(){
        if(pizzaMDCounter >= 2){
            cost = cost - (5.00 * pizzaMDCounter);
        }
        return "mix&match";
    }

    public String lg3ToppingPizza(){
        if(pizzaLGCounter >= 1){
            cost = cost - (7.00 * pizzaLGCounter);
        }
        return "lg3ToppingPizza";
    }

    public static void main(String[] args) {

    }
    /**
     *
     */
}
