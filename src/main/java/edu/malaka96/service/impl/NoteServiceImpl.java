package edu.malaka96.service.impl;

import edu.malaka96.model.dto.NoteRequest;
import edu.malaka96.model.dto.NoteResponse;
import edu.malaka96.model.entity.NoteEntity;
import edu.malaka96.model.entity.UserEntity;
import edu.malaka96.repository.NoteRepository;
import edu.malaka96.repository.UserRepository;
import edu.malaka96.service.NoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NoteServiceImpl implements NoteService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    @Override
    public NoteResponse addNote(String email, NoteRequest noteRequest) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isEmpty())
            throw new UsernameNotFoundException("User is not found");

        NoteEntity note = NoteEntity.builder()
                .user(user.get())
                .title(noteRequest.getTitle())
                .body(noteRequest.getBody())
                .isFavorite(false)
                .build();

        return maptoNoteResponse(noteRepository.save(note));

    }

    @Override
    public List<NoteResponse> getAllNotes(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        return user.map(userEntity -> noteRepository.findByUser(userEntity).stream()
                .map(this::maptoNoteResponse)
                .toList()).orElseGet(List::of);

    }

    @Override
    public void updateNote(String email, Long id, NoteRequest noteRequest) {

        NoteEntity existingNote = noteRepository
                .findByIdAndUserEmail(id, email)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        existingNote.setTitle(noteRequest.getTitle());
        existingNote.setBody(noteRequest.getBody());
        existingNote.setIsFavorite(noteRequest.getIsFavorite());

        noteRepository.save(existingNote);
    }

    @Override
    public List<NoteResponse> getAllFavoriteNotes(String email) {
        return noteRepository.findByUserEmailAndIsFavoriteTrue(email).stream()
                .map(this::maptoNoteResponse)
                .toList();
    }

    @Override
    public void updateNoteFavoriteState(String email, Long id, Boolean newState) {
        NoteEntity existingNote = noteRepository
                .findByIdAndUserEmail(id, email)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        existingNote.setIsFavorite(newState);
        noteRepository.save(existingNote);
    }

    @Override
    public void deleteNote(String email, Long id) {
        noteRepository.deleteByIdAndUserEmail(id,email);
    }

    private NoteResponse maptoNoteResponse(NoteEntity noteEntity){
        return NoteResponse.builder()
                .id(noteEntity.getId())
                .userEmail(noteEntity.getUser().getEmail())
                .title(noteEntity.getTitle())
                .body(noteEntity.getBody())
                .isFavorite(noteEntity.getIsFavorite())
                .build();
    }
}
