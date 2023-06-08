/**
 * class describes specialty chicken, wings and boneless chicken
 */
public class Wings  extends Item{
    private static final String[] wingWords = {"wings", "specialty chicken"};
    private static final String[] wingKinds = {"plain", "garlic parm", "hot buffalo", "bbq", "mango hab"};
    private static final String[] specialtyChicken = {"crispy bacon and tomato", "classic hot buffalo", "sweet bbq bacon"};
    private static final String[] pieces = {"8pc", "16pc", "12pc"};
    private static final double[] chickenPrice = {8.99, 18.25, 7.65};
    protected static String[] names = {pieces[0]+" "+wingKinds[0]+" "+wingWords[0], pieces[0]+" "+wingKinds[1]+" "+wingWords[0], pieces[0]+" "+wingKinds[2]+" "+wingWords[0], pieces[0]+" "+wingKinds[3]+" "+wingWords[0], pieces[0]+" "+wingKinds[4]+" "+wingWords[0],
                                       pieces[1]+" "+wingKinds[0]+" "+wingWords[0], pieces[1]+" "+wingKinds[1]+" "+wingWords[0], pieces[1]+" "+wingKinds[2]+" "+wingWords[0], pieces[1]+" "+wingKinds[3]+" "+wingWords[0], pieces[1]+" "+wingKinds[4]+" "+wingWords[0],
                                       pieces[2]+" "+specialtyChicken[0]+"" +wingWords[1], pieces[2]+" "+specialtyChicken[1]+"" +wingWords[1], pieces[2]+" "+specialtyChicken[2]+"" +wingWords[1]};

    public Wings(int quantity, String name){
        super.setItem(quantity, name);
    }

    public Wings(){
        limiter = 0;
    }

    public void chickenNames(int quantity, String chickenName){

        if(chickenName.equals(names[0]) || chickenName.equals(names[1]) || chickenName.equals(names[2]) || chickenName.equals(names[3])){
            super.cost = chickenPrice[0] * quantity;

        } else if(chickenName.equals(names[4]) || chickenName.equals(names[5]) || chickenName.equals(names[6]) || chickenName.equals(names[7])){
            super.cost = chickenPrice[1] * quantity;

        }else if(chickenName.equals(names[8]) || chickenName.equals(names[9]) || chickenName.equals(names[10])){
            super.cost = chickenPrice[2] * quantity;
        }
    }

    public void addChicken(int quantity, String name){
        chickenNames(quantity, name);
        if(limiter == 0){
            super.setItem(quantity, name);
        }
        limiter = 1;
    }
    @Override
    public String toString(){
        return this.quantity + " " + this.name + " $" + this.cost;
    }

    public static void main(String[] args) {
        try {
            Wings wing1 = new Wings();
            wing1.addChicken(2, names[5]);
            System.out.println(wing1);

        }catch (Exception exception) {
            System.out.println("error");
        }

    }
}
