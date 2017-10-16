package ro.siit.aut.gr4.exam.test.functional;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public class BaseTest {
    static WebDriver driver;



    File[] getListOfFiles(String directoryName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL path = classLoader.getResource(directoryName);
        String configPath = null;

        try {
            assert path != null;
            configPath = URLDecoder.decode(path.getFile(), "UTF-8");
            System.out.println(configPath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        assert configPath != null;
        File directory = new File(configPath);

        File[] files = directory.listFiles();
        assert files != null;
        System.out.println("Found " + files.length + " files in " + directoryName + " folder");
        return files;
    }
}
