package customers;

public class DocumentCustomers {

    private String cpf;

    public DocumentCustomers() {

    }

    public DocumentCustomers(String cpf) {
        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }

    public String setDocCPF(String docCPF) {
        this.cpf = docCPF;
        return docCPF;
    }


}
