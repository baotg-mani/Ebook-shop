package com.cmcglobal.ebshop.service.impl;

import com.cmcglobal.ebshop.dto.PublisherDTO;
import com.cmcglobal.ebshop.dto.mapper.PublisherMapper;
import com.cmcglobal.ebshop.entity.Publisher;
import com.cmcglobal.ebshop.exception.NotFoundException;
import com.cmcglobal.ebshop.repository.EbookRepository;
import com.cmcglobal.ebshop.repository.PublisherRepository;
import com.cmcglobal.ebshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {
    private PublisherRepository publisherRepository;
    private PublisherMapper publisherMapper;
    private EbookRepository ebookRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository,
                                PublisherMapper publisherMapper,
                                EbookRepository ebookRepository) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
        this.ebookRepository = ebookRepository;
    }


    @Override
    public List<PublisherDTO> getAllPublishers() {

        return publisherRepository
                .findAll()
                .stream()
                .map(publisherMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PublisherDTO getPublisherById(long id) {
        Optional<Publisher> opPublisher = publisherRepository.findById(id);
        if(opPublisher.isPresent()) {
            return publisherMapper.toDto(opPublisher.get());
        }
        throw new NotFoundException("Publisher id: " + id + " not found!");
    }

    @Override
    public PublisherDTO addPublisher(PublisherDTO publisherDTO) {
        publisherRepository.save(publisherMapper.toPublisher(publisherDTO));
        return publisherDTO;
    }

    @Override
    public PublisherDTO updatePublisherById(PublisherDTO publisherDTO, long id) {
        Optional<Publisher> opPublisher = publisherRepository.findById(id);
        if(opPublisher.isPresent()) {
            return publisherMapper.toDto(opPublisher.get());
        }
        throw new NotFoundException("Publisher id: " + id + " not found!");
    }

    @Override
    public void deletePublisherById(long id) {
        Optional<Publisher> opPublisher = publisherRepository.findById(id);
        if (opPublisher.isPresent()) {
            // check NXB hết sách trên hệ thống thì mới cho xóa NXB
            if (ebookRepository.findByPublisherId(id).size() == 0) {
                publisherRepository.deleteById(id);
            }
        }
        throw new NotFoundException("Publisher id: " + id + " not found!");
    }
}
