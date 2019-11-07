package com.company;

public enum ConstantesDeTempo {
    DIA_EM_MILISEGNUDOS(84600000L),
    DIA_EM_HORAS(24);

    private long unidadeDeTempo;

    ConstantesDeTempo(long l) {
        this.unidadeDeTempo = l;
    }

    public long getUnidadeDeTempo() {
        return unidadeDeTempo;
    }
}
