package org.acme.repositories;

import java.util.Optional;

import org.acme.data.SimpleContactProjection;
import org.acme.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleContactProjectionRepository extends CrudRepository<Contact, Long> {

    Optional<SimpleContactProjection> findByUsername(String username);

}
