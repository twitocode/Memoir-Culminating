
import java.util.List;

public class JournalFile {

    public String title;
    public List<String> contents;

    public JournalFile(String title, List<String> contents) {
        this.title = title;
        this.contents = contents;
    }

    public JournalFile() {
    }
}
