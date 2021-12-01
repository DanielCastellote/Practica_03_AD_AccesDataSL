package Controller;


import DTO.ProgramadorDTO;
import Repository.ProgramadorRepositorio;
import Service.ProgrService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.SQLException;

public class ProgramadorController {
    private static ProgramadorController controller= null;

    // Mi servicio unido al repositorio
    private final ProgrService progService;



    //implementamos nuestro Singleton para el controlador
    public ProgramadorController(ProgrService progService) {this.progService = progService;}

    public static ProgramadorController getInstance() {
        if (controller == null) {
            controller = new ProgramadorController(new ProgrService(new ProgramadorRepositorio()));
        }
        return controller;
    }

    public String getAllProgramadoresJSON() {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(progService.getAllProgramadores());
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getAllProgramadores: " + e.getMessage());
            return "Error ProgramadorController en getAllProgramadores:" + e.getMessage();
        }
    }
    public String getProgramadoresByIdJSON(Long id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(progService.getProgamadoresById(id));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en getProgramadoresById: " + e.getMessage());
            return "Error ProgramadorController en getProgramadoresById: " + e.getMessage();
        }
    }
    public String postProgramadoresJSON(ProgramadorDTO progDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(progService.postProgramador(progDTO));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en postProgramadores: " + e.getMessage());
            return "Error ProgramadorController en postProgramadores:" + e.getMessage();
        }
    }
    public String updateProgamadoresJSON(ProgramadorDTO progDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(progService.updateProgramdor(progDTO));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en updateProgramadores: " + e.getMessage());
            return "Error ProgramadorController en updateProgramadores: " + e.getMessage();
        }
    }
    public String deleteProgramadoresJSON(ProgramadorDTO progDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(progService.deleteDepartamentos(progDTO));
        } catch (SQLException e) {
            System.err.println("Error ProgramadorController en deleteProgramadores: " + e.getMessage());
            return "Error ProgramadorController en deleteProgramadores: " + e.getMessage();
        }
    }
}
