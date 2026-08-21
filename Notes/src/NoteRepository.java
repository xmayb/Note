import java.util.List;

public interface NoteRepository {

    public int getNote(int id, List<Note> notes);

    public int deleteNote(int id);

    public String updateNote(int id, String text);

    public String createNote(String text);
}
