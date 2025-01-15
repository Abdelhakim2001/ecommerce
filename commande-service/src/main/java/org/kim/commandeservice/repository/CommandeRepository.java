package org.kim.commandeservice.repository;

import org.kim.commandeservice.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
