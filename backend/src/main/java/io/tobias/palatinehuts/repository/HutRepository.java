package io.tobias.palatinehuts.repository;

import io.tobias.palatinehuts.model.Hut;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;


public interface HutRepository extends JpaRepository<Hut, UUID> {

    List<Hut> findByName(String name);
}
