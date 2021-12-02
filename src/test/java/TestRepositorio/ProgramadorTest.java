package TestRepositorio;


import Model.Programador;
import Repository.ProgramadorRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProgramadorTest {

    Programador d=new Programador(1,"pepe",null,new ArrayList<>(),1000,1,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"rr");
    ProgramadorRepositorio programador = new ProgramadorRepositorio();


    @Test
    void selectAllDepartamento() throws SQLException {
        Optional<List<Programador>> dep = Optional.ofNullable(programador.findAll());
        Assertions.assertEquals(1,dep.stream().count());
    }

    @Test
    void selectDepartamentoById() throws SQLException {
        Optional<Programador> dep = Optional.ofNullable(programador.getById(null));
        Assertions.assertEquals(Optional.of(d),dep);
    }

    @Test
    void insertDepartamento() throws SQLException {
        Optional<Programador> dep = Optional.ofNullable(programador.save(d));
        Assertions.assertEquals(Optional.of(d),dep);
    }

    @Test
    void deleteDepartamento() throws SQLException {
        Optional<Programador> dep = Optional.ofNullable(programador.delete(d));
        Assertions.assertEquals(Optional.of(d), dep);
    }
}
