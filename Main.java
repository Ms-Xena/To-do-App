import javax.swing.*;

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
}

class Login {
    
    Login(){
        JFrame frame = new JFrame("Login");
        JLabel label = new JLabel("Welcome to the Login Page");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //i'll be creating JTextFields for username and password
        //and a button for login
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