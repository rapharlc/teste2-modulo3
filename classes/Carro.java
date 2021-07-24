package classes;

import java.util.InputMismatchException;

public class Carro {
    private String letrasPlaca;
    private int numerosPlaca;
    private int numChassi;
    private int velocidadeAtual;

    public Carro(String placa, int numChassi) {
        setPlaca(placa);
        this.numChassi = numChassi;
    }
  
    //#region Getters / Setters
    public String getPlaca() {
        if(letrasPlaca == null) {
            return letrasPlaca;
        } else {
            return letrasPlaca + numerosPlaca;
        }
    }

    public void setPlaca(String placa) {
        if(placa != null && placa.matches("[A-Z]{3}\\d{4}")) {
            letrasPlaca = placa.substring(0, 3);
            numerosPlaca = Integer.parseInt(placa.substring(3));
        } else {
            throw new InputMismatchException("A placa deve ter 3 letras e 4 números");
        }

    }

    public int getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(int numChassi) {
        this.numChassi = numChassi;
    }
    
    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }
    //#endregion

    //#region Métodos de pacote
    void acelerar() {
        velocidadeAtual++;
    }

    void acelerar(int limite) {
        for(int i = 0; i < limite; i++) {
            velocidadeAtual++;
        }
    }
    //#endregion
}