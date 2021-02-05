import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Person extends ClubAbstractEntity
{
    
    //-----------data fields---------------
    private String idP;
    private String nameP;    //first name
    private String surnameP; //last name
    private String telP;     //telephone

    private JTextField idT;
    private JTextField nameT;
    private JTextField surnameT;
    private JTextField telT;

    //----------constructors---------------
    public Person(String idP, String nameP, String surnameP ,String telP){
        super();
        this.idP = idP;
        this.nameP = nameP;
        this.surnameP = surnameP;
        this.telP = telP;

        this.idT= new JTextField("id");
        this.nameT= new JTextField("name");
        this.surnameT= new JTextField("surname");
        this.telT= new JTextField("telT");
        
        setSize(450,220);
<<<<<<< HEAD


        setTitle("Person Clubber's Data");

        JPanel mainGui = new JPanel();
        mainGui.setLayout(new GridLayout(4,2,0,0));
        // mainGui.setBorder(new EmptyBorder(5,5,5,5));
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(4,1));       
        mainGui.add(idT);
        mainGui.add(nameT);
        mainGui.add(surnameT);         
        mainGui.add(telT);
       

        mainGui.add(textPanel,BorderLayout.WEST);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(4,1));
        mainGui.add(new JLabel("Id:"));
        mainGui.add(new JLabel("Name:"));
        mainGui.add(new JLabel("Surname:"));
        mainGui.add(new JLabel("Tel:"));
        mainGui.add(textPanel,BorderLayout.CENTER);
        // pack();
        setVisible(true);

=======
>>>>>>> parent of ec086f4... GUI fixed
        addToCenter(this.idT);
        addToCenter(this.nameT);
        addToCenter(this.surnameT);
        addToCenter(this.telT);
        
<<<<<<< HEAD


        addToCenter(this.idT);
        addToCenter(this.nameT);
        addToCenter(this.surnameT);
        addToCenter(this.telT);
        

=======

>>>>>>> parent of ec086f4... GUI fixed
        // init GUI elements
        
    }
    

    //----------methods-------------------
    public boolean match(String inputId){
        return inputId.equals(this.idP) ? true: false;

    }

    protected boolean validateData(){
        String id = idT.getText();
        String name = nameT.getText();
        String tel = telT.getText();
        String surname = surnameT.getText();

        boolean validIdCheck = id.matches("([0-9]-\\d{7}\\|[1-9])");
        boolean validNameCheck = name.matches("[A-Z][a-z]*");
        boolean validTelCheck = surname.matches("[A-Z][a-z]*(['-][a-zA-Z]+)*");
        boolean validSureNameCheck = tel.matches("\\+\\([1-9]\\d{0,2}\\)[1-9]\\d{0,2}-[1-9]\\d{6}");

        return(validIdCheck && validNameCheck && validTelCheck && validSureNameCheck);
    }
    protected void commit(){
        this.idP = idT.getText();
        this.nameP = nameT.getText();
        this.surnameP = surnameT.getText();
        this.telP = telT.getText();
    }


    protected void rollBack(){
        this.idT.setText(idP);
        this.nameT.setText(nameP);
        this.surnameT.setText(surnameP);
        this.telT.setText(telP);
    }

    
}


