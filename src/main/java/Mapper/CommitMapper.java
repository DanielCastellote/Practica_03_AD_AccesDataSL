package Mapper;

import DTO.CommitDTO;
import Model.Commit;

public class CommitMapper extends BaseMapper<Commit, CommitDTO> {

    @Override
    public Commit fromDTO(CommitDTO item) {
        return Commit.builder().idCommit(item.getIdCommit()).titulo(item.getTitulo())
                .texto(item.getTexto()).fecha(item.getFecha()).idRepositorio(item.getIdRepositorio())
                .idProyecto(item.getIdProyecto()).idAutor(item.getIdAutor()).idIssue(item.getIdIssue())
                .build();
    }

    @Override
    public CommitDTO toDTO(Commit item) {
        return CommitDTO.builder().idCommit(item.getIdCommit()).titulo(item.getTitulo())
                .texto(item.getTexto()).fecha(item.getFecha()).idRepositorio(item.getIdRepositorio())
                .idProyecto(item.getIdProyecto()).idAutor(item.getIdAutor()).idIssue(item.getIdIssue())
                .build();
    }
}
