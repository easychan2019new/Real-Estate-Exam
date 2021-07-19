package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    Dictionary findDictionaryById(Long did);
}
