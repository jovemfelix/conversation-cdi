package com.byteslounge.bean;

import com.test.AbaEncaminhamento;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ConversationScoped
public class ConversationBean implements Serializable {
	private static final long serialVersionUID = 123;
	
	@Inject
    private Conversation conversation;

	@Inject
	private AbaEncaminhamento abaEncaminhamento;
	
	private int counter;

	public ConversationBean() {
		System.out.println("[constructor] abaEncaminhamento=" +abaEncaminhamento);
	}

	// Will only be called once
	// during bean initialization
	@PostConstruct
	public void init(){
		counter = 0;
		System.out.println("[init] abaEncaminhamento=" +abaEncaminhamento);
	}
	
	public void initConversation(){
		if (!FacesContext.getCurrentInstance().isPostback() 
			&& conversation.isTransient()) {
			
			conversation.begin();
		}
	}
	
	public void increment(){
		counter++;
	}
	
	public String handleFirstStepSubmit(){
		return "step2?faces-redirect=true";
	}
	
	public String endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
		return "step1?faces-redirect=true";
	}

	public int getCounter() {
		System.out.println("[counter] abaEncaminhamento=" +abaEncaminhamento);
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Conversation getConversation() {
		return conversation;
	}
	
}
