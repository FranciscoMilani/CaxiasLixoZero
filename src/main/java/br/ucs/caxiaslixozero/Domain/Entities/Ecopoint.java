package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Ecopoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public LocalDateTime openingDateTime;
    public LocalDateTime closingDateTime;
    public Boolean openToPublic;
    public String contactInfo;
    public String imageUrl;
}
