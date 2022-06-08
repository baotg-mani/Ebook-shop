package com.cmcglobal.ebshop.dto.mapper;

import com.cmcglobal.ebshop.dto.AuthorDTO;
import com.cmcglobal.ebshop.entity.Author;
import com.cmcglobal.ebshop.entity.Ebook;
import com.cmcglobal.ebshop.repository.AuthorRepository;
import com.cmcglobal.ebshop.repository.EbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {
    private EbookRepository ebookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorMapper(EbookRepository ebookRepository, AuthorRepository authorRepository) {
        this.ebookRepository = ebookRepository;
        this.authorRepository = authorRepository;
    }

    public AuthorDTO toDto(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setFirstname(author.getFirstname());
        authorDTO.setLastname(author.getLastname());
        authorDTO.setNumOfTitles(author.getYearOfBirth());
        authorDTO.setWebsite(author.getWebsite());
        authorDTO.setDescription(author.getDescription());

        authorDTO.setNumOfTitles(ebookRepository
                .findAllById(Collections.singleton(author.getId()))
                .size());
        authorDTO.setListTop3Titles(authorRepository
                .findListTop3Titles(author.getId())
                .stream()
                .map(Ebook::getTitle)
                .collect(Collectors.toList()));
        return authorDTO;
    }

    public Author toAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstname(authorDTO.getFirstname());
        author.setLastname(authorDTO.getLastname());
        author.setYearOfBirth(authorDTO.getYearOfBirth());
        author.setWebsite(authorDTO.getWebsite());
        author.setDescription(authorDTO.getDescription());
        author.setDescription(authorDTO.getDescription());
        author.setEbooks(authorDTO.getEbooks());

        return author;
    }
}
