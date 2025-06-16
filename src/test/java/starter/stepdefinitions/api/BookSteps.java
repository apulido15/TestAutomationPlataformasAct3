package starter.stepdefinitions.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.*;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import java.util.List;
import java.util.Map;
import org.hamcrest.Matchers;

public class BookSteps {
    private Actor actor;
    private String response;
    private String request;
    private int idEliiminar;


    @Given("que el {actor} quiere realizar el CRUD sobre los libros")
    public void que_el_cliente_quiere_consultar_un_libro(Actor actor) {
        actor.whoCan(CallAnApi.at("http://localhost:8089"));
        this.actor = actor;
    }
    @When("consulta el libro con id {int}")
    public void consulta_el_libro_con_id(Integer id) {
       actor.attemptsTo(Get.resource("/libros/" + id.toString()));
    }
    @Then("vera que el libro no existe")
    public void vera_que_el_libro_no_existe() {
        actor.attemptsTo(Ensure.that("El codigo de respuesta es 404",
                t -> t.statusCode(HttpStatus.SC_NOT_FOUND)));
    }

    @When("crea un libro con la siguiente informacion")
    public void crea_un_libro_con_la_siguiente_informacion(List<Map<String, Object>> dataTable) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dataTable.get(0));
        actor.attemptsTo(Post.to("/libros").with(rq -> rq.body(json)));
    }
    @Then("vera que el libro fue creado de manera exitosa")
    public void vera_que_el_libro_fue_creado_de_manera_exitosa() {
        actor.attemptsTo(Ensure.that("Respuesta de la creación es exitosa",
                t -> t.statusCode(HttpStatus.SC_CREATED)));
        actor.attemptsTo(Get.resource("/libros/" + LastResponse.received().answeredBy(actor).jsonPath().get("idlibro")));
        actor.attemptsTo(Ensure.that("Respuesta de la consulta es exitosa",
                t -> t.statusCode(HttpStatus.SC_OK)));
    }


    @When("edita el libro con id {int} con la siguiente informacion")
    public void edita_el_libro_con_id_con_la_siguiente_informacion(Integer id,List<Map<String, Object>> dataTable) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
         request = mapper.writeValueAsString(dataTable.get(0));
        actor.attemptsTo(Put.to("/libros/" + id).with(rq -> rq.body(request)));

    }
    @Then("vera que el libro fue editado de manera exitosa")
    public void vera_que_el_libro_fue_editado_de_manera_exitosa() {

        actor.attemptsTo(Ensure.that("Respuesta de la creación es exitosa",
                t -> t.statusCode(HttpStatus.SC_OK)));
        actor.attemptsTo(Get.resource("/libros/" + LastResponse.received().answeredBy(actor).jsonPath().get("idlibro")));
        actor.attemptsTo(Ensure.that("Respuesta de la consulta es exitosa",
                t -> t.statusCode(HttpStatus.SC_OK)));
        actor.attemptsTo(Ensure.that("campo stock editado de manera exitosa",
                t -> t.body("stock", Matchers.equalTo(Integer.parseInt( JsonPath.with(request).get("stock"))))));
    }


    @When("elimina el libro con id {int}")
    public void elimina_el_libro_con_id(Integer id) {
        idEliiminar= id;
        actor.attemptsTo(Delete.from("/libros/" + id));
    }
    @Then("vera que el libro fue elminado de manera exitosa")
    public void vera_que_el_libro_fue_elminado_de_manera_exitosa() {
        actor.attemptsTo(Ensure.that("Respuesta de la elminacion es exitosa",
                t -> t.statusCode(HttpStatus.SC_OK)));
        actor.attemptsTo(Get.resource("/libros/" + idEliiminar));
        actor.attemptsTo(Ensure.that("Respuesta de la consulta del elemento eliminado no existe",
                t -> t.statusCode(HttpStatus.SC_NOT_FOUND)));
    }

}
