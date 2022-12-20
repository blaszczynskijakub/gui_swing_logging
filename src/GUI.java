

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private final JPanel panel;
    private final JFrame frame;
    private final JLabel success;
    private final JLabel userLabel;
    private final JTextField userText;
    private final JLabel passwordLabel;
    private final JPasswordField userPassword;
    private final JButton buttonLog;
    private final JButton buttonCancel;
    private final JButton buttonRegister;
    private final ArrayList<User> userss = new ArrayList<>();


    public GUI() {

        User user = new User("bolek", "lolek".toCharArray());
        userss.add(user);


        frame = new JFrame();
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Logowanie");


        panel = new JPanel();
        panel.setLayout(null);


        userLabel = new JLabel("login");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);


        userText = new JTextField(20);
        userText.setBounds(80, 20, 290, 25);
        panel.add(userText);

        passwordLabel = new JLabel("hasło");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        userPassword = new JPasswordField(20);
        userPassword.setBounds(80, 50, 290, 25);
        panel.add(userPassword);


        buttonLog = new JButton(new AbstractAction("Zaloguj się") {
            @Override
            public void actionPerformed(ActionEvent e) {


                String user = userText.getText();
                char[] password = userPassword.getPassword();
                int counter = 0;
                int wrongPassword = 0;

                for (int i = 0; i < userss.size(); i++) {
                    if (user.equals(userss.get(i).getName()) && (password.length == userss.get(i).getPassword().length)) {

                        while (counter < userss.get(i).getPassword().length) {

                            if (password[counter] != userss.get(i).getPassword()[counter]) {
                                wrongPassword = 1;

                                break;
                            }

                            counter += 1;
                        }

                        if (wrongPassword == 0) {
                            success.setText("Logowanie powiodło się");
                            panel.setBackground(Color.GREEN);
                            break;
                        } else {
                            success.setText("Logowanie nie powiodło się");
                            panel.setBackground(Color.red);
                        }
                    } else {
                        if (i == userss.size() - 1) {
                            success.setText("Logowanie nie powiodło się");
                            panel.setBackground(Color.red);
                        }


                    }

                }
                userText.setText("");
                userPassword.setText("");
            }
        });
        buttonLog.setBounds(10, 100, 100, 25);
        panel.add(buttonLog);


        buttonCancel = new JButton(new AbstractAction("Anuluj") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.white);
                success.setText("Anulowano dane");
                userText.setText("");
                userPassword.setText("");


            }
        });

        buttonCancel.setBounds(140, 100, 100, 25);
        panel.add(buttonCancel);


        buttonRegister = new JButton(new AbstractAction("Zarejstruj") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                char[] password = userPassword.getPassword();
                panel.setBackground(Color.white);

                if (user.length() < 3 || password.length < 6) {
                    success.setText("Zbyt krótki login lub hasło");
                } else {
                    CheckIfBefore checkIfBefore = new CheckIfBefore(userss, user);
                    checkIfBefore.ifBefore();
                    if (!checkIfBefore.isWasBefore()) {


                        success.setText("Dodano użytkownika");
                        userss.add(new User(user, password));
                    } else {
                        success.setText("Użytkownik jest już w bazie ");

                    }

                }
                userText.setText("");
                userPassword.setText("");


            }
        });
        buttonRegister.setBounds(270, 100, 100, 25);
        panel.add(buttonRegister);


        success = new JLabel("");
        success.setBounds(10, 160, 300, 25);
        panel.add(success);


        frame.getContentPane().setBackground(Color.GREEN);


        frame.add(panel, BorderLayout.CENTER);


        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

}






