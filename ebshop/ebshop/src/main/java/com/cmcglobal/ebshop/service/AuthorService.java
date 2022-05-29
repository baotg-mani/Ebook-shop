package com.cmcglobal.ebshop.service;

import com.cmcglobal.ebshop.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAllAuthors();

    AuthorDTO getAuthorById(Long id);

    AuthorDTO addAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthorById(AuthorDTO authorDTO, Long id);

    void deleteAuthorById(Long id);
}
