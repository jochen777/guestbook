/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guestbook;

import org.hibernate.validator.constraints.NotBlank;

import de.jformchecker.elements.Label;
import de.jformchecker.elements.LabelTranslationKey;
import de.jformchecker.fieldmarkers.LongText;


/**
 * Interface to bind request payloads and make them available in the controller.
 * 
 * @author Oliver Gierke
 * @see GuestbookController#addEntry(GuestbookForm, org.springframework.validation.Errors, org.springframework.ui.Model)
 */
public class GuestbookForm {

	/**
	 * Returns the value bound to the {@code name} attribute of the request.
	 * 
	 * @return
	 */
	@NotBlank
	@LabelTranslationKey("guestbook.form.name")
	public String name;

	/**
	 * Returns the value bound to the {@code text} attribute of the request.
	 * 
	 * @return
	 */
	@NotBlank
	@LongText
	@LabelTranslationKey("guestbook.form.text")
	public String text;
	
//	@Min(18)
//	@Label(text="Dein Alter")
//	int age;

	/**
	 * Returns a new {@link GuestbookEntry} using the data submitted in the request.
	 * 
	 * @return
	 */
	public GuestbookEntry toNewEntry() {
		return new GuestbookEntry(name, text);
	}

	
	
	@Override
	public String toString() {
		return "Bean: " + name + " --  " + text;
	}





	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}






//	public int getAge() {
//		return age;
//	}
//
//
//
//	public void setAge(int age) {
//		this.age = age;
//	}


}
