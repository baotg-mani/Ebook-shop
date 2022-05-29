package com.cmcglobal.ebshop.service.impl;

import com.cmcglobal.ebshop.entity.Publisher;
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

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> findAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }

    @Override
    public List<Publisher> findAllById(Iterable<Long> longs) {
        return publisherRepository.findAllById(longs);
    }

    @Override
    public <S extends Publisher> List<S> saveAll(Iterable<S> entities) {
        return publisherRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        publisherRepository.flush();
    }

    @Override
    public <S extends Publisher> S saveAndFlush(S entity) {
        return publisherRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Publisher> List<S> saveAllAndFlush(Iterable<S> entities) {
        return publisherRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Publisher> entities) {
        publisherRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Publisher> entities) {
        publisherRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        publisherRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        publisherRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Publisher getOne(Long aLong) {
        return publisherRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public Publisher getById(Long aLong) {
        return publisherRepository.getById(aLong);
    }

    @Override
    public Publisher getReferenceById(Long aLong) {
        return publisherRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends Publisher> List<S> findAll(Example<S> example) {
        return publisherRepository.findAll(example);
    }

    @Override
    public <S extends Publisher> List<S> findAll(Example<S> example, Sort sort) {
        return publisherRepository.findAll(example, sort);
    }

    @Override
    public Page<Publisher> findAll(Pageable pageable) {
        return publisherRepository.findAll(pageable);
    }

    @Override
    public <S extends Publisher> S save(S entity) {
        return publisherRepository.save(entity);
    }

    @Override
    public Optional<Publisher> findById(Long aLong) {
        return publisherRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return publisherRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return publisherRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        publisherRepository.deleteById(aLong);
    }

    @Override
    public void delete(Publisher entity) {
        publisherRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        publisherRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Publisher> entities) {
        publisherRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        publisherRepository.deleteAll();
    }

    @Override
    public <S extends Publisher> Optional<S> findOne(Example<S> example) {
        return publisherRepository.findOne(example);
    }

    @Override
    public <S extends Publisher> Page<S> findAll(Example<S> example, Pageable pageable) {
        return publisherRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Publisher> long count(Example<S> example) {
        return publisherRepository.count(example);
    }

    @Override
    public <S extends Publisher> boolean exists(Example<S> example) {
        return publisherRepository.exists(example);
    }

    @Override
    public <S extends Publisher, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return publisherRepository.findBy(example, queryFunction);
    }
}
