package com.cmcglobal.ebshop.controller;

import com.cmcglobal.ebshop.dto.AuthorDTO;
import com.cmcglobal.ebshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<AuthorDTO> authorsRes = authorService.getAllAuthors();
        return ResponseEntity.ok(authorsRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable long id) {
        AuthorDTO authorRes = authorService.getAuthorById(id);
        return ResponseEntity.ok(authorRes);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        AuthorDTO authorRes = authorService.addAuthor(authorDTO);
        return ResponseEntity.ok(authorRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthorById(@Valid @RequestBody AuthorDTO authorDTO, @PathVariable long id) {
        AuthorDTO authorRes = authorService.updateAuthorById(authorDTO, id);
        return ResponseEntity.ok(authorRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok("Delete success!");
    }
}
