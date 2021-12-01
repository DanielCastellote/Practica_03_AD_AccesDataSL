package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jefe {

    private long idJefe;
    private String nombre;
    private Date fAlta;
    private long idDepartamento;


}
