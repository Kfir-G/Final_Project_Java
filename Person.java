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

        this.idT= new JTextField();
        this.nameT= new JTextField();
        this.surnameT= new JTextField();
        this.telT= new JTextField();

        JFrame main = new JFrame("Person Clubber's Data");
        main.setSize(450,220); // fit in 50% screen size
        main.setLocationRelativeTo(null);
        nameT = new JTextField(10);
        idT = new JTextField(10);
        surnameT = new JTextField(10);
        telT = new JTextField(10);
        JPanel gui = new JPanel(new BorderLayout(3,3));
        gui.setBorder(new EmptyBorder(5,5,5,5));
        main.setContentPane(gui);
        JPanel labels = new JPanel(new GridLayout(0,1));
        JPanel controls = new JPanel(new GridLayout(0,1));
        gui.add(labels, BorderLayout.WEST);
        gui.add(controls, BorderLayout.CENTER);
        labels.add(new JLabel("Id: "));
        controls.add(idT);
        labels.add(new JLabel("Name: "));
        controls.add(nameT);
        labels.add(new JLabel("Surname: "));
        controls.add(surnameT);
        labels.add(new JLabel("Tel: "));
        controls.add(telT);
        main.pack();
        main.setVisible(true);
        // JFrame mainFrame = new JFrame();
        // mainFrame.setTitle("Person Clubber's Data");
        // mainFrame.setSize(450,220);

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


