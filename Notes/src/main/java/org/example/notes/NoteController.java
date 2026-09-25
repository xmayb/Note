package org.example.notes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class NoteController {
    private NoteService noteService;
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id) {
        Note getNote = noteService.getNote(id);
        if(getNote == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity.ok(getNote);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> allNotes = noteService.getAllNotes();

        return  ResponseEntity.ok(allNotes);
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> createNote(@RequestBody String noteRequest) {
        try{
            Note isCreated = noteService.createNote(noteRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(isCreated);
        }catch(IllegalArgumentException e ){
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Void> updateNote(@PathVariable int id, @RequestBody String note) {
        try{
            boolean isUpdated = noteService.updateNote(id, note);
            if(isUpdated) {
                return ResponseEntity.ok().build();
            }
        }catch(IllegalArgumentException e ) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable int id) {
        boolean isDeleted = noteService.deleteNote(id);

        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

}
