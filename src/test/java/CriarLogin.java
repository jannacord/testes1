import complementos.GenerateCPF;
import customers.DocumentCustomers;
import customers.InfCustomers;
import customers.PhoneCustomers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import login.Login;
import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static mainJson.RetornoJson.converterJSON;

public class CriarLogin {

    public String jsonRequest = null;
    private String email;
    private String senha;
    private  String token;
    public String recebeTokenGerado;

    public InfCustomers infoCustomers = new InfCustomers();
    public PhoneCustomers foneCustomers = new PhoneCustomers();
    public DocumentCustomers docCustomers = new DocumentCustomers();
    public Login login = new Login();
    public GenerateCPF generateCPF = new GenerateCPF();


    @BeforeClass
    public void retornoCustomers() throws JSONException {

        docCustomers.setDocCPF( generateCPF.geraCPF() );
        foneCustomers.setNumberPhone( "11979932127" );
        email = "clienteemail24@gmail.com";
        senha = "Rede@2018";

        infoCustomers.setName( "Asheley Banks do Tio Fiu" );
        infoCustomers.setEmail( email );
        infoCustomers.setDocuments( docCustomers );
        infoCustomers.setPhones( foneCustomers );

        jsonRequest = converterJSON( infoCustomers );

        System.out.println( "JsonRquest " + jsonRequest );
    }

    //Criar o usuário

    @Test (groups = "criacao")
    public void envioRequest() {
        //Criando o request
        RestAssured.baseURI = "http://10.59.164.13/api-integracao";

        token = RestAssured.given().contentType( ContentType.JSON ).when().body( jsonRequest ).post( "/customers" ).then().extract().path( "createdToken" ).toString();
        System.out.println( "--> TOKEN GERADO : " + token );
        //token =  RestAssured.given().contentType( ContentType.JSON).when().body(jsonRequest).post("/customers").prettyPrint();

        recebeTokenGerado = this.token;


    }

   
    /*
    public String retornoTokenGerado (String retornoTokenGerado ){

        retornoTokenGerado = RestAssured.given().contentType( ContentType.JSON )
                .when().body( jsonRequest ).post( "/customers" )
                .then().extract().path( "createdToken" ).toString();

        return retornoTokenGerado;
    }
    */
    // @AfterClass
    //  public String retornoToken(String retornoToken){
    //    return retornoToken = this.token;

    // }



}
