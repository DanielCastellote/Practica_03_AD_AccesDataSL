package Mapper;


import DTO.ParticipacionDTO;
import Model.Participacion;

public class ParticipacionMapper extends BaseMapper<Participacion, ParticipacionDTO> {
    @Override
    public Participacion fromDTO(ParticipacionDTO item) {
        return Participacion.builder().idProgramador(item.getIdProgramador()).idProyecto(item.getIdProyecto())
                .build();
    }

    @Override
    public ParticipacionDTO toDTO(Participacion item) {
        return ParticipacionDTO.builder().idProgramador(item.getIdProgramador()).idProyecto(item.getIdProyecto())
                .build();
    }
}
