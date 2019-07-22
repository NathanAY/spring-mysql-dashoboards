/**
 * 
 */
package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.MstBarang;

/**
 * @author Owner
 *
 */
@Repository
public interface BarangRepo extends JpaRepository<MstBarang, String> {
	
}
