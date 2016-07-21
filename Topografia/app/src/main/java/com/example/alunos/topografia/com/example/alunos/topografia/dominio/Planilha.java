package com.example.alunos.topografia.com.example.alunos.topografia.dominio;

/**
 * Created by alunos on 04/06/16.
 */
public class Planilha {

    public String NomeEstacao;
    public String PontoVisado;

    public String getNomeEstacao() {
        return NomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.NomeEstacao = nomeEstacao;
    }

    public String getPontoVisado() {
        return PontoVisado;
    }

    public void setPontoVisado(String pontoVisado) {
        PontoVisado = pontoVisado;
    }

    public int getGrauHorizontal() {
        return GrauHorizontal;
    }

    public void setGrauHorizontal(int grauHorizontal) {
        GrauHorizontal = grauHorizontal;
    }

    public int getMinutoHorizontal() {
        return MinutoHorizontal;
    }

    public void setMinutoHorizontal(int minutoHorizontal) {
        MinutoHorizontal = minutoHorizontal;
    }

    public int getSegundoHorizontal() {
        return SegundoHorizontal;
    }

    public void setSegundoHorizontal(int segundoHorizontal) {
        SegundoHorizontal = segundoHorizontal;
    }

    public int getFioSuperior() {
        return FioSuperior;
    }

    public void setFioSuperior(int fioSuperior) {
        FioSuperior = fioSuperior;
    }

    public int getFioMedio() {
        return FioMedio;
    }

    public void setFioMedio(int fioMedio) {
        FioMedio = fioMedio;
    }

    public int getFioInferior() {
        return FioInferior;
    }

    public void setFioInferior(int fioInferior) {
        FioInferior = fioInferior;
    }

    public int getGrauVertical() {
        return GrauVertical;
    }

    public void setGrauVertical(int grauVertical) {
        GrauVertical = grauVertical;
    }

    public int getMinutoVertical() {
        return MinutoVertical;
    }

    public void setMinutoVertical(int minutoVertical) {
        MinutoVertical = minutoVertical;
    }

    public int getSegundoVertical() {
        return SegundoVertical;
    }

    public void setSegundoVertical(int segundoVertical) {
        SegundoVertical = segundoVertical;
    }

    public double getAlturaAparelho() {
        return AlturaAparelho;
    }

    public void setAlturaAparelho(double alturaAparelho) {
        AlturaAparelho = alturaAparelho;
    }


    public String toString(){

        String retorno = NomeEstacao + ";" + PontoVisado + ";" + GrauHorizontal + ";" + MinutoHorizontal + ";" + SegundoHorizontal + ";" + FioSuperior + ";" + FioMedio + ";" + FioInferior + ";" + GrauVertical + ";" + MinutoVertical + ";" + SegundoVertical + ";" + AlturaAparelho + ".";
        return retorno;
    }

    public int GrauHorizontal;
    public int MinutoHorizontal;
    public int SegundoHorizontal;

    public int FioSuperior;
    public int FioMedio;
    public int FioInferior;

    public int GrauVertical;
    public int MinutoVertical;
    public int SegundoVertical;

    public double AlturaAparelho;

}
