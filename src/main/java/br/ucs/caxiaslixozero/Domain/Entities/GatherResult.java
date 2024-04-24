package br.ucs.caxiaslixozero.Domain.Entities;

import br.ucs.caxiaslixozero.Domain.Enums.MeasureType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
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
