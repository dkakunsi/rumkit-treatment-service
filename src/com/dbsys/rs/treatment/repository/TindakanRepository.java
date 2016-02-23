package com.dbsys.rs.treatment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsys.rs.Kelas;
import com.dbsys.rs.treatment.entity.Tindakan;

public interface TindakanRepository extends JpaRepository<Tindakan, Long> {

	List<Tindakan> findByKodeContainingOrNamaContaining(String kode, String nama);

	Tindakan findByNamaAndKelas(String nama, Kelas kelas);

}
