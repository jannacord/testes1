import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payments.RequestPagamentos;

import static mainJson.RetornoJson.converterJSON;

public class RequestAntesDoPagamento {

    public String jsonAntesPgto = null;
    private String email;
    public String token;


    @BeforeClass
    public void verificaPgto() {
        RequestPagamentos verificaPagamentos = new RequestPagamentos();

        verificaPagamentos.setClientID( email );
        verificaPagamentos.setAutenticaPagamento( token );

        String descompctarToken = null;

        jsonAntesPgto = converterJSON( verificaPagamentos );
        System.out.println( "-->JSON Antes Pgto " + jsonAntesPgto );

    }

    @Test
    public void antesDoPagamento() {
        RestAssured.baseURI = "http://10.59.164.13/api-integracao";

        String recebeDadosPgto = RestAssured.given().contentType( ContentType.JSON ).when().body( jsonAntesPgto ).post( "/payments/create" ).prettyPrint();

        System.out.println( "-->JSON Antes Pgto " + recebeDadosPgto );


    }

}


