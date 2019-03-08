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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	private JTextArea textTwit = new JTextArea();
	private JLabel nbCaracteres = new JLabel("Nombre de caractères: 0");

	
	public TwitupCreateTwit(IObserverCreateTwit observer) {
		this.observer = observer;
		Border compound = null;
		this.setBorder(BorderFactory.createTitledBorder(compound, "",TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM));
		this.setBackground(Color.WHITE);
		this.textTwit.setPreferredSize(new Dimension(screenSize.width/3, screenSize.height/8));
		this.textTwit.setLineWrap(true);
		this.setLayout(new GridBagLayout());
		this.add(textTwit,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		JPanel buttonCreateTwit = new JPanel();
		buttonCreateTwit.add(nbCaracteres);
		buttonCreateTwit.add(creationTwit);
		buttonCreateTwit.setBackground(Color.white);
		this.add(buttonCreateTwit,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.SOUTH,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		this.addAction();
	}

	private void addAction(){
		this.creationTwit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyAddTwit(textTwit.getText());
				textTwit.setText("");
			}
		});

		this.textTwit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						nbCaracteres.setText("Nombre de caractères: "+ textTwit.getText().length());
						if(textTwit.getText().length() > 150){
							try {
								nbCaracteres.setText("Nombre de caractères: 150");
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
