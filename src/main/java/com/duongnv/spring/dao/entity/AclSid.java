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
@Table(name = "ACL_SID", uniqueConstraints = @UniqueConstraint(columnNames = { "SID", "PRINCIPAL" }))
public class AclSid implements java.io.Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	private Long id;

	@Column(name = "PRINCIPAL", nullable = false, precision = 1, scale = 0)
	private boolean principal;

	@Column(name = "SID", nullable = false, length = 200)
	private String sid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aclSid")
	private Set<AclEntry> aclEntries = new HashSet<AclEntry>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aclSid")
	private Set<AclObjectIdentity> aclObjectIdentities = new HashSet<AclObjectIdentity>(0);

	public AclSid() {
	}

	public AclSid(Long id, boolean principal, String sid) {
		this.id = id;
		this.principal = principal;
		this.sid = sid;
	}

	public AclSid(Long id, boolean principal, String sid, Set<AclEntry> aclEntries,
			Set<AclObjectIdentity> aclObjectIdentities) {
		this.id = id;
		this.principal = principal;
		this.sid = sid;
		this.aclEntries = aclEntries;
		this.aclObjectIdentities = aclObjectIdentities;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPrincipal() {
		return this.principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Set<AclEntry> getAclEntries() {
		return this.aclEntries;
	}

	public void setAclEntries(Set<AclEntry> aclEntries) {
		this.aclEntries = aclEntries;
	}

	public Set<AclObjectIdentity> getAclObjectIdentities() {
		return this.aclObjectIdentities;
	}

	public void setAclObjectIdentities(Set<AclObjectIdentity> aclObjectIdentities) {
		this.aclObjectIdentities = aclObjectIdentities;
	}

}
