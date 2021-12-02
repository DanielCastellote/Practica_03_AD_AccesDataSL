package Mapper;

import DTO.JefeDTO;
import Model.Jefe;

public class JefeMapper extends BaseMapper<Jefe, JefeDTO> {
    @Override
    public Jefe fromDTO(JefeDTO item) {
        return Jefe.builder().idJefe(item.getIdJefe()).nombre(item.getNombre()).fAlta(item.getFAlta()).
                idDepartamento(item.getIdDepartamento()).build();
    }

    @Override
    public JefeDTO toDTO(Jefe item) {
        return JefeDTO.builder().idJefe(item.getIdJefe()).nombre(item.getNombre()).fAlta(item.getFAlta()).
                idDepartamento(item.getIdDepartamento()).build();
    }
}
