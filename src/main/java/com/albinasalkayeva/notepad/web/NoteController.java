package com.albinasalkayeva.notepad.web;

import com.albinasalkayeva.notepad.Note;
import com.albinasalkayeva.notepad.data.NoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @ModelAttribute
    public void addNotesToModel(Model model) {
        List<Note> notes = noteRepository.findAll();
        model.addAttribute("notes", notes);
    }

    @GetMapping("/notes")
    public String notes() {
        return "notes";
    }
}
