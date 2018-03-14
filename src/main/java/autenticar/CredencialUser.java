package autenticar;

public class CredencialUser {
    private String credential;
    private String createdToken;

    public CredencialUser() {
    }

    public CredencialUser(String credential, String createdToken) {
        this.credential = credential;
        this.createdToken = createdToken;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getCreatedToken() {
        return createdToken;
    }

    public void setCreatedToken(String createdToken) {
        this.createdToken = createdToken;
    }
}
