package com.cmcglobal.ebshop.controller;

import com.cmcglobal.ebshop.dto.EbookDTO;
import com.cmcglobal.ebshop.dto.EbookDTO;
import com.cmcglobal.ebshop.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    private EbookService ebookService;

    @Autowired
    public EbookController(EbookService ebookService) {
        this.ebookService = ebookService;
    }

    @GetMapping
    public ResponseEntity<List<EbookDTO>> getAllEbooks() {
        List<EbookDTO> ebooksRes = ebookService.getAllEbooks();
        return ResponseEntity.ok(ebooksRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EbookDTO> getEbookById(@PathVariable long id) {
        EbookDTO ebookRes = ebookService.getEbookById(id);
        return ResponseEntity.ok(ebookRes);
    }

    @PostMapping
    public ResponseEntity<EbookDTO> createEbook(@Valid @RequestBody EbookDTO ebookDTO) {
        EbookDTO ebookRes = ebookService.addEbook(ebookDTO);
        return ResponseEntity.ok(ebookRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EbookDTO> updateEbook(@Valid @RequestBody EbookDTO ebookDTO, @PathVariable long id) {
        EbookDTO ebookRes = ebookService.updateEbookById(ebookDTO, id);
        return ResponseEntity.ok(ebookRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEbook(@PathVariable long id) {
        // soft delete
        ebookService.deleteEbookById(id);
        return ResponseEntity.ok("Delete success!");
    }
}
