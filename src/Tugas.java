import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import javax.swing.SpinnerDateModel;

public class Tugas extends JFrame {
    
    private boolean checkBoxSelected;

    public Tugas() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Menu reset dan exit
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenu = new JMenuItem("Reset");
        JMenuItem exitMenu = new JMenuItem("Exit");
        menu.add(resetMenu);
        menu.add(exitMenu);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        
        //Label Nama
        JLabel labelInput = new JLabel("Input Nama:");
        labelInput.setBounds(130, 10, 100, 20);
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 30, 150, 30);

        //Label Nomor
        JLabel labelinput2 = new JLabel("Input Nomor Telepon:");
        labelinput2.setBounds(130, 70, 150, 20);
        JTextField textFieldNomor = new JTextField();
        textFieldNomor.setBounds(130, 90, 150, 30);

        //Label Jenis Kelamin
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

        // Label Tanggal Lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(130, 200, 150, 20);

        // Spinner Tanggal Lahir
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner spinnerTanggalLahir = new JSpinner(dateModel);
        spinnerTanggalLahir.setBounds(130, 220, 150, 30);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);

        //Label Checkbox
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(130, 260, 350, 30);

        // Label Jenis Tabungan
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
        labelJenisTabungan.setBounds(130, 300, 150, 20);

        // List Jenis Tabungan
        String[] jenisTabungan = {"Tabungan Reguler", "Tabungan Investasi", "Tabungan Dana Darurat", "Tabungan Pendidikan"};
        JList<String> listTabungan = new JList<>(jenisTabungan);
        listTabungan.setBounds(130, 320, 150, 60);

        // Label Frekuensi Transaksi
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi/Bulan:");
        labelFrekuensi.setBounds(130, 390, 200, 20);

        // Spinner Frekuensi Transaksi
        JSpinner spinnerFrekuensi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinnerFrekuensi.setBounds(130, 410, 100, 30);

        //Label Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(130, 450, 150, 20);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(130, 470, 150, 30);

        //Label Confirm Password
        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(130, 510, 150, 20);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(130, 530, 150, 30);

        //Label Button
        JButton button = new JButton("Simpan");
        button.setBounds(130, 570, 100, 40);

        //Text area
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130, 630, 300, 150);

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
                String JK = radioButton1.isSelected() ? radioButton1.getText() : radioButton2.getText();
                Date tanggalLahir = (Date) spinnerTanggalLahir.getValue();
                String jenisTabunganDipilih = listTabungan.getSelectedValue();
                int frekuensiTransaksi = (int) spinnerFrekuensi.getValue();
                
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String passwordStatus = password.equals(confirmPassword) ? "Password cocok" : "Password tidak cocok";

                txtOutput.setText("");
                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("Nomor : " + nomor + "\n");
                txtOutput.append("Jenis Kelamin : " + JK + "\n");
                txtOutput.append("Tanggal Lahir : " + dateEditor.getFormat().format(tanggalLahir) + "\n");
                txtOutput.append("Jenis Tabungan : " + jenisTabunganDipilih + "\n");
                txtOutput.append("Frekuensi Transaksi/Bulan : " + frekuensiTransaksi + "\n");
                txtOutput.append(passwordStatus + "\n");

                if (checkBoxSelected) {
                    txtOutput.append("WNA : Ya\n");
                } else {
                    txtOutput.append("WNA : Bukan\n");
                }

                // Reset input fields after saving
                textFieldNama.setText("");
                textFieldNomor.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });

        // Reset dan exit
        resetMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldNama.setText("");
                textFieldNomor.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                txtOutput.setText("");
                checkBox.setSelected(false);
                listTabungan.clearSelection();
                spinnerFrekuensi.setValue(1);
            }
        });

        exitMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(labelJenisTabungan);
        this.add(listTabungan);
        this.add(labelFrekuensi);
        this.add(spinnerFrekuensi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(button);
        this.add(txtOutput);

        this.setSize(500, 900);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas b = new Tugas();
                b.setVisible(true);
            }
        });
    }
}
