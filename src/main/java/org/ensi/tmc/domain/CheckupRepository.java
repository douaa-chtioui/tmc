package org.ensi.tmc.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CheckupRepository extends JpaRepository<Checkup, Long> {
    List<Checkup> findByUserIdentifier(long patientId);
}
