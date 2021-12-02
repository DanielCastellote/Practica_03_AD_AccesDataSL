package Controller;

import DTO.DepartamentoDTO;
import Repository.DepartamentoRepositorio;
import Service.DepartService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.SQLException;


public class DepartamentoController {
    private static DepartamentoController controller = null;

    // Mi Servicio unido al repositorio
    private final DepartService depService;

    // Implementamos nuestro Singleton para el controlador
    private DepartamentoController(DepartService depService) {
        this.depService= depService;
    }

    public static DepartamentoController getInstance() {
        if (controller == null) {
            controller = new DepartamentoController(new DepartService(new DepartamentoRepositorio()));
        }
        return controller;
    }

    public String getAllDepartamentosJSON() {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(depService.getAllDepartamentos());
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getAllDepartamentos: " + e.getMessage());
            return "Error DepartamentoController en getAllDepartamentos:" + e.getMessage();
        }
    }

    public String getDepartamentosByIdJSON(Long id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(depService.getDepartamentosById(id));
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en getDepartamentoById: " + e.getMessage());
            return "Error DepartamentoController en getDepartamentoById:" + e.getMessage();
        }
    }

    public String postDepartamentosJSON(DepartamentoDTO deparDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(depService.postDepartamentos(deparDTO));
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en postDepartamento: " + e.getMessage());
            return "Error DepartamentoController en postDepartamento: " + e.getMessage();
        }
    }

    public String updateDepartamentosJSON(DepartamentoDTO deparDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(depService.updateDepartamentos(deparDTO));
        } catch (SQLException e) {
            System.err.println("Error DepartamentoController en updateDepartamentos: " + e.getMessage());
            return "Error DepartamentoController en updateDepartamentos: " + e.getMessage();
        }
    }

    public String deleteDepartamentosJSON(DepartamentoDTO deparDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(depService.deleteDepartamentos(deparDTO));
        } catch (SQLException e) {
            System.err.println("Error DepartamentosController en deleteDepartamentos: " + e.getMessage());
            return "Error DepartamentosController en deleteDepartamentos: " + e.getMessage();
        }
    }
}
