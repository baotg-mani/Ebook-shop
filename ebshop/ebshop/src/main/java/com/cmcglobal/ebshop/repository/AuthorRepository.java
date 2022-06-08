package com.cmcglobal.ebshop.repository;

import com.cmcglobal.ebshop.entity.Author;
import com.cmcglobal.ebshop.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT e.title, e.author_id, COUNT(ed.quantity) AS total_quantity" +
            "FROM ebooks e " +
            "JOIN order_details od ON e.id=ed.ebook_id " +
            "WHERE e.author_id LIKE :authorId" +
            "GROUP BY e.title" +
            "ORDER BY total_quantity DESC " +
            "LIMIT 3",nativeQuery = true)
    List<Ebook> findListTop3Titles(@Param("authorId") Long authorId);

}
