package starter.tasks.login;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static starter.ui.RelatosElements.BUTTON_INICIO;

public class Login implements Task {
    @Step("Realizar login en la app")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_INICIO));
    }

    public static Login success() {
        return Tasks.instrumented(Login.class);
    }
}
