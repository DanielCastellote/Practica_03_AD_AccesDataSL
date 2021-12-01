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
public class Proyecto {

    private long idProyecto;
    private String nombre;
    private long idJefe;
    private double presupuesto;
    private Date fInicio,fFin;
    private String tecnologias;
    private long idRepositorio;

}
