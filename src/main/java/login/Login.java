package login;

public class Login {

    private String userEmail;
    private String userSenha;
    private String idUser;


    public Login() {
    }

    public Login(String userEmail, String userSenha, String idUser) {
        this.userEmail = userEmail;
        this.userSenha = userSenha;
        this.idUser = idUser;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
