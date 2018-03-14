import autenticar.EfetuarAutenticacaoUser;
import customers.InfCustomers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static mainJson.RetornoJson.converterJSON;

public class AutenticarUsuario {

    InfCustomers recebeEmailCadastrado = new InfCustomers(  );
    CriarLogin recebeTokenGerado = new CriarLogin();

    public String jsonAutenticador = null;
    private String email = recebeEmailCadastrado.getEmail();
    //public String token = recebeTokenGerado.token;

    //Gerar a autenticação do usuário
    @BeforeClass
    public void retornarAutenticacaoUsuario() {
        EfetuarAutenticacaoUser autentic = new EfetuarAutenticacaoUser();

        autentic.setUsernameClient( email );
        autentic.setCredentialClient( " " );
        autentic.setPartnerCtrlId( "f8721cddfe07bae7cfd4e9e4138234cf7e66f32fdc0cdc4781e7196fb23bf80c" );

        jsonAutenticador = converterJSON( autentic );
        System.out.println( "-->JSON AUTENTICADOR " + jsonAutenticador );
    }

    @Test
    public void validarAutenticacao() {
        RestAssured.baseURI = "http://10.59.164.13/api-integracao";

        String usuarioAutenticado = RestAssured.given().contentType( ContentType.JSON ).when().body( jsonAutenticador ).post( "/login" ).prettyPrint();
        System.out.println( "-->USUARIO AUTENTICADO EM LOGIN " + usuarioAutenticado );


    }
}
