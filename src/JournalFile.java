
import java.util.List;

//This file is used for representing a Journal note that the user can interact with
public class JournalFile {

    //Journal's name
    public String name;

    //All the text the user typed in
    //Each line is an element in the list
    public List<String> contents;

    //The vault that the journal belongs to
    public Vault vault;

    //Simple constructor for setting up the class
    public JournalFile(String title, List<String> contents) {
        this.name = title;
        this.contents = contents;
    }

    //Simple constructor for setting up the class, except this also sets the vault
    public JournalFile(String title, List<String> contents, Vault vault) {
        this.vault = vault;
        this.name = title;
        this.contents = contents;
    }

    //Default constructor
    public JournalFile() {
    }
}
