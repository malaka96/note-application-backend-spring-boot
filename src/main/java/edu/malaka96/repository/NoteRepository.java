package edu.malaka96.repository;

import edu.malaka96.model.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
}
