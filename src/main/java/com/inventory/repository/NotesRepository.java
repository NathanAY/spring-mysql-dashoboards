package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

}
