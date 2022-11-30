package com.soprasteria.terna.mymicroservice.utenti.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.soprasteria.terna.mymicroservice.utenti.api.model.UtenteDto;


@Document("ETL_UTENTI")
public class UtentiModel extends UtenteDto{
    
}
