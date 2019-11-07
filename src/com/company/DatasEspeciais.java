package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatasEspeciais {

    private GregorianCalendar dataInicioRelacao;
    private GregorianCalendar aniversarioDeUmAno;
    private GregorianCalendar proximoAniversario;
    private int diaDoAniversario;
    private int mesDoAniversario;
    private final SimpleDateFormat formatoPadrao = new SimpleDateFormat("dd/MM/yyyy");
    private long diasCorridosDaRelacao;

    public DatasEspeciais(GregorianCalendar dataInicioRelacao){
        this.dataInicioRelacao = dataInicioRelacao;
        this.diaDoAniversario = dataInicioRelacao.get(Calendar.DATE);
        this.mesDoAniversario = dataInicioRelacao.get(Calendar.MONTH);
        setAniversarioDeUmAno(dataInicioRelacao);
        setProximoAniversario();
        setDiasCorridosDaRelacao();
    }

    public GregorianCalendar getAniversarioDeUmAno() {
        return aniversarioDeUmAno;
    }

    private void setAniversarioDeUmAno(GregorianCalendar dataInicio) {
        GregorianCalendar novaData = (GregorianCalendar) this.dataInicioRelacao.clone();
        novaData.add(Calendar.YEAR,1);
        this.aniversarioDeUmAno = novaData;
    }

    public GregorianCalendar getProximoAniversario() {
        return proximoAniversario;
    }

    private void setProximoAniversario() {
        GregorianCalendar dataAtual = new GregorianCalendar();
        int anoAtual = dataAtual.get(Calendar.YEAR);
        GregorianCalendar aniversarioAnoAtual = new GregorianCalendar();
        aniversarioAnoAtual.set(anoAtual, this.mesDoAniversario, this.diaDoAniversario,0,0);

        if (dataAtual.before(aniversarioAnoAtual)){
            this.proximoAniversario = aniversarioAnoAtual;
        }else{
            aniversarioAnoAtual.add(Calendar.YEAR,1);
            this.proximoAniversario = aniversarioAnoAtual;
        }

    }

    public String toString(){
        SimpleDateFormat padraoData = new SimpleDateFormat("dd/MM/yyyy");
        String strDataInicio = padraoData.format(this.dataInicioRelacao.getTime());
        String strDataAniversario = padraoData.format(this.aniversarioDeUmAno.getTime());
        String strProximoaniversario = padraoData.format(this.proximoAniversario.getTime());

        String resultado = String.format("inicio da relacao: %s\nAniversario de um ano: %s\nProximo aniversario: %s\nDias contados: %d",
                strDataInicio, strDataAniversario, strProximoaniversario, this.diasCorridosDaRelacao);
        return resultado;
    }

    public void setDataInicioRelacao(GregorianCalendar dataInicioRelacao) {
        this.dataInicioRelacao = dataInicioRelacao;
        setAniversarioDeUmAno(dataInicioRelacao);
        setProximoAniversario();

    }

    public long getDiasCorridosDaRelacao() {
        return this.diasCorridosDaRelacao;
    }

    private void setDiasCorridosDaRelacao() {
        GregorianCalendar dataAtual = new GregorianCalendar();
        long dataInicioEmMiliSegundos = this.dataInicioRelacao.getTimeInMillis();
        long dataAtualEmMiliSegundos = dataAtual.getTimeInMillis();
        long miliSegundosDeUmDia = 86400000L;
        long diasDaRelacao = (dataAtualEmMiliSegundos - dataInicioEmMiliSegundos)/miliSegundosDeUmDia;
        this.diasCorridosDaRelacao = diasDaRelacao;
    }
}
