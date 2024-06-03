
import java.util.ArrayList;
import java.util.List;

public class Vault {

    public String name;
    public List<JournalFile> files = new ArrayList<JournalFile>();

    public Vault(String name) {

        this.name = name;
    }

    public void loadFiles() {
        List<String> fileNames = FileManager.loadVaultFiles(name);

        for (int i = 0; i < fileNames.size(); i++) {
            files.add(new JournalFile(fileNames[i], FileManager.loadFileContents("Vaults/" + name + fileNames[i])));
        }

    }
}
