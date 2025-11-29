package edu.malaka96.service;

import edu.malaka96.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {

    ArrayList<Note> noteArrayList = new ArrayList<>(Arrays.asList(new Note(1, "Java", "Complete java project"),
            new Note(2, "Flutter", "Watch flutter tutorials"),
            new Note(3, "Devops", "complete linux fundamentals")));

    public List<Note> getAllNotes() {
        return noteArrayList;
    }

    public Note getNote(int id){
        return noteArrayList.get(id);
    }

    public void addNote(Note note){
        noteArrayList.add(note);
    }

    public void updateNote(Note note){
        noteArrayList.set(note.getId() - 1, note);
    }

    public void deleteNote(int id){
        noteArrayList.remove(id -1 );
    }

}
