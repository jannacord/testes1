package recover;

public class RecuperaSenhaComCPF {

    private String cpf;

    public RecuperaSenhaComCPF(String cpf) {
        this.cpf = cpf;
    }

    public RecuperaSenhaComCPF() {
    }

    public String getCpf() {
        return cpf;
    }

    public String setCpf(String cpf) {
        this.cpf = cpf;
        return cpf;
    }
}
