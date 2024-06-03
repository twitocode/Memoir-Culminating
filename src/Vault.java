
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vault {

    public String name;
    public List<JournalFile> files;
    public JournalFile currentNote;

    public Vault(String name) {

        this.name = name;
        files = new ArrayList<JournalFile>();

        try {
            loadFiles();
        } catch (IOException ex) {
            Logger.getLogger(Vault.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadFiles() throws IOException {
        List<String> fileNames = FileManager.loadVaultFiles(name);

        for (String fileName : fileNames) {
            var journalFile = new JournalFile(fileName, FileManager.loadFileContents("Vaults/" + name + "/" + fileName));
            files.add(journalFile);
        }
    }

    public JournalFile getNoteByName(String name) {
        JournalFile file;

        for (var f : files) {
            if (f.title == name) {
                return f;
            }
        }

        return null;
    }
}
