package Service;

import DTO.DepartamentoDTO;
import DTO.ProyectoDTO;
import Mapper.ProyectoMapper;
import Model.Departamento;
import Model.Proyecto;
import Repository.ProyectoRespositorio;

import java.sql.SQLException;
import java.util.List;

public class ProytService extends BaseService<Proyecto,Long, ProyectoRespositorio> {

    ProyectoMapper mapper = new ProyectoMapper();

    public ProytService(ProyectoRespositorio repository) {
        super(repository);
    }

    public List<ProyectoDTO> getAllProyectos() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public ProyectoDTO getDProyectosById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public ProyectoDTO postProyectos(ProyectoDTO proyectoDTO) throws SQLException {
        Proyecto res = this.save(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(res);
    }

    public ProyectoDTO updateProyectos(ProyectoDTO proyectoDTO) throws SQLException {
        Proyecto res = this.update(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(res);
    }

    public ProyectoDTO deleteProyectos(ProyectoDTO proyectoDTO) throws SQLException {
        Proyecto res = this.delete(mapper.fromDTO(proyectoDTO));
        return mapper.toDTO(res);
    }
}