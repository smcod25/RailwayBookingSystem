import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reservationplatform {
    public static void main(String[] args) {
        //Store the URL,Username,Password in string object of database
        String URL = "jdbc:mysql://localhost:3306/railwayreservationdb";
        String Username = "root";
        String Password = "";
        Connection connection;
        JFrame frame = new JFrame("Railway Reservation System");


        JLabel personalin = new JLabel("Personal Detail");
        personalin.setBounds(10, 10, 120, 30);
        frame.add(personalin);

        JLabel Traindetail = new JLabel("Train Detail");
        Traindetail.setBounds(310, 10, 120, 30);
        frame.add(Traindetail);


        JLabel username_label = new JLabel("Username:");
        username_label.setBounds(10, 45, 120, 30);
        frame.add(username_label);

        JTextField username_field = new JTextField();
        username_field.setBounds(80, 45, 120, 30);
        frame.add(username_field);

        JLabel DOJ_label = new JLabel("Date Of Journey:");
        DOJ_label.setBounds(310, 45, 120, 30);
        frame.add(DOJ_label);

        JTextField DOJ_field = new JTextField();
        DOJ_field.setBounds(410, 45, 120, 30);
        frame.add(DOJ_field);


        JLabel Age_Label = new JLabel("Age:");
        Age_Label.setBounds(10, 80, 120, 30);
        frame.add(Age_Label);

        JTextField age_field = new JTextField();
        age_field.setBounds(80, 80, 120, 30);
        frame.add(age_field);

        JLabel gender_Label = new JLabel("Gender:");
        gender_Label.setBounds(10, 120, 120, 30);
        frame.add(gender_Label);

        JTextField gender_field = new JTextField();
        gender_field.setBounds(80, 115, 120, 30);
        frame.add(gender_field);

        JLabel mobile_Label = new JLabel("Mobile:");
        mobile_Label.setBounds(10, 150, 120, 30);
        frame.add(mobile_Label);

        JTextField mobile_field = new JTextField();
        mobile_field.setBounds(80, 150, 120, 30);
        frame.add(mobile_field);

        JLabel email_Label = new JLabel("E-Mail:");
        email_Label.setBounds(10, 185, 120, 30);
        frame.add(email_Label);


        JTextField email_field = new JTextField();
        email_field.setBounds(80, 185, 120, 30);
        frame.add(email_field);

        JLabel source_label = new JLabel("Source:");
        source_label.setBounds(310, 80, 120, 30);
        frame.add(source_label);

        JTextField source_field = new JTextField();
        source_field.setBounds(410, 80, 120, 30);
        frame.add(source_field);

        JLabel destination_label = new JLabel("Destination:");
        destination_label.setBounds(310, 115, 120, 30);
        frame.add(destination_label);

        JTextField destination_field = new JTextField();
        destination_field.setBounds(410, 115, 120, 30);
        frame.add(destination_field);

        JLabel tp_label = new JLabel("Ticket Price:");
        tp_label.setBounds(310, 150, 120, 30);
        frame.add(tp_label);

        JTextField tp_field = new JTextField();
        tp_field.setBounds(410, 150, 120, 30);
        frame.add(tp_field);

        JLabel sp_label = new JLabel("Seat Preference:");
        sp_label.setBounds(310, 185, 120, 30);
        frame.add(sp_label);

        JTextField sp_field = new JTextField();
        sp_field.setBounds(410, 185, 120, 30);
        frame.add(sp_field);

        JLabel bid_label=new JLabel("Booking ID:");
        bid_label.setBounds(10,220,120,30);
        frame.add(bid_label);

        JTextField bid_field=new JTextField();
        bid_field.setBounds(80,220,120,30);
        frame.add(bid_field);

        JButton book_button = new JButton("Book");
        book_button.setBounds(100, 270, 120, 50);
        book_button.setBackground(Color.GREEN);
        book_button.setForeground(Color.BLUE);
        frame.add(book_button);

        JButton update_button = new JButton("Update");
        update_button.setBounds(250, 270, 120, 50);
        update_button.setBackground(Color.RED);
        update_button.setForeground(Color.BLUE);
        frame.add(update_button);

        JButton cancel_button = new JButton("Cancel");
        cancel_button.setBounds(400, 270, 120, 50);
        cancel_button.setBackground(Color.BLUE);
        cancel_button.setForeground(Color.RED);
        frame.add(cancel_button);

        JButton detail_bt=new JButton("Ticket Detail");
        detail_bt.setBounds(250,350,120,50);
        detail_bt.setBackground(Color.ORANGE);
        detail_bt.setForeground(Color.BLACK);
        frame.add(detail_bt);


        try {
            connection = DriverManager.getConnection(URL, Username, Password);
            System.out.println("DB Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //add booking info
        book_button.addActionListener(e -> {
            String insertQuery = "insert into ticketbookingtb(Username,Age,Gender,Mobile,Email,DOJ,Source,Destination,TicketPrice,Seatpreference) values(?,?,?,?,?,?,?,?,?,?)";
            if (username_field.getText().isEmpty() && age_field.getText().isEmpty() && gender_field.getText().isEmpty() && mobile_field.getText().isEmpty()&&email_field.getText().isEmpty()&&DOJ_field.getText().isEmpty()&&source_field.getText().isEmpty()&&destination_field.getText().isEmpty()&&tp_field.getText().isEmpty()&&sp_field.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Invalid Input");
            }
            else {
                try {
                    PreparedStatement ps = connection.prepareStatement(insertQuery);
                    ps.setString(1, username_field.getText());
                    ps.setInt(2, Integer.parseInt(age_field.getText()));
                    ps.setString(3, gender_field.getText());
                    ps.setString(4, mobile_field.getText());
                    ps.setString(5, email_field.getText());
                    ps.setString(6, DOJ_field.getText());
                    ps.setString(7, source_field.getText());
                    ps.setString(8, destination_field.getText());
                    ps.setString(9, tp_field.getText());
                    ps.setString(10, sp_field.getText());
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Your Ticket is booked");
                    username_field.setText("");
                    age_field.setText("");
                    gender_field.setText("");
                    mobile_field.setText("");
                    email_field.setText("");
                    DOJ_field.setText("");
                    source_field.setText("");
                    destination_field.setText("");
                    tp_field.setText("");
                    sp_field.setText("");

                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Invalid input" + e1.getMessage());

                }
            }

        });


         cancel_button.addActionListener(e -> {
             String deleteQuery = "delete from ticketbookingtb where BookingID=?";
             if (bid_field.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Enter Valid Booking ID ");
             } else {
                 try {
                     PreparedStatement ps = connection.prepareStatement(deleteQuery);
                     ps.setInt(1, Integer.parseInt(bid_field.getText()));
                     ps.executeUpdate();
                     System.out.println(ps);
                     JOptionPane.showMessageDialog(null, "Your Ticket is Cancelled");
                     bid_field.setText("");

                 }
                     catch(SQLException e1){
                     JOptionPane.showMessageDialog(null, "Invalid Input" + e1.getMessage());
                 }
             }

         });



        detail_bt.addActionListener(e -> {
            String fetchQuery="SELECT * FROM ticketbookingtb where BookingID=? ";
            try {
                PreparedStatement ps = connection.prepareStatement(fetchQuery);
                ps.setInt(1, Integer.parseInt(bid_field.getText()));
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    username_field.setText(resultSet.getString("Username"));
                    age_field.setText(String.valueOf(resultSet.getInt("Age")));
                    gender_field.setText(resultSet.getString("gender"));
                    mobile_field.setText(resultSet.getString("Mobile"));
                    email_field.setText(resultSet.getString("Email"));
                    DOJ_field.setText(resultSet.getString("DOJ"));
                    source_field.setText(resultSet.getString("Source"));
                    destination_field.setText(resultSet.getString("Destination"));
                    tp_field.setText(resultSet.getString("TicketPrice"));
                    sp_field.setText(resultSet.getString("Seatpreference"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"No Detail was found!"+ bid_field.getText());
                    bid_field.setText("");
                }
            }
            catch(SQLException e1){
                JOptionPane.showMessageDialog(null,"Invalid Input"+e1.getMessage());
            }
        });


         update_button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String updateQuery="update ticketbookingtb set Username=?,Age=?,Email=?,DOJ=?,Source=?,Destination=?,TicketPrice=?,Seatpreference=? where BookingID=?";
                 if(bid_field.getText().isEmpty())
                 {
                     JOptionPane.showMessageDialog(null,"Enter your Booking ID");
                 }
                 else {
                     try {
                         PreparedStatement ps = connection.prepareStatement(updateQuery);
                         ps.setString(1, username_field.getText());
                         ps.setInt(2, Integer.parseInt(age_field.getText()));
                         ps.setString(3, email_field.getText());
                         ps.setString(4, DOJ_field.getText());
                         ps.setString(5, source_field.getText());
                         ps.setString(6, destination_field.getText());
                         ps.setString(7,tp_field.getText());
                         ps.setString(8, sp_field.getText());
                         ps.setInt(9, Integer.parseInt(bid_field.getText()));
                         ps.execute();
                         JOptionPane.showMessageDialog(null, "Your Booked Ticket is updated");
                         username_field.setText("");
                         age_field.setText("");
                         gender_field.setText("");
                         mobile_field.setText("");
                         email_field.setText("");
                         DOJ_field.setText("");
                         source_field.setText("");
                         destination_field.setText("");
                         tp_field.setText("");
                         sp_field.setText("");
                         bid_field.setText("");

                     } catch (SQLException e1) {
                         JOptionPane.showMessageDialog(null, "Invalid Input");
                     }
                 }
             }
         });


        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.GRAY);


    }
}