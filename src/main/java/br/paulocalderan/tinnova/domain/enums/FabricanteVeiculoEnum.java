package br.paulocalderan.tinnova.domain.enums;

import br.paulocalderan.tinnova.exception.InvalidMarcaException;

import java.util.Arrays;

import static br.paulocalderan.tinnova.exception.ExceptionConstants.MARCA_INVALIDA;

/**
 * Enumeração que representa os fabricantes de veículos.
 */
public enum FabricanteVeiculoEnum {
    ALFA_ROMEO("Alfa Romeo"),
    ASTON_MARTIN("Aston Martin"),
    AUDI("Audi"),
    BENTLEY("Bentley"),
    BMW("BMW"),
    BUGATTI("Bugatti"),
    CADILLAC("Cadillac"),
    CHEVROLET("Chevrolet"),
    CHRYSLER("Chrysler"),
    CITROEN("Citroën"),
    DODGE("Dodge"),
    FERRARI("Ferrari"),
    FIAT("Fiat"),
    FORD("Ford"),
    GMC("GMC"),
    HONDA("Honda"),
    HYUNDAI("Hyundai"),
    INFINITI("Infiniti"),
    JAGUAR("Jaguar"),
    JEEP("Jeep"),
    KIA("Kia"),
    LAMBORGHINI("Lamborghini"),
    LAND_ROVER("Land Rover"),
    LEXUS("Lexus"),
    LINCOLN("Lincoln"),
    LOTUS("Lotus"),
    MASERATI("Maserati"),
    MAZDA("Mazda"),
    MERCEDES_BENZ("Mercedes-Benz"),
    MITSUBISHI("Mitsubishi"),
    NISSAN("Nissan"),
    PEUGEOT("Peugeot"),
    PORSCHE("Porsche"),
    RENAULT("Renault"),
    SUBARU("Subaru"),
    SUZUKI("Suzuki"),
    TESLA("Tesla"),
    TOYOTA("Toyota"),
    VOLKSWAGEN("Volkswagen"),
    VOLVO("Volvo");

    private final String nome;

    FabricanteVeiculoEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Verifica se uma marca de veículo é válida.
     *
     * @param marca a marca a ser verificada
     * @throws InvalidMarcaException se a marca não for válida
     */
    public static void isValid(String marca) {
        String marcaNormalizada = marca.trim().toUpperCase();
        boolean marcaValida = Arrays.stream(FabricanteVeiculoEnum.values())
                .anyMatch(value -> value.getNome().equalsIgnoreCase(marcaNormalizada));

        if (!marcaValida) {
            throw new InvalidMarcaException(MARCA_INVALIDA + marca);
        }
    }

}