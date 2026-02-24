package edu.malaka96.service.impl;

import edu.malaka96.model.dto.NoteRequest;
import edu.malaka96.model.entity.NoteEntity;
import edu.malaka96.model.entity.UserEntity;
import edu.malaka96.repository.NoteRepository;
import edu.malaka96.repository.UserRepository;
import edu.malaka96.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    @Override
    public void addNote(String email, NoteRequest noteRequest) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isEmpty())
            throw new UsernameNotFoundException("User is not found");

        NoteEntity note = NoteEntity.builder()
                .user(user.get())
                .title(noteRequest.getTitle())
                .body(noteRequest.getBody())
                .isFavorite(false)
                .build();

        noteRepository.save(note);

    }
}
