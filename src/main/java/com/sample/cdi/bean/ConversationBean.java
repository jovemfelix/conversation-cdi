package com.sample.cdi.bean;

import com.test.AbaEncaminhamento;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@ConversationScoped
public class ConversationBean implements Serializable {
    private static final long serialVersionUID = 123;
    private static final Logger LOGGER = Logger.getLogger(ConversationBean.class.getName());

    @Inject
    private Conversation conversation;

    @Inject
    private AbaEncaminhamento abaEncaminhamento;

    @Inject
    private HttpServletRequest request;

    private int counter;

    public ConversationBean() {
        LOGGER.info("[constructor] abaEncaminhamento=" + abaEncaminhamento + getUri());
        System.out.println("[constructor] abaEncaminhamento=" + abaEncaminhamento + getUri());
    }

    // Will only be called once
    // during bean initialization
    @PostConstruct
    public void init() {
        counter = 0;
        System.out.println("[init] abaEncaminhamento=" + abaEncaminhamento + getUri());
    }

    public void initConversation() {
        if (!FacesContext.getCurrentInstance().isPostback()
                && conversation.isTransient()) {

            conversation.begin();
        }
    }

    public void increment() {
        counter++;
    }

    public String handleFirstStepSubmit() {
        return "step2?faces-redirect=true";
    }

    public String endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "step1?faces-redirect=true";
    }

    public int getCounter() {
        System.out.println("[counter] abaEncaminhamento=" + abaEncaminhamento + getUri());
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public String getUri() {
        if (request == null)
            return " uri=NULL";

        return " uri=" + request.getRequestURI();
    }
}
