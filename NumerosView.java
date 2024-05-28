package Codigo;

import java.util.List;

public class NumerosView extends NumerosController{
    public NumerosView(NumerosModel model, NumerosView view) {
		super(model, view);
		// TODO Auto-generated constructor stub
	}

	public void mostrarNumeros(List<Integer> numeros) {
        System.out.println("Números armazenados: " + numeros);
    }
}
