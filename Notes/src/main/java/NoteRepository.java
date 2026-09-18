
import java.util.List;

public interface NoteRepository {

    public Note getNote(int id);
    public Note createNote(String note);

    public boolean deleteNote(int id);
    public boolean updateNote(int id, String note);

    public List<Note> getAllNotes();
}
