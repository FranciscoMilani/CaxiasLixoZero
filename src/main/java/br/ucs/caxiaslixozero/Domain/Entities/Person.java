package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    private String name;
    private String cpf;
    private String phoneNumber;
    private String emailAddress;
    private char sex;

}
