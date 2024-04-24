package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class EcopointOwner extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public EcopointOwner() {
    }
}
