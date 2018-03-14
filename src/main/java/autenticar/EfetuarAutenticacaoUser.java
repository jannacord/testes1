package autenticar;

public class EfetuarAutenticacaoUser {
/* {
  "username": "user",
  "credential": "pass",
  "partnerCtrlId": "f8721cddfe07bae7cfd4e9e4138234cf7e66f32fdc0cdc4781e7196fb23bf80c"
}
*/
    private String usernameClient;
    private String credentialClient;
    private String partnerCtrlId;

    public EfetuarAutenticacaoUser() {
    }

    public EfetuarAutenticacaoUser(String usernameClient, String credentialClient, String partnerCtrlId) {
        this.usernameClient = usernameClient;
        this.credentialClient = credentialClient;
        this.partnerCtrlId = partnerCtrlId;
    }


    public String getUsernameClient() {
        return usernameClient;
    }

    public void setUsernameClient(String usernameClient) {
        this.usernameClient = usernameClient;
    }

    public String getCredentialClient() {
        return credentialClient;
    }

    public void setCredentialClient(String credentialClient) {
        this.credentialClient = credentialClient;
    }

    public String getPartnerCtrlId() {
        return partnerCtrlId;
    }

    public void setPartnerCtrlId(String partnerCtrlId) {
        this.partnerCtrlId = partnerCtrlId;
    }


}
