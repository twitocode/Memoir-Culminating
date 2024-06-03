
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    public void createVault(String vault) {
        try {
            new File("Vaults/" + vault.trim()).mkdirs();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
