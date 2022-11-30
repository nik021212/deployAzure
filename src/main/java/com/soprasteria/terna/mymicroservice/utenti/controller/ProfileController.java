package com.soprasteria.terna.mymicroservice.utenti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.soprasteria.terna.mymicroservice.utenti.api.CheckApiDelegate;
import com.soprasteria.terna.mymicroservice.utenti.api.model.UtenteDto;
import com.soprasteria.terna.mymicroservice.utenti.api.model.UsernameDto;
import com.soprasteria.terna.mymicroservice.utenti.service.UtentiService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProfileController implements CheckApiDelegate {
    
    @Autowired
    private UtentiService utentiService;

    @Override
    public ResponseEntity<UtenteDto> postUserProfiles(UsernameDto username){
        log.info("ProfileController - postUserProfiles : #start");
   
        return new ResponseEntity<UtenteDto>(utentiService.getUtentiByUsername(username.getUsername()), HttpStatus.OK);
    }
}