package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jefe {

    private long idJefe;
    private String nombre;
    private Date fAlta;
    private long idDepartamento;


}
