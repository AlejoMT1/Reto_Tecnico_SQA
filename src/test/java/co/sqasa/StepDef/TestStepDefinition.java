package co.sqasa.StepDef;

import co.sqasa.exeptions.ProductoNoEncontradoException;
import co.sqasa.questions.ExtraerValor;
import co.sqasa.tasks.SeleccionarFecha;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.regex.Matcher;

import static co.sqasa.userinterfaces.InicioUI.DATE;
import static co.sqasa.utils.Constantes.URL;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class TestStepDefinition {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Dado("Que me encuentro en la pagina de jqueryui")
    public void queMeEncuentroEnLaPaginaDeJqueryui() {
        WebDriverManager.chromedriver().setup();
        theActorCalled("QA").wasAbleTo(Open.url(URL));
    }

    @Cuando("selecciona la fecha {string}")
    public void seleccionaLaFecha(String fecha) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarFecha.enCalendario(fecha)
        );
    }
    @Entonces("Visualizare {string} en la seleccion")
    public void visualizareEnLaSeleccion(String fecha) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ExtraerValor.value(DATE))
        );
    }
}
