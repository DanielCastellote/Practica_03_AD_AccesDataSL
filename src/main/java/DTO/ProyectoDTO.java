package DTO;

import Model.Proyecto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProyectoDTO {

    private long idProyecto;
    private String nombre;
    private long idJefe;
    private double presupuesto;
    private Date fInicio,fFin;
    private String tecnologias;
    private long idRepositorio;

    // From/To JSON
    public static ProyectoDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, ProyectoDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }
}