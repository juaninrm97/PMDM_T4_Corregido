package es.studium.myavatar;

public class Avatar {

    private String nombre;
    private String genero;
    private String especie;
    private String profesion;
    private int vida;
    private int magia;
    private int fuerza;
    private int velocidad;

    // Constructor vacío
    public Avatar() {
        // Valores por defecto para los poderes
        this.vida = 0;
        this.magia = 0;
        this.fuerza = 0;
        this.velocidad = 0;
    }

    // Constructor con parámetros
    public Avatar(String nombre, String genero, String especie, String profesion, int vida, int magia, int fuerza, int velocidad) {
        this.nombre = nombre;
        this.genero = genero;
        this.especie = especie;
        this.profesion = profesion;
        this.vida = vida;
        this.magia = magia;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    // Métodos para obtener poderes
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", especie='" + especie + '\'' +
                ", profesion='" + profesion + '\'' +
                ", vida=" + vida +
                ", magia=" + magia +
                ", fuerza=" + fuerza +
                ", velocidad=" + velocidad +
                '}';
    }
}
