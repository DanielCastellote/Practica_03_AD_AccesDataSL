package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Commit {

    private long idCommit;
    private String titulo,texto;
    private Date fecha;
    private long idRepositorio;
    private long idProyecto;
    private long idAutor;
    private long idIssue;
}
