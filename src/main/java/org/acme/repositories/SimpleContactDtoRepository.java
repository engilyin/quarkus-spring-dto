package org.acme.repositories;

import java.util.Optional;

import org.acme.data.SimpleContactDto;
import org.acme.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleContactDtoRepository extends CrudRepository<Contact, Long> {

    Optional<SimpleContactDto> findByUsername(String username);
}
