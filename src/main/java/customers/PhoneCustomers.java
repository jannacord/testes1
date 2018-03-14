package customers;

public class PhoneCustomers {

    private String mobile;


    public PhoneCustomers() {

    }

    public PhoneCustomers(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public String setNumberPhone(String numberPhone) {
        this.mobile = numberPhone;
        return numberPhone;
    }

    public void setNumberPhone() {
        this.mobile = mobile;
    }
}
