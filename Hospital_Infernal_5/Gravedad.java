package Hospital_Infernal_5;

public enum Gravedad {
	LEVE(1), MODERADA(2), GRAVE(3), CRITICA(4);

	private final int nivel;

	Gravedad(int nivel) {
		this.nivel = nivel;
	}

	public int getNivel() {
		return this.nivel;
	}
}