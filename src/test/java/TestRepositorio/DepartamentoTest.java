package TestRepositorio;

import Model.Departamento;
import Repository.DepartamentoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DepartamentoTest {

    Departamento d=new Departamento(1,"IT",23000,200000,11,"j","t","p");
    DepartamentoRepositorio departamento = new DepartamentoRepositorio();


    @Test
    void selectAllDepartamento() throws SQLException {
        Optional<List<Departamento>> dep = Optional.ofNullable(departamento.findAll());
        Assertions.assertEquals(1,dep.stream().count());
    }

    @Test
    void selectDepartamentoById() throws SQLException {
        Optional<Departamento> dep = Optional.ofNullable(departamento.getById(null));
        Assertions.assertEquals(Optional.of(d),dep);
    }

    @Test
    void insertDepartamento() throws SQLException {
        Optional<Departamento> dep = Optional.ofNullable(departamento.save(d));
        Assertions.assertEquals(Optional.of(d),dep);
    }

    @Test
    void deleteDepartamento() throws SQLException {
        Optional<Departamento> dep = Optional.ofNullable(departamento.delete(d));
        Assertions.assertEquals(Optional.of(d), dep);
    }
}
