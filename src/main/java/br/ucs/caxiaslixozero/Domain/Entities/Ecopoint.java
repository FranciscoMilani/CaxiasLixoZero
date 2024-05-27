package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Ecopoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String companyName;
    private String email;
    private String responsibleName;
    private String responsiblePhone;
    private String socialNetwork;
    @OneToOne
    private Address ecopointAddress;
    @ElementCollection
    @CollectionTable(name = "ecopoint_residues", joinColumns = @JoinColumn(name = "ecopoint_id"))
    @Column(name = "string")
    private List<String> residueType;
    private Boolean isPublic;
    private Date solicitationDate;
    private Date openingDateTime;
    private Date closingDateTime;
    private String imageUrl;
    private Boolean isApproved;
//	@ManyToMany
//	@JoinTable(name = "ecopoint_residue")
//	private Collection<Residue> residues;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResponsibleName() {
		return responsibleName;
	}
	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}
	public String getResponsiblePhone() {
		return responsiblePhone;
	}
	public void setResponsiblePhone(String responsiblePhone) {
		this.responsiblePhone = responsiblePhone;
	}
	public String getSocialNetwork() {
		return socialNetwork;
	}
	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}
	public Address getEcopointAddress() {
		return ecopointAddress;
	}
	public void setEcopointAddress(Address ecopointAddress) {
		this.ecopointAddress = ecopointAddress;
	}
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public Date getSolicitationDate() {
		return solicitationDate;
	}
	public void setSolicitationDate(Date solicitationDate) {
		this.solicitationDate = solicitationDate;
	}
	public Date getOpeningDateTime() {
		return openingDateTime;
	}
	public void setOpeningDateTime(Date openingDateTime) {
		this.openingDateTime = openingDateTime;
	}
	public Date getClosingDateTime() {
		return closingDateTime;
	}
	public void setClosingDateTime(Date closingDateTime) {
		this.closingDateTime = closingDateTime;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<String> getResidueType() {
		return residueType;
	}
	public void setResidueType(List<String> residueType) {
		this.residueType = residueType;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
}
