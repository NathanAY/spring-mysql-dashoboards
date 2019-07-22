/**
 * 
 */
package com.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Owner
 *
 */
@Entity
@Table(name = "mst_barang")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class MstBarang {
    @Id
    @Column(name="kd_barang", length=5, unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String kodeBarang;
    
    @Column(name="nama_barang", length=15)
    private String namaBarang;
    
    @Column(name="spesifikasi", length=30)
    private String spesifikasi;
    
    @Column(name="harga_beli", length=5)
    private Float hargaBeli;
   
    @Column(name="harga_jual", length=5)
    private Float hargaJual;
    
    @Column(name="stok", length=5)
    private Integer stok;
    
    @Column(name="keterangan", length=20)
    private String keterangan;
    
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
    
}
