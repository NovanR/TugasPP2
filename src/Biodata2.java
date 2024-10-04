import java.awt.event.*;
import javax.swing.*;

public class Biodata2 extends JFrame {
    
    private boolean checkBoxSelected;

    public Biodata2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Label Nama
        JLabel labelInput = new JLabel("Input Nama:");
        labelInput.setBounds(130, 10, 100, 20);
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 30, 150, 30);

        //Label Nomor
        JLabel labelinput2 = new JLabel("Input Nomor Telepon");
        labelinput2.setBounds(130, 70, 150, 20);
        JTextField textFieldNomor = new JTextField();
        textFieldNomor.setBounds(130, 90, 150, 30);

        //Label JK
        JLabel labelInput3 = new JLabel("Jenis Kelamin:");
        labelInput3.setBounds(130, 120, 150, 30);

        //Radio Button
        JRadioButton radioButton1 = new JRadioButton("Laki Laki", true);
        radioButton1.setBounds(130,150,350,30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(130,170,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        //Label Checkbox
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(130,200,350,30);

         //Label Button
         JButton button = new JButton("Simpan");
         button.setBounds(130, 240, 100, 40);

        //Label textfield
        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);

        //Text area
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130, 300, 300, 100);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

          //action button
          button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String nama = textFieldNama.getText();
                String nomor = textFieldNomor.getText();
                
                String JK = "";
                if(radioButton1.isSelected()) {
                    JK = radioButton1.getText();
                }
                if(radioButton2.isSelected()) {
                    JK = radioButton2.getText();
                }

                txtOutput.append("Nama : "+ nama +"\n");
                txtOutput.append("Nomor : "+ nomor +"\n");
                txtOutput.append("Jenis Kelamin : "+ JK +"\n");
                textFieldNama.setText("");
                textFieldNomor.setText("");

                if (checkBoxSelected) {
                    String WN = "Ya";
                    txtOutput.append("WNA : "+WN+"\n");
                    textField.setText("");
                } else {
                    txtOutput.append("WNA : "+"Bukan"+"\n");
                }


               
                
            }
        });

      
        this.add(labelInput);
        this.add(textFieldNama);
        this.add(labelinput2);
        this.add(textFieldNomor);
        this.add(labelInput3);
        this.add(checkBox);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(button);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata2 b = new Biodata2();
                b.setVisible(true);
            }
        });
    }

        
}
