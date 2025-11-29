package edu.malaka96.controller;

import edu.malaka96.model.Note;
import edu.malaka96.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoteController {

    final NoteService service;

    @GetMapping()
    public List<Note> getAllNotes(){
        return service.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getNote(@PathVariable int id){
        return service.getNote(id);
    }

    @PostMapping("/add")
    public void addNote(@RequestBody Note note){
        service.addNote(note);
    }

    @PutMapping("/update")
    public void updateNote(@RequestBody Note note){
        service.updateNote(note);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable int id){
        service.deleteNote(id);
    }

}
