package Hospital_Infernal_4;

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

	}

	@Override
	public void realizar(Paciente_Hospitalizado pac) {

	}

	@Override
	public void administrar(Paciente_Hospitalizado pac) {
		this.asignar(pac);
	}
}
