package com.marginallyclever.artPipeline.generators;

import java.beans.PropertyChangeEvent;

import com.marginallyclever.makelangelo.Translator;
import com.marginallyclever.makelangelo.select.SelectInteger;
import com.marginallyclever.makelangelo.select.SelectOneOfMany;
import com.marginallyclever.makelangelo.select.SelectTextArea;

/**
 * Panel for {@link Generator_Text}
 * @author Dan Royer
 *
 */
public class Generator_Text_Panel extends ImageGeneratorPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Generator_Text generator;
	private SelectOneOfMany fontChoices;
	private SelectInteger size;
	private SelectTextArea text;
	
	Generator_Text_Panel(Generator_Text generator) {
		super();
		
		this.generator = generator;

		add(fontChoices = new SelectOneOfMany(Translator.get("FontFace"),generator.getFontNames(),generator.getLastFont()));
		add(size = new SelectInteger(Translator.get("TextSize"),generator.getLastSize()));
		add(text = new SelectTextArea(Translator.get("TextMessage"),generator.getLastMessage()));
		finish();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
		
		generator.setMessage(text.getText());
		generator.setSize(((Number)size.getValue()).intValue());
		generator.setFont(fontChoices.getSelectedIndex());
		generator.generate();
	}
}
