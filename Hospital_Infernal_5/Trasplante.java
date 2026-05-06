package Hospital_Infernal_5;

public class Trasplante {
	private TipoOrgano organo;
	private Paciente donante;
	private Paciente receptor;

	public Trasplante(TipoOrgano organo, Paciente donante, Paciente receptor) {
		this.organo = organo;
		this.donante = donante;
		this.receptor = receptor;
		this.realizarTrasplantament();
	}

	public void realizarTrasplantament() {
		    System.out.println("====== INICIANDO OPERACIÓN DE TRASPLANTE ======");
		    System.out.println("Órgano a trasplantar: " + this.organo);
		    System.out.println("\n[PASO 1: Extracción en Donante]");
		    for (Organo o : this.donante.getOrganos().keySet()) {
		        if (o.getTipo() == this.organo) {
		            this.donante.getOrganos().put(o, false);
		            System.out.println("-> ÉXITO: Órgano " + o.getTipo() + " extraído del donante (Estado: FALSE)");
		            break;
		        }
		    }
		    System.out.println("\n[PASO 2: Implante en Receptor]");
		    boolean exitoReceptor = false;
		    for (Organo o : this.receptor.getOrganos().keySet()) {
		        if (o.getTipo() == this.organo) {
		            this.receptor.getOrganos().put(o, true);
		            System.out.println("-> ÉXITO: Órgano " + o.getTipo() + " implantado en receptor (Estado: TRUE)");
		            exitoReceptor = true;
		            break;
		        }
		    }
		    System.out.println("\n===============================================");
		    if (exitoReceptor) {
		        System.out.println("RESULTADO: Trasplante finalizado correctamente.");
		    } else {
		        System.out.println("RESULTADO: Error crítico en la cirugía.");
		    }
		    System.out.println("===============================================");
		}
}