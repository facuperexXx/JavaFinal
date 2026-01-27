package parseadores;

import builders.OperacionBuilder;
import dto.Operacion;
import interfaces.BaseParser;

import java.util.HashMap;

public class OperacionParser implements BaseParser<Operacion> {

    @Override
    public Operacion leerCadena(String cadena) {
        OperacionBuilder builder = new OperacionBuilder();

        // Análisis de servicio y acción
        String[] segmentos = cadena.split(" ");
        builder.setServicio(segmentos[0]);
        builder.setAccion(segmentos[1]);

        // Análisis de parámetros
        String[] allParams = segmentos[2].split(",");
        for (String p : allParams) {
            String[] param = p.split("=");
            builder.setParametro(param[0], param[1]);
        }

        return builder.build();
    }
}
