package com.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Notes;
import com.inventory.repository.NotesRepository;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NotesRepository notesRepository;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome.jsp";
	}

	@GetMapping("/notes")
	public List<Notes> getAllNotes() {
		return notesRepository.findAll();
	}

	@PostMapping("/notes")
	public Notes createNote(@Valid @RequestBody Notes notes) {
		return notesRepository.save(notes);
	}

	@GetMapping("/notes/{id}")
	public ResponseEntity<Notes> getNoteById(@PathVariable(value = "id") Long noteId) {
		Notes notes = notesRepository.findOne(noteId);
		if (notes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(notes);
	}

	@PutMapping("/notes/{id}")
	public ResponseEntity<Notes> updateNote(@PathVariable(value = "id") Long noteId,
			@Valid @RequestBody Notes noteDetails) {
		Notes notes = notesRepository.findOne(noteId);
		if (notes == null) {
			return ResponseEntity.notFound().build();
		}
		notes.setTitle(noteDetails.getTitle());
		notes.setContent(noteDetails.getContent());

		Notes updatedNotes = notesRepository.save(notes);
		return ResponseEntity.ok(updatedNotes);
	}

	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Notes> deleteNote(@PathVariable(value = "id") Long noteId) {
		Notes notes = notesRepository.findOne(noteId);
		if (notes == null) {
			return ResponseEntity.notFound().build();
		}

		notesRepository.delete(notes);
		return ResponseEntity.ok().build();
	}
}
