package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "KHO_HANG")
public class Warehouse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_KHO_HANG", nullable = false, unique = true)
	private int repositoryId;
	
	/******************************************************************************/
	
	@Column(name = "TEN_KHO_HANG", nullable = false)
	private String repositoryName;
	
	/******************************************************************************/
	
	public Warehouse() {}
	
	public Warehouse(int repositoryId, String repositoryName) {
		this.repositoryId = repositoryId;
		this.repositoryName = repositoryName;
	}

	/******************************************************************************/
	
	public int getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(int repositoryId) {
		this.repositoryId = repositoryId;
	}

	/******************************************************************************/
	
	public String getRepositoryName() {
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	
	/******************************************************************************/
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "repositoryId", fetch = FetchType.EAGER)
//	private Set<ImportRepository> importRepository;
//
//	public Set<ImportRepository> getImportRepository() {
//		return importRepository;
//	}
//
//	public void setImportRepository(Set<ImportRepository> importRepository) {
//		this.importRepository = importRepository;
//	}
	
	/******************************************************************************/
//	@JsonManagedReference
//	@OneToMany(mappedBy = "repositoryId", fetch = FetchType.EAGER)
//	private Set<ExportRepository> exportRepositories;
//
//	public Set<ExportRepository> getExportRepositories() {
//		return exportRepositories;
//	}
//
//	public void setExportRepositories(Set<ExportRepository> exportRepositories) {
//		this.exportRepositories = exportRepositories;
//	}
		
}
