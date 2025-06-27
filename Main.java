import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
//make sure to handle exceptions properly in the code
// This is a simple task management application with a GUI using Java Swing
// It includes a login page, account creation page, user dashboard, and task management features
// The application will connect to a MySQL database to store user and task information
// The code is structured to allow for easy expansion and modification in the future

//self note : make sure to decorate it in a minimalistic aesthetic way

class mysql_Connection {
    // This class would handle the connection to the MySQL database
    // For simplicity, we are not implementing any actual database logic here
    // i'll be creating a static method for connection and to run queries easily throughtout the program


     static {
        // Load the MySQL JDBC driver
        // This is necessary to establish a connection to the MySQL database
        // static block so i don't have to create an object of mysql_Connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Driver for mysql
            //jdbc Connection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception if the driver is not found
        }
    }

    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "username"; // Replace with your actual username
    private static final String PASSWORD = "password"; // Replace with your actual password
// Database URL, username, and password
// Make sure to change these values according to your database configuration

    // URL format: jdbc:mysql://<host>:<port>/<database_name>
    // Example: jdbc:mysql://localhost:3306/project
    public static Connection connectingToDatabase() {
        // This method will return a Connection object to the MySQL database
        // It will be used to execute SQL queries and retrieve results
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Handle SQL exceptions that may occur during connection
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
            // Return null if the connection fails
            // This will allow the calling code to handle the failure appropriately :)
            return null;
        }
    }

    
}

class Login {


    
    Login(){
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10)); // 3 rows, 1 column with gaps
       // frame.setVisible(true);
        //i'll be creating JTextFields for username and password
        //and a button for login
        
        // After successful login, it will redirect to the user dashboard
        // For now, it will just display a message

        JLabel label = new JLabel("Welcome to the Login Page");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);
        label.setPreferredSize(new Dimension(300, 50));

        //can't figure out how to set the layout properly
        // So, I'll use null layout for now

        //let's try panels

        JPanel labelpanel = new JPanel();
        labelpanel.setPreferredSize(new Dimension(300, 50));
        labelpanel.setBackground(Color.LIGHT_GRAY);
        JPanel buttonpanel = new JPanel();
        buttonpanel.setPreferredSize(new Dimension(300, 50));
        buttonpanel.setBackground(Color.LIGHT_GRAY);
        JPanel inputpanel = new JPanel();
        inputpanel.setPreferredSize(new Dimension(300, 100));
        inputpanel.setBackground(Color.LIGHT_GRAY);


        //okay let's add a main panel to the frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10)); // 3 rows, 1 column with gaps
        mainPanel.add(labelpanel, BorderLayout.NORTH);
        mainPanel.add(buttonpanel, BorderLayout.SOUTH); 
        mainPanel.add(inputpanel, BorderLayout.CENTER);

        labelpanel.setLayout(new BorderLayout());
        labelpanel.add(label, BorderLayout.CENTER);
        // Set the layout for the label panel to center the label
        // This will ensure the label is centered in the panel

        buttonpanel.setLayout(new FlowLayout());


       
        //sigh i 'll have to create subpanels for username and password fields'
        JPanel usernamePanel = new JPanel();
        usernamePanel.setPreferredSize(new Dimension(300, 50));
        usernamePanel.setBackground(Color.CYAN);
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JTextField usernameField = new JTextField();
        usernameField.setToolTipText("Enter your username");
        usernameField.setPreferredSize(new Dimension(90, 30));
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setLabelFor(usernameField);
        usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        
        // Create a password field for secure input
        // It will hide the actual characters typed by the user
        JPasswordField passwordField = new JPasswordField();
        passwordField.setToolTipText("Enter your password");
        passwordField.setPreferredSize(new Dimension(90, 30));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setLabelFor(passwordField);
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setPreferredSize(new Dimension(100, 50));
        passwordPanel.setBackground(Color.CYAN);
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        inputpanel.setLayout(new GridLayout(2,1)); // 2 rows, 2 columns with gaps
        inputpanel.add(usernamePanel);
        inputpanel.add(passwordPanel);
        
       // inputpanel.add(passwordLabel);
        //inputpanel.add(passwordField);
        // Add the username and password fields to the frame
       
       

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 30));
        // Add an ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //later.....
                // new User_dashboard();
                // This will redirect to the user dashboard after successful login
                
                frame.dispose(); // Close the login window
            }
        });
        
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setPreferredSize(new Dimension(150, 30));
        // Add an ActionListener to the create account button
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirect to the account creation page
                //later....
                //new Create_account();
                frame.dispose(); // Close the login window
            }
        });

        // Adding buttons to the button panel
        buttonpanel.add(loginButton);
        buttonpanel.add(createAccountButton);

       // frame.add(labelpanel, BorderLayout.NORTH);
       // frame.add(buttonpanel, BorderLayout.SOUTH);
       // frame.add(inputpanel, BorderLayout.CENTER);
        
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

class Create_account {
    // This class will handle the account creation process
    // It will have fields for username, password, email, etc.
    // After successful creation, it will redirect to the login page
    Create_account(){
        JFrame frame = new JFrame("Create Account");
        JLabel label = new JLabel("Welcome to the Create Account Page");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // I'll be creating JTextFields for username, password, email, etc.
        // and a button for account creation
        // After successful creation, it will redirect to the login page
        // For now, it will just display a message
        //in actionListener i'l be adding the password creation restrictions like minimum 8 characters, at least one uppercase, one lowercase, one number and one special character
        // and also check if the username is already taken or not
    }
}
class User_dashboard {
    //if login is sucessful, this dashboard will be displayed
    //display all tasks like cards 
    //show priority tasks, completed tasks, pending tasks etc.
    // craete task button
    // show time and date with greetings
    // a random quote will be shown below the greeting everytime.
    //it'll show a small calender with the current date highlighted
    // a pomodoro timer will be implemented
    // a button to create a new task
    // a journal button to write daily journal
    // a button to view tasks
    // a button to view profile
    // task anylytics will be shown like how many tasks are completed, how many are pending, how many are overdue etc.
    
    // if user selects a task , a object of Task will be creating and that particular task will be showcased 
    // separately new Task();
    User_dashboard(){
        JFrame frame = new JFrame("User Dashboard");
        JLabel label = new JLabel("Welcome to the User Dashboard");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class User_profile{
    //user profile will be displayed here
    //with addditional settings like change password, update profile etc.
    // theme settings, notification settings etc.
}

class Task{
    //Task settings
    //delete it , extend it , modify it 
}

class Create_task{
    //create a task
    //add title, description, priority, deadline etc.
    //save it to the database
}

class journal{
    //this will be a simple text area where user can write their daily journal
    //it will save the journal to the database
    //and display it in a list format
}
public class Main {
    public static void main(String[] args) {
        new Login();
        // The Login window will be displayed when the program runs
    }
}