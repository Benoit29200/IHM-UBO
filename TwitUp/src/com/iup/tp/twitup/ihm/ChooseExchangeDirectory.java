package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.core.Twitup;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChooseExchangeDirectory extends JFrame {

    private JFileChooser fileChooser = new JFileChooser();
    protected ResourceBundle fileLanguage;
    private JPanel content;
    private JLabel message;
    private Twitup twitup;


    public ChooseExchangeDirectory(Twitup twitup){
        super();
        this.fileLanguage = ResourceBundle.getBundle(Constants.MENU, Locale.getDefault());
        this.twitup = twitup;
        this.content = new JPanel();
        this.message = new JLabel(this.fileLanguage.getObject(Constants.MESSAGE_CHOOSE_DIRECTORY).toString());
        this.message.setForeground(Color.RED);
        this.setContentPane(content);
        content.add(this.message);
        content.add(fileChooser,BorderLayout.CENTER);

        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);


        switch (fileChooser.showOpenDialog(this))
        {
            case JFileChooser.APPROVE_OPTION:

                this.twitup.setmExchangeDirectoryPath(this.fileChooser.getSelectedFile().getPath());
                this.twitup.init();
                break;

            case JFileChooser.CANCEL_OPTION:
                System.exit(0);
                break;
        }

    }

    public void showGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Custom de l'affichage
                setIconImage(new ImageIcon("/resources/images/logoIUP_20.jpg").getImage());
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(true);
            }
        });
    }
}
