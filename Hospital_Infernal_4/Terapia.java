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
		if (pac.getDiagnostico().equals(Diagnostico.IBACTERIANA) && this.tipoM.equals(Tipo_Medicamento.ANTIBIOTICO)) {
			int efectividad = random.nextInt(80, 100);
		}
		if (pac.getDiagnostico().equals(Diagnostico.DIABETES) && this.tipoM.equals(Tipo_Medicamento.ANTIDIABETICO)) {

			int efectividad = random.nextInt(80, 100);
		}
		if (pac.getDiagnostico().equals(Diagnostico.TOS) && this.tipoM.equals(Tipo_Medicamento.ANTITUSIVO)) {
			int efectividad = random.nextInt(80, 100);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ESGUINCE) && this.tipoM.equals(Tipo_Medicamento.ANALGESICO)) {
			int efectividad = random.nextInt(80, 100);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ANSIEDAD) && this.tipoM.equals(Tipo_Medicamento.ANSIOLITICO)) {
			int efectividad = random.nextInt(80, 100);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ALERGIA) && this.tipoM.equals(Tipo_Medicamento.ANTIHISTAMINICO)) {
			int efectividad = random.nextInt(80, 100);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ALERGIA) && this.tipoM.equals(Tipo_Medicamento.ANALGESICO)) {
			int efectividad = random.nextInt(40, 70);
		}
		if (pac.getDiagnostico().equals(Diagnostico.IVIRICA) && this.tipoM.equals(Tipo_Medicamento.ANTIBIOTICO)) {
			int efectividad = random.nextInt(40, 70);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ANSIEDAD) && this.tipoM.equals(Tipo_Medicamento.ANTITUSIVO)) {
			int efectividad = random.nextInt(40, 70);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ESTREÑIMIENTO) && this.tipoM.equals(Tipo_Medicamento.ANTIDIABETICO)) {
			int efectividad = random.nextInt(40, 70);
		}
		if (pac.getDiagnostico().equals(Diagnostico.DIABETES) && this.tipoM.equals(Tipo_Medicamento.ANTIHISTAMINICO)) {
			int efectividad = random.nextInt(40, 70);
		}
		if (pac.getDiagnostico().equals(Diagnostico.TOS) && this.tipoM.equals(Tipo_Medicamento.ANSIOLITICO)) {
			int efectividad = random.nextInt(40, 70);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ESGUINCE) && this.tipoM.equals(Tipo_Medicamento.ANTIDIABETICO)) {
			int efectividad = random.nextInt(10, 30);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ANSIEDAD) && this.tipoM.equals(Tipo_Medicamento.ANTIBIOTICO)) {
			int efectividad = random.nextInt(10, 30);
		}
		if (pac.getDiagnostico().equals(Diagnostico.DIABETES) && this.tipoM.equals(Tipo_Medicamento.ANTITUSIVO)) {
			int efectividad = random.nextInt(10, 30);
		}
		if (pac.getDiagnostico().equals(Diagnostico.IBACTERIANA) && this.tipoM.equals(Tipo_Medicamento.ANTIHISTAMINICO)) {
			int efectividad = random.nextInt(10, 30);
		}
		if (pac.getDiagnostico().equals(Diagnostico.ESTREÑIMIENTO) && this.tipoM.equals(Tipo_Medicamento.ANSIOLITICO)) {
			int efectividad = random.nextInt(10, 30);
		}
		if (pac.getDiagnostico().equals(Diagnostico.IVIRICA) && this.tipoM.equals(Tipo_Medicamento.ANALGESICO)) {
			int efectividad = random.nextInt(10, 30);
		}
	}
		
	}

