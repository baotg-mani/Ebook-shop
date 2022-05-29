package com.cmcglobal.ebshop.service.impl;

import com.cmcglobal.ebshop.dto.EbookDTO;
import com.cmcglobal.ebshop.dto.mapper.EbookMapper;
import com.cmcglobal.ebshop.entity.Ebook;
import com.cmcglobal.ebshop.exception.NotFoundException;
import com.cmcglobal.ebshop.repository.EbookRepository;
import com.cmcglobal.ebshop.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EbookServiceImpl implements EbookService {
    private final EbookRepository ebookRepository;
    private final EbookMapper ebookMapper;

    @Autowired
    public EbookServiceImpl(EbookRepository ebookRepository, EbookMapper ebookMapper) {
        this.ebookRepository = ebookRepository;
        this.ebookMapper = ebookMapper;
    }

    @Override
    public List<EbookDTO> getAllEbooks() {
        return ebookRepository
                .findAll()
                .stream()
                .map(ebookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EbookDTO getEbookById(long id) {
        return ebookMapper.toDto(ebookRepository.findById(id).get());
    }

    @Override
    public EbookDTO addEbook(EbookDTO ebookDTO) {
        Optional<Ebook> opEbook = Optional.ofNullable(ebookRepository.findByIsbn(ebookDTO.getIsbn()));
        if(opEbook.isPresent()) {
            // update field quantity of ebook
            opEbook.get().setQuantity(
                    opEbook.get().getQuantity() + ebookDTO.getQuantity());
        } else {
            // add new ebook
            ebookRepository.save(ebookMapper.toEbook(ebookDTO));
        }
        return ebookDTO;
    }

    @Override
    public EbookDTO updateEbookById(EbookDTO ebookDTO, long id) {
        Optional<Ebook> opEbook = ebookRepository.findById(id);
        if(opEbook.isPresent()) {
            ebookRepository.save(ebookMapper.toEbook(ebookDTO));
            return ebookDTO;
        }
        throw new NotFoundException("Ebook id: " + id + " not found!");
    }

    @Override
    public void deleteEbookById(long id) {
        Optional<Ebook> opEbook = ebookRepository.findById(id);
        if(opEbook.isPresent()) {
            // soft delete (only set field 'deleted' to 'true' value)
            opEbook.get().setDeleted(true);
        }
        throw new NotFoundException("Ebook id: " + id + " not found!");
    }
}
