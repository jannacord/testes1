import autenticar.CredencialUser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static mainJson.RetornoJson.converterJSON;

public class CriarCredencial {

    CriarLogin criarLogin = new CriarLogin();


    public String jsonCredeincial = null;
    public String tokenGerado =  criarLogin.getToken();

    //Gerar a credencial do usuário
    @BeforeClass
    public void retornoCredencial() throws JSONException {
        CredencialUser credencialUser = new CredencialUser();

        credencialUser.setCredential( "Rede@2018" );
        credencialUser.setCreatedToken( tokenGerado );

        jsonCredeincial = converterJSON( credencialUser );
        System.out.println( "--> JSON CREDENCIAL: " + jsonCredeincial );

    }

    @Test
    public void autenticarUser() {
        /*"credential": "senha", "createdToken": "token gerado na createdUser"*/
        RestAssured.baseURI = "http://10.59.164.13/api-integracao";

        String credenciado = RestAssured.given().contentType( ContentType.JSON ).when().body( jsonCredeincial ).post( "/login/credentials" ).prettyPrint();
        System.out.println( "--> CREDENCIADO " + credenciado );


    }


}
