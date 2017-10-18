package com.duongnv.spring.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ACL_OBJECT_IDENTITY", uniqueConstraints = @UniqueConstraint(columnNames = { "OBJECT_ID_CLASS",
		"OBJECT_ID_IDENTITY" }))
public class AclObjectIdentity implements java.io.Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OWNER_SID")
	private AclSid aclSid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_OBJECT")
	private AclObjectIdentity aclObjectIdentity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECT_ID_CLASS", nullable = false)
	private AclClass aclClass;

	@Column(name = "OBJECT_ID_IDENTITY", nullable = false, precision = 38, scale = 0)
	private Long objectIdIdentity;

	@Column(name = "ENTRIES_INHERITING", nullable = false, precision = 1, scale = 0)
	private boolean entriesInheriting;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aclObjectIdentity")
	private Set<AclEntry> aclEntries = new HashSet<AclEntry>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aclObjectIdentity")
	private Set<AclObjectIdentity> aclObjectIdentities = new HashSet<AclObjectIdentity>(0);

	public AclObjectIdentity() {
	}

	public AclObjectIdentity(Long id, AclClass aclClass, Long objectIdIdentity, boolean entriesInheriting) {
		this.id = id;
		this.aclClass = aclClass;
		this.objectIdIdentity = objectIdIdentity;
		this.entriesInheriting = entriesInheriting;
	}

	public AclObjectIdentity(Long id, AclSid aclSid, AclObjectIdentity aclObjectIdentity, AclClass aclClass,
			Long objectIdIdentity, boolean entriesInheriting, Set<AclEntry> aclEntries,
			Set<AclObjectIdentity> aclObjectIdentities) {
		this.id = id;
		this.aclSid = aclSid;
		this.aclObjectIdentity = aclObjectIdentity;
		this.aclClass = aclClass;
		this.objectIdIdentity = objectIdIdentity;
		this.entriesInheriting = entriesInheriting;
		this.aclEntries = aclEntries;
		this.aclObjectIdentities = aclObjectIdentities;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AclSid getAclSid() {
		return this.aclSid;
	}

	public void setAclSid(AclSid aclSid) {
		this.aclSid = aclSid;
	}

	public AclObjectIdentity getAclObjectIdentity() {
		return this.aclObjectIdentity;
	}

	public void setAclObjectIdentity(AclObjectIdentity aclObjectIdentity) {
		this.aclObjectIdentity = aclObjectIdentity;
	}

	public AclClass getAclClass() {
		return this.aclClass;
	}

	public void setAclClass(AclClass aclClass) {
		this.aclClass = aclClass;
	}

	public Long getObjectIdIdentity() {
		return this.objectIdIdentity;
	}

	public void setObjectIdIdentity(Long objectIdIdentity) {
		this.objectIdIdentity = objectIdIdentity;
	}

	public boolean isEntriesInheriting() {
		return this.entriesInheriting;
	}

	public void setEntriesInheriting(boolean entriesInheriting) {
		this.entriesInheriting = entriesInheriting;
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
