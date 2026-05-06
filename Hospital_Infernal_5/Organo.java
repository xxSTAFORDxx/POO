package Hospital_Infernal_5;

public class Organo {
	TipoOrgano tipo;
	boolean sano;

	public Organo(TipoOrgano tipoRecibido) {
		this.tipo = tipoRecibido;
		this.sano = true;
	}

	public TipoOrgano getTipo() {
		return tipo;
	}

	public boolean isSano() {
		return sano;
	}

	public void setSano(boolean sano) {
		this.sano = sano;
	}
}