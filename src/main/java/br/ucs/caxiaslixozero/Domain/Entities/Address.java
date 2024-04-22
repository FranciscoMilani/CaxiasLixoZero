package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.*;

@Table
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String road;
    public Integer number;
    public String addOn;
    public String neighborhood;
}
