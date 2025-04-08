package co.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioUI {


    public static final Target BTN_CALENDARIO = Target.the("Boton fechas")
            .located(By.xpath("//input[@class='hasDatepicker']"));

    public static final Target IFRAME = Target.the("Boton fechas")
            .located(By.xpath("//iframe[@src='/resources/demos/datepicker/default.html']"));


    public static final Target CALENDARIO = Target.the("Vista Calendario")
            .located(By.id("ui-datepicker-div"));

    public static final Target CHECKBOX_ATRAS = Target.the("Checkbox atras")
            .located(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));

    public static final Target CHECKBOX_ADELANTE = Target.the("Checkbox adelante")
            .located(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));

    public static final Target MONTH = Target.the("Mes calendario")
            .located(By.xpath("//span[@class='ui-datepicker-month']"));

    public static final Target YEAR = Target.the("Mes calendario")
            .located(By.xpath("//span[@class='ui-datepicker-year']"));

    public static final Target DATE = Target.the("Date")
            .located(By.xpath("//input[@class='hasDatepicker']"));

    public static Target DAY(int dia) {
        return Target.the("Día " + dia)
                .located(By.xpath("//a[@class='ui-state-default' and @data-date='" + dia + "']"));
    }


    private InicioUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}
