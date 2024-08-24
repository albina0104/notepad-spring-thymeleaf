package com.albinasalkayeva.notepad.data;

import com.albinasalkayeva.notepad.Note;
import org.springframework.data.repository.ListCrudRepository;

public interface NoteRepository extends ListCrudRepository<Note, Long> {
}
