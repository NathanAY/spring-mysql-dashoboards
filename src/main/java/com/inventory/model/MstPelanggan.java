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
@Table(name = "mst_pelanggan")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class MstPelanggan {
	@Id
    @Column(name="kd_pelanggan", length=5)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String kodePelanggan;
    
    @Column(name="nama_pelanggan", length=20)
    private String namaPelanggan;
    
    @Column(name="alamat", length=50)
    private String alamat;
    
    @Column(name="kota", length=20)
    private String kota;
    
    @Column(name="telepon", length=15)
    private Integer telepon;
    
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
}
