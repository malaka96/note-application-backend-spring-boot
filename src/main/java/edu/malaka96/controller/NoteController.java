package edu.malaka96.controller;

import edu.malaka96.model.Note;
import edu.malaka96.model.dto.NoteRequest;
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
    public String getSessionId(HttpServletRequest request){
        return "yello user, : "+request.getSession().getId();
    }


    @PostMapping("/add")
    public ResponseEntity<?> addNote(
            @CurrentSecurityContext(expression = "authentication?.name") String email,
            @RequestBody NoteRequest noteRequest) {
        try{
            service.addNote(email,noteRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Note created successfully");
        }catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot create note");
        }
    }

}
