package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento {
    private long idDepartamento;
    private String nombre;
    private long presupuesto;
    private long presupuestoAnual;
    private long idJefeDepartamento;
    private String proyectosTerminados;
    private String proyectosDesarrollo;
    private String historialJefes;
}
