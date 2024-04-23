package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.*;

import java.util.Date;

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
    private Address ecopointAdress;
    private String residueType;
    private Boolean isPublic;
    private Date solicitationDate;
    private Date openingDateTime;
    private Date closingDateTime;
    private String imageUrl;
    
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
	public Address getEcopointAdress() {
		return ecopointAdress;
	}
	public void setEcopointAdress(Address ecopointAdress) {
		this.ecopointAdress = ecopointAdress;
	}
	public String getResidueType() {
		return residueType;
	}
	public void setResidueType(String residueType) {
		this.residueType = residueType;
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
}
