package Repository;

import Database.DataBaseController;
import Model.Commit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommitRespositorio  implements CRUD_Repositorio<Commit,Long>{
    @Override
    public List<Commit> findAll() throws SQLException {
        String query = "SELECT * FROM commits";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error CommitRepository al consultar registros de commit"));
        ArrayList<Commit> list = new ArrayList<>();
        while (result.next()) {
            list.add(
                    new Commit(
                            result.getLong("idCommit"),
                            result.getString("titulo"),
                            result.getString("texto"),
                            result.getDate("fecha"),
                            result.getLong("idRepositorio"),
                            result.getLong("idProyecto"),
                            result.getLong("idAutor"),
                            result.getLong("idIssue")
                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Commit getById(Long aLong) throws SQLException {
        String query = "SELECT * FROM commits WHERE idCommit = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, aLong).orElseThrow(() -> new SQLException("Error CommitRepository al consultar commit con ID " + aLong));
        if (result.first()) {
            Commit commit = new Commit(
                    result.getInt("idCommit"),
                    result.getString("titulo"),
                    result.getString("texto"),
                    result.getDate("fecha"),
                    result.getInt("idRepositorio"),
                    result.getInt("idProyecto"),
                    result.getInt("idAutor"),
                    result.getInt("idIssue")
            );
            db.close();
            return commit;
        } else
            throw new SQLException("Error CommitRepository no existe commit con ID: " + aLong);
    }

    @Override
    public Commit save(Commit commits) throws SQLException {
        String query = "INSERT INTO commits VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();

        ResultSet result = db.insert(query, commits.getTitulo(), commits.getTexto(),
                commits.getFecha(), commits.getIdRepositorio(), commits.getIdProyecto(), commits.getIdAutor(),
                commits.getIdIssue()
        ).orElseThrow(() ->
                new SQLException("Error CommitRepository al insertar commit"));
        if (result.first()) {
            commits.setIdCommit(result.getInt(1));

            db.close();
            return commits;
        } else
            throw new SQLException("Error CommitRepository al insertar commit en BBDD");
    }

    @Override
    public Commit update(Commit commits) throws SQLException {
        String query = "UPDATE commits titulo = ?, texto = ?, fecha = ?,  " +
                "idRepositorio = ?, idProyecto = ?, idAutor = ?, idIssue = ? WHERE idCommit = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, commits.getTitulo(), commits.getTexto(),
                commits.getFecha(), commits.getIdRepositorio(), commits.getIdProyecto(), commits.getIdAutor(),
                commits.getIdIssue(), commits.getIdCommit()
        );
        db.close();
        if (res > 0)
            return commits;
        else
            throw new SQLException("Error CommitRepository al actualizar commit con id: " + commits.getIdCommit());
    }

    @Override
    public Commit delete(Commit commits) throws SQLException {
        String query = "DELETE FROM commits WHERE idCommit = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, commits.getIdCommit());
        db.close();
        if (res > 0)
            return commits;
        else
            throw new SQLException("Error CommitRepository al eliminar commit con id: " + commits.getIdCommit());
    }
}
