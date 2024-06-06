
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VaultManager {

    public static List<Vault> vaults = new ArrayList<Vault>();
    private static Vault _current;

    public static Vault findVaultByName(String name) {
        for (var v : vaults) {
            if (v.name.equals(name)) {
                return v;
            }
        }

        return null;
    }

    public static void setCurrentVaultByName(String name) {
        for (var v : vaults) {
            if (v.name.equals(name)) {
                _current = v;
                return;
            }
        }
    }

    public static void setCurrentVault(Vault vault) {
        _current = vault;
    }

    public static void addVault(String name) {
        vaults.add(new Vault(name));
    }

    public static JournalFile findNoteByName(String name) {
        for (var f : _current.files) {
            if (f.name.equals(name)) {
                return f;
            }
        }

        return null;
    }

    public static String getName() {
        return _current.name;
    }

    public static Vault get() {
        return _current;
    }

    public static List<JournalFile> getFiles() {
        return _current.files;
    }

    public static void loadFiles() throws IOException {
        _current.loadFiles();
    }

    public static void addFile(JournalFile file) {
        _current.files.add(file);
    }
}
