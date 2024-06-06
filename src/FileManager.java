
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
import java.util.stream.Collectors;

//This class manaages any file related operations
public class FileManager {

    //Creates a vault with the specified name in the "Vaults" folder
    public static void createVault(String name) {
        new File("Vaults/" + name.trim()).mkdirs();
    }

    //Finds the names of all the vaults in the "Vaults" folder and sorts them by last modified
    public static List<String> loadVaults() {

        var directoryPath = new File("Vaults");

        //Gets the name of all the vaults
        File[] files = directoryPath.listFiles();

        //Sorts the List<Files> by the last modified date
        Arrays.sort(files, Comparator.comparingLong(File::lastModified));

        //Converts the array into a list, then runs a map function to convert the List<Files> into a List<String> using the file name as the element
        //Returns it in a reveresd order so that it is (modified recently = first result)
        return Arrays.asList(files)
                .stream()
                .map(e -> e.getName())
                .collect(Collectors.toList())
                .reversed();
    }

    //Loads all of the files of a vault given the vault name
    public static List<String> loadVaultFiles(String vaultName) {
        var directoryPath = new File("Vaults/" + vaultName);

        //Lists all of the files in the vault's folder.
        File[] files = directoryPath.listFiles();

        //Sorts the List<Files> by the last modified date
        Arrays.sort(files, Comparator.comparingLong(File::lastModified));

        //Converts the array into a list, then runs a map function to convert the List<Files> into a List<String> using the file name as the element
        return Arrays.asList(files)
                .stream()
                .map(e -> e.getName())
                .collect(Collectors.toList())
                .reversed();

    }

    //Reads the file with the given name and returns a list of each line in the file
    public static List<String> loadFileContents(String fileName) throws FileNotFoundException, IOException {
        //stores the result
        ArrayList<String> list = new ArrayList<String>();

        //Creates a new file reader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            //Stores the current line
            String line;

            //Keep running as long as the current the reader reads a line
            while ((line = reader.readLine()) != null) {
                //Add the line to the list and add a "new line" character for displaying purposes.
                list.add(line + "\n");
            }
        }

        return list;
    }

    //Saves a file give a JournalFile instance
    public static void saveFile(JournalFile file) throws IOException {
        //Creates a new file writer.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Vaults/" + file.vault.name + "/" + file.name))) {
            //For every line in the notes contents, write that line to the file
            for (String line : file.contents) {
                writer.write(line);
            }
        }
    }

    //Deletes the file with the given JournalFile instance
    public static void deleteFile(JournalFile file) throws IOException {
        new File("Vaults/" + file.vault.name + "/" + file.name).delete();
    }

    //Creates a file with a given name
    public static JournalFile createFile(String fileName) throws IOException {
        //Gets the current vault's name
        String vaultName = VaultManager.getName();

        //Creates a new file in the vault's folder with the givene name
        new File("Vaults/" + vaultName + "/" + fileName.trim()).createNewFile();

        //returns a new JournalFile instance for use.
        return new JournalFile(fileName, new ArrayList<String>(), VaultManager.get());
    }

    //There is probably i nicer way to do this
    //This searches every vault for files that have a name that contains the query
    public static List<JournalFile> searchAllFiles(String query) throws IOException {
        //Stores the search results
        var results = new ArrayList<JournalFile>();

        var directoryPath = new File("Vaults");
        //Gets every vault in the "Vaults" folder
        File[] vaultFolders = directoryPath.listFiles();

        //Loops through every vault
        for (File vaultPath : vaultFolders) {
            //Gets every file in the folder, then it converts the array into a list
            List<File> files = Arrays.asList(vaultPath.listFiles());

            //If the list is empty, then continue with the next vault folder
            if (files.isEmpty()) {
                continue;
            }

            //Finds the Vault instance that is assocaited with the vault folder
            Vault vault = VaultManager.findVaultByName(vaultPath.getName());

            //If the Vault instance does not exist, then continue with the next one 
            if (vault == null) {
                continue;
            }

            //This filters throug the list to see which files have a name that contains the search query.
            //It is case-insensitive
            files = files
                    .stream()
                    .filter(file -> {
                        return file.getName().toLowerCase().contains(query.toLowerCase());
                    })
                    .collect(Collectors.toList());

            //Loops through every file that meets the criteria in the vault
            for (File result : files) {
                //Loads the file contents and stores it in a list of strings
                List<String> fileContents = loadFileContents("Vaults/" + vault.name + "/" + result.getName());

                //Creates a new JournalFile instance with the file content and the vault it belongs to
                var searchResult = new JournalFile(result.getName(), fileContents, vault);

                //Adds the search result ot the list of results
                results.add(searchResult);

            }
        }

        return results;
    }
}
