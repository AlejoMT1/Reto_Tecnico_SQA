package co.sqasa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
public class ValidarNombreProducto implements Question<Boolean> {
    protected Target element;
    public ValidarNombreProducto(Target element){
        this.element = element;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return element.resolveFor(actor).isEnabled();
    }

    public static Question<Boolean> value(Target element) {
        return new ValidarNombreProducto(element);
    }
}