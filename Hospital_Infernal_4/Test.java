package Hospital_Infernal_4;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Medico marc = new Medico("Marc");
		marc.diElNombre();
		System.out.println(marc.getAñosTrabajados());
		marc.augmentarAñosTrabajados();
		System.out.println(marc.getAñosTrabajados());

		Medico faustino = new Medico("Dr.Faustino");
		System.out.println(faustino.getSueldo());
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		faustino.augmentarAñosTrabajados();
		System.out.println(faustino.getSueldo());

		Medico perDefecte = new Medico();
		System.out.println(perDefecte.getNombre());
		Medico house = new Medico("House");
		System.out.println(house.getNombre() + " " + house.getSueldo());
		Medico wilson = new Medico("Wilson", 10);
		System.out.println(wilson.getNombre() + " " + wilson.getAñosTrabajados());

		Medico marc2 = new Medico("marc", Categoria.ESPECIALISTA);
		System.out.println(marc2.getNombre() + " " + marc2.getSueldo());
		if (marc2.getCategoria().equals(Categoria.ESPECIALISTA)) {
			System.out.println("Marc es un Especialista!");
		}

		Medico faustino2 = new Medico("Dr. Faustino", "General", 1000.0, 0);

		System.out.println("Sueldo Faustino (esperado aprox 1181.37): " + faustino2.getSueldo());

		Medico house2 = new Medico("Dr. House", Categoria.ESPECIALISTA);
		Paciente p = new Paciente("Juan", 100.0, 20, Gravedad.LEVE);

		System.out.println("Dinero Juan antes: " + p.getDinero());
		house2.consulta(p);
		System.out.println("Dinero Juan después: " + p.getDinero());
		System.out.println("Sueldo House después de cobrar: " + house2.getSueldo());

		Paciente p1 = new Paciente("Yago", 29);

		Paciente_Hospitalizado yagoEnPlanta = p1.hospitalizar("Reposo total");

		Paciente dani = new Paciente();
		dani.estatic = "hola";
		Paciente claudia = new Paciente();
		claudia.estatic = "adeu";
		System.out.println(dani.estatic);

	}
}