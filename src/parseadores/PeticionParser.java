package parseadores;

import builders.PeticionBuilder;
import dto.Peticion;
import interfaces.BaseParser;

public class PeticionParser implements BaseParser<Peticion> {

    @Override
    public Peticion leerCadena(String cadena) {
        PeticionBuilder builder = new PeticionBuilder();

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
