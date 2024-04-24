package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    public String name;
    public String cpf;
    public String phoneNumber;
    public String emailAddress;
    public char sex;

}
