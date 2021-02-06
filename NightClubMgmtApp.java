// File: NightClubMgmtApp.java
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NightClubMgmtApp extends JFrame

{
    private ArrayList<ClubAbstractEntity> clubbers;
    private Scanner sc;

    private JButton sreachButton;
    private JButton createButton;
    private ButtonsHandler btnHandler;
    private JTextField inputField;

    public NightClubMgmtApp()
    {
        this.btnHandler=new ButtonsHandler();
        this.sreachButton=new JButton("Sreach");
        this.createButton=new JButton("Create");
        this.createButton.addActionListener(btnHandler); 
        this.sreachButton.addActionListener(btnHandler); 
        this.inputField = new JTextField(20);
        clubbers = new ArrayList<>();

        JPanel startGui = new JPanel();
        JPanel subJPanel = new JPanel();

        subJPanel.add(sreachButton);
        subJPanel.add(createButton);
        subJPanel.add(inputField);

        startGui.add(subJPanel,BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   
        setContentPane(startGui); 
        getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setResizable(false); 
        setLocationRelativeTo(null);
        setSize(420,220);
        setVisible(true);

        loadClubbersDBFromFile();
        


        // File: NightClubMgmtApp.java
        // sc = new Scanner(System.in);
    }
    private void manipulateDB()
    {
        String input; 
       
            input = inputField.getText();
            if(input.trim().equalsIgnoreCase("exit"))
            {writeClubbersDBtoFile(); System.exit(0);}
            for(ClubAbstractEntity clubber : clubbers)
                if(clubber.match(input))
                {
                   
                    clubber.showDetails();
                    clubber.setVisible(true);
                    break;
                }
            else {
            //MessageDialog
                System.out.printf("Clubber with key %s does not exist%n", input);
                
            }
        
    }// End of method manipulateDB
    private void loadClubbersDBFromFile()
    {
        //Read data from file, create the corresponding objects and put them
        //into clubbers ArrayList. For example:
        clubbers.add(new Person("0-2423535|1", "Mark", "Mc'Cormic","+(1)4-9520205"));
        clubbers.add(new Person("0-2423535|2", "Kfir", "Mc'Cormic","+(1)4-9520205"));
        clubbers.add(new Soldier("0-2223335|1", "Zohar", "Couper-Berg","+(44)206-8208167", "O/4684109"));
        clubbers.add(new Student("2-5554445|3", "Avi", "Avrahami-O'Mally","+(972)50-6663210", "SCE/12345"));
    }
    private void writeClubbersDBtoFile()
    {
        //Write all the objects’ data in clubbers ArrayList into the file
    }

    private class ButtonsHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sreachButton){
                manipulateDB();
                
            }
            if (e.getSource() == createButton){
                
                
                
            }
        } 
    }


    public static void main(String[] args)
    {
        NightClubMgmtApp appliction = new NightClubMgmtApp();
    }
}//End of class NightClubMgmtApp