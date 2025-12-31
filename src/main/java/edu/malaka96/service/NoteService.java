package edu.malaka96.service;

import edu.malaka96.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {

    ArrayList<Note> noteArrayList = new ArrayList<>(Arrays.asList(new Note(0, "Java", "Java is a high-level, general-purpose, memory-safe, object-oriented programming language. It is intended to let programmers write once, run anywhere, meaning that compiled Java code can run on all platforms that support Java without the need to recompile.",false),
            new Note(1, "Flutter", "Watch flutter tutorials",false),
            new Note(2, "Devops", "complete linux fundamentals",false),
            new Note(3, "React", "note application",false),
            new Note(4, "Angular", "create your first project",true),
            new Note(5, "Spring boot", "note appication backend",false),
            new Note(6, "Spring boot1", "note appication backend",false),
            new Note(7, "Spring boot2", "note appication backend", false),
            new Note(8, "Spring boot3", "note appication backend", false),
            new Note(9, "Spring boot4", "note appication backend", false),
            new Note(10, "Spring boot5", "note appication backend", false)));

    public List<Note> getAllNotes() {
        return noteArrayList;
    }

    public Note getNote(int id){
        return noteArrayList.get(id);
    }

    public void addNote(Note note){
        noteArrayList.add(new Note(noteArrayList.size(), note.getTitle(), note.getBody(), note.isFavorite()));
    }

    public void updateNote(Note note){
        noteArrayList.set(note.getId(), note);
    }

    public void deleteNote(int id){
        noteArrayList.remove(id -1 );
    }

}
