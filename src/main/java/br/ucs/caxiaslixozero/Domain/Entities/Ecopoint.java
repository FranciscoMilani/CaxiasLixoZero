package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
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
//    @ElementCollection
//    @CollectionTable(name = "ecopoint_residues", joinColumns = @JoinColumn(name = "ecopoint_id"))
//    @Column(name = "string")
//    private List<String> residueType;
    private Boolean isPublic;
    private Date solicitationDate;
	private LocalTime openingTime;
	private LocalTime closingTime;
    private String imageUrl;
    private Boolean isApproved;
	private String cep;
	private Float latitude;
	private Float longitude;
	@ManyToMany
	@JoinTable(name = "ecopoint_residue")
	private List<Residue> residues;

    @Transient
    private String residuesJson;
}
