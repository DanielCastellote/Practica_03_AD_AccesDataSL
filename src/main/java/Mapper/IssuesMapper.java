package Mapper;

import DTO.IssuesDTO;
import Model.Issues;

public class IssuesMapper extends BaseMapper<Issues, IssuesDTO> {
    @Override
    public Issues fromDTO(IssuesDTO item) {
        return Issues.builder().idIssue(item.getIdIssue()).titulo(item.getTitulo())
                .texto(item.getTexto()).fecha(item.getFecha()).programadores(item.getProgramadores())
                .idProyecto(item.getIdProyecto()).idRepositorio(item.getIdRepositorio())
                .build();
    }

    @Override
    public IssuesDTO toDTO(Issues item) {
        return IssuesDTO.builder().idIssue(item.getIdIssue()).titulo(item.getTitulo())
                .texto(item.getTexto()).fecha(item.getFecha()).programadores(item.getProgramadores())
                .idProyecto(item.getIdProyecto()).idRepositorio(item.getIdRepositorio())
                .build();
    }
}
