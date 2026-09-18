import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonNoteRepository implements NoteRepository {

    private static final String FILE_PATH = "notes.json";
    private static ObjectMapper mapper = new ObjectMapper();

    private Map<Integer, Note> notes = new HashMap<>();
    private int nextId;

    public JsonNoteRepository() {
        File file = new File(FILE_PATH);
        if(file.exists()){
            try{
                List<Note> loaded = mapper.readValue(file, new TypeReference<List<Note>>() {});
                for(Note n: loaded) {
                    notes.put(n.getId(), n);
                }
            } catch(IOException e) {
                throw new RuntimeException("Cannot load notes from " + e);
            }
        }
        int maxId = 0;
        for(int key : notes.keySet()) {
            if( key > maxId) {
                maxId= key;
            }
        }
        this.nextId = maxId +1;
    }

    @Override
    public Note getNote(int id) {
        return null;
    }

    @Override
    public Note createNote(String note) {
        return null;
    }

    @Override
    public boolean deleteNote(int id) {
        return false;
    }

    @Override
    public boolean updateNote(int id, String note) {
        return false;
    }

    @Override
    public List<Note> getAllNotes() {
        return List.of();
    }
}
