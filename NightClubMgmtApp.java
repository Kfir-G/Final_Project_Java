// File: NightClubMgmtApp.java
import java.util.*;
public class NightClubMgmtApp
{
    private ArrayList<ClubAbstractEntity> clubbers;
    private Scanner sc;
    
    public NightClubMgmtApp()
    {
        // File: NightClubMgmtApp.java
        clubbers = new ArrayList<>();
        sc = new Scanner(System.in);
        loadClubbersDBFromFile();
        manipulateDB();
    }
    private void manipulateDB()
    {
        String input; boolean found = false;
        while(true)
        {
            System.out.print("Please Enter The Clubber's Key ");
            System.out.print("or \"exit\" to exit: ");
            input = sc.nextLine();
            if(input.trim().equalsIgnoreCase("exit"))
            {writeClubbersDBtoFile(); System.exit(0);}
            for(ClubAbstractEntity clubber : clubbers)
                if(clubber.match(input))
                {
                    found = true;
                    clubber.setVisible(true);
                    break;
                }
            if(!found)
                System.out.printf("Clubber with key %s does not exist%n", input);
            else found = !found;
        }
    }// End of method manipulateDB
    private void loadClubbersDBFromFile()
    {
        //Read data from file, create the corresponding objects and put them
        //into clubbers ArrayList. For example:
        clubbers.add(new Person("0-2423535|1", "Mark", "Mc'Cormic","+(1)4-9520205"));
        clubbers.add(new Soldier("0-2223335|1", "Zohar", "Couper-Berg","+(44)206-8208167", "O/4684109"));
        clubbers.add(new Student("2-5554445|3", "Avi", "Avrahami-O'Mally","+(972)50-6663210", "SCE/12345"));
    }
    private void writeClubbersDBtoFile()
    {
        //Write all the objects’ data in clubbers ArrayList into the file
    }
    public static void main(String[] args)
    {
        NightClubMgmtApp appliction = new NightClubMgmtApp();
    }
}//End of class NightClubMgmtApp