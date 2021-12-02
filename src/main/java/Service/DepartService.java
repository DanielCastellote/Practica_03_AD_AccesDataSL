package Service;

import DTO.DepartamentoDTO;
import Mapper.DepartamentoMapper;
import Model.Departamento;
import Repository.DepartamentoRepositorio;
import java.sql.SQLException;
import java.util.List;

public class DepartService extends BaseService<Departamento,Long, DepartamentoRepositorio>{

    DepartamentoMapper mapper = new DepartamentoMapper();


    public DepartService(DepartamentoRepositorio repository) {
        super(repository);
    }
    public List<DepartamentoDTO> getAllDepartamentos() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public DepartamentoDTO getDepartamentosById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public DepartamentoDTO postDepartamentos(DepartamentoDTO categoryDTO) throws SQLException {
        Departamento res = this.save(mapper.fromDTO(categoryDTO));
        return mapper.toDTO(res);
    }

    public DepartamentoDTO updateDepartamentos(DepartamentoDTO categoryDTO) throws SQLException {
        Departamento res = this.update(mapper.fromDTO(categoryDTO));
        return mapper.toDTO(res);
    }

    public DepartamentoDTO deleteDepartamentos(DepartamentoDTO categoryDTO) throws SQLException {
        Departamento res = this.delete(mapper.fromDTO(categoryDTO));
        return mapper.toDTO(res);
    }
}
