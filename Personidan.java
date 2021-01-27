import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Person extends ClubAbstractEntity {
    protected String idS;
    protected String nameS;
    protected String surnameS;
    protected String telS;
    protected JTextField idJ;
    protected JTextField nameJ;
    protected JTextField surnameJ;
    protected JTextField telJ;
    // constructor
    public Person(String idS, String nameS, String surnameS, String telS){
        super();
        this.idS=idS;
        this.nameS=nameS;
        this.surnameS=surnameS;
        this.telS=telS;
        this.idJ= new JTextField();
        this.nameJ= new JTextField();
        this.surnameJ= new JTextField();
        this.telJ= new JTextField();

        JFrame main = new JFrame("Person Clubber's Data");
        main.setSize(450,220); // fit in 50% screen size
        main.setLocationRelativeTo(null);
        nameJ = new JTextField(10);
        idJ = new JTextField(10);
        surnameJ = new JTextField(10);
        telJ = new JTextField(10);
        JPanel gui = new JPanel(new BorderLayout(3,3));
        gui.setBorder(new EmptyBorder(5,5,5,5));
        main.setContentPane(gui);
        JPanel labels = new JPanel(new GridLayout(0,1));
        JPanel controls = new JPanel(new GridLayout(0,1));
        gui.add(labels, BorderLayout.WEST);
        gui.add(controls, BorderLayout.CENTER);
        labels.add(new JLabel("Id: "));
        controls.add(idJ);
        labels.add(new JLabel("Name: "));
        controls.add(nameJ);
        labels.add(new JLabel("Surname: "));
        controls.add(surnameJ);
        labels.add(new JLabel("Tel: "));
        controls.add(telJ);
        main.pack();
        main.setVisible(true);


    }
    public boolean match(String key) {
        return (key==this.idS);
    }
    protected boolean validateData() {
        String idCurrent=idJ.getText();
        String nameCurrent=nameJ.getText();
        String telCurrent=telJ.getText();
        String surnameCurrent=surnameJ.getText();

        return( idCurrent.matches("([0-9]-\\d{7}\\|[1-9])")
                && nameCurrent.matches("[A-Z][a-z]*")
                && surnameCurrent.matches("[A-Z][a-z]*(['-][a-zA-Z]+)*")
                && telCurrent.matches("\\+\\([1-9]\\d{0,2}\\)[1-9]\\d{0,2}-[1-9]\\d{6}")
        );

    }
    protected void commit() {
        this.idS=idJ.getText();
        this.nameS=nameJ.getText();
        this.telS=telJ.getText();
        this.surnameS=surnameJ.getText();
    }
    protected void rollBack() {
        this.idJ.setText(idS);
        this.nameJ.setText(nameS);
        this.telJ.setText(telS);
        this.surnameJ.setText(surnameS);
    }

}
