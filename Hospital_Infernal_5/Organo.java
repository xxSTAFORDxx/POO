package Hospital_Infernal_5;

public class Organo {

	Tipo_Organo tipo;
	boolean sano;

	public Organo(Tipo_Organo tipoRecibido) {
		this.tipo = tipoRecibido;
		this.sano = true;
	}

	public Tipo_Organo getTipo() {
		return tipo;
	}

	public boolean isSano() {
		return sano;
	}

	public void setSano(boolean sano) {
		this.sano = sano;
	}
}