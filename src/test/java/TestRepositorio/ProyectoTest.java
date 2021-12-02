package TestRepositorio;

import Model.Proyecto;
import Repository.ProyectoRespositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProyectoTest {

    Proyecto d=new Proyecto(1,"GG",2,2000,null,null,"java",1);
    ProyectoRespositorio proyecto = new ProyectoRespositorio();

    @Test
    void selectAllDepartamento() throws SQLException {
        Optional<List<Proyecto>> dep = Optional.ofNullable(proyecto.findAll());
        Assertions.assertEquals(1,dep.stream().count());
    }

    @Test
    void selectDepartamentoById() throws SQLException {
        Optional<Proyecto> dep = Optional.ofNullable(proyecto.getById(null));
        Assertions.assertEquals(Optional.of(d),dep);
    }

    @Test
    void insertDepartamento() throws SQLException {
        Optional<Proyecto> dep = Optional.ofNullable(proyecto.save(d));
        Assertions.assertEquals(Optional.of(d),dep);
    }

    @Test
    void deleteDepartamento() throws SQLException {
        Optional<Proyecto> dep = Optional.ofNullable(proyecto.delete(d));
        Assertions.assertEquals(Optional.of(d), dep);
    }
}
