package br.ucs.caxiaslixozero.Domain.Entities;

import br.ucs.caxiaslixozero.Domain.Enums.MeasureType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class GatherResult {

    @Id
    public Long gatherId;
    public LocalDate startGatherDate;
    public LocalDate endGatherDate;
    public float collectedAmount;
    public MeasureType measureType;

    public GatherResult() {
    }
}
