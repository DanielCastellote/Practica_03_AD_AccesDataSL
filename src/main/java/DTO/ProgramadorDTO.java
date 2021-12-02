package DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class ProgramadorDTO {

    private long idProgramador;
    private String nombre;
    private Date fAlta;
    private List<String> tecnologias;
    private double salario;
    private long idDepartamento;
    private List<String> proyectosParticipa;
    private List<String> commitsDone;
    private List<String> issuesDone;
    private String password;

    // From/To JSON
    public static ProgramadorDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, ProgramadorDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }
}