/**
 * class describes different bread types like twists, parm_bites, cheesy breads
 */
public class Bread  extends Item{
    private static String[] breadWords = {"8pc", "cheesy bread", "twists", "parm bites"};
    private static String[] cheesyBreads = {"8pc cheesy bread", "spinach and feta", "bacon and jalapeno"};
    private static String[] twists = {"garlic", "cinnamon", "garlic parmesan"};
    private static String[] parmBites = {"16pc", "32pc"};
    private static final double[] breadPrice = {8.79, 9.11, 8.99, 9.79};
    protected static String[] names = {cheesyBreads[0], breadWords[0] + " " + cheesyBreads[1] + " " + breadWords[1], breadWords[0] + " " + cheesyBreads[2] + " " + breadWords[1],
                                        breadWords[0] + " " + twists[0] + " " + breadWords[2], breadWords[0] + " " + twists[1] + " " + breadWords[2], breadWords[0] + " " + twists[2] + " " + breadWords[2],
                                        parmBites[0] + " " + breadWords[3], parmBites[1] + " " + breadWords[3]};

    public Bread(int quantity, String name){
        super.setItem(quantity, name);
        breadNames(quantity, name);
        limiter = 1;
    }

    public Bread(){
        limiter = 0;
    }
    
    public void addBread(int quantity, String name){
        breadNames(quantity, name);
        if(limiter == 0){
            super.setItem(quantity, name);
        }
        limiter = 1;
    }
    
    public void breadNames(int quantity, String breadName){
        
        if(breadName.equals(names[0]) || breadName.equals(names[1]) || breadName.equals(names[2])){
            if(breadName == names[0]) {
                super.cost = breadPrice[0] * quantity;
            }else if(breadName.equals(names[1]) || breadName.equals(names[2])){
                super.cost = breadPrice[1] * quantity;
            }
        }else if(breadName.equals(names[3]) || breadName.equals(names[4]) || breadName.equals(names[5])){
            super.cost = breadPrice[3] * quantity;

        }else if(breadName.equals(names[6]) || breadName.equals(names[7])){
            if(breadName.equals(names[6])) {
                super.cost = breadPrice[1] * quantity;
            }else {
                super.cost = breadPrice[4] * quantity;
            }
        }
    }
    @Override
    public String toString(){
        return this.quantity + " " + this.name + " $" + this.cost;
    }

    public static void main(String[] args) {
        Bread bread1 = new Bread();
        bread1.addBread(2, names[2]);
        System.out.println(bread1);

    }
}
