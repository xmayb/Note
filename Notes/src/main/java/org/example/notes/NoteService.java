package org.example.notes;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService {
    private final NoteRepository repository;

    public NoteService(NoteRepository repository){
        this.repository = repository;

    }
    public Note createNote(String note){

        if(note == null || note.isBlank() ) {
            throw new IllegalArgumentException("Note cannot be null or blank");
        }
        return repository.createNote(note);
    }

    public Note getNote(int id){
        return repository.getNote(id);
    }

    public boolean deleteNote(int id){
        return repository.deleteNote(id);
    }

    public List<Note> getAllNotes(){
        return repository.getAllNotes();
    }

    public boolean updateNote(int id, String note){
        if(note == null || note.isBlank()) {
            throw new IllegalArgumentException("Note cannot be null or blank");
        }
        return repository.updateNote(id, note);
    }
}
