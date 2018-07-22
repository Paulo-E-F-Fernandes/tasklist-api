package br.com.paulofernandes.tasklistapi.utils;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

	@Autowired
	private MessageSource messageSource;

	private MessageSourceAccessor acessor;

	@PostConstruct
	private void init() {
		this.acessor = new MessageSourceAccessor(this.messageSource, new Locale("pt", "BR"));
	}

	public String getMessage(String key) {
		return this.acessor.getMessage(key);
	}

}
