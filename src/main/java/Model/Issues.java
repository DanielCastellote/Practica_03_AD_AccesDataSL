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
public class Issues {
    private long idIssue;
    private String titulo,texto;
    private Date fecha;
    private List<String> programadores;
    private long idProyecto;
    private long idRepositorio;
    //private boolean estado;
}
