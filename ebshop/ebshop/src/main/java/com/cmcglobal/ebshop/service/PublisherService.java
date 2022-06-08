package com.cmcglobal.ebshop.service;

import com.cmcglobal.ebshop.dto.PublisherDTO;
import com.cmcglobal.ebshop.entity.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PublisherService {

    List<PublisherDTO> getAllPublishers();

    PublisherDTO getPublisherById(long id);

    PublisherDTO addPublisher(PublisherDTO publisherDTO);

    PublisherDTO updatePublisherById(PublisherDTO publisherDTO, long id);

    void deletePublisherById(long id);
}
