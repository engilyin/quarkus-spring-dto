package org.acme.repositories;

import java.util.Optional;

import org.acme.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    Optional<Contact> findByUsername(String username);
}
