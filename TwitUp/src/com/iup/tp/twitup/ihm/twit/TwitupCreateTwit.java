package com.iup.tp.twitup.ihm.twit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.datamodel.createTwit.IObservableCreateTwit;
import com.iup.tp.twitup.datamodel.createTwit.IObserverCreateTwit;

public class TwitupCreateTwit extends JPanel implements IObservableCreateTwit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObserverCreateTwit observer;
	
	private ResourceBundle fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());


	private JButton creationTwit = new JButton(this.fileLanguage.getObject(Constants.CREATION_TWIT).toString());

	private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField textTwit = new JTextField();
	private JLabel nbCaracteres = new JLabel("Nombre de caractères: 0");

	
	public TwitupCreateTwit(IObserverCreateTwit observer) {
		this.observer = observer;
		Border compound = null;
		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.textTwit.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/8));
		this.add(textTwit);
		this.add(creationTwit);
		this.add(nbCaracteres);
		this.addAction();
	}

	private void addAction(){
		this.creationTwit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyAddTwit(textTwit.getText());
			}
		});

		this.textTwit.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

					int nb = textTwit.getText().length()+1;
				System.out.println(nb);
					nbCaracteres.setText("Nombre de caractères: "+ nb);

				if(textTwit.getText().length() > 150){
					try {
						textTwit.setText(textTwit.getText(0, 149));
					} catch (BadLocationException ble) { ble.printStackTrace(); }
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
	}


	@Override
	public void addObserver(IObserverCreateTwit o) {
		this.observer = o;
	}

	@Override
	public void deleteObserver() {
		this.observer = null;
	}

	@Override
	public void notifyAddTwit(String twitTexte) {
		this.observer.addTwit(twitTexte);
	}
}
