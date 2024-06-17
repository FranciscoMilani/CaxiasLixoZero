package br.ucs.caxiaslixozero.Domain.Entities;

import jakarta.persistence.*;
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
}
