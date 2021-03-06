package com.test;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Logger;

public class AbaEncaminhamento implements ObservadorEncaminhamentoDto, Serializable {
    private static final Logger LOGGER = Logger.getLogger(AbaEncaminhamento.class.getName());

    @Inject
    public AbaEncaminhamento(ObserverEncaminhamentoDto observerEncaminhamentoDto) {
        observerEncaminhamentoDto.registrarObservador(this);
    }

    @Override
    public void setDto(Dto dto) {
        LOGGER.info("[setDto] dto=" + dto);
    }
}
