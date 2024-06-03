
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileManager {

    public static void createVault(String vault) {
        try {
            new File("Vaults/" + vault.trim()).mkdirs();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<String> loadVaults() {
        try {
            var directoryPath = new File("Vaults");
            return Arrays.asList(directoryPath.list());
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<String>();
        }
    }

    public static List<String> loadVaultFiles(String vault) {
        try {
            var directoryPath = new File("Vaults/" + vault);
            return Arrays.asList(directoryPath.list());
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<String>();
        }
    }

    public static List<String> loadFileContents(String fileName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        var list = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line + "\n");
        }

        return list;
    }
}
