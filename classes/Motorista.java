package classes;

public class Motorista extends Pessoa {
    private int matricula;
    private String habilitacao;
    private Carro veiculoAtual;

    public Motorista() {}

    public Motorista(Carro veiculoAtual) {
        this.veiculoAtual = veiculoAtual;
    }

    //#region Getters / Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public Carro getVeiculoAtual() {
        return veiculoAtual;
    }

    public void setVeiculoAtual(Carro veiculoAtual) {
        this.veiculoAtual = veiculoAtual;
    }
    //#endregion

    //#region Métodos relacionados ao exercício do Carro
    /*
    O método acelerar() em Motorista NÃO É o mesmo método acelerar() em Carro.
    Este método é um encapsulamento da DELEGAÇÃO que motorista faz a carro quando
    precisa acelerar. Assim como no mundo real.
    Você poderia chamar de pisaFundo() ou qualquer outro nome que lhe faça sentido,
    por exemplo.
     */
    public void pisaFundo() {
        veiculoAtual.acelerar();//Fazer isso é pisar no pedal de acelerar
    }

    public void pisaFundo(int limite) {
        veiculoAtual.acelerar(limite);
    }
    //#endregion

    @Override
    public String cumprimentar() {
        return "Olá, passageiro!";
    }
}