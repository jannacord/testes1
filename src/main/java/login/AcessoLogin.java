package login;

import customers.DocumentCustomers;
import customers.InfCustomers;
import customers.PhoneCustomers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static mainJson.RetornoJson.converterJSON;


public class AcessoLogin {

    public String jsonRequest = null;
    private String email;
    private String senha;
    private String dadosCriados;
    private String dadosLogin;
    private String tokenUser;

    public InfCustomers infoCustomers = new InfCustomers();
    public PhoneCustomers foneCustomers = new PhoneCustomers();
    public DocumentCustomers docCustomers = new DocumentCustomers();
    public Login login = new Login( );

    public void retornoCustomers() throws JSONException {

        docCustomers.setDocCPF("72113693291");
        foneCustomers.setNumberPhone( "11967393571" );
        email = "analisekeating@eua.com";
        senha = "Rede@2018";

        infoCustomers.setName( "Analise Keating" );
        infoCustomers.setEmail(email);
        infoCustomers.setDocuments(docCustomers);
        infoCustomers.setPhones(foneCustomers);

        jsonRequest = converterJSON( infoCustomers ); //System.out.println( jsonRequest );

    }



    @Test
    public void  envioRequest() {

        RestAssured.baseURI = "http://10.59.164.13/api-integracao";
        dadosCriados =
        RestAssured.given()
                .contentType( ContentType.JSON)
                .when()
                .body(jsonRequest)
                .post("/customers")
                .then()
                .statusCode( 201 )
                .extract()
                .path( "createdToken" )
                .toString();  // System.out.println( dadosCriados );

        System.out.println("Dados criados " +  dadosCriados );

        login.setUserEmail(email);
        login.setUserSenha(senha);
        login.setIdUser(dadosCriados);


        jsonRequest = converterJSON( login );
        System.out.println("JSON Login " +  jsonRequest );


        RestAssured.baseURI = "http://10.59.164.13/api-integracao";
        dadosLogin =
                RestAssured.given()
                        .contentType("application/jsonRequest")
                        .request()
                        .body( jsonRequest )
                        .contentType(ContentType.JSON)
                        .post("/login")
                        .then()
                        .statusCode( 400 )
                        .extract()
                        .path("createdToken" )
                        .toString();

        System.out.println("Dados login " +  dadosLogin );


    }

}




