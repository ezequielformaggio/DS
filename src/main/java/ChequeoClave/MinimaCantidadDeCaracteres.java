package ChequeoClave;

public class MinimaCantidadDeCaracteres implements ChequeoDeCalidadDeClave {

	private static final Integer CANTIDAD_MINIMA_DE_CARACTERES = 8;

	public Boolean esValida(String clave) {
		return clave.length() >= CANTIDAD_MINIMA_DE_CARACTERES;
	}

}
