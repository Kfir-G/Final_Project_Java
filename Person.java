import javax.swing.*;
import java.awt.*;
/**
 * Person class which extends ClubAbstractEntity class
 * {@link ClubAbstractEntity}
 */
public class Person extends ClubAbstractEntity
{
    //-----------data fields---------------
    private String idP;       //personal ID
    private String nameP;    //first name
    private String surnameP; //last name
    private String telP;     //telephone

    private JLabel asteriskId;  //lebels of asterisks
    private JLabel asteriskName;
    private JLabel asteriskSurname;
    private JLabel asteriskTel;

    private JTextField idT;
    private JTextField nameT;
    private JTextField surnameT;
    private JTextField telT;

    protected JPanel mainGui;
    
    GridBagConstraints gbc = new GridBagConstraints();
    //----------constructors---------------
    public Person(String idP, String nameP, String surnameP ,String telP){
        super();
        this.idP = idP;
        this.nameP = nameP;
        this.surnameP = surnameP;
        this.telP = telP;

        //JTextFields
        idT= new JTextField(30);
        nameT= new JTextField(30);
        surnameT= new JTextField(30);
        telT= new JTextField(30);
        
        //asterisks label
        this.asteriskId = new JLabel("*");
        this.asteriskName = new JLabel("*");
        this.asteriskSurname = new JLabel("*");
        this.asteriskTel = new JLabel("*");

        setSize(450,220);
        setTitle("Person Clubber's Data");

        this.mainGui = new JPanel();
        mainGui.setLayout(new GridBagLayout());

        gbc.insets = new Insets(3,0,3,10);
        gbc.anchor = GridBagConstraints.EAST;

        //sets grid corrdinate each grid
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainGui.add(new JLabel("ID"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainGui.add(idT,gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        mainGui.add(asteriskId,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainGui.add(new JLabel("Name"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainGui.add(nameT,gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        mainGui.add(asteriskName,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainGui.add(new JLabel("Surname"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainGui.add(surnameT,gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        mainGui.add(asteriskSurname,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainGui.add(new JLabel("Tel"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainGui.add(telT,gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        mainGui.add(asteriskTel,gbc);

        //set asterisk to red
        asteriskId.setForeground(Color.RED);
        asteriskName.setForeground(Color.RED);
        asteriskSurname.setForeground(Color.RED);
        asteriskTel.setForeground(Color.RED);

        hideAllAsterisks();

        setVisible(false);
        addToCenter(mainGui);
    } 
    /** 
     * match method is equals the ID
     * @param inputId String type is the user input
     * @return boolean return true if it's equal and return false else
     */
    //----------methods-------------------
    public boolean match(String inputId){
        return inputId.equals(this.idP) ? true: false;
    }
    /**
     * validateData method check if the user input is valid
     * @return boolean return true if the input is valid and false else
     */
    protected boolean validateData(){ 
        hideAllAsterisks();

        boolean validIdCheck = idT.getText().matches("([0-9]-\\d{7}\\|[1-9])");
        boolean validNameCheck = nameT.getText().matches("[A-Z][a-z]*");
        boolean validSureNameCheck = surnameT.getText().matches("[A-Z][a-z]*(['-][a-zA-Z]+)*");
        boolean validTelCheck = telT.getText().matches("\\+\\([1-9]\\d{0,2}\\)[1-9]\\d{0,2}-[1-9]\\d{6}");
        
        if (!validIdCheck) {
            asteriskId.setVisible(true);
        } 
        else if (!validNameCheck) {
            asteriskName.setVisible(true);
        } 
        else if (!validSureNameCheck) {
            asteriskSurname.setVisible(true);
        } 
        else if (!validTelCheck) {
            asteriskTel.setVisible(true);
        } 

        return(validIdCheck && validNameCheck && validTelCheck && validSureNameCheck);
    }
    /**
     * commit method insert the user input to the class class data fields
     */
    protected void commit(){ 
        this.idP = idT.getText();
        this.nameP = nameT.getText();
        this.surnameP = surnameT.getText();
        this.telP = telT.getText();
    }
    /**
     * rollBack method set the texts that was before and hide all the Asterisks
     */
    protected void rollBack(){
        hideAllAsterisks();

        setTexts();
    }
    /**
     * showDetails method show the details of the entity
     */
    protected void showDetails(){
        setTexts();
    }
    /**
     * hideAllAsterisks method hide all asterisks
     */
    protected void hideAllAsterisks(){
        asteriskId.setVisible(false);
        asteriskName.setVisible(false);
        asteriskSurname.setVisible(false);
        asteriskTel.setVisible(false);
    }
    /**
     * setTexts method sets the data fields 
     */
    protected void setTexts(){
        this.idT.setText(idP);
        this.nameT.setText(nameP);
        this.surnameT.setText(surnameP);
        this.telT.setText(telP);
    }
}