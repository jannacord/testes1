/*
http://10.59.164.13/api-integracao/payments/create
```
post
{
 "clientId": "823adcdb2e6f2a5e",
 "sessionId": ""
}```

acessar o site - para descompactar as informacoes
https://jwt.io/ */

package payments;

public class RequestPagamentos {

    private String clientID;
    private String autenticaPagamento;


    public RequestPagamentos() {
    }

    public RequestPagamentos(String clientID, String autenticaPagamento) {
        this.clientID = clientID;
        this.autenticaPagamento = autenticaPagamento;
    }


    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getAutenticaPagamento() {
        return autenticaPagamento;
    }

    public void setAutenticaPagamento(String autenticaPagamento) {
        this.autenticaPagamento = autenticaPagamento;
    }
}
