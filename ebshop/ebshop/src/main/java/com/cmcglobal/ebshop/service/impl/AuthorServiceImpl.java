package com.cmcglobal.ebshop.service.impl;

import com.cmcglobal.ebshop.dto.AuthorDTO;
import com.cmcglobal.ebshop.dto.mapper.AuthorMapper;
import com.cmcglobal.ebshop.entity.Author;
import com.cmcglobal.ebshop.entity.Ebook;
import com.cmcglobal.ebshop.exception.NotFoundException;
import com.cmcglobal.ebshop.repository.AuthorRepository;
import com.cmcglobal.ebshop.repository.EbookRepository;
import com.cmcglobal.ebshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper mapper;
    private final EbookRepository ebookRepository;

    @Autowired
    private AuthorServiceImpl(AuthorMapper mapper
            , AuthorRepository authorRepository
            , EbookRepository ebookRepository) {
        this.mapper = mapper;
        this.authorRepository = authorRepository;
        this.ebookRepository = ebookRepository;
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    /*
    Xem thông tin của tác giả
    Trả về thông tin của tác giả theo mã tác giả.
    Ngoài các thông tin cơ bản của tác giả, cần trả về thêm:
    Số lượng đầu sách của tác giả đó trong hệ thống.
    Danh sách 3 đầu sách bán chạy nhất của tác giả đó.
    Nếu mã tác giả không tồn tại, hệ thống cần thông báo lỗi.
    */
    @Override
    public AuthorDTO getAuthorById(Long id) {
        Optional<Author> opAuthor = authorRepository.findById(id);
        if(opAuthor.isPresent()) {
            return mapper.toDto(opAuthor.get());
        }
        throw new NotFoundException("Author id: " + id + " not found!");
    }

    @Override
    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        authorRepository.save(mapper.toAuthor(authorDTO));
        return authorDTO;
    }

    @Override
    public AuthorDTO updateAuthorById(AuthorDTO authorDTO, Long id) {
        Optional<Author> opAuthor = authorRepository.findById(id);
        if(opAuthor.isPresent()) {
            authorRepository.save(mapper.toAuthor(authorDTO));
            return authorDTO;
        }
        throw new NotFoundException("Author id: " + id + " not found!");
    }

    /*
    Xóa tác giả khỏi hệ thống theo mã tác giả
    Nếu mã tác giả không tồn tại, hệ thống cần thông báo lỗi.
    Nếu vẫn còn sách của tác giả đó trong hệ thống thì không cho phép xóa tác giả.
    */
    @Override
    public void deleteAuthorById(Long id) {
        Optional<Author> opAuthor = authorRepository.findById(id);
        if(opAuthor.isPresent()) {
            List<Ebook> listEbooks = ebookRepository.findByAuthorId(id);
            if(listEbooks.isEmpty()){
                authorRepository.deleteById(id);
            }
        }
        throw new NotFoundException("Author id: " + id
                + " not found OR ebooks store of this author is not empty.");
    }
}
