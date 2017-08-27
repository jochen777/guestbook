package guestbook;


import de.jformchecker.FormCheckerForm;
import de.jformchecker.criteria.Criteria;
import de.jformchecker.elements.LongTextInput;
import de.jformchecker.elements.TextInput;
import de.jformchecker.message.MessageSource;

public class GuestbookForm extends FormCheckerForm{

	TextInput name = TextInput.build("name");
	LongTextInput text = LongTextInput.build("text");
	
	public GuestbookForm(MessageSource messageSource) {
		name.setDescription(messageSource.getMessage("guestbook.form.name"));
		name.setCriterias(Criteria.maxLength(10), Criteria.startsWith("Pe"));
		name.setRequired();
		text.setDescription(messageSource.getMessage("guestbook.form.text"));
		text.setRequired();
		this.setSubmitLabel(messageSource.getMessage("guestbook.form.submit"));
	}

	@Override
	public void init() {
		add(name);
		add(text);
	}

	GuestbookEntry toNewEntry() {
		return new GuestbookEntry(name.getValue(), text.getValue());
	}
	
}
