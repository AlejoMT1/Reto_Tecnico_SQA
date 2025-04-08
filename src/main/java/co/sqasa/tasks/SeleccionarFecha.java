package co.sqasa.tasks;

import co.sqasa.questions.ExtraerValor;
import co.sqasa.utils.Funciones;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static co.sqasa.userinterfaces.InicioUI.*;

public class SeleccionarFecha implements Task {
    private String fecha;

    public SeleccionarFecha(String fecha) {
        this.fecha = fecha;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement iframe = (WebElement) actor.asksFor(WebElementQuestion.the(By.xpath("//iframe[@src='/resources/demos/datepicker/default.html']")));

        String mesDeseado = Funciones.convertirFechaALetra(fecha);
        int dia = Funciones.extraerDia(fecha);
        int year = Funciones.extraerYear(fecha);

        actor.attemptsTo(
                Switch.toFrame(iframe),
                Click.on(BTN_CALENDARIO));

        if (WebElementQuestion.stateOf(CALENDARIO).answeredBy(actor).isVisible()) {

            String mesActual = ExtraerValor.value(MONTH).answeredBy(actor);

            // Verificamos si el mes actual coincide con el mes deseado
            if (mesActual.equals(mesDeseado)) {
                actor.attemptsTo(Click.on(DAY(dia)));
            } else {
                String anioActual = ExtraerValor.value(YEAR).answeredBy(actor);
                if (anioActual.equals(year)) {

                    if (mesActual.compareTo(mesDeseado) < 0) {
                        actor.attemptsTo(Click.on(CHECKBOX_ADELANTE));
                    } else {
                        actor.attemptsTo(Click.on(CHECKBOX_ATRAS));
                    }
                } else {
                    actor.attemptsTo(Click.on(CHECKBOX_ATRAS));
                }
            }

        }
    }

// Método estático para crear la tarea con la fecha
public static SeleccionarFecha enCalendario(String fecha) {
    return new SeleccionarFecha(fecha);
}
}