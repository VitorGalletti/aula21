package Codigo;

import java.util.ArrayList;
import java.util.List;

public class NumerosModel {
    private List<Integer> numeros;

    public NumerosModel() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public List<Integer> obterNumeros() {
        return numeros;
    }
}

