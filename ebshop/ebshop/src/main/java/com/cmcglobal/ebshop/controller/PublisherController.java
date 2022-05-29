package com.cmcglobal.ebshop.controller;

import com.cmcglobal.ebshop.dto.PublisherDTO;
import com.cmcglobal.ebshop.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping
    public ResponseEntity<PublisherDTO> getAllPublishers() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher(@Valid @RequestBody PublisherDTO publisherDTO) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherDTO> updatePublisherById(@Valid @RequestBody PublisherDTO publisherDTO, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PublisherDTO> deletePublisher(@PathVariable long id) {
        return null;
    }
}
