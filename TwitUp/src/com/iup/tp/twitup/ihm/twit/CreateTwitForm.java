package com.iup.tp.twitup.ihm.twit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.communicationInterface.vueController.createTwit.IObservableCreateTwit;
import com.iup.tp.twitup.communicationInterface.vueController.createTwit.IObserverCreateTwit;

public class CreateTwitForm extends TwitMother implements IObservableCreateTwit {


	private IObserverCreateTwit observer;

	private JButton creationTwit;

	private JTextArea textTwit;
	private JLabel nbCaracteres;

	
	/**
	 * Constructeur
	 * @param observer
	 */
	public CreateTwitForm(IObserverCreateTwit observer) {
		this.initComponent();
		this.addObserver(observer);
		this.setBorder(BorderFactory.createTitledBorder(null, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		
		configurationTextTwit();
		
		this.setLayout(new GridBagLayout());
		this.addInto(this,textTwit,0,0,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE,5,5,0,5,0,0);
		addButtonCreateTwit();
		this.addAction();
	}

	private void initComponent(){
		this.creationTwit = new JButton(this.fileLanguage.getObject(Constants.CREATION_TWIT).toString());
		this.textTwit = new JTextArea(3,50);
		this.nbCaracteres = new JLabel("Nombre de caractères: 0");
		revalidate();
		repaint();
	}

	/**
	 * Permet de configurer le JTextArea textTwit
	 */
	private void configurationTextTwit() {
		this.textTwit.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/8));
		this.textTwit.setLineWrap(true);
		this.textTwit.setBorder(new LineBorder(Color.black,2));
	}

	/**
	 * Permet d'ajouter le bouton de création d'un twit
	 */
	private void addButtonCreateTwit() {
		JPanel buttonCreateTwit = new JPanel();
		buttonCreateTwit.add(nbCaracteres);
		buttonCreateTwit.add(creationTwit);
		buttonCreateTwit.setBackground(Color.white);
		this.addInto(this, buttonCreateTwit,0,0,1,1,1,1,GridBagConstraints.SOUTH, GridBagConstraints.NONE,5,5,0,5,0,0);
	}

	/**
	 * Permet de définir une action lors de la création d'un twit
	 */
	private void addAction(){
		this.creationTwit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyAddTwit(textTwit.getText());
				textTwit.setText("");
				nbCaracteres.setText("Nombre de caractères: 0 ");
			}
		});

		this.textTwit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if(textTwit.getText().length() <= 150){
							nbCaracteres.setText("Nombre de caractères: "+ textTwit.getText().length());
						}
						else{
							try {
								textTwit.setText(textTwit.getText(0, 150));

							} catch (BadLocationException ble) { ble.printStackTrace(); }
						}
					}
				});
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
