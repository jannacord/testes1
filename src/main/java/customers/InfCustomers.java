package customers;

public class InfCustomers {

    private String name;
    private String email;
    private DocumentCustomers documents;
    private PhoneCustomers phones;

    public InfCustomers() {

    }

    public InfCustomers(String name, String email, customers.DocumentCustomers documents, customers.PhoneCustomers phones) {
        this.name = name;
        this.email = email;
        this.documents = documents;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public customers.DocumentCustomers getDocuments() {
        return documents;
    }

    public void setDocuments(customers.DocumentCustomers documents) {
        this.documents = documents;
    }

    public customers.PhoneCustomers getPhones() {
        return phones;
    }

    public void setPhones(customers.PhoneCustomers phones) {
        this.phones = phones;
    }
}
