package org.example;

import com.google.common.reflect.TypeToken;
import org.example.model.Cerveceria;
import com.google.gson.Gson;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Steps {
    static String SEPARADOR="\n**************************************************\n";
    Response res;
    final Type tipoListaCervecerias = new TypeToken<List<Cerveceria>>(){}.getType();
    List<Cerveceria> cervecerias, cerveceriasFilt=new ArrayList<Cerveceria>();
    Cerveceria cerveceriaResultante;

    @Before
    public void doBefore(Scenario scenario) {

        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.println("|                                    INICIO DE LA PRUEBA                                        |");
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.println("\n\tStarting - " + scenario.getName());

    }

    //---------- SE EJECUTA DESPUES DE EJECUTAR LAS PRUEBAS ------------------------------------------------------------
    @After
    public void doSomethingAfter(Scenario scenario) {
        System.out.println("\n\t"+scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.println("|                                       FIN DE LA PRUEBA                                        |");
        System.out.println("+-----------------------------------------------------------------------------------------------+");
    }
    /**
     *
     * @param URL
     * @param parametro
     * @param valor
     */
    @Dado("que invoco al servicio (.*) con el parametro (.*) con valor (.*)")
    public void invocacionAlServicio(String URL, String parametro, String valor) {
        System.out.println(SEPARADOR+"\t\tPASO 1 - Invocación al servicio"+SEPARADOR);
        JSONObject requestParams = new JSONObject(); JSONObject paymentExtraParams = new JSONObject();
        requestParams.put(parametro, valor);
        Response response = given()
                .header("Content-Type", "application/json;charset=utf-8")
                .header("Session-Id", "Sesión1")
                .when()
                .body(requestParams.toString())
                .get(URL)
                .then()
                .extract()
                .response();

        System.out.println("Body del response");
        String jsonResponse = response.getBody().print();
        System.out.println("Final del body");

        //JsonParser parser = new JsonParser();
        //JsonObject json = parser.parse(jsonResponse).getAsJsonObject();
        System.out.println("El response.asString es: "+response.asString());
        this.res=response;
        Gson gson = new Gson();
        this.cervecerias = gson.fromJson(response.asString(), tipoListaCervecerias);

        System.out.println("La primera cervecería es: "+ cervecerias.get(0).getId());
        System.out.println("Y su nombre es: "+cervecerias.get(0).getName());


    }

    /**
     *
     * @param key
     * @param valor
     */
    @Y("filtro cervecerías con key (.*) valor (.*)")
    public void filtroCerveceríasConClaveX(String key, String valor) {
        System.out.println(SEPARADOR+"\t\tPASO 2 - Filtrado de cervecerías"+SEPARADOR);
        System.out.println(" ----> Key: "+key+"; Valor: "+valor);
        for (Cerveceria cerv: cervecerias
             ) {
            if(cerv.getName().equalsIgnoreCase(valor)){
                cerveceriasFilt.add(cerv);
                System.out.println(cerv.toString());
            }
        }

        System.out.println("La lista resultante tiene un tamaño de: "+cerveceriasFilt.size());

    }

    /**
     *
     * @param clave
     * @param valor
     * @param url
     */
    @Cuando("obtengo el detalle de la cervecería con clave (.*) y valor (.*) desde la URL (.*)")
    public void obtengoElDetalleDeLaCerveceríaConClaveCLAVEYValorVALORDesdeLaURLURL(String clave, String valor, String url) {
        System.out.println(SEPARADOR+"\t\tPASO 3 - Obtengo la cervecería puntual, con sus detalles"+SEPARADOR);
        System.out.println(" -----> Clave: "+clave+"; Valor: "+valor);
        for (Cerveceria cer:cerveceriasFilt){
            JSONObject requestParams = new JSONObject(); JSONObject paymentExtraParams = new JSONObject();
            //requestParams.put(parametro, valor);
            Response response = given()
                    .header("Content-Type", "application/json;charset=utf-8")
                    .header("Session-Id", "Sesión1")
                    .when()
                    .body(requestParams.toString())
                    .get(url+cer.getId())
                    .then()
                    .extract()
                    .response();

            Gson gson = new Gson();
            Cerveceria cerveceria = gson.fromJson(response.asString(), Cerveceria.class);

            if(cerveceria.getState().equalsIgnoreCase(valor)){
                cerveceriaResultante=cerveceria;
                System.out.println("\nLa cervecería resultante es: "+cerveceriaResultante.toString());
                break;
            }
        }
    }

    @Entonces("la cervecería resultante tiene id (.*), name (.*), street (.*), phone (.*)")
    public void laCerveceríaResultanteTieneIdNameLagunitasBrewingCoStreetNMcDowellBlvdPhone(String id, String name, String street, String phone) {
        System.out.println(SEPARADOR+"\t\tPASO 4 - ASSERTS"+SEPARADOR);
        Assert.assertEquals("El id no coincide", Integer.parseInt(id), cerveceriaResultante.getId());
        Assert.assertEquals("El name no coincide", name, cerveceriaResultante.getName());
        Assert.assertEquals("El campo street no coincide", street, cerveceriaResultante.getStreet());
        Assert.assertEquals("El campo \"phone\" no coincide", phone, cerveceriaResultante.getPhone());

        System.out.println("Las afirmaciones se resolvieron [OK]");

    }
}

