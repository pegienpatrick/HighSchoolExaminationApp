package com.pegien.HighSchoolExamination.TimeTable;

import com.pegien.HighSchoolExamination.StudySubjects.StudySubject;
import com.pegien.HighSchoolExamination.StudySubjects.StudySubjectsRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DummyRepo implements StudySubjectsRepository {
    @Override
    public List<StudySubject> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<StudySubject> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<StudySubject> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(StudySubject entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends StudySubject> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends StudySubject> S save(S entity) {
        return null;
    }

    @Override
    public <S extends StudySubject> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<StudySubject> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends StudySubject> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends StudySubject> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<StudySubject> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public StudySubject getOne(Long aLong) {
        return null;
    }

    @Override
    public StudySubject getById(Long aLong) {
        return null;
    }

    @Override
    public StudySubject getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends StudySubject> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends StudySubject> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends StudySubject> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends StudySubject> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends StudySubject> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends StudySubject> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends StudySubject, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
