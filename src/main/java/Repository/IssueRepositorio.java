package Repository;

import Database.DataBaseController;
import Model.Issues;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IssueRepositorio  implements CRUD_Repositorio<Issues,Long>{
    @Override
    public List<Issues> findAll() throws SQLException {
        String query = "SELECT * FROM issues";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error IssueRepository al consultar registros de issues"));
        ArrayList<Issues> list = new ArrayList<>();
        while (result.next()) {
            List<String> programadores = Arrays.stream(result.getString("programadores").split(";")).collect(Collectors.toList());

            list.add(
                    new Issues(
                            result.getLong("idIssue"),
                            result.getString("titulo"),
                            result.getString("texto"),
                            result.getDate("fecha"),
                            programadores,
                            result.getLong("idProyecto"),
                            result.getLong("idRepositorio")
                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Issues getById(Long aLong) throws SQLException {
        String query = "SELECT * FROM issues WHERE idIsuue = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, aLong).orElseThrow(() -> new SQLException("Error IssueRepository al consultar issue con ID " + aLong));
        if (result.first()) {
            List<String> programadores = Arrays.stream(result.getString("programadores").split(";")).collect(Collectors.toList());

            Issues issue = new Issues(
                    result.getLong("idIssue"),
                    result.getString("titulo"),
                    result.getString("texto"),
                    result.getDate("fecha"),
                    programadores,
                    result.getLong("idProyecto"),
                    result.getLong("idRepositorio")
            );
            db.close();
            return issue;
        } else
            throw new SQLException("Error IssueRepository no existe issue con ID: " + aLong);
    }

    @Override
    public Issues save(Issues issue) throws SQLException {
        String query = "INSERT INTO issues VALUES (null, ?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();

        ResultSet result = db.insert(query, issue.getTitulo(), issue.getTexto(),
                issue.getFecha(), issue.getProgramadores(), issue.getIdProyecto(), issue.getIdRepositorio()
        ).orElseThrow(() ->
                new SQLException("Error IssueRepository al insertar issue"));
        if (result.first()) {
            issue.setIdIssue(result.getInt(1));

            db.close();
            return issue;
        } else
            throw new SQLException("Error IssueRepository al insertar issue en BBDD");
    }

    @Override
    public Issues update(Issues issue) throws SQLException {
        String query = "UPDATE issues titulo = ?, texto = ?, fecha = ?,  " +
                "programadores = ?, idProyecto = ?, idRepositorio = ? WHERE idIssue = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, issue.getTitulo(), issue.getTexto(),
                issue.getFecha(), issue.getProgramadores(), issue.getIdProyecto(), issue.getIdRepositorio(), issue.getIdIssue()
        );
        db.close();
        if (res > 0)
            return issue;
        else
            throw new SQLException("Error IssueRepository al actualizar issue con id: " + issue.getIdIssue());
    }

    @Override
    public Issues delete(Issues issue) throws SQLException {
        String query = "DELETE FROM issues WHERE idIssue = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, issue.getIdIssue());
        db.close();
        if (res > 0)
            return issue;
        else
            throw new SQLException("Error IssueRepository al eliminar issue con id: " + issue.getIdIssue());
    }
}
