package starter.tasks.addcart;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.AlertAction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static starter.ui.RelatosElements.*;

public class AddCart implements Task {
    @Step("Agregar libro al carrito de compras")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_VER_DETALLE_LIBRO, WebElementStateMatchers.isCurrentlyVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(BUTTON_VER_DETALLE_LIBRO),
                WaitUntil.the(BUTTON_AGREGAR_AL_CARRITO, WebElementStateMatchers.isCurrentlyVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(BUTTON_AGREGAR_AL_CARRITO),
                new AlertAction().andAccept(),
                Click.on(BUTTON_VER_CARRITO));
    }

    public static AddCart bookFromDatails() {
        return Tasks.instrumented(AddCart.class);
    }
}
