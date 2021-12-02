package Controller;

import DTO.DepartamentoDTO;
import DTO.RepositorioDTO;
import Repository.DepartamentoRepositorio;
import Repository.RepositorioRepositorio;
import Service.DepartService;
import Service.ReposService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.SQLException;

public class RepositorioController {
    private static RepositorioController controller = null;

    // Mi Servicio unido al repositorio
    private final ReposService reposService;

    // Implementamos nuestro Singleton para el controlador
    private RepositorioController(ReposService reposService) {
        this.reposService= reposService;
    }

    public static RepositorioController getInstance() {
        if (controller == null) {
            controller = new RepositorioController(new ReposService(new RepositorioRepositorio()));
        }
        return controller;
    }

    public String getAllRepositoriosJSON() {
        try {
            // Vamos a devolver el JSON de los Repositorios
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(reposService.getAllRepositorios());
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en getAllRepositorio: " + e.getMessage());
            return "Error RepositorioController en getAllRepositorio:" + e.getMessage();
        }
    }

    public String getRepositoriosByIdJSON(Long id) {
        try {
            // Vamos a devolver el JSON de los Repositorios
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(reposService.getRepositoriosById(id));
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getDepartamentoById: " + e.getMessage());
            return "Error DepartamentoController en getDepartamentoById:" + e.getMessage();
        }
    }

    public String postRepositoriosJSON(RepositorioDTO repoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(reposService.postRepositorios(repoDTO));
        } catch (SQLException e) {
            System.err.println("Error RepositoriosController en postRepositorios " + e.getMessage());
            return "ErrorRepositoriosController en postRepositorios: " + e.getMessage();
        }
    }

    public String updateRepositoriosJSON(RepositorioDTO repoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(reposService.updateRepositorios(repoDTO));
        } catch (SQLException e) {
            System.err.println("Error RepositoriosController en updateRepositorios: " + e.getMessage());
            return "ErrorRepositoriosController en updateRepositorios: " + e.getMessage();
        }
    }

    public String deleteRepositoriosJSON(RepositorioDTO repoDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(reposService.deleteRepositorios(repoDTO));
        } catch (SQLException e) {
            System.err.println("Error RepositoriosController en deleteRepositorios: " + e.getMessage());
            return "ErrorRepositoriosController en deleteRepositorios: " + e.getMessage();
        }
    }

}
