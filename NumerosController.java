package Codigo;

import java.util.List;

public class NumerosController {
    private NumerosModel model;
    private NumerosView view;

    public NumerosController(NumerosModel model, NumerosView view) {
        this.model = model;
        this.view = view;
    }

    public void adicionarNumeros(int[] numeros) {
        for (int numero : numeros) {
            model.adicionarNumero(numero);
        }
    }

    public void ordenarNumerosInsertionSort() {
        List<Integer> numeros = model.obterNumeros();
        int n = numeros.size();
        for (int i = 1; i < n; ++i) {
            int chave = numeros.get(i);
            int j = i - 1;

            while (j >= 0 && numeros.get(j) > chave) {
                numeros.set(j + 1, numeros.get(j));
                j = j - 1;
            }
            numeros.set(j + 1, chave);
        }
    }

    public void ordenarNumerosQuickSort() {
        List<Integer> numeros = model.obterNumeros();
        quickSort(numeros, 0, numeros.size() - 1);
    }

    private void quickSort(List<Integer> numeros, int baixo, int alto) {
        if (baixo < alto) {
            int pi = particao(numeros, baixo, alto);

            quickSort(numeros, baixo, pi - 1);
            quickSort(numeros, pi + 1, alto);
        }
    }

    private int particao(List<Integer> numeros, int baixo, int alto) {
        int pivo = numeros.get(alto);
        int i = (baixo - 1);
        for (int j = baixo; j < alto; j++) {
            if (numeros.get(j) < pivo) {
                i++;

                int temp = numeros.get(i);
                numeros.set(i, numeros.get(j));
                numeros.set(j, temp);
            }
        }

        int temp = numeros.get(i + 1);
        numeros.set(i + 1, numeros.get(alto));
        numeros.set(alto, temp);

        return i + 1;
    }

    public void mostrarNumeros() {
        view.mostrarNumeros(model.obterNumeros());
    }

    public static void main(String[] args) {
        NumerosModel model = new NumerosModel();
        NumerosView view = new NumerosView();
        NumerosController controller = new NumerosController(model, view);

        int[] numeros = {10, 7, 8, 9, 1, 5, 6, 3, 4, 2};

        controller.adicionarNumeros(numeros);
        controller.mostrarNumeros();

        controller.ordenarNumerosInsertionSort();
        controller.mostrarNumeros();

        controller.ordenarNumerosQuickSort();
        controller.mostrarNumeros();
    }
}