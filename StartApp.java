import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;


class StartApp extends JFrame {
    JPanel headingPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel titleL = new JLabel("Welcome to the Sticky Notes App");
    JLabel creditL = new JLabel("Assembled by Hammad Naqvi");
    JButton startB = new JButton("Start Application");
    ImageIcon img;

    public StartApp() {
        setTitle("Welcome to Sticky Notes app");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// header file
        headingPanel.setLayout(new BorderLayout());
        headingPanel.add(titleL, BorderLayout.CENTER);
        titleL.setFont(new Font("Arial", Font.BOLD, 25));
        titleL.setForeground(Color.BLUE);
        titleL.setHorizontalAlignment(JLabel.CENTER);
        headingPanel.add(creditL, BorderLayout.SOUTH);
        creditL.setFont(new Font("gaudy", Font.BOLD, 20));
        creditL.setForeground(Color.BLACK);
        creditL.setHorizontalAlignment(JLabel.CENTER);
        add(headingPanel, BorderLayout.NORTH);
        // adding the image in the app
        try {
            Image originalImage = ImageIO.read(new File("C:\\Users\\hp\\Downloads\\_b419b39a-e191-4e56-a00f-71da37b25426.jpeg"));
            Image scaledImage = originalImage.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
            img = new ImageIcon(scaledImage);
        } catch (Exception e) {
            System.out.println("error");
        }
        JLabel imageLabel = new JLabel(img);
        add(imageLabel, BorderLayout.CENTER);
        startB.setFont(new Font("Arial", Font.BOLD, 18));

        startB.setBackground(Color.GREEN);
        startB.setForeground(Color.black);
        buttonPanel.add(startB);
        add(buttonPanel, BorderLayout.SOUTH);

        startB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("The app is opening");
                dispose();
                new StickyNotesApp().setVisible(true);
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}