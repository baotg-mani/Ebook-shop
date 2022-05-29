package com.cmcglobal.ebshop.service;

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
    List<Publisher> findAll();

    List<Publisher> findAll(Sort sort);

    List<Publisher> findAllById(Iterable<Long> longs);

    <S extends Publisher> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends Publisher> S saveAndFlush(S entity);

    <S extends Publisher> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Publisher> entities);

    void deleteAllInBatch(Iterable<Publisher> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Publisher getOne(Long aLong);

    @Deprecated
    Publisher getById(Long aLong);

    Publisher getReferenceById(Long aLong);

    <S extends Publisher> List<S> findAll(Example<S> example);

    <S extends Publisher> List<S> findAll(Example<S> example, Sort sort);

    Page<Publisher> findAll(Pageable pageable);

    <S extends Publisher> S save(S entity);

    Optional<Publisher> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Publisher entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Publisher> entities);

    void deleteAll();

    <S extends Publisher> Optional<S> findOne(Example<S> example);

    <S extends Publisher> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Publisher> long count(Example<S> example);

    <S extends Publisher> boolean exists(Example<S> example);

    <S extends Publisher, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
