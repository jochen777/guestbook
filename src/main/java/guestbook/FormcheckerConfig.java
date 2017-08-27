package guestbook;

import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import de.jformchecker.FormChecker;
import de.jformchecker.FormCheckerConfig;
import de.jformchecker.themes.BasicBootstrapFormBuilder;

@Service
public class FormcheckerConfig {

	private MessageSource messageSource;
	
	FormcheckerConfig(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	FormCheckerConfig config = new FormCheckerConfig(getMessageSource(), new BasicBootstrapFormBuilder());
	
	public FormChecker runFc(Map<String, String> params, GuestbookForm gf) {
		FormChecker fc = FormChecker.build((k) -> params.get(k), gf);
		fc.setConfig(config);
		fc.run();
		return fc;
	}

	public  GuestbookForm buildForm() {
		GuestbookForm form = new GuestbookForm(getMessageSource());
		return form;
	}
	
	private de.jformchecker.message.MessageSource getMessageSource() {
		return key -> messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}
}
