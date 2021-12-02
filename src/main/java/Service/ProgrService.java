package Service;

import DTO.DepartamentoDTO;
import DTO.ProgramadorDTO;
import Mapper.ProgramadorMapper;
import Model.Departamento;
import Model.Programador;
import Repository.ProgramadorRepositorio;

import java.sql.SQLException;
import java.util.List;

public class ProgrService extends BaseService<Programador,Long, ProgramadorRepositorio> {
    ProgramadorMapper mapper = new ProgramadorMapper();

    public ProgrService(ProgramadorRepositorio repository) {
        super(repository);
    }
    public List<ProgramadorDTO> getAllProgramadores()throws SQLException {
        return mapper.toDTO(this.findAll());
    }
    public ProgramadorDTO getProgamadoresById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO) throws SQLException {
        Programador res = this.save(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res);
    }

    public ProgramadorDTO updateProgramdor(ProgramadorDTO programadorDTO) throws SQLException {
        Programador res = this.update(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res);
    }

    public ProgramadorDTO deleteDepartamentos(ProgramadorDTO programadorDTO) throws SQLException {
        Programador res = this.delete(mapper.fromDTO(programadorDTO));
        return mapper.toDTO(res);
    }
}
