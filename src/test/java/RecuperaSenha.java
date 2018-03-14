import customers.DocumentCustomers;
import customers.InfCustomers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import recover.*;

import static mainJson.RetornoJson.converterJSON;


public class RecuperaSenha {

    public String jsonRecuperaPorCPF = null;
    private String dadosCPF;
    public String jsonRecuperaPorEmail = null;
    private String dadosEmail;

    @Test
    public void requisicaoRecuperaSenhaComCPF(){

        RecuperaSenhaComCPF recuperaSenhaComCPF = new RecuperaSenhaComCPF();
        RecuperaSenharResend recuperaSenharResend = new RecuperaSenharResend();
        DocumentCustomers recebeCPF = new DocumentCustomers( );

        dadosCPF = recuperaSenhaComCPF.setCpf(recebeCPF.getCpf());
        recuperaSenharResend.setIdentificationType(dadosCPF);
        recuperaSenharResend.setOtpToken( " " );

        jsonRecuperaPorCPF = converterJSON( recuperaSenharResend );
        System.out.println("Recupera por CPF: " + jsonRecuperaPorCPF);

    }

    @Test
    public void validarRecuperacaoPorCPF() {
        RestAssured.baseURI = "http://10.59.164.13/api-integracao/recover";

        String usuarioRecuperadoPorCPF = RestAssured.given().contentType(ContentType.JSON ).when().body( jsonRecuperaPorCPF ).post( "/resend" ).prettyPrint();
        System.out.println( "--> USUARIO RECUPERADO POR CPF " + usuarioRecuperadoPorCPF );

    }

    @Test
    public void requisicaoRecuperaSenhaComEmail(){

        RecuperaSenhaComEmail recuperaSenhaComEmail = new RecuperaSenhaComEmail( );
        RecuperaSenhaValidarCodigo recuperaSenhaValidarCodigo = new RecuperaSenhaValidarCodigo( );
        InfCustomers recebeEmail = new InfCustomers(  );

        dadosEmail = recuperaSenhaComEmail.setEmail(recebeEmail.getEmail());
        recuperaSenhaValidarCodigo.setOtp( dadosEmail );
        recuperaSenhaValidarCodigo.setOtpToken(" ");

        jsonRecuperaPorEmail = converterJSON( recuperaSenhaValidarCodigo );
        System.out.println("Dados recuperado via Email: " + jsonRecuperaPorEmail );

    }

    @Test
    public void validarRecuperacaoPorEmail() {

        RestAssured.baseURI = "http://10.59.164.13/api-integracao/recover";

        String usuarioRecuperadoPorEmail = RestAssured.given().contentType(ContentType.JSON )
                .when().body(jsonRecuperaPorEmail ).post( "/validade" ).prettyPrint();

        System.out.println( "--> USUARIO RECUPERADO POR EMAIL " + usuarioRecuperadoPorEmail );



    }



}
