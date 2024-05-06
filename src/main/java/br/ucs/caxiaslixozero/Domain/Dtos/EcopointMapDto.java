package br.ucs.caxiaslixozero.Domain.Dtos;

import java.util.List;

public record EcopointMapDto (String phone, String email, String ecopointName, String openingDateTime, String closingDateTime, List<String> residues)
{ }
