package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.Id;

public class EcopointOwner extends Person {

    @Id
    public Long ownerId;

    public EcopointOwner() {
    }
}
