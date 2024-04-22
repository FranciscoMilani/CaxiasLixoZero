package br.ucs.caxiaslixozero.Domain.Entities;

import br.ucs.caxiaslixozero.Domain.Enums.MeasureType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class GatherResult {

    @Id
    public Long id;
    public LocalDate startGatherDate;
    public LocalDate endGatherDate;
    public float collectedAmount;
    public MeasureType measureType;

    public GatherResult() {
    }
}
