package com.cmcglobal.ebshop.controller;

import com.cmcglobal.ebshop.dto.PublisherDTO;
import com.cmcglobal.ebshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {
        List<PublisherDTO> publishersRes = publisherService.getAllPublishers();
        return ResponseEntity.ok(publishersRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable long id) {
        PublisherDTO publisherRes = publisherService.getPublisherById(id);
        return ResponseEntity.ok(publisherRes);
    }

    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher(@Valid @RequestBody PublisherDTO publisherDTO) {
        PublisherDTO publisherRes = publisherService.addPublisher(publisherDTO);
        return ResponseEntity.ok(publisherRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherDTO> updatePublisherById(@Valid @RequestBody PublisherDTO publisherDTO, @PathVariable long id) {
        PublisherDTO publisherRes = publisherService.updatePublisherById(publisherDTO, id);
        return ResponseEntity.ok(publisherRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable long id) {
        publisherService.deletePublisherById(id);
        return ResponseEntity.ok("delete success!");
    }
}
