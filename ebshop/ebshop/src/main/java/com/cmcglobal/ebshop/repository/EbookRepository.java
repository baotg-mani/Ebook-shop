package com.cmcglobal.ebshop.repository;

import com.cmcglobal.ebshop.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {
    List<Ebook> findByAuthorId(Long id);

    Ebook findByIsbn(String isbn);
}
