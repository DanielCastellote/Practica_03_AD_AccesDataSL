package Repository;

import Database.DataBaseController;
import Model.Departamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepositorio implements CRUD_Repositorio<Departamento, Long> {

    @Override
    public List<Departamento> findAll() throws SQLException {
        String query = "SELECT * FROM departamento";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error DepartamentoRepository al consultar registros"));
        ArrayList<Departamento> list = new ArrayList<>();
        while (result.next()) {
            list.add(
                    new Departamento(
                            result.getLong("idDepartamento"),
                            result.getString("nombre"),
                            result.getLong("presupuesto"),
                            result.getLong("presupuestoAnual"),
                            result.getLong("idJefeDepartamento"),
                            result.getString("proyectosTerminados"),
                            result.getString("proyectosDesarrollo"),
                            result.getString("historialJefes")
                    )
            );
        }
        db.close();
        return list;
    }

    @Override
    public Departamento getById(Long aLong) throws SQLException {
        String query = "SELECT * FROM departamento WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet result = db.select(query, aLong).orElseThrow(() -> new SQLException("Error DepartamentoRepository al consultar con ID " + aLong));
        if (result.first()) {
            Departamento departamento = new Departamento(
                    result.getLong("idDepartamento"),
                    result.getString("nombre"),
                    result.getLong("presupuesto"),
                    result.getLong("presupuestoAnual"),
                    result.getLong("idJefeDepartamento"),
                    result.getString("proyectosTerminados"),
                    result.getString("proyectosDesarrollo"),
                    result.getString("historialJefes")
            );
            db.close();
            return departamento;
        } else
            throw new SQLException("Error DepartamentoRepository no existe  con ID: " + aLong);
    }

    @Override
    public Departamento save(Departamento departamento) throws SQLException {
        String query = "INSERT INTO departamento VALUES (null,?,?,?,?,?,?,?)";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        ResultSet res = db.insert(query, departamento.getIdDepartamento(), departamento.getIdJefeDepartamento(), departamento.getNombre(), departamento.getPresupuesto(), departamento.getPresupuestoAnual(),
                departamento.getProyectosDesarrollo(), departamento.getProyectosTerminados(), departamento.getHistorialJefes()).orElseThrow(() -> new SQLException("Error DepartamentoRepository al insertar "));
        // Para obtener su ID
        if (res.first()) {
            departamento.setIdDepartamento(res.getLong(1));
            db.close();
            return departamento;
        } else
            throw new SQLException("Error DepartamentoRepository al insertar  en BD");
    }

    @Override
    public Departamento update(Departamento departamento) throws SQLException {
        String query = "UPDATE departamento nombre=?, idDepartamento=?," +
                "idJefeDepartamento=?,presupuesto = ?, presupuestoAnual=?,proyectosDesarrollo=?,proyectosTerminados=?,historialJefes=? WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.update(query, departamento.getIdDepartamento(), departamento.getIdJefeDepartamento(), departamento.getNombre(), departamento.getPresupuesto(), departamento.getPresupuestoAnual(),
                departamento.getProyectosDesarrollo(), departamento.getProyectosTerminados(), departamento.getHistorialJefes());
        db.close();
        if (res > 0)
            return departamento;
        else
            throw new SQLException("Error DepartamentoRepository al actualizar con id: " + departamento.getIdDepartamento());
    }

    @Override
    public Departamento delete(Departamento departamento) throws SQLException {
        String query = "DELETE FROM departamento WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        db.open();
        int res = db.delete(query, departamento.getIdDepartamento());
        db.close();
        if (res > 0)
            return departamento;
        else
            throw new SQLException("Error DepartamentoRepository al eliminar con id: " + departamento.getIdDepartamento());
    }

}