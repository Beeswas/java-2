// imports and decleration of the class
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane; 
import java.util.ArrayList;
/**
 * Write a description of class StudentsGUI here.
 *
 * @author (Bishwash Chaudhary)
 * @version (2023-07-28)
 */
public class StudentsGUI 
{
    private JFrame studentframe;//decleration of jframe

    private JPanel regularpanel,dropoutpanel;//decleration of regular and dropout panel
    //decleration of regular JLabel,JTextField,JComboBox and JButton and others instance variables.
    private JLabel studentnameLabel,enrollmentidLabel,
    coursenameLabel,coursedurationLabel,tuitionfeeLabel,
    numberofmodulesLabel,numberofcredithoursLabel,
    numberofdayspresentLabel,numberofremainingmodulesLabel,
    numberofmonthsattendedLabel,remainingamountLabel,dateofbirthLabel,
    dateofenrollmentLabel,dateofdropoutLabel,titelrLabel; 

    private JTextField studentnameText,enrollmentidText,
    coursenameText,coursedurationText,tuitionfeeText,
    numberofmodulesText,numberofcredithoursText,
    numberofdayspresentText,numberofremainingmodulesText,
    numberofmonthsattendedText,remainingamountText; 

    private JComboBox<String> dateofbirthComboBox,dateofbirthComboBoxm,dateofbirthComboBoxd,dateofenrollmentComboBox;

    private JButton addaregularstudent,
    presentpercentage,grantcertificate,
    clearrecord,dropoutButton,displayButton;
    private Regular regular;
    private int Rcourseduration,Rtuitionfee,Rnumofmodules,Renrollmentid,
    Rnumofcredithrs,Rdayspresent;
    private String Rcoursename,Rstudentname,Rdateofbirth,Rdateofenrollment; 
    ////decleration of dropout JLabel,JTextField,JComboBox and JButton.  
    private JLabel studentnameLabel1,enrollmentidLabel1,
    coursenameLabel1,coursedurationLabel1,tuitionfeeLabel1,
    numberofmodulesLabel1,numberofcredithoursLabel1,
    numberofremainingmodulesLabel1,
    numberofmonthsattendedLabel1,remainingamountLabel1,dateofbirthLabel1,
    dateofenrollmentLabel1,dateofdropoutLabel1,titeldLabel; 

    private JTextField studentnameText1,enrollmentidText1,
    coursenameText1,coursedurationText1,tuitionfeeText1,
    numberofremainingmodulesText1,
    numberofmonthsattendedText1,remainingamountText1; 

    private JComboBox<String> dateofbirthComboBox1,dateofenrollmentComboBox1,
    dateofdropoutComboBox1;

    private JButton addadropoutstudent,
    paybills,removestudent,
    clearrecord1,regularButton,displayButton1;
    
    private Dropout dropout;
    
    private int Denrollmentid,Dcourseduration,Dtuitionfee,
    Dnumofremainingmodules,Dnumofmonthattend;
    
    private String Dcoursename,Dstudentname,Ddateofbirth,Ddateofenrollment,
    Ddateofdropout;
    
    private ArrayList<Students>student=new ArrayList<>();
    
    public Regular regularobjectdetails()
    {
        Rcourseduration=Integer.parseInt(coursedurationText.getText());
        Rtuitionfee=Integer.parseInt(tuitionfeeText.getText());
        Rnumofmodules=Integer.parseInt(numberofmodulesText.getText());
        Renrollmentid=Integer.parseInt(enrollmentidText.getText());
        Rnumofcredithrs=Integer.parseInt(numberofcredithoursText.getText());
        Rdayspresent=Integer.parseInt(numberofdayspresentText.getText());
        
        Rcoursename=coursenameText.getText();
        Rstudentname=studentnameText.getText();
        Rdateofbirth=dateofbirthComboBox.getSelectedItem().toString();
        Rdateofenrollment=dateofenrollmentComboBox.getSelectedItem().toString();
    
        Regular regular=new Regular( Rdateofbirth, Rstudentname,  Rcourseduration,Rtuitionfee, Rnumofmodules,
                Rnumofcredithrs, Rdayspresent, Renrollmentid, Rcoursename, Rdateofenrollment);
                
        return regular;  
        
    }

