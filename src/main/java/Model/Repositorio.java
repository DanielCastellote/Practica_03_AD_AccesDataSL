package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Repositorio {

    private UUID idRepositorio;
    private Date fCreacion;
    private UUID idProyecto;
    private List<Commit> commits;
    private List<Issues> issues;

}
