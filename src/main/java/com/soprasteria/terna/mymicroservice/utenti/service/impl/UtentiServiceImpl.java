package com.soprasteria.terna.mymicroservice.utenti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import com.soprasteria.terna.mymicroservice.utenti.model.UtentiModel;
import com.soprasteria.terna.mymicroservice.utenti.repository.UtentiRepository;
import com.soprasteria.terna.mymicroservice.utenti.service.UtentiService;
import com.soprasteria.terna.mymicroservice.utenti.api.model.UtenteDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UtentiServiceImpl implements UtentiService{

    @Autowired
    private UtentiRepository utentiRepo;

    @Override
    public UtenteDto getUtentiByUsername(String username) {
        log.info("Start getUtentiByUsername");
        
        try{
            Optional<UtentiModel> opt = utentiRepo.findByUsername(username);
            
            // if(opt.isPresent()){
                return checkProfilo(opt.get());
            // }
            
        } catch(Exception e){
            log.error("error in getUtentiByUsername : " + e.getMessage());

            // throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User Not Authorized");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        
        // return null;
    }
    
    // se presente un solo operatore o profilo viene impostato di default
    private UtentiModel checkProfilo(UtentiModel utenteCheck) {
        log.info("Start checkProfilo");

        UtentiModel checkUno = utenteCheck;

        // check per vedere se l'utente ha un solo operatore elettrico
        if (utenteCheck.getOe().size() == 1) {
            // utenteCheck.getOe().get(0).getOperatoreElettrico();
            checkUno.setOperatoreElettricoIdScelto(utenteCheck.getOe().get(0).getOperatoreElettricoId());

            // check per vedere se utente ha un solo profilo relativo all'operatore
            // elettrico
            if (utenteCheck.getOe().get(0).getProfili().size() == 1) {
                // utenteCheck.getOe().get(0).getProfili().get(0).getProfiloNome();
                checkUno.setProfiloIdScelto(utenteCheck.getOe().get(0).getProfili().get(0).getProfiloId());
            }
        }

        return checkUno;

    }
    
    
}
