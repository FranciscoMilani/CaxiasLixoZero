package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Boolean isPublic;
    private Date solicitationDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime openingTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
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
