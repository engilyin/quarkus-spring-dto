package org.acme.services;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.acme.data.SimpleContactDto;
import org.acme.data.SimpleContactProjection;
import org.acme.entities.Contact;
import org.acme.repositories.ContactRepository;
import org.acme.repositories.DynamicContactRepository;
import org.acme.repositories.SimpleContactDtoRepository;
import org.acme.repositories.SimpleContactProjectionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Singleton
@AllArgsConstructor
@Slf4j
public class ContactService {

    private final ContactRepository contactRepository;
    
    private final SimpleContactDtoRepository simpleContactDtoRepository;
    
    private final SimpleContactProjectionRepository simpleContactProjectionRepository;

//    private final DynamicContactRepository dynamicContactRepository;
    
    @Transactional
    public Contact find(String username) {

        log.debug("Searching by username: {}", username);

        return contactRepository.findByUsername(username).orElseThrow();
    }
    
    @Transactional
    public SimpleContactDto findSimpleContactDto(String username) {
        
        log.debug("Searching SimpleContactDto by username: {}", username);
        
        return simpleContactDtoRepository.findByUsername(username).orElseThrow();
    }
    
    
    @Transactional
    public SimpleContactProjection findSimpleContactProjection(String username) {
        
        log.debug("Searching SimpleContactProjection by username: {}", username);
        
        return simpleContactProjectionRepository.findByUsername(username).orElseThrow();
    }
    
//    @Transactional
//    public SimpleContactDto findSimpleContactDynamic(String username) {
//        
//        log.debug("Searching SimpleContactProjection dynamic by username: {}", username);
//        
//        return dynamicContactRepository.findByUsername(username, SimpleContactDto.class).orElseThrow();
//    }
    
    @Transactional
    public Iterable<Contact> findAll() {
        
        log.debug("List all contacts");
        
        return contactRepository.findAll();
    }
}
