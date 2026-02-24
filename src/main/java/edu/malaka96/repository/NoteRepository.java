package edu.malaka96.repository;

import edu.malaka96.model.entity.NoteEntity;
import edu.malaka96.model.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> findByUser(UserEntity user);
    Optional<NoteEntity> findByIdAndUserEmail(Long id, String email);
    List<NoteEntity> findByUserEmailAndIsFavoriteTrue(String email);
    void deleteByIdAndUserEmail(Long id, String email);
}
