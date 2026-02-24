package edu.malaka96.repository;

import edu.malaka96.model.entity.NoteEntity;
import edu.malaka96.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> findByUser(UserEntity user);
}
