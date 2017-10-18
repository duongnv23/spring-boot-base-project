package com.duongnv.spring.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ACL_CLASS", uniqueConstraints = @UniqueConstraint(columnNames = "CLASS"))
public class AclClass implements java.io.Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	private Long id;

	@Column(name = "CLASS", unique = true, nullable = false, length = 256)
	private String class_;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aclClass")
	private Set<AclObjectIdentity> aclObjectIdentities = new HashSet<AclObjectIdentity>(0);

	public AclClass() {
	}

	public AclClass(Long id, String class_) {
		this.id = id;
		this.class_ = class_;
	}

	public AclClass(Long id, String class_, Set<AclObjectIdentity> aclObjectIdentities) {
		this.id = id;
		this.class_ = class_;
		this.aclObjectIdentities = aclObjectIdentities;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Set<AclObjectIdentity> getAclObjectIdentities() {
		return this.aclObjectIdentities;
	}

	public void setAclObjectIdentities(Set<AclObjectIdentity> aclObjectIdentities) {
		this.aclObjectIdentities = aclObjectIdentities;
	}

}
