package Hospital_Infernal_4;

public interface Intervencion {

	public default boolean puedeAsignarse(Paciente_Hospitalizado pac) {
		if (pac.getIntervencionAsignada() == null && pac.getGravedad().equals(Gravedad.CRITICA)) {
			return true;
		} else {
			return false;
		}
	}

	public default boolean intervencionMalAplicada(Paciente_Hospitalizado pac) {
		for (int i = 0; i < pac.getTratamientosActuales().size(); i++) {
			if (pac.getTratamientosActuales().get(i) instanceof Intervencion) {
				return true;
			}
		}
		return false;
	}

	public abstract void asignar(Paciente_Hospitalizado pac);

	public abstract void realizar(Paciente_Hospitalizado pac);
}