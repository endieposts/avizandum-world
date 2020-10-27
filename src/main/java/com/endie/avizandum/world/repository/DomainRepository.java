package com.endie.avizandum.world.repository;

import com.endie.avizandum.world.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {

    Domain findOneByDomainId(@Param("domainId") Long domainId);
}
