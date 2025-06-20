package starter.stepdefinitions.front;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.navigation.NavigateTo;
import starter.tasks.addcart.AddCart;
import starter.tasks.login.Login;

import static starter.ui.RelatosElements.TABLE_ROW_CANTIDAD;

public class ShoppingCartSteps {
    @Given("que el {actor} se encuentra en el home de la aplicacion")
    public void que_el_cliente_se_encuentra_en_el_home_de_la_aplicacion(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
        actor.attemptsTo(Login.success());
    }
    @When("agrega un libro al carrito de compras")
    public void agrega_un_libro_al_carrito_de_compras() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddCart.bookFromDatails());
    }
    @Then("podra ver el libro agregado en el carrito de compras")
    public void podra_ver_el_libro_agregado_en_el_carrito_de_compras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TABLE_ROW_CANTIDAD).isDisplayed());
    }
}
