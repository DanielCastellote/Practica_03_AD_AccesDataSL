package Repository;

import Database.DataBaseController;
import Model.Proyecto;
import Model.Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoRespositorio  implements CRUD_Repositorio<Proyecto,Long> {
    @Override
    public List<Proyecto> findAll() throws SQLException {
        String query = "SELECT *  FROM proyectos";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error ProyectoRepository al consultar registros de Proyectos"));
        ArrayList<Proyecto> list = new ArrayList<Proyecto>();
        while (result.next()) {
            list.add(
                    new Proyecto(
                            result.getLong("idProyecto"),
                            result.getString("nombre"),
                            result.getInt("idJefe"),
                            result.getDouble("presupuesto"),
                            result.getDate("fInicio"),
                            result.getDate("fFin"),
                            result.getString("tecnologias"),
                            result.getInt("idRepositorio")
                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Proyecto getById(Long aLong) throws SQLException {
        String query = "SELECT * FROM proyectos WHERE idProyecto = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, aLong).orElseThrow(() -> new SQLException("Error ProyectoRepository al consultar proyecto con ID " + aLong));
        if (result.first()) {
            Proyecto proyecto = new Proyecto(
                    result.getLong("idProyecto"),
                    result.getString("nombre"),
                    result.getInt("jefeProyecto"),
                    result.getDouble("presupuesto"),
                    result.getDate("fechaInicio"),
                    result.getDate("fechaFin"),
                    result.getString("tecnologias"),
                    result.getInt("repositorio")
            );
            db.close();
            return proyecto;
        } else
            throw new SQLException("Error ProyectoRepository no existe proyecto con ID: " + aLong);
    }

    @Override
    public Proyecto save(Proyecto proyecto) throws SQLException {
        String query = "INSERT INTO proyectos VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();

        //Si mantenemos el formato con ; transformar las listas al insertar
        ResultSet result = db.insert(query,proyecto.getIdProyecto(), proyecto.getNombre(), proyecto.getIdJefe(),
                proyecto.getPresupuesto(), proyecto.getFInicio(), proyecto.getFFin(), proyecto.getTecnologias()
                , proyecto.getIdRepositorio()).orElseThrow(() ->
                new SQLException("Error ProyectoRepository al proyecto issue"));
        if (result.first()) {
            proyecto.setIdProyecto(result.getInt(1));

            db.close();
            return proyecto;
        } else
            throw new SQLException("Error ProyectoRepository al insertar proyecto en BBDD");
    }

    @Override
    public Proyecto update(Proyecto proyecto) throws SQLException {
        String query = "UPDATE proyectos nombre = ?, idJefe = ?, presupuesto = ?,  " +
                "fInicio = ?, fFin = ?, tecnologias = ?, idRepositorio = ? WHERE idProyecto = ?";

        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, proyecto.getNombre(), proyecto.getIdJefe(),
                proyecto.getPresupuesto(), proyecto.getFInicio(), proyecto.getFFin(), proyecto.getTecnologias(), proyecto.getIdRepositorio()
        );
        db.close();
        if (res > 0)
            return proyecto;
        else
            throw new SQLException("Error ProyectoRepository al actualizar proyecto con id: " + proyecto.getIdProyecto());
    }

    @Override
    public Proyecto delete(Proyecto proyecto) throws SQLException {
        String query = "DELETE FROM proyectos WHERE idProyecto = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, proyecto.getIdProyecto());
        db.close();
        if (res > 0)
            return proyecto;
        else
            throw new SQLException("Error ProyectoRepository al eliminar proyecto con id: " + proyecto.getIdProyecto());
    }
}
