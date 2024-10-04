import java.awt.event.*;
import javax.swing.*;

public class Biodata extends JFrame {
    
    public Biodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelInput = new JLabel("Input Nama:");
        labelInput.setBounds(130, 10, 100, 20);
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 30, 100, 30);

        JLabel labelinput2 = new JLabel("Input Nomor Telepon");
        labelinput2.setBounds(130, 70, 150, 20);
        JTextField textFieldNomor = new JTextField();
        textFieldNomor.setBounds(130, 90, 150, 30);


        JButton button = new JButton("Klik");
        button.setBounds(130, 130, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(50, 180, 300, 100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomor = textFieldNomor.getText();
                txtOutput.append(nama +" = " + nomor + "\n");
                textFieldNama.setText("");
                textFieldNomor.setText("");
            }
        });
        this.add(labelInput);
        this.add(textFieldNama);
        this.add(labelinput2);
        this.add(textFieldNomor);
        this.add(button);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata b = new Biodata();
                b.setVisible(true);
            }
        });
    }

        
}
