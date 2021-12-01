package Database;

import Util.ApplicationProperties;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.NonNull;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.Optional;


public class DataBaseController {
    private static DataBaseController controller;
    @NonNull
    private String serverUrl;
    @NonNull
    private String serverPort;
    @NonNull
    private String dataBaseName;
    @NonNull
    private String user;
    @NonNull
    private String password;

    @NonNull
    private String jdbcDriver;
    // Para manejar las conexiones y respuestas de las mismas
    @NonNull
    private Connection connection;
    @NonNull
    private PreparedStatement preparedStatement;


    private DataBaseController() {

        initConfig();
    }


    public static DataBaseController getInstance() {
        if (controller == null) {
            controller = new DataBaseController();
        }
        return controller;
    }

    private void initConfig() {
        serverUrl = "localhost";
        serverPort = "3306";
        dataBaseName = "data";
        jdbcDriver = "com.mariadb.cj.jdbc.Driver";
        user = "dani";
        password = "2002";
    }


    public void open() throws SQLException {
        //String url = "jdbc:sqlite:"+this.ruta+this.bbdd; //MySQL jdbc:mysql://localhost/prueba", "root", "1daw"
        String url = "jdbc:mariadb://" + this.serverUrl + ":" + this.serverPort + "/" + this.dataBaseName;
        // System.out.println(url);
        // Obtenemos la conexión
        connection = DriverManager.getConnection(url, user, password);
    }


    public void close() throws SQLException {
        preparedStatement.close();
        connection.close();
    }


    private ResultSet executeQuery(@NonNull String querySQL, Object... params) throws SQLException {
        preparedStatement = connection.prepareStatement(querySQL);
        // Vamos a pasarle los parametros usando preparedStatement
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeQuery();
    }


    public Optional<ResultSet> select(@NonNull String querySQL, Object... params) throws SQLException {
        return Optional.of(executeQuery(querySQL, params));
    }


    public Optional<ResultSet> select(@NonNull String querySQL, int limit, int offset, Object... params) throws SQLException {
        String query = querySQL + " LIMIT " + limit + " OFFSET " + offset;
        return Optional.of(executeQuery(query, params));
    }


    public Optional<ResultSet> insert(@NonNull String insertSQL, Object... params) throws SQLException {
        // Con return generated keys obtenemos las claves generadas is las claves es autonumerica por ejemplo
        preparedStatement = connection.prepareStatement(insertSQL, preparedStatement.RETURN_GENERATED_KEYS);
        // Vamos a pasarle los parametros usando preparedStatement
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        preparedStatement.executeUpdate();
        return Optional.of(preparedStatement.getGeneratedKeys());
    }


    public int update(@NonNull String updateSQL, Object... params) throws SQLException {
        return updateQuery(updateSQL, params);
    }


    public int delete(@NonNull String deleteSQL, Object... params) throws SQLException {
        return updateQuery(deleteSQL, params);
    }


    private int updateQuery(@NonNull String genericSQL, Object... params) throws SQLException {
        // Con return generated keys obtenemos las claves generadas
        preparedStatement = connection.prepareStatement(genericSQL);
        // Vamos a pasarle los parametros usando preparedStatement
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeUpdate();
    }

    public void initData(@NonNull String sqlFile) throws FileNotFoundException {
        ScriptRunner sr = new ScriptRunner(connection);
        Reader reader = new BufferedReader(new FileReader(sqlFile));
        sr.runScript(reader);
    }
}
