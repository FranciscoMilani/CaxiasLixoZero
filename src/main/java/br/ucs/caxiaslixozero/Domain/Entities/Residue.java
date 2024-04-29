package br.ucs.caxiaslixozero.Domain.Entities;

import br.ucs.caxiaslixozero.Domain.Enums.ResidueType;
import jakarta.persistence.Entity;
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
public class Residue {
	
    @Id
    public Long id;
	private ResidueType residueType;
    private String nome;
    private String descricao;
    private String descarte;
    private byte[] imagem;
}
