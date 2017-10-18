package com.duongnv.spring.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ACL_ENTRY", uniqueConstraints = @UniqueConstraint(columnNames = { "ACL_OBJECT_IDENTITY", "ACE_ORDER" }))
public class AclEntry implements java.io.Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SID", nullable = false)
	private AclSid aclSid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACL_OBJECT_IDENTITY", nullable = false)
	private AclObjectIdentity aclObjectIdentity;
	
	@Column(name = "ACE_ORDER", nullable = false, precision = 22, scale = 0)
	private Long aceOrder;
	
	@Column(name = "MASK", nullable = false, precision = 22, scale = 0)
	private Long mask;
	
	@Column(name = "GRANTING", nullable = false, precision = 1, scale = 0)
	private boolean granting;
	
	@Column(name = "AUDIT_SUCCESS", nullable = false, precision = 1, scale = 0)
	private boolean auditSuccess;
	
	@Column(name = "AUDIT_FAILURE", nullable = false, precision = 1, scale = 0)
	private boolean auditFailure;

	public AclEntry() {
	}

	public AclEntry(Long id, AclSid aclSid, AclObjectIdentity aclObjectIdentity, Long aceOrder, Long mask,
			boolean granting, boolean auditSuccess, boolean auditFailure) {
		this.id = id;
		this.aclSid = aclSid;
		this.aclObjectIdentity = aclObjectIdentity;
		this.aceOrder = aceOrder;
		this.mask = mask;
		this.granting = granting;
		this.auditSuccess = auditSuccess;
		this.auditFailure = auditFailure;
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

	
	public Long getAceOrder() {
		return this.aceOrder;
	}

	public void setAceOrder(Long aceOrder) {
		this.aceOrder = aceOrder;
	}

	
	public Long getMask() {
		return this.mask;
	}

	public void setMask(Long mask) {
		this.mask = mask;
	}

	
	public boolean isGranting() {
		return this.granting;
	}

	public void setGranting(boolean granting) {
		this.granting = granting;
	}

	
	public boolean isAuditSuccess() {
		return this.auditSuccess;
	}

	public void setAuditSuccess(boolean auditSuccess) {
		this.auditSuccess = auditSuccess;
	}

	
	public boolean isAuditFailure() {
		return this.auditFailure;
	}

	public void setAuditFailure(boolean auditFailure) {
		this.auditFailure = auditFailure;
	}

}
