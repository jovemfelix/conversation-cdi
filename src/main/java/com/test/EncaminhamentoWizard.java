package com.test;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Logger;

public class EncaminhamentoWizard implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(EncaminhamentoWizard.class.getName());
    private AbaEncaminhamento abaEncaminhamento;
    @Inject
    public EncaminhamentoWizard(AbaEncaminhamento abaEncaminhamento) {
        this.abaEncaminhamento = abaEncaminhamento;
        LOGGER.info("[constructor] abaEncaminhamento=" + abaEncaminhamento + " this=" + this);
    }
}