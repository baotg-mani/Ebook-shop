package com.cmcglobal.ebshop.repository;

import com.cmcglobal.ebshop.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {
    List<Ebook> findByAuthorId(Long id);

    List<Ebook> findByPublisherId(Long id);

    Ebook findByIsbn(String isbn);

    @Query(value = "SELECT e.title, COUNT(od.quantity) as total FROM ebooks e JOIN order_details od ON od.ebook_id = o.id WHERE e.publisher_id LIKE :publisher_id GROUP BY e.title ORDER BY total DESC LIMIT 5", nativeQuery = true)
    List<Ebook> findTop5TitleBestSeller(@Param("publisher_id") Long publisherId);
}
