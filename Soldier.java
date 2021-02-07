import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * Soldier class extends Person class 
 * Soldier has an adition field which is student ID
 * {@link Person}, {@link ClubAbstractEntity}
 */
public class Soldier extends Person
{
    //-----------data fields-----------
    private String personalNumP;

    private JLabel asteriskPersonalNum;

    private JTextField personalNumT;
    //-----------constructors----------
    /**
     * 
     * @param idP
     * @param nameP
     * @param surnameP
     * @param telP
     * @param personalNumP
     */
    public Soldier(String idP, String nameP, String surnameP ,String telP,String personalNumP){
        super(idP,nameP,surnameP,telP);
        this.personalNumP = personalNumP;

        personalNumT = new JTextField(30);
        this.asteriskPersonalNum = new JLabel("*");
        asteriskPersonalNum.setForeground(Color.RED);

        setSize(450,220);
        setTitle("Soldier Clubber's Data");

        //sets grid corrdinate each grid
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainGui.add(new JLabel("Soldier No"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainGui.add(personalNumT,gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        mainGui.add(asteriskPersonalNum,gbc);

        asteriskPersonalNum.setVisible(false);

        setVisible(false);
    }
    //------------methods--------------
    /** 
     * match method is equals the ID or pernoal number
     * {@link Person#match}
     * @param key String type is the user input
     * @return boolean return true if it's equal and return false else to the ID or Soldier ID
     */
    @Override
    public boolean match(String key)
    {
        return (super.match(key) || key.equals(this.personalNumP)) ? true : false; 
    }   
    /** 
     * validateData method check if the user input is valid
     * {@link Person#validateData}
     * @return boolean return true if the input is valid and false else
     */
    @Override
    protected boolean validateData(){
        asteriskPersonalNum.setVisible(false);

        boolean superCheck =  super.validateData();
        boolean personalNumCheck = personalNumT.getText().matches("[ROC][/][1-9][0-9]{6}");//TO DO
        //super - true need to check personalNumCheck
        //super - false 
        if(superCheck && !personalNumCheck) {
            asteriskPersonalNum.setVisible(true);
        }     
       
        return (superCheck && personalNumCheck);
    }
    /**
     * commit method insert the user input to the class class data fields
     * {@link Person#commit}
     */
    @Override
    protected void commit(){
        super.commit();
        this.personalNumP = personalNumT.getText();
    }
    /**
     * rollBack method set the texts that was before and hide all the Asterisks
     * {@link Person#rollBack}
     */
    @Override
    protected void rollBack(){
        super.rollBack();
        this.personalNumT.setText(personalNumP);
    }
    /**
     * showDetails method show the details of the entity
     * {@link Person#showDetails}
     */
    @Override
    protected void showDetails(){
        super.showDetails();
        this.personalNumT.setText(personalNumP);
    }
}