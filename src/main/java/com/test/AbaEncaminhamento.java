package com.test;

import java.io.Serializable;
import java.util.logging.Logger;

public class AbaEncaminhamento implements ObservadorEncaminhamentoDto, Serializable {
    private static final Logger LOGGER = Logger.getLogger(AbaEncaminhamento.class.getName());

    public AbaEncaminhamento() {
        LOGGER.info("[constructor] AbaEncaminhamento (this) =" + this);
    }

    @Override
    public void setDto(Dto dto) {
        LOGGER.info("[setDto] dto=" + dto);
    }
}
