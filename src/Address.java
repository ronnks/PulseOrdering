public class Address {
    private String streetNumber;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String zipCode;

    public Address(String streetNumber, String streetName, String apartmentNumber, String city, String state, String zipCode){
        this.apartmentNumber = apartmentNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    //default constructor to set all fields to defaults to be set later...
    public Address() {
        this.apartmentNumber = "Unknown";
        this.streetNumber = "Unknown";
        this.streetName = "Unknown";
        this.city = "Unknown";
        this.state = "Unknown";
        this.zipCode = "Unknown";
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    //method breaks down logic for easier use of the "equals" method...
    private boolean equalsHelper(Object object){
        Address address = (Address) object;
        return (this.getApartmentNumber().equals(address.getApartmentNumber()) && this.getStreetNumber().equals(address.getStreetNumber()) &&
                this.getStreetName().equals(address.getStreetName()) && this.getCity().equals(address.getCity()) && this.getState().equals(address.getState()) &&
                this.getZipCode().equals(address.getZipCode()));

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
        return this.getStreetNumber() + " " + this.getStreetName() + "Apt " + this.getApartmentNumber() + " " + this.getCity() + " " + this.getState() + " " +
                this.getZipCode();
    }
}