    public void regularenrollidcompare(int newenid,int dayPresent,ArrayList<Students>student)
    {
        for(Students students:student)
        {
            if (students instanceof Regular)   
            {
                if(students.getEnrollmentID()==newenid)
                {
                    String idcheck=((Regular)students).presentPercentage(Rdayspresent);
                    JOptionPane.showMessageDialog(null,"present value"+idcheck);
                
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"please enter valid enrollment id" );
                }
                break;
            }
        }

    }

    public void checkenidforgrandcertificate(int newenid,String entercourseName, String enterdateofenrollment ,ArrayList<Students>student){
        for(Students students:student)
        {
            if (students instanceof Regular)   
            {
                if(students.getEnrollmentID()== newenid)
                {
                    String idcheck=((Regular)students).grantCertificate( Rcoursename, Renrollmentid ,Rdateofenrollment);
                    JOptionPane.showMessageDialog(null,"certificate of this student is "+idcheck);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"please enter correct enrollment id");
                }
                break;
            }
        }
    }

    public Dropout dropoutobjectdetails(){

        Denrollmentid=Integer.parseInt(enrollmentidText1.getText());
        Dcourseduration=Integer.parseInt(coursedurationText1.getText());
        Dtuitionfee=Integer.parseInt(tuitionfeeText1.getText());
        Dnumofremainingmodules=Integer.parseInt(numberofremainingmodulesText1.getText());
        Dnumofmonthattend=Integer.parseInt(numberofmonthsattendedText1.getText());

        Dcoursename=coursenameText1.getText();
        Dstudentname=studentnameText1.getText();

        Ddateofbirth=dateofbirthComboBox1.getSelectedItem().toString();
        Ddateofenrollment=dateofenrollmentComboBox1.getSelectedItem().toString();
        Ddateofdropout=dateofdropoutComboBox1.getSelectedItem().toString();

        dropout=new Dropout( Ddateofbirth,Dstudentname,Dcourseduration,Dtuitionfee,Dnumofremainingmodules, 
                    Dnumofmonthattend,Ddateofdropout,Denrollmentid, Dcoursename,Ddateofenrollment);

        return dropout;
    }
    
    public void dropoutbillspayable(int billspay,ArrayList<Students>student){
        for(Students students:student)
        {
            if (students instanceof Dropout)   
            {
                if(students.getEnrollmentID()== billspay)
                {
                   String idcheck=((Dropout)students).billsPayable();
                   JOptionPane.showMessageDialog(null,"bills payable:"+idcheck);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"please enter correct enrollment id");
                }
                break;
            }
        }
    }

     public void removestudent(int removestdpane,ArrayList<Students>student){
        for(Students students:student)
        {
            if (students instanceof Dropout)   
            {
                if(students.getEnrollmentID()== removestdpane)
                {
                    ((Dropout)students).removeStudent();
                    JOptionPane.showMessageDialog(null,"dropout student is romoved:");
                }
                 else
                {
                    JOptionPane.showMessageDialog(null,"please enter correct enrollment id");
                }
                break;
            }
        }
    }
    
      public  StudentsGUI()
    { 
        //GUI for regular students
        //setting up the components of the regular panel
        studentframe=new JFrame ("..Students_management_system.."); 
        studentframe.setSize(800,600);//setting size of the students frame
        studentframe.setVisible(true);//setting frames visibility to true

        regularpanel=new JPanel();//creating an object of regular panel
        regularpanel.setSize(800,600);//setting size
        regularpanel.setLayout(null);//setting layout to null
        regularpanel.setVisible(true);//setting the visibility to true

        titelrLabel=new JLabel("Regular Management System ");
        titelrLabel.setBounds(300,60,300,40);//creating an object and setting its bounds and adding it to regular panel
        regularpanel.add(titelrLabel);
        titelrLabel.setFont(new Font("Serif", Font.PLAIN, 20));//setting font style and size

        studentnameLabel=new JLabel("Student name");
        studentnameLabel.setBounds(50,150,150,40);
        regularpanel.add(studentnameLabel);//creating an object and setting its bounds and adding it to regular panel

        studentnameText=new JTextField();
        studentnameText.setBounds(220,155,150,30);
        regularpanel.add(studentnameText);//creating an object and setting its bounds and adding it to regular panel

        enrollmentidLabel=new JLabel("Enrollment ID ");
        enrollmentidLabel.setBounds(50,100,100,40);
        regularpanel.add(enrollmentidLabel);//creating an object and setting its bounds and adding it to regular panel

        enrollmentidText=new JTextField();
        enrollmentidText.setBounds(220,105,150,30);
        regularpanel.add(enrollmentidText);//creating an object and setting its bounds and adding it to regular panel

        coursenameLabel=new JLabel("Course Name");
        coursenameLabel.setBounds(50,200,100,40);
        regularpanel.add(coursenameLabel);//creating an object and setting its bounds and adding it to regular panel

        coursenameText=new JTextField();
        coursenameText.setBounds(220,205,150,30);
        regularpanel.add(coursenameText);//creating an object and setting its bounds and adding it to regular panel

        coursedurationLabel=new JLabel("Course Duration");
        coursedurationLabel.setBounds(410,200,150,40);
        regularpanel.add(coursedurationLabel);//creating an object and setting its bounds and adding it to regular panel

        coursedurationText=new JTextField();
        coursedurationText.setBounds(580,205,150,30);
        regularpanel.add( coursedurationText);//creating an object and setting its bounds and adding it to regular panel

        tuitionfeeLabel=new JLabel("Tuition Fee");
        tuitionfeeLabel.setBounds(50,250,100,40);
        regularpanel.add(tuitionfeeLabel);//creating an object and setting its bounds and adding it to regular panel

        tuitionfeeText=new JTextField();
        tuitionfeeText.setBounds(220,255,150,30);
        regularpanel.add(tuitionfeeText);//creating an object and setting its bounds and adding it to regular panel

        numberofmodulesLabel=new JLabel("Number Of Modules");
        numberofmodulesLabel.setBounds(410,250,150,40);
        regularpanel.add(numberofmodulesLabel);//creating an object and setting its bounds and adding it to regular panel

        numberofmodulesText=new JTextField();
        numberofmodulesText.setBounds(580,255,150,30);
        regularpanel.add(numberofmodulesText);//creating an object and setting its bounds and adding it to regular panel

        numberofcredithoursLabel=new JLabel("Number Of Credit Hours");
        numberofcredithoursLabel.setBounds(50,300,180,40);
        regularpanel.add(numberofcredithoursLabel);//creating an object and setting its bounds and adding it to regular panel

        numberofcredithoursText=new JTextField();
        numberofcredithoursText.setBounds(220,305,150,30);
        regularpanel.add(numberofcredithoursText);//creating an object and setting its bounds and adding it to regular panel

        numberofdayspresentLabel=new JLabel("Number Of Days Present");
        numberofdayspresentLabel.setBounds(410,300,180,40);
        regularpanel.add(numberofdayspresentLabel);//creating an object and setting its bounds and adding it to regular panel

        numberofdayspresentText=new JTextField();
        numberofdayspresentText.setBounds(580,305,150,30);
        regularpanel.add(numberofdayspresentText); //creating an object and setting its bounds and adding it to regular panel   

        dateofbirthLabel=new JLabel("DateOfBirth");
        dateofbirthLabel.setBounds(410,100,100,40);//creating an object for button  and setting its bounds and adding it to regular panel and using for loop to store the value in the combobox
                
        dateofbirthComboBox=new JComboBox<>();
        for(int i=1990;i<=2022;i++)
        {
            dateofbirthComboBox.addItem(String.valueOf(i));
        }
        regularpanel.add(dateofbirthLabel); 
        dateofbirthComboBox.setBounds(580,105,100,40);
        regularpanel.add(dateofbirthComboBox);

        dateofenrollmentLabel=new JLabel("DateOfEnrollment");
        dateofenrollmentLabel.setBounds(410,150,120,40);
        dateofenrollmentComboBox=new JComboBox<>();//creating an object for button  and setting its bounds and adding it to regular panel and using for loop to store the value in the combobox
        for(int i=1990;i<=2022;i++)
        {
            dateofenrollmentComboBox.addItem(String.valueOf(i));
        }
        dateofenrollmentComboBox.setBounds(580,155,100,30);
        regularpanel.add(dateofenrollmentComboBox);
        regularpanel.add(dateofenrollmentLabel);

        addaregularstudent=new JButton("Add regular Student");
        addaregularstudent.setBounds(190,360,160,50);
        regularpanel.add(addaregularstudent);//creating an object for button  and setting its bounds and adding it to regular panel 
        addaregularstudent.addActionListener(new ActionListener()
        {
            // adding action listener to this button and comparing enrollment id , itrating,and adding studentregular to Arraylist
           public void actionPerformed(ActionEvent e1)
           {
           try {
               Regular studentregular = regularobjectdetails();
               student.add(studentregular);
               JOptionPane.showMessageDialog(null, "Regular student is added to the list");
             } catch (NullPointerException ex) {
               JOptionPane.showMessageDialog(null, "Error: Please ensure all fields are filled.");
               ex.printStackTrace(); 
             } catch (NumberFormatException ex) {
               JOptionPane.showMessageDialog(null, "Error: Please enter valid  values for numeric fields.");
               ex.printStackTrace(); 
            }  catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "An error occurred. Please check your input.");
               ex.printStackTrace(); 
               }    
            }         
          });

        presentpercentage=new JButton("Present Percentage");
        presentpercentage.setBounds(400,360,160,50);
        regularpanel.add(presentpercentage);//creating an object for button  and setting its bounds and adding it to regular panel 
        presentpercentage.addActionListener(new ActionListener()
        {
            // adding action listener to this button and comparing enrollment id , itrating.
           public void actionPerformed(ActionEvent e1)
                {
                try {
                     String enternewid = JOptionPane.showInputDialog(null, "Insert enrollmentid", JOptionPane.PLAIN_MESSAGE);
                     String enterdayspresent = JOptionPane.showInputDialog(null, "Insert dayspresent", JOptionPane.PLAIN_MESSAGE);
                    if (enternewid == null || enterdayspresent == null) 
                     {
                         
                       return;
                     }
                    else{
                          int newenid = Integer.parseInt(enternewid);
                          int dayPresent = Integer.parseInt(enterdayspresent);
                          regularenrollidcompare(newenid, dayPresent, student);
                        }
                     } catch (NumberFormatException ex) {
                           JOptionPane.showMessageDialog(null, "Error: Please enter valid numeric values.");
                           ex.printStackTrace(); 
                     } catch (Exception ex) {
                           JOptionPane.showMessageDialog(null, "An error occurred. Please check your input.");
                           ex.printStackTrace();
                    }
                }
            });

        grantcertificate=new JButton("Grant Certificate");
        grantcertificate.setBounds(190,430,160,50);
        regularpanel.add(grantcertificate);
        grantcertificate.addActionListener(new ActionListener()
        {
            // adding action listener to this button and comparing enrollment id 
            public void actionPerformed(ActionEvent e3)
                {
                    String insertenid=JOptionPane.showInputDialog(null,"insert enrollmentid"+JOptionPane.PLAIN_MESSAGE);
                    String entercourseName=JOptionPane.showInputDialog(null,"insert coursename"+JOptionPane.PLAIN_MESSAGE);
                    String enterdateofenrollment=JOptionPane.showInputDialog(null,"insert dateofenrollment"+JOptionPane.PLAIN_MESSAGE); 
                    int newenid=Integer.valueOf(insertenid);
                    checkenidforgrandcertificate( newenid,entercourseName,enterdateofenrollment,student);
                }
            });

        clearrecord=new JButton("Clear Record");
        clearrecord.setBounds(360,430,100,50);
        regularpanel.add(clearrecord);
        clearrecord.addActionListener(new ActionListener()
        {
            // adding action listener to this button and setting all the components text to empty string
            public void actionPerformed(ActionEvent e1)
                {
                    enrollmentidText.setText("");
                    coursedurationText.setText("");
                    tuitionfeeText.setText("");
                    numberofmodulesText.setText("");
                    numberofcredithoursText.setText("");
                    coursenameText.setText("");
                    studentnameText.setText("");
                    dateofbirthComboBox.setSelectedItem("");
                    dateofenrollmentComboBox.setSelectedItem("");
                    numberofdayspresentText.setText("");
                 }
            });


        displayButton=new JButton("DISPLAY");
        displayButton.setBounds(480,430,100,50);
        regularpanel.add(displayButton);
        displayButton.addActionListener(new ActionListener()
        {
            // adding action listener to this button and use to display the details of regular object
            public void actionPerformed(ActionEvent e1)
                {
                    Regular studentregular= regularobjectdetails();
                    studentregular.display();

                }
            });

        dropoutButton=new JButton("Go To Dropout");
        dropoutButton.setBounds(310,30,200,40);
        regularpanel.add(dropoutButton);
        dropoutButton.addActionListener(new ActionListener()
        {
            // adding action listener to this button and it sets visibility of regular to false and dropout to true
           public void actionPerformed(ActionEvent e1)
            {
              regularpanel.setVisible(false); 
              dropoutpanel.setVisible(true); 
              JOptionPane.showMessageDialog(null,"welcome to dropout management system");
            }
         });

        studentframe.add(regularpanel);
        regularpanel.setBackground(Color.gray);//setting color of the regular panel
        studentframe.setResizable(false);//setting frames size to fix

        //GUI for dropout students   
        dropoutpanel=new JPanel();//creating an object and setting its components
        dropoutpanel.setSize(800,600);
        dropoutpanel.setLayout(null);//setting panel layout to null

        titeldLabel=new JLabel("Dropout Management System ");
        titeldLabel.setBounds(300,60,300,40);//creating an object and setting its components
        dropoutpanel.add(titeldLabel);
        titeldLabel.setFont(new Font("Serif", Font.PLAIN, 20));//setting font size and style

        studentnameLabel1=new JLabel("Student name");
        studentnameLabel1.setBounds(40,150,150,40);
        dropoutpanel.add(studentnameLabel1);//creating an object and setting its components

        studentnameText1=new JTextField();
        studentnameText1.setBounds(220,155,150,30);
        dropoutpanel.add(studentnameText1);//creating an object and setting its components

        enrollmentidLabel1=new JLabel("Enrollment ID ");
        enrollmentidLabel1.setBounds(40,100,100,40);
        dropoutpanel.add(enrollmentidLabel1);//creating an object and setting its components

        enrollmentidText1=new JTextField();
        enrollmentidText1.setBounds(220,105,150,30);
        dropoutpanel.add(enrollmentidText1);//creating an object and setting its components

        coursenameLabel1=new JLabel("Course Name");
        coursenameLabel1.setBounds(40,200,100,40);
        dropoutpanel.add(coursenameLabel1);//creating an object and setting its components

        coursenameText1=new JTextField();
        coursenameText1.setBounds(220,205,150,30);
        dropoutpanel.add(coursenameText1);//creating an object and setting its components

        coursedurationLabel1=new JLabel("Course Duration");
        coursedurationLabel1.setBounds(410,300,180,40);
        dropoutpanel.add(coursedurationLabel1);//creating an object and setting its components

        coursedurationText1=new JTextField();
        coursedurationText1.setBounds(580,305,150,30);
        dropoutpanel.add( coursedurationText1);//creating an object and setting its components

        tuitionfeeLabel1=new JLabel("Tuition Fee");
        tuitionfeeLabel1.setBounds(40,250,100,40);
        dropoutpanel.add(tuitionfeeLabel1);//creating an object and setting its components

        tuitionfeeText1=new JTextField();
        tuitionfeeText1.setBounds(220,255,150,30);
        dropoutpanel.add(tuitionfeeText1); //creating an object and setting its components     

        numberofremainingmodulesLabel1=new JLabel("Number Of Remaining Modules");
        numberofremainingmodulesLabel1.setBounds(410,250,150,40);
        dropoutpanel.add(numberofremainingmodulesLabel1);//creating an object and setting its components

        numberofremainingmodulesText1=new JTextField();//creating an object and setting its components
        numberofremainingmodulesText1.setBounds(580,255,150,30);
        dropoutpanel.add(numberofremainingmodulesText1);

        numberofmonthsattendedLabel1=new JLabel("Number Of Months Attended");
        numberofmonthsattendedLabel1.setBounds(40,300,180,40);
        dropoutpanel.add(numberofmonthsattendedLabel1);

        numberofmonthsattendedText1=new JTextField();
        numberofmonthsattendedText1.setBounds(220,305,150,30);
        dropoutpanel.add(numberofmonthsattendedText1);      

        dateofbirthLabel1=new JLabel("Date Of Birth");
        dateofbirthLabel1.setBounds(410,100,100,40);
        dateofbirthComboBox1=new JComboBox<>();//creating an object of the combobox and setting its components
        for(int i=1990; i<=2020; i++)
        {
            dateofbirthComboBox1.addItem(String.valueOf(i)); 
        }
        dateofbirthComboBox1.setBounds(580,100,100,40);   
        dropoutpanel.add(dateofbirthComboBox1);
        dropoutpanel.add(dateofbirthLabel1);

        dateofenrollmentLabel1=new JLabel("DateOfEnrollment");
        dateofenrollmentLabel1.setBounds(410,150,120,40);
        dateofenrollmentComboBox1=new JComboBox<>();//creating an object of the combobox and setting its components
        for(int i=1990;i<=2022;i++)
        {
            dateofenrollmentComboBox1.addItem(String.valueOf(i));
        }
        dateofenrollmentComboBox1.setBounds(580,155,100,30);
        dropoutpanel.add(dateofenrollmentComboBox1);
        dropoutpanel.add(dateofenrollmentLabel1);

        dateofdropoutLabel1=new JLabel("Date Of dropout");
        dateofdropoutLabel1.setBounds(410,200,150,40);
        dateofdropoutComboBox1=new JComboBox<>();//creating an object of the combobox and setting its components
        for(int i=1990;i<=2022;i++)
        {
            dateofdropoutComboBox1.addItem(String.valueOf(i));
        }
        dateofdropoutComboBox1.setBounds(580,205,100,30);
        dropoutpanel.add(dateofdropoutComboBox1);
        dropoutpanel.add(dateofdropoutLabel1);

        addadropoutstudent=new JButton("Add dropout student");
        addadropoutstudent.setBounds(190,360,160,50);
        dropoutpanel.add(addadropoutstudent);
        addadropoutstudent.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e1)
            {
                //adding action listener to the button and comparing enrollment id and adding object  to Arraylist
                try{
                     Dropout studentdropout= dropoutobjectdetails();
                     student.add(studentdropout);
                     JOptionPane.showMessageDialog(null,"dropout student is added in the list");
                     }catch (NumberFormatException ex) {
                      JOptionPane.showMessageDialog(null, "Error: Please enter valid  values for numeric fields.");
                      ex.printStackTrace(); 
                     } catch (NullPointerException ex) {
                      JOptionPane.showMessageDialog(null, "Error: Please ensure all fields are filled.");
                      ex.printStackTrace(); 
                     } catch (Exception ex) {
                      JOptionPane.showMessageDialog(null, "An error occurred. Please check your input.");
                      ex.printStackTrace(); 
                    }
            }
        });
        paybills=new JButton("Pay Bills");
        paybills.setBounds(190,430,140,50);
        dropoutpanel.add(paybills);
        paybills.addActionListener(new ActionListener()
        {
            //adding action listener to the button
           public void actionPerformed(ActionEvent e2)
            {
              String enidcheck= JOptionPane.showInputDialog(null, "Enter enrollment ID","Input Dialog",JOptionPane.PLAIN_MESSAGE);
              int billspay = Integer.valueOf(enidcheck);
              dropoutbillspayable(billspay,student);
            }
            });

        removestudent=new JButton("Remove Student");
        removestudent.setBounds(400,360,160,50);
        dropoutpanel.add(removestudent);
        removestudent.addActionListener(new ActionListener()
        { 
            //adding action listener to the button to removestudent
           public void actionPerformed(ActionEvent e3)
            {
             String uservalue=JOptionPane.showInputDialog(null, "Enter enrollment ID",JOptionPane.PLAIN_MESSAGE);
             int remove=Integer.valueOf(uservalue);
             removestudent(remove,student);
                     
              }
            });

        clearrecord1=new JButton("Clear Record");
        clearrecord1.setBounds(360,430,100,50);
        dropoutpanel.add(clearrecord1);
        clearrecord1.addActionListener(new ActionListener()
        {
            //setting all the components textfields to empty string
           public void actionPerformed(ActionEvent e1)
                {
                    enrollmentidText1.setText("");
                    coursedurationText1.setText("");
                    tuitionfeeText1.setText("");
                    numberofremainingmodulesText1.setText("");
                    numberofcredithoursText.setText("");
                    numberofcredithoursText.setText("");
                    numberofdayspresentText.setText("");
                    coursenameText1.setText("");
                    studentnameText1.setText("");
                    numberofmonthsattendedText1.setText("");
                    dateofbirthComboBox1.setSelectedItem("");
                    dateofenrollmentComboBox1.setSelectedItem("");
                }
            });


        displayButton1=new JButton("DISPLAY");
        displayButton1.setBounds(480,430,100,50);
        dropoutpanel.add(displayButton1);
        displayButton1.addActionListener(new ActionListener()
        {
            //this button displays all the details of the dropout student
            public void actionPerformed(ActionEvent e5)
                {
                    Dropout studentdropout= dropoutobjectdetails();
                    studentdropout.display();
                 }
            });

        regularButton=new JButton("Go To Regular");
        regularButton.setBounds(310,30,200,40);
        dropoutpanel.add(regularButton);
        regularButton.addActionListener(new ActionListener()
        {
            //it sets dropout visibility to false and regular to true
            public void actionPerformed(ActionEvent e1)
               {
                    regularpanel.setVisible(true); 
                    dropoutpanel.setVisible(false); 
                    JOptionPane.showMessageDialog(null,"welcome to regular management system");
                 }
            });

        studentframe.add( dropoutpanel);//adding dropout panel to students frame
        dropoutpanel.setBackground(Color.gray);//setting color of the dropout panel
        dropoutpanel.setVisible(false);//setting visibility to visible
        studentframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting exit on close to the frame

    } 
    //creating an main method and creating object of the StudentsGUI
    public static void main(String []agr)
       {

        StudentsGUI stdGui= new StudentsGUI();
    }
}   