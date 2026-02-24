package edu.malaka96.controller;

import edu.malaka96.model.Note;
import edu.malaka96.model.dto.NoteRequest;
import edu.malaka96.model.dto.NoteResponse;
import edu.malaka96.service.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/note")
public class NoteController {

    final NoteService service;

    @GetMapping("/session-id")
    public String getSessionId(HttpServletRequest request) {
        return "yello user, : " + request.getSession().getId();
    }


    @PostMapping("/add")
    public ResponseEntity<?> addNote(
            @CurrentSecurityContext(expression = "authentication?.name") String email,
            @RequestBody NoteRequest noteRequest) {
        try {
            service.addNote(email, noteRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Note created successfully");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot create note");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(@CurrentSecurityContext(expression = "authentication?.name") String email) {
        return ResponseEntity.ok(service.getAllNotes(email));
    }

    @GetMapping("/all/favorite")
    public ResponseEntity<?> getAllFavorites(
            @CurrentSecurityContext(expression = "authentication?.name") String email
    ) {
        return ResponseEntity.ok(service.getAllFavoriteNotes(email));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(
            @CurrentSecurityContext(expression = "authentication?.name") String email,
            @RequestParam Long id,
            @RequestBody NoteRequest noteRequest) {
        try {
            service.updateNote(email, id, noteRequest);
            return ResponseEntity.ok("Note updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
