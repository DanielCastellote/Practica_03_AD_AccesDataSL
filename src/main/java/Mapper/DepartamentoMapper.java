package Mapper;

import DTO.DepartamentoDTO;
import Model.Departamento;

public class DepartamentoMapper extends BaseMapper<Departamento, DepartamentoDTO>{
    @Override
    public Departamento fromDTO(DepartamentoDTO item) {
        return Departamento.builder().idDepartamento(item.getIdDepartamento())
                .nombre(item.getNombre()).presupuesto(item.getPresupuesto()).presupuestoAnual(item.getPresupuestoAnual()).
                idJefeDepartamento(item.getIdJefeDepartamento()).proyectosDesarrollo(item.getProyectosDesarrollo()).proyectosTerminados(item.getProyectosTerminados()).
                historialJefes(item.getHistorialJefes())
                .build();
    }

    @Override
    public DepartamentoDTO toDTO(Departamento item) {
        return DepartamentoDTO.builder().idDepartamento(item.getIdDepartamento())
                .nombre(item.getNombre()).presupuesto(item.getPresupuesto()).presupuestoAnual(item.getPresupuestoAnual()).
                idJefeDepartamento(item.getIdJefeDepartamento()).proyectosDesarrollo(item.getProyectosDesarrollo()).proyectosTerminados(item.getProyectosTerminados()).
                historialJefes(item.getHistorialJefes())
                .build();
    }
}
