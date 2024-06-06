
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileManager {

    public static void createVault(String vault) {
        try {
            new File("Vaults/" + vault.trim()).mkdirs();
            VaultManager.current = new Vault(vault);
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
            File[] files = directoryPath.listFiles();

            //Sorts the List<Files> by the last modified date
            Arrays.sort(files, Comparator.comparingLong(File::lastModified));

            //Converts the array into a list, then runs a map function to convert the List<Files> into a List<String> using the file name as the element
            return Arrays.asList(files)
                    .stream()
                    .map(e -> e.getName())
                    .collect(Collectors.toList())
                    .reversed();

        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<String>();
        }
    }

    public static List<String> loadFileContents(String fileName) throws FileNotFoundException, IOException {
        ArrayList<String> list;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            list = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line + "\n");
            }
        }

        return list;
    }

    public static void saveFile(JournalFile file) throws IOException {
        String vaultName = VaultManager.current.name;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Vaults/" + vaultName + "/" + file.name))) {
            for (String line : file.contents) {
                writer.write(line);
            }
        }
    }

    public static void deleteFile(JournalFile file) {
        try {
            String vaultName = VaultManager.current.name;
            new File("Vaults/" + vaultName + "/" + file.name).delete();

            VaultManager.current.loadFiles();
        } catch (IOException ex) {
        }
    }

    public static JournalFile createFile(String fileName) {
        try {
            String vaultName = VaultManager.current.name;
            new File("Vaults/" + vaultName + "/" + fileName.trim()).createNewFile();

            var file = new JournalFile(fileName, new ArrayList<String>(), VaultManager.current);
            VaultManager.current.files.add(file);

            return file;
        } catch (IOException ex) {
            return null;
        }
    }

    public static List<JournalFile> searchAllFiles(String query) throws IOException {
        var results = new ArrayList<JournalFile>();
        var directoryPath = new File("Vaults");
        File[] vaultPaths = directoryPath.listFiles();

        for (File vaultPath : vaultPaths) {
            List<File> files = Arrays.asList(vaultPath.listFiles());

            if (files.isEmpty()) {
                continue;
            }

            files = files.stream().filter(file -> {
                return file.getName().toLowerCase().contains(query.toLowerCase());
            }).collect(Collectors.toList());

            Vault vault = VaultManager.findVault(vaultPath.getName());

            if (vault == null) {
                continue;
            }

            for (File result : files) {

                List<String> fileContents = loadFileContents("Vaults/" + vault.name + "/" + result.getName());
                var searchResult = new JournalFile(result.getName(), fileContents, vault);
                results.add(searchResult);

            }
        }

        return results;
    }
}
