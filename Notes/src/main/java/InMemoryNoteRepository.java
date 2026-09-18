

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryNoteRepository implements NoteRepository {

    private Map<Integer, Note> notes = new HashMap<>();
    private int nextId = 1;
    @Override
    public Note getNote(int id) {
        return notes.get(id);
    }

    @Override
    public Note createNote(String note) {
        Note n = new Note(nextId, note);
        notes.put(nextId++, n);
        return n;

    }

    @Override
    public boolean deleteNote(int id) {
        return notes.remove(id) != null;
    }

    @Override
    public boolean updateNote(int id, String note) {
        if(notes.containsKey(id)){
            Note n = new Note(id, note);
            notes.put(id, n);
        }else{
            return false;
        }
        return true;
    }

    @Override
    public List<Note> getAllNotes() {
        return new ArrayList<>(notes.values());
    }
}
