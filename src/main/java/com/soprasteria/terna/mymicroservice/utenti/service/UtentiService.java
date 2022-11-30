package com.soprasteria.terna.mymicroservice.utenti.service;

import com.soprasteria.terna.mymicroservice.utenti.api.model.UtenteDto;

public interface UtentiService {
    
    public UtenteDto getUtentiByUsername(String username);
}
