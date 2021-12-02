package DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class CommitDTO {

    private long idCommit;
    private String titulo,texto;
    private Date fecha;
    private long idRepositorio;
    private long idProyecto;
    private long idAutor;
    private long idIssue;
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
