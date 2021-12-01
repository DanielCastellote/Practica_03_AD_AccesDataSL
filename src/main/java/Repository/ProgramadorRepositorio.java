package Repository;

import Database.DataBaseController;
import Model.Departamento;
import Model.Programador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramadorRepositorio implements CRUD_Repositorio<Programador, Long> {
    @Override
    public List<Programador> findAll() throws SQLException {
        String query = "SELECT * FROM programador";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error ProgramadorRepository al consultar registros"));
        ArrayList<Programador> list = new ArrayList<Programador>();
        while (result.next()) {
            List<String> issues = Arrays.stream(result.getString("issuesDone").split(";")).collect(Collectors.toList());
            List<String> proyecto = Arrays.stream(result.getString("proyectosParticipa").split(";")).collect(Collectors.toList());
            List<String> commits = Arrays.stream(result.getString("commitsDone").split(";")).collect(Collectors.toList());
            List<String> tecnologias = Arrays.stream(result.getString("tecnologias").split(";")).collect(Collectors.toList());

            list.add(
                    new Programador(
                            result.getLong("idProgramador"),
                            result.getString("nombre"),
                            result.getDate("fAlta"),
                            tecnologias,
                            result.getDouble("salario"),
                            result.getLong("idDepartamento"),
                            proyecto,
                            commits,
                            issues,
                            result.getString("password")
                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Programador getById(Long aLong) throws SQLException {
        String query = "SELECT * FROM programador WHERE idProgramador = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, aLong).orElseThrow(() -> new SQLException("Error ProgramadorRepository al consultar con ID " + aLong));
        if (result.first()) {
            List<String> issues = Arrays.stream(result.getString("issuesDone").split(";")).collect(Collectors.toList());
            List<String> proyecto = Arrays.stream(result.getString("proyectosParticipa").split(";")).collect(Collectors.toList());
            List<String> commits = Arrays.stream(result.getString("commitsDone").split(";")).collect(Collectors.toList());
            List<String> tecnologias = Arrays.stream(result.getString("tecnologias").split(";")).collect(Collectors.toList());
            Programador programador = new Programador(
                    result.getLong("idProgramador"),
                    result.getString("nombre"),
                    result.getDate("fAlta"),
                    tecnologias,
                    result.getDouble("salario"),
                    result.getLong("idDepartamento"),
                    proyecto,
                    commits,
                    issues,
                    result.getString("password")
            );
            db.close();
            return programador;
        } else
            throw new SQLException("Error ProgramadorRepository no existe  con ID: " + aLong);
    }

    @Override
    public Programador save(Programador programador) throws SQLException {
        String query = "INSERT INTO programador VALUES (null, ?,?,?,?,?,?,?,?,?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet res = db.insert(query,programador.getIdProgramador(), programador.getNombre(), programador.getFAlta(),
                programador.getIdDepartamento(), programador.getProyectosParticipa(), programador.getCommitsDone(), programador.getIssuesDone(),
                programador.getTecnologias(), programador.getSalario(), programador.getPassword()).orElseThrow(() -> new SQLException("Error ProgramadorRepository al insertar "));
        // Para obtener su ID
        if (res.first()) {
            programador.setIdDepartamento(res.getLong(1));
            db.close();
            return programador;
        } else
            throw new SQLException("Error DepartamentoRepository al insertar  en BD");
    }

    @Override
    public Programador update(Programador programador) throws SQLException {
        String query = "UPDATE programador nombre = ?, fAlta = ?, idDepartamento = ?," +
                "proyectoParticipa = ?, commitsDone = ?, issuesDone = ?, tecnologias = ?, salario = ?, password = ? WHERE idProgramador = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, programador.getIdProgramador(),programador.getNombre(), programador.getFAlta(),
                programador.getIdDepartamento(), programador.getProyectosParticipa(), programador.getCommitsDone(), programador.getIssuesDone(),
                programador.getTecnologias(), programador.getSalario(), programador.getPassword());
        db.close();
        if (res > 0)
            return programador;
        else
            throw new SQLException("Error ProgramadorRepository al actualizar con id: " + programador.getIdDepartamento());

    }

    @Override
    public Programador delete(Programador programador) throws SQLException {
        String query = "DELETE FROM programador WHERE idProgramador = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, programador.getIdProgramador());
        db.close();
        if (res > 0)
            return programador;
        else
            throw new SQLException("Error ProgramadorRepository al eliminar con id: " + programador.getIdDepartamento());

    }
}
