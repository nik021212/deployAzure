package com.soprasteria.terna.mymicroservice.utenti.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.soprasteria.terna.mymicroservice.utenti.model.UtentiModel;

public interface UtentiRepository extends MongoRepository<UtentiModel, Integer>{
    
    Optional<UtentiModel> findByUsername(String username);
}
