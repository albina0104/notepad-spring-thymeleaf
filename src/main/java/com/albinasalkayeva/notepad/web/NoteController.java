package com.albinasalkayeva.notepad.web;

import com.albinasalkayeva.notepad.Note;
import com.albinasalkayeva.notepad.data.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @ModelAttribute(name = "note")
    public Note note() {
        return new Note();
    }

    @ModelAttribute
    public void addNotesToModel(Model model) {
        List<Note> notes = noteRepository.findAll();
        model.addAttribute("notes", notes);
    }

    @GetMapping
    public String notes() {
        return "notes";
    }

    @PostMapping("/create")
    public String createNote(Note note) {
        log.trace("Note is about to be saved: {}", note);
        noteRepository.save(note);
        log.debug("Note saved: {}", note);
        return "redirect:/notes";
    }
}
