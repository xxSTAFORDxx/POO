package Hospital_Infernal_4;

import java.util.Random;

public class Medicamento extends Tratamiento {

	Tipo_Medicamento tipoM;

	public Medicamento(String nombre, Tipo_Medicamento tipo) {
		super(nombre);
		this.tipoM = tipo;
	}

	public Tipo_Medicamento getTipoM() {
		return tipoM;
	}

	@Override
	public void administrar(Paciente_Hospitalizado pac) {
		Random random = new Random();
		int efectividad = 0;
		if (this.getCantidad() > 0) {
			if (pac.getDiagnostico().equals(Diagnostico.IBACTERIANA)
					&& this.tipoM.equals(Tipo_Medicamento.ANTIBIOTICO)) {
				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.DIABETES)
					&& this.tipoM.equals(Tipo_Medicamento.ANTIDIABETICO)) {

				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.TOS) && this.tipoM.equals(Tipo_Medicamento.ANTITUSIVO)) {
				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ESGUINCE) && this.tipoM.equals(Tipo_Medicamento.ANALGESICO)) {
				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ANSIEDAD) && this.tipoM.equals(Tipo_Medicamento.ANSIOLITICO)) {
				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ALERGIA)
					&& this.tipoM.equals(Tipo_Medicamento.ANTIHISTAMINICO)) {
				efectividad = random.nextInt(80, 100);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ALERGIA) && this.tipoM.equals(Tipo_Medicamento.ANALGESICO)) {
				efectividad = random.nextInt(40, 70);
			}
			if (pac.getDiagnostico().equals(Diagnostico.IVIRICA) && this.tipoM.equals(Tipo_Medicamento.ANTIBIOTICO)) {
				efectividad = random.nextInt(40, 70);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ANSIEDAD) && this.tipoM.equals(Tipo_Medicamento.ANTITUSIVO)) {
				efectividad = random.nextInt(40, 70);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ESTREÑIMIENTO)
					&& this.tipoM.equals(Tipo_Medicamento.ANTIDIABETICO)) {
				efectividad = random.nextInt(40, 70);
			}
			if (pac.getDiagnostico().equals(Diagnostico.DIABETES)
					&& this.tipoM.equals(Tipo_Medicamento.ANTIHISTAMINICO)) {
				efectividad = random.nextInt(40, 70);
			}
			if (pac.getDiagnostico().equals(Diagnostico.TOS) && this.tipoM.equals(Tipo_Medicamento.ANSIOLITICO)) {
				efectividad = random.nextInt(40, 70);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ESGUINCE)
					&& this.tipoM.equals(Tipo_Medicamento.ANTIDIABETICO)) {
				efectividad = random.nextInt(10, 30);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ANSIEDAD) && this.tipoM.equals(Tipo_Medicamento.ANTIBIOTICO)) {
				efectividad = random.nextInt(10, 30);
			}
			if (pac.getDiagnostico().equals(Diagnostico.DIABETES) && this.tipoM.equals(Tipo_Medicamento.ANTITUSIVO)) {
				efectividad = random.nextInt(10, 30);
			}
			if (pac.getDiagnostico().equals(Diagnostico.IBACTERIANA)
					&& this.tipoM.equals(Tipo_Medicamento.ANTIHISTAMINICO)) {
				efectividad = random.nextInt(10, 30);
			}
			if (pac.getDiagnostico().equals(Diagnostico.ESTREÑIMIENTO)
					&& this.tipoM.equals(Tipo_Medicamento.ANSIOLITICO)) {
				efectividad = random.nextInt(10, 30);
			}
			if (pac.getDiagnostico().equals(Diagnostico.IVIRICA) && this.tipoM.equals(Tipo_Medicamento.ANALGESICO)) {
				efectividad = random.nextInt(10, 30);
			}
		}
		this.cantidad--;
	}
}
