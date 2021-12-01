import Util.ApplicationProperties;

public class App {
    public static void main(String[] args) {
        ApplicationProperties properties = new ApplicationProperties();
        System.out.println("Bienvenid@s a " +
                properties.readProperty("app.title") + " "
                + properties.readProperty("app.version") + " de " +
                properties.readProperty("app.curso"));

        Data blog = Data.getInstance();
        // Chequeamos el sistema
        blog.checkService();

        // Iniciamos la base de datos al estado original en cada prueba
        if (properties.readProperty("database.init").equals("true"))
            blog.initDataBase();

    }
}
