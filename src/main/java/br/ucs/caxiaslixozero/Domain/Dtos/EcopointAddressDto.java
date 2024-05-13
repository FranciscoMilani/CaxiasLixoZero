package br.ucs.caxiaslixozero.Domain.Dtos;

import java.text.MessageFormat;

public record EcopointAddressDto (String street, String number, String neighborhood) {

    public static String formatAddressToString(EcopointAddressDto address) {
        return MessageFormat.format("{0}, {1} - {2}", address.street, address.number, address.neighborhood);
    }
}
