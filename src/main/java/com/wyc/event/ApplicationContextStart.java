package com.wyc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
public class ApplicationContextStart
implements ApplicationListener<ContextStartedEvent>{
	
	
	public void onApplicationEvent(ContextStartedEvent event) {
	System.out.println("Context  Start");
	}
}
