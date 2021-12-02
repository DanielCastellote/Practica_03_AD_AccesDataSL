package Mapper;

import DTO.CreacionDTO;
import Model.Creacion;

public class CreacionMapper extends BaseMapper<Creacion, CreacionDTO>  {
    @Override
    public Creacion fromDTO(CreacionDTO item) {
        return Creacion.builder().idProgramador(item.getIdProgramador()).idIssue(item.getIdIssue())
                .build();
    }

    @Override
    public CreacionDTO toDTO(Creacion item) {
        return CreacionDTO.builder().idProgramador(item.getIdProgramador()).idIssue(item.getIdIssue())
                .build();
    }
}
