// File: NightClubMgmtApp.java
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * NightClubMgmtApp class is handler the manegment of the night club
 */
public class NightClubMgmtApp extends JFrame implements WindowListener
{   
    //-----------data fields---------------
    private ArrayList<ClubAbstractEntity> clubbers;
    private JComboBox<String> comboBox;
    private JButton sreachButton;
    private JButton createButton;
    // private ButtonsHandler btnHandler;
    GridBagConstraints gbc = new GridBagConstraints();

    /**
     * NightClubMgmtApp constructor create Search, Create and JComboBox buttons
     */
    public NightClubMgmtApp()
    {   
        String[] entityStrings = { "Person", "Soldier", "Studnet" };
        this.comboBox = new JComboBox<String>(entityStrings);
        ButtonsHandler btnHandler = new ButtonsHandler();

        this.sreachButton = new JButton("Search");
        this.createButton = new JButton("Create");
        this.createButton.addActionListener(btnHandler); 
        this.sreachButton.addActionListener(btnHandler); 

        clubbers = new ArrayList<ClubAbstractEntity>();
        loadClubbersDBFromFile();
        
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
        setResizable(false); 
        setLocationRelativeTo(null);
        setSize(420,220);

        /**
         * addWindowListener inner class which handler the exit
         */
        addWindowListener(new java.awt.event.WindowAdapter() {
            /**
             * windowClosing method which handler the exit
             * @param windowEvent is a WindowEvent of the exit
             */
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            writeClubbersDBtoFile();
            System.exit(0);
            }
        });

        setVisible(true);       
    }
    /**
     * manipulateDB method show and handle the menu
     */
    private void manipulateDB(){
            String input = JOptionPane.showInputDialog(this,"Please Enter The Clubber's Key"); 
            boolean found = false;

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
                    JOptionPane.showMessageDialog(this,"Clubber with key "+input+" does not exist","Warning",JOptionPane.INFORMATION_MESSAGE);
                }
            }
    }
    /**
     * loadClubbersDBFromFile method load from the file BKCustomers.dat
     */
    private void loadClubbersDBFromFile()
    {
            FileInputStream fis;
            ObjectInputStream ois;
		try {
                fis = new FileInputStream("BKCustomers.dat");
                ois = new ObjectInputStream(fis);
                clubbers = (ArrayList<ClubAbstractEntity>) ois.readObject();
                ois.close();
                fis.close();
         } catch (Exception e){

        }

        //Read data from file, create the corresponding objects and put them
        //into clubbers ArrayList. For example:
        clubbers.add(new Person("0-2423535|3", "Mark", "Mc'Cormic","+(1)4-9520205"));
        clubbers.add(new Soldier("0-2223335|1", "Zohar", "Couper-Berg","+(44)206-8208167", "O/4684109"));
        clubbers.add(new Student("2-5554445|3", "Avi", "Avrahami-O'Mally","+(972)50-6663210", "SCE/12345"));
    }
    /**
     * writeClubbersDBtoFile method write to the file BKCustomers.dat
     */
    private void writeClubbersDBtoFile()
    {
        FileOutputStream fos;
		try {

            fos = new FileOutputStream("BKCustomers.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clubbers);
            oos.close();//error
            fos.close();
        }
            catch (IOException e){
                JOptionPane.showMessageDialog(new JFrame(),
                        "Error has been accord "+e,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
    }
    /**
     * createObject method is create the user input entity
     */
    private void createObject(){
        String create =  comboBox.getSelectedItem()+"";

        switch (create) {
            case "Person":
            clubbers.add((new Person("", "", "", "")));
            break;
            case "Soldier":
            clubbers.add((new Soldier("", "", "", "", "")));
            break;
            case "Studnet":
            clubbers.add((new Student("", "", "", "", "")));
            break;
        }
        clubbers.get(clubbers.size()-1).setEnabledCancel(false);
        clubbers.get(clubbers.size()-1).setVisible(true);
    }
    /**
     * ButtonsHandler which listen to buttons in the menu
     */
    private class ButtonsHandler implements ActionListener
    {
        /**
         * actionPerformed listen to Sreach and Create buttons
         * @param e ActionEvent of the button
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == sreachButton){
                manipulateDB();                
            }
            if (e.getSource() == createButton){
                createObject();                
            }
        } 
    }
    /** 
     * static main method which handle user's input and handle the draw pannel
     */
    public static void main(String[] args)
    {
        NightClubMgmtApp appliction = new NightClubMgmtApp();
    }
}