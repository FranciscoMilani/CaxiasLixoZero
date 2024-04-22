package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EcopointOwner extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public EcopointOwner() {
    }
}
