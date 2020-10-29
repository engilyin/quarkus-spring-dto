package org.acme.services;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.acme.entities.Contact;
import org.acme.repositories.ContactRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Singleton
@AllArgsConstructor
@Slf4j
public class ContactService {

    private final ContactRepository contactRepository;

    @Transactional
    public Contact find(String username) {

        log.debug("Searching by username: {}", username);

        return contactRepository.findByUsername(username).orElseThrow();
    }
    
    @Transactional
    public Iterable<Contact> findAll() {
        
        log.debug("List all contacts");
        
        return contactRepository.findAll();
    }
}
