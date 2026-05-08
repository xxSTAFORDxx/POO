package Hospital_Infernal_5;

public class Trasplante {

	private Tipo_Organo organo;
	private Paciente donante;
	private Paciente receptor;

	public Trasplante(Tipo_Organo organo, Paciente donante, Paciente receptor) {
		this.organo = organo;
		this.donante = donante;
		this.receptor = receptor;
		this.realizarTrasplante();
	}

	public void realizarTrasplante() {
		System.out.println("====== INICIANDO OPERACIÓN DE TRASPLANTE ======");
		this.donante.getOrganos().put(this.organo, false);
		this.receptor.getOrganos().put(this.organo, true);
		System.out.println("-> ÉXITO: Trasplante de " + this.organo + " completado.");
		System.out.println("===============================================");
	}
}