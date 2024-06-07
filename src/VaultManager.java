/*
Toheeb Eji
June 7, 2024

This class is manaages all vault related operations
Stores what the current vault is and all the available vaults
It has operations that the vault uses.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//This class is used for managing the current vault
public class VaultManager {

    //A list for storing all loade vaults
    public static List<Vault> vaults = new ArrayList<>();

    //The current vault being viewed. This is private so no other classes can use
    private static Vault _current;

    //Finds a vault using its name and returns it
    public static Vault findVaultByName(String name) {
        for (var v : vaults) {
            if (v.name.equals(name)) {
                return v;
            }
        }

        return null;
    }

    //Sets the current vault using its name
    public static void setCurrentVaultByName(String name) {
        for (var v : vaults) {
            if (v.name.equals(name)) {
                _current = v;
                return;
            }
        }
    }

    //Sets the current vault using a vault parameter
    public static void setCurrentVault(Vault vault) {
        _current = vault;
    }

    //Adds a vault to the vaults list using its name
    public static void addVault(String name) {
        vaults.add(new Vault(name));
    }

    //Finds a note in the currentVault by name
    public static JournalNote findNoteByName(String name) {
        //Loops through all of th vaults notes and checks if
        //The name is the same as the one passed in
        for (var f : _current.notes) {
            if (f.name.equals(name)) {
                return f;
            }
        }

        return null;
    }

    //Returns the name of the current vault
    public static String getName() {
        return _current.name;
    }

    //Returns the current vault
    public static Vault get() {
        return _current;
    }

    //Returns the vault's notes
    public static List<JournalNote> getFiles() {
        return _current.notes;
    }

    //Laads the vault's notes
    public static void loadFiles() throws IOException {
        _current.loadFiles();
    }

    //Adds a file to the vault
    public static void addFile(JournalNote file) {
        _current.notes.add(file);
    }
}
