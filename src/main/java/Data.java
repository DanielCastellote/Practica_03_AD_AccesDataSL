import Database.DataBaseController;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sqlFile = System.getProperty("user.dir") + File.separator + "sql" + File.separator + "blog.sql";
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

}

