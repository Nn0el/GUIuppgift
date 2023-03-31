import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI {
    private JButton sökButton;
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton nyttButton;
    private JButton öppnaButton;
    private JButton sparaButton;

    public GUI() {
        nyttButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = "info.txt";
                BufferedReader in = null;
                try {
                    in = new BufferedReader(new FileReader(filename));
                } catch (FileNotFoundException ex) {
                    textArea1.setText("");
                    return;
                }
                String nextline = null;
                try {
                    nextline = in.readLine();
                    while (nextline != null) {
                        textArea1.append(nextline + "\n");
                        nextline = in.readLine();
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }


        });
        sparaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
    }
public void save(){
    String filename ="text.txt";
    PrintWriter out = null;
    try {
        out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    out.println(textArea1.getText());
            out.flush();
            out.close();
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        GUI gui = new GUI();
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
