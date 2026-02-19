package edu.malaka96.controller;

import edu.malaka96.model.Note;
import edu.malaka96.service.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class NoteController {

    final NoteService service;

    @GetMapping("/session-id")
    public String getSessionId(HttpServletRequest request){
        return "yello user, : "+request.getSession().getId();
    }

    @GetMapping("/note/all")
    public List<Note> getAllNotes() {
        return service.getAllNotes();
    }

    @GetMapping("/{id}")
    public Optional<Note> getNote(@PathVariable int id) {
        return service.getNote(id);
    }

    @PostMapping("/add")
    public void addNote(@RequestBody Note note) {
        service.addNote(note);
    }

    @PutMapping("/update")
    public void updateNote(@RequestBody Note note) {
        System.out.println(note);
        service.updateNote(note);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable int id) {
        service.deleteNote(id);
    }

}
