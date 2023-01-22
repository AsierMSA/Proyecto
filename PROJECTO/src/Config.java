import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties prop;

    public Config() {
        prop = new Properties();
        try {
            //carga el archivo de configuracion
            prop.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}

