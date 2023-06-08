public class Customer{
    private String customerName;
    private String telephoneNumber;
    private Address address;

    public Customer(String telephone, String name, Address address){
        this.telephoneNumber = telephone;
        this.customerName = name;
        this.address = address;
    }

    public Customer(){
        Address address2 = new Address();
        this.telephoneNumber = "Unknown";
        this.customerName = "Unknown";
        this.address = address2;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    //method breaks down logic for easier use of the "equals" method..., its not accessible outside class
    private boolean equalsHelper(Object object){
        Customer customer = (Customer) object;
        return this.getTelephoneNumber().equals(customer.getTelephoneNumber()) && this.getCustomerName().equals(customer.getCustomerName()) &&
                this.getAddress().equals(customer.getAddress());
    }

    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(this.getClass() == object.getClass()) {
            return equalsHelper(object);
        }
        return false;
    }
    @Override
    public String toString(){
        return "  " + this.getCustomerName() + "\n  " + this.getTelephoneNumber() + "\n" + this.getAddress();
    }
}
