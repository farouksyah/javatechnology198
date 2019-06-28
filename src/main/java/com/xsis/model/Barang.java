package com.xsis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="barang")
public class Barang  {

	
	
	@Id
	@Column(name="id", nullable =false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name="namabarang", nullable = false, length = 50)
	private String namabarang;
	
	@Column(name="jenisbarang", length=30)
	private String jenisbarang;
	
	@Column(name="kotapembuat", length=30)
	private String kotapembuat;
	
	@Column(name="jmlbarang")
	private int jmlbarang;
	
	@Column(name="hargabarang")
	private int hargabarang;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaBarang() {
		return namabarang;
	}

	public void setNamaBarang(String namabarang) {
		this.namabarang = namabarang;
	}

	public String getJenisBarang() {
		return jenisbarang;
	}

	public void setJenisBarang(String jenisbarang) {
		this.jenisbarang = jenisbarang;
	}

	public String getKotaPembuat() {
		return kotapembuat;
	}

	public void setKotaPembuat(String kotapembuat) {
		this.kotapembuat = kotapembuat;
	}

	public int getJmlBarang() {
		return jmlbarang;
	}

	public void setJmlBarang(int jmlbarang) {
		this.jmlbarang = jmlbarang;
	}

	public int getHargaBarang() {
		return hargabarang;
	}

	public void setHargaBarang(int hargabarang) {
		this.hargabarang = hargabarang;
	}
	
	
	
}
