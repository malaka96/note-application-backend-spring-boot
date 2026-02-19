package edu.malaka96.service;

import edu.malaka96.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    ArrayList<Note> noteArrayList = new ArrayList<>(Arrays.asList(new Note(0, "Java", "Java is a high-level, general-purpose, memory-safe, object-oriented programming language. It is intended to let programmers write once, run anywhere, meaning that compiled Java code can run on all platforms that support Java without the need to recompile.",false),
            new Note(1, "Flutter", "Flutter transforms the entire app development process. Build, test, and deploy beautiful mobile, web, desktop, and embedded apps from a single codebase.",false),
            new Note(2, "Devops", "DevOps is a culture, set of practices, and tools that merge software development (Dev) and IT operations (Ops) to shorten the systems development life cycle, providing continuous delivery with high software quality, by focusing on collaboration, automation, and rapid feedback to deliver value faster and more reliably",false),
            new Note(3, "React", "React lets you build user interfaces out of individual pieces called components. Create your own React components like Thumbnail, LikeButton, and Video.",false),
            new Note(4, "Angular", "Angular is a TypeScript-based free and open-source single-page web application framework. It is developed by Google and by a community of individuals and corporations.",true),
            new Note(5, "Spring boot", "Spring Boot is an open-source Java framework used for programming standalone, production-grade Spring-based applications with a bundle of libraries that make project startup and management easier.",false)
            ));

    public List<Note> getAllNotes() {
        return noteArrayList;
    }

    public Optional<Note> getNote(int id){
        return noteArrayList.stream().filter(n -> n.getId() == id).findFirst();
    }

    public void addNote(Note note){
        noteArrayList.add(new Note(noteArrayList.size(), note.getTitle(), note.getBody(), note.getIsFavorite()));
    }

    public void updateNote(Note note){
        noteArrayList.set(note.getId(), note);
    }

    public void deleteNote(int id){
        noteArrayList.remove(id );
    }

}
