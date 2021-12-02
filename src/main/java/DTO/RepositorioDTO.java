package DTO;

import Model.Commit;
import Model.Issues;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class RepositorioDTO {

    private UUID idRepositorio;
    private Date fCreacion;
    private UUID idProyecto;
    private List<Commit> commits;
    private List<Issues> issues;

    // From/To JSON
    public static RepositorioDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, RepositorioDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }
}
