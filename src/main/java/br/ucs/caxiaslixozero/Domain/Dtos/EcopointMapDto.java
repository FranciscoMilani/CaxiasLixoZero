package br.ucs.caxiaslixozero.Domain.Dtos;

import br.ucs.caxiaslixozero.Domain.Entities.Residue;

import java.util.Collection;
import java.util.List;

public record EcopointMapDto (String id, String title, String phone, String email, EcopointAddressDto address, String openingTime, String closingTime, List<ResidueDto> residues/*List<String> residues*/, String latitude, String longitude) {

}
