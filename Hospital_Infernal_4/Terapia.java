package Hospital_Infernal_4;

import java.util.Random;

public class Terapia extends Tratamiento {

	Tipo_Terapia tipoT;

	public Terapia(String nombre, Tipo_Terapia tipo) {
		super(nombre);
		this.tipoT = tipo;
	}

	@Override
	public void administrar(Paciente_Hospitalizado pac) {
		Random random = new Random();
		int efectividad = 0;
		if (this.getCantidad() > 0) {
			if (pac.getDiagnostico().equals(Diagnostico.ESGUINCE) && this.tipoT.equals(Tipo_Terapia.FISIO)) {
				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ANSIEDAD) && this.tipoT.equals(Tipo_Terapia.PSICO)) {

				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ESTREÑIMIENTO) && this.tipoT.equals(Tipo_Terapia.NUTRICIONAL)) {
				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.DIABETES) && this.tipoT.equals(Tipo_Terapia.NUTRICIONAL)) {
				efectividad = random.nextInt(80, 100);
			}
			if (this.tipoT.equals(Tipo_Terapia.TIMO)) {
				efectividad = 0;
			}
		}
		this.cantidad--;
	}

}
