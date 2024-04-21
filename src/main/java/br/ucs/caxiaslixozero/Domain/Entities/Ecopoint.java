package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Ecopoint {

    @Id
    public Long ecopointId;
    public String name;
    public LocalDateTime openingDateTime;
    public LocalDateTime closingDateTime;
    public Boolean openToPublic;
    public String contactInfo;
    public String imageUrl;
}
