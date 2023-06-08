/**
 * class services offered, including delivery and carryout...
 */
public class Service{
    private static final String[] services = {"CarryOut", "Delivery"};
    private String service;
    private int addServiceLimit;

    public Service(String service){//initialized constructor
        addServiceLimit = 1;
        this.service = service;
    }

    public Service(){//default constructor
        addServiceLimit = 0;
    }

    public void addService(String newService){//sets required service
        if(addServiceLimit == 0) {
            this.service = newService;
            addServiceLimit = 1;
        }
    }

    public String getService(){//gets the current service
        return this.service;
    }

    @Override
    public String toString(){
        return "     " + this.service;
    }

    public static void main(String[] args) {
        Service service1 = new Service(services[0]);
        service1.addService(services[1]);
        service1.addService(services[0]);
        System.out.println(service1);

    }

}
