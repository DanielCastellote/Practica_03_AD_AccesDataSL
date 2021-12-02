package Mapper;

import DTO.ProgramadorDTO;
import Model.Programador;

public class ProgramadorMapper extends BaseMapper<Programador, ProgramadorDTO> {


    @Override
    public Programador fromDTO(ProgramadorDTO item) {
        return Programador.builder().idProgramador(item.getIdProgramador())
                .nombre(item.getNombre()).fAlta(item.getFAlta()).tecnologias(item.getTecnologias())
                .salario(item.getSalario()).idDepartamento(item.getIdDepartamento())
                .proyectosParticipa(item.getProyectosParticipa()).commitsDone(item.getCommitsDone())
                .issuesDone(item.getIssuesDone()).password(item.getPassword())
                .build();

    }

    @Override
    public ProgramadorDTO toDTO(Programador item) {
        return ProgramadorDTO.builder().idProgramador(item.getIdProgramador())
                .nombre(item.getNombre()).fAlta(item.getFAlta()).tecnologias(item.getTecnologias())
                .salario(item.getSalario()).idDepartamento(item.getIdDepartamento())
                .proyectosParticipa(item.getProyectosParticipa()).commitsDone(item.getCommitsDone())
                .issuesDone(item.getIssuesDone()).password(item.getPassword())
                .build();
    }
}
