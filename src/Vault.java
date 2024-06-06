
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//A class used for storing data about vaults
public class Vault {

    //The name of the vault
    public String name;

    //All the journal files in the vault
    public List<JournalFile> files;

    //The current journal note being viewed
    public JournalFile currentNote;

    public Vault(String name) {

        this.name = name;
        files = new ArrayList<JournalFile>();

        try {
            loadFiles();
        } catch (IOException ex) {
        }
    }

    //Loads the journal files for this vault
    public void loadFiles() throws IOException {
        //Loads the files' names
        List<String> fileNames = FileManager.loadVaultFiles(name);

        //Removes all the current files that are in the list
        files.removeAll(files);

        //For every fileName in the list returned
        for (String fileName : fileNames) {
            //Create a new JournalFile instance and, passing in this vault
            var journalFile = new JournalFile(fileName, FileManager.loadFileContents("Vaults/" + name + "/" + fileName), this);

            //Add the JournalFile to the list
            files.add(journalFile);
        }
    }
}
