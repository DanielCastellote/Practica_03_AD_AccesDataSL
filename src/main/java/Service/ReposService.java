package Service;

import DTO.DepartamentoDTO;
import DTO.RepositorioDTO;
import Mapper.RepositorioMapper;
import Model.Departamento;
import Model.Repositorio;
import Repository.RepositorioRepositorio;

import java.sql.SQLException;
import java.util.List;

public class ReposService extends BaseService<Repositorio,Long, RepositorioRepositorio> {
    RepositorioMapper mapper = new RepositorioMapper();
    public ReposService(RepositorioRepositorio repository) {super(repository);}

    public List<RepositorioDTO> getAllRepositorios() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public RepositorioDTO getRepositoriosById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public RepositorioDTO postRepositorios(RepositorioDTO repositorioDTO) throws SQLException {
        Repositorio res = this.save(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res);
    }

    public RepositorioDTO updateRepositorios(RepositorioDTO repositorioDTO) throws SQLException {
        Repositorio res = this.update(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res);
    }

    public RepositorioDTO deleteRepositorios(RepositorioDTO repositorioDTO) throws SQLException {
        Repositorio res = this.delete(mapper.fromDTO(repositorioDTO));
        return mapper.toDTO(res);
    }

}
