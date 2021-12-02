package Controller;

import DTO.ProyectoDTO;
import Repository.ProyectoRespositorio;
import Service.ProytService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.SQLException;

public class ProyectosController {
    private static ProyectosController controller= null;

    //Mi Servicio unido al repositorio
    private final ProytService proytService;

    public ProyectosController(ProytService proytService) {this.proytService = proytService;}

    // Implementamos nuestro Singleton para el controlador
    public static ProyectosController getInstance() {
        if (controller == null) {
            controller = new ProyectosController(new ProytService(new ProyectoRespositorio()));
        }
        return controller;
    }
    public String getAllProyectosJSON() {
        try {

            // Vamos a devolver el JSON de los proyectos

            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proytService.getAllProyectos());
        } catch (SQLException e) {
            System.err.println("Error ProyectosController en getAllProyectos: " + e.getMessage());
            return "Error ProyectosController en getAllProyectos:" + e.getMessage();
        }
    }

    public String getProyectosByIdJSON(Long id) {
        try {

            // Vamos a devolver el JSON de los proyectos

            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proytService.getDProyectosById(id));
        } catch (SQLException e) {
            System.err.println("Error ProyectosController en getProyectosById: " + e.getMessage());
            return "Error ProyectosController en getProyectosById:" + e.getMessage();
        }
    }
    public String postProyectosJSON(ProyectoDTO proytDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proytService.postProyectos(proytDTO));
        } catch (SQLException e) {
            System.err.println("Error ProyectosController en postProyectoso: " + e.getMessage());
            return "Error ProyectosController en postProyectos: " + e.getMessage();
        }
    }
    public String updateProyectosJSON(ProyectoDTO proytDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proytService.updateProyectos(proytDTO));
        } catch (SQLException e) {
            System.err.println("Error ProyectosController en updateProyectos: " + e.getMessage());
            return "Error ProyectosController en updateProyectos: " + e.getMessage();
        }
    }
    public String deleteProyectosJSON(ProyectoDTO proytDTO) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proytService.deleteProyectos(proytDTO));
        } catch (SQLException e) {
            System.err.println("Error ProyectosController en deleteProyectos: " + e.getMessage());
            return "Error ProyectosController en deleteProyectos: " + e.getMessage();
        }
    }
}