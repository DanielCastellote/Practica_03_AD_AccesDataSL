package DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartamentoDTO {

    private long idDepartamento;
    private String nombre;
    private long presupuesto;
    private long presupuestoAnual;
    private long idJefeDepartamento;
    private String proyectosTerminados;
    private String proyectosDesarrollo;
    private String historialJefes;

    // From/To JSON
    public static DepartamentoDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, DepartamentoDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }
}
