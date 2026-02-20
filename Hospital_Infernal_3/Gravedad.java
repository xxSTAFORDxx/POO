package Hospital_Infernal_3;

public enum Gravedad {
    LEVE(1), MODERADA(2), GRAVE(3), CRITICA(4);

    private final int nivel;

    // Constructor del Enum
    Gravedad(int nivel) {
        this.nivel = nivel;
    }

    // Método para obtener el valor
    public int getNivel() {
        return this.nivel;
    }
}