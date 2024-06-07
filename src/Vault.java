/*
Toheeb Eji
June 7, 2024

This class is stores what a Vault is, and loads its notes.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//A class used for storing data about vaults
public class Vault {

    //The name of the vault
    public String name;

    //All the journal notes in the vault
    public List<JournalNote> notes;

    public Vault(String name) {

        this.name = name;
        notes = new ArrayList<JournalNote>();

        try {
            loadFiles();
        } catch (IOException ex) {
        }
    }

    //Loads the journal notes for this vault
    public void loadFiles() throws IOException {
        //Loads the notes' names
        List<String> fileNames = FileManager.loadVaultFileNames(name);

        //Removes all the current notes that are in the list
        notes.removeAll(notes);

        //For every fileName in the list returned
        for (String fileName : fileNames) {
            //Create a new JournalNote instance and, passing in this vault
            var journalFile = new JournalNote(fileName, FileManager.loadFileContents("Vaults/" + name + "/" + fileName), this);

            //Add the JournalNote to the list
            notes.add(journalFile);
        }
    }
}
