package com.xsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xsis.model.Barang;

public interface BarangRepo extends JpaRepository<Barang, Long> {

	/*@Query(value = "DELETE FROM barang WHERE barang.id =  ?1 ")
	void hapusBarangById(int id);
	*/
}
