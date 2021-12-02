package Mapper;

import DTO.RepositorioDTO;
import Model.Repositorio;

public class RepositorioMapper extends BaseMapper<Repositorio, RepositorioDTO> {
    @Override
    public Repositorio fromDTO(RepositorioDTO item) {
        return Repositorio.builder().idRepositorio(item.getIdRepositorio())
                .fCreacion(item.getFCreacion()).idRepositorio(item.getIdRepositorio()
                ).commits(item.getCommits()).issues(item.getIssues()).build();
    }

    @Override
    public RepositorioDTO toDTO(Repositorio item) {
         return RepositorioDTO.builder().idRepositorio(item.getIdRepositorio())
                .fCreacion(item.getFCreacion()).idRepositorio(item.getIdRepositorio()
                ).commits(item.getCommits()).issues(item.getIssues()).build();
    }
}
