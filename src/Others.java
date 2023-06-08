/**
 * class is about drinks, brownies, lava cakes, and drinks
 */
public class Others  extends Item{
    private static final String[] words = {"20oz", "2ltr"};
    private static final String[] sodaKinds = {"coke", "diet coke", "orange", "sprite", "water", "lemonade"};
    private static final String[] cakes = {"9pc brownies", "3pc lava cakes"};
    private static final double[] Prices = {2.55, 3.69, 7.99};
    protected static String[] names = {words[0] +" "+sodaKinds[0], words[0] +" "+sodaKinds[1], words[0] +" "+sodaKinds[2], words[0] +" "+sodaKinds[3], words[0] +" "+sodaKinds[4], words[0] +" "+sodaKinds[5],
                                       words[1] +" "+sodaKinds[0], words[1] +" "+sodaKinds[1], words[1] +" "+sodaKinds[2], words[1] +" "+sodaKinds[3], words[1] +" "+sodaKinds[4], words[1] +" "+sodaKinds[5]};

    public Others(int quantity, String name){
        othersNames(quantity, name);
        if(limiter == 0){
            super.setItem(quantity, name);
        }
        limiter = 1;
    }

    public Others(){ limiter = 0; }

    public void addOther(int quantity, String name){
        othersNames(quantity, name);
        if(limiter == 0){
            super.setItem(quantity, name);
        }
        limiter = 1;
    }

    public void othersNames(int quantity, String otherName){
        if(otherName.equals(names[0]) || otherName.equals(names[1]) || otherName.equals(names[2]) || otherName.equals(names[3]) || otherName.equals(names[4]) || otherName.equals(names[5])){
            super.cost = quantity * Prices[0];
        }else if(otherName.equals(names[6]) || otherName.equals(names[7]) || otherName.equals(names[8]) || otherName.equals(names[9]) || otherName.equals(names[10]) || otherName.equals(names[11])){
            super.cost = quantity * Prices[1];
        }else if(otherName.equals(cakes[0]) || otherName.equals(cakes[1])){
            super.cost = quantity * Prices[2];
        }
    }

    @Override
    public String toString(){
        return this.quantity + " " + this.name + " $" + this.cost;
    }

    public static void main(String[] args) {

        try {
            Others other = new Others();
            other.addOther(2, names[2]);
            System.out.println(other);

        }catch (Exception exception) {
            System.out.println("error");
        }

    }
}
