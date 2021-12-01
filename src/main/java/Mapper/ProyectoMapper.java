package Mapper;

import DTO.ProyectoDTO;
import Model.Proyecto;

public class ProyectoMapper extends BaseMapper<Proyecto, ProyectoDTO> {


    @Override
    public Proyecto fromDTO(ProyectoDTO item) {
        return Proyecto.builder().idProyecto(item.getIdProyecto()).nombre(item.getNombre())
                .idJefe(item.getIdJefe()).presupuesto(item.getPresupuesto())
                .fInicio(item.getFInicio()).fFin(item.getFFin())
                .tecnologias(item.getTecnologias()).idRepositorio(item.getIdRepositorio())
                .build();
    }

    @Override
    public ProyectoDTO toDTO(Proyecto item) {
        return ProyectoDTO.builder().idProyecto(item.getIdProyecto()).nombre(item.getNombre())
                .idJefe(item.getIdJefe()).presupuesto(item.getPresupuesto())
                .fInicio(item.getFInicio()).fFin(item.getFFin())
                .tecnologias(item.getTecnologias()).idRepositorio(item.getIdRepositorio())
                .build();
    }
}
