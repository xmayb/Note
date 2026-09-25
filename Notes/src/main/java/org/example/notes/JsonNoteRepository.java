package org.example.notes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class JsonNoteRepository implements NoteRepository {

    private static final String FILE_PATH = "notes.json";
    private static ObjectMapper mapper = new ObjectMapper();

    private Map<Integer, Note> notes = new HashMap<>();
    private int nextId;

    private void save() {
        try {
            mapper.writeValue(new File(FILE_PATH), new ArrayList<>(notes.values()));

        }catch (IOException e) {
            throw new RuntimeException("cannot save notes to file" + e);
        }
    }

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
        return notes.get(id);
    }

    @Override
    public Note createNote(String note) {
        Note n = new Note(nextId, note);
        notes.put(nextId++, n);
        save();
        return n;
    }

    @Override
    public boolean deleteNote(int id) {
        boolean removed = notes.remove(id) != null ;
        if(removed) {
            save();
        }
        return removed;
    }

    @Override
    public boolean updateNote(int id, String note) {
        if(notes.containsKey(id)) {
            Note n = notes.get(id);
            notes.put(id, n);
            save();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Note> getAllNotes() {
        return new ArrayList<>(notes.values());
    }
}
