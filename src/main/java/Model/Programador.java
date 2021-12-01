package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programador {

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

}
