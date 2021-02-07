// File: NightClubMgmtApp.java
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NightClubMgmtApp extends JFrame

{   
     //-----------data fields---------------

    private ArrayList<ClubAbstractEntity> clubbers;
    private JComboBox<String> comboBox;
    private JButton sreachButton;
    private JButton createButton;
    private ButtonsHandler btnHandler;
    GridBagConstraints gbc = new GridBagConstraints();


    public NightClubMgmtApp()
    {      
        String[] entityStrings = { "Person", "Soldier", "Studnet" };

        this.comboBox = new JComboBox<String>(entityStrings);
        this.btnHandler=new ButtonsHandler();
        this.sreachButton=new JButton("Sreach");
        this.createButton=new JButton("Create");
        this.createButton.addActionListener(btnHandler); 
        this.sreachButton.addActionListener(btnHandler); 
        // this.inputField = new JTextField(20);
        clubbers = new ArrayList<>();
        

        JPanel startGui = new JPanel();
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(3,0,3,10);


        gbc.gridx = 0;
        gbc.gridy = 0;
        subPanel.add(sreachButton,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        subPanel.add(createButton,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        subPanel.add(comboBox,gbc);


        startGui.add(subPanel,BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   
        setContentPane(startGui); 
        getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setResizable(false); 
        setLocationRelativeTo(null);
        setSize(420,220);
        setVisible(true);

        loadClubbersDBFromFile();
    }
    private void manipulateDB(){
            
            String input = JOptionPane.showInputDialog(this,"Please Enter The Clubber's Key"); 
            boolean found = false;

            // if(input.trim().equalsIgnoreCase("exit")){
            //     writeClubbersDBtoFile();
            // }

            if(input != null){
                for(ClubAbstractEntity clubber : clubbers){
                
                    if(clubber.match(input)){
                        found = true;
                        clubber.showDetails();
                        clubber.setVisible(true);
                        break;
                    }
                }
    
                if(!found){
                //MessageDialog
                JOptionPane.showMessageDialog(this,"Clubber with key "+input+" does not exist","Warning",JOptionPane.INFORMATION_MESSAGE);
                }
            }

    }
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

    private void createEntity(){
        String create =  comboBox.getSelectedItem()+"";


        switch (create) {
            case "Person":
                System.out.println("Person");
            break;
            case "Soldier":
                System.out.println("Soldier");
            break;
            case "Studnet":
                 System.out.println("Studnet");
            break;
        
        }
    }
    private class ButtonsHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sreachButton){
                manipulateDB();
                
            }
            if (e.getSource() == createButton){
                createEntity();
                
                
            }
        } 
    }


    public static void main(String[] args)
    {
        NightClubMgmtApp appliction = new NightClubMgmtApp();
    }
}