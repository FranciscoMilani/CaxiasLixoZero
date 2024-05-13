package br.ucs.caxiaslixozero.Domain.Dtos;

import java.util.List;

public record EcopointMapDto (String title, String phone, String email, EcopointAddressDto address, String openingDateTime, String closingDateTime, List<String> residues) {

}
