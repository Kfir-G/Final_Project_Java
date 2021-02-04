public class Person extends ClubAbstractEntity
{
    //test branch
    //-----------data fields---------------
    String id;
    String name;    //first name
    String surname; //last name
    String tel;     //telephone

    private JTextField id;
    private JTextField name;
    private JTextField surname;
    private JTextField tel;

    //----------constructors---------------
    public Person(String idP, String nameP, String surnameP ,String telP){
        super();
        this.idP = idP;
        this.nameP = nameP;
        this.surnameP = surnameP;
        this.telP = telP;


        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Person Clubber's Data");
        mainFrame.setSize(450,220);

        // init GUI elements

    }
    //----------methods-------------------
    public boolean match(String key)
    {
        return key.equals(this.id) ? true: false; 
    }

    protected boolean validateData();
    protected void commit();
    protected void rollBack();
}