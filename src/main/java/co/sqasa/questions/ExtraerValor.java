package co.sqasa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ExtraerValor implements Question<String> {

    protected Target element;
    public ExtraerValor(Target element){
        this.element = element;
    }
    @Override
    public String answeredBy(Actor actor) {
        return element.resolveFor(actor).getText();
    }

    public static Question<String> value(Target element) {
        return new ExtraerValor(element);
    }
}