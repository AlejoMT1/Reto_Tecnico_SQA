package co.sqasa.utils;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Funciones {

    @SneakyThrows
    public static String convertirFechaALetra(String fechaStr){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse(fechaStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        String[] meses = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        int mes = calendar.get(Calendar.MONTH);

        return meses[mes];
    }

    @SneakyThrows
    public static int extraerDia(String fechaStr){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse(fechaStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        return dia;
    }

    @SneakyThrows
    public static int extraerYear(String fechaStr) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse(fechaStr);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        int year = calendar.get(Calendar.YEAR);

        return year;
    }

    @SneakyThrows
    public static Boolean compararFechaConActual(String fechaStr) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse(fechaStr);

        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Comparar las fechas
        if (fecha.before(fechaActual)) {
            return false;
        } else {
            return true;
        }
    }
}
