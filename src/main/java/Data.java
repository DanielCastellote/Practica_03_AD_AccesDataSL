import Controller.DepartamentoController;
import Controller.ProgramadorController;
import Controller.ProyectosController;
import DTO.DepartamentoDTO;
import DTO.ProgramadorDTO;
import DTO.ProyectoDTO;
import Database.DataBaseController;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Optional;

public class Data {

    private static Data instance;

    private Data() {
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public void checkService() {
        DataBaseController controller = DataBaseController.getInstance();
        try {
            controller.open();
            Optional<ResultSet> rs = controller.select("SELECT 'Hello World'");
            if (rs.isPresent()) {
                rs.get().first();
                controller.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
            System.exit(1);
        }
    }

    public void initDataBase() {
        String sqlFile = System.getProperty("user.dir") + File.separator + "sql" + File.separator + "data.sql";
        System.out.println(sqlFile);
        DataBaseController controller = DataBaseController.getInstance();
        try {
            controller.open();
            controller.initData(sqlFile);
            controller.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el fichero de datos iniciales: " + e.getMessage());
            System.exit(1);
        }
    }
    public void Departamentos() {
        DepartamentoController departamentoController = DepartamentoController.getInstance();

        System.out.println("GET Todas las Departamentos");
        System.out.println(departamentoController.getAllDepartamentosJSON());

        System.out.println("GET Departamento con ID = 2");
        System.out.println(departamentoController.getDepartamentosByIdJSON(2L));

        System.out.println("POST Insertando Departamento");
        DepartamentoDTO departDTO = DepartamentoDTO.builder()
                .nombre("Prueba " + Instant.now().toString())
                .build();
        System.out.println(departamentoController.postDepartamentosJSON(departDTO));

        System.out.println("UPDATE Departamento con ID = 4");
        departDTO = DepartamentoDTO.builder()
                .idDepartamento(4L)
                .nombre("Prueba Update")
                .build();
        System.out.println(departamentoController.updateDepartamentosJSON(departDTO));

        System.out.println("DELETE Departamento con ID = 4");
        departDTO = DepartamentoDTO.builder()
                .idDepartamento(4L)
                .build();
        System.out.println(departamentoController.deleteDepartamentosJSON(departDTO));
    }

    public void Prroyectos() {
        ProyectosController proyController = ProyectosController.getInstance();

        System.out.println("GET Todos los Proyecto");
        System.out.println(proyController.getAllProyectosJSON());

        System.out.println("GET Proyecto con ID = 2");
        System.out.println(proyController.getProyectosByIdJSON(2L));

        System.out.println("Proyecto Insertando ");
        ProyectoDTO proyDTO = ProyectoDTO.builder()
                .nombre("Nombre " + Instant.now().toString())
                .presupuesto(2000)
                .build();
        System.out.println(proyController.postProyectosJSON(proyDTO));

        System.out.println("UPDATE Proyecto con ID = 5");
        proyDTO = ProyectoDTO.builder()
                .idProyecto(5L)
                .nombre("Prueba Update")
                .build();
        System.out.println(proyController.updateProyectosJSON(proyDTO));

        System.out.println("DELETE Proyecto con ID = 5");
        proyDTO = ProyectoDTO.builder()
                .idProyecto(5L)
                .build();
        System.out.println(proyController.deleteProyectosJSON(proyDTO));
    }

    public void Programadores() {
        ProgramadorController progrController = ProgramadorController.getInstance();

        System.out.println("GET Todos los Programadores");
        System.out.println(progrController.getAllProgramadoresJSON());

        System.out.println("GET Programador con ID = 2");
        System.out.println(progrController.getProgramadoresByIdJSON(2L));

        System.out.println("Programador Insertando");
        ProgramadorDTO prograDTO = ProgramadorDTO.builder()
                .nombre("Nombre: " + Instant.now().toString())
                .password("htttiiep")
                .build();

        System.out.println(progrController.postProgramadoresJSON(prograDTO));

        System.out.println("UPDATE Programador con ID = 4");
        prograDTO = ProgramadorDTO.builder()
                .idProgramador(4L)
                .nombre("Update " + Instant.now().toString())
                .build();
        System.out.println(progrController.updateProgamadoresJSON(prograDTO));

        System.out.println("DELETE Programador con ID = 5");
        prograDTO = ProgramadorDTO.builder()
                .idProgramador(5L)
                .build();

        System.out.println(progrController.deleteProgramadoresJSON(prograDTO));



    }


}

