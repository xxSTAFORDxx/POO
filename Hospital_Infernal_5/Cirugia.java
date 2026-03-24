package Hospital_Infernal_5;

import java.util.Random;

public class Cirugia extends Tratamiento implements Intervencion {

	private boolean exitosa;

	public Cirugia(String nombre) {
		super(nombre);
		Random random = new Random();
		this.exitosa = random.nextBoolean();
	}

	@Override
	public void asignar(Paciente_Hospitalizado pac) {
		pac.setIntervencionAsignada(this);
	}

	@Override
	public void realizar(Paciente_Hospitalizado pac) {
		if (pac.getIntervencionAsignada() == this) {
			if (exitosa) {
				pac.setGravedad(Gravedad.MODERADA);
			}
			{
				pac.setIntervencionAsignada(null);
			}
		}
	}

	@Override
	public void administrar(Paciente_Hospitalizado pac) {
		this.asignar(pac);
	}
}
