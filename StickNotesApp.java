import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class StickyNotesApp extends JFrame {

    JPanel mainP = new JPanel();
    JPanel savedNotesP = new JPanel();
    JPanel buttonP = new JPanel();
    JLabel titleL = new JLabel("Sticky Notes App");
    JButton createB = new JButton("Create Note");
    JButton saveB = new JButton("Save Note");
    JButton showSavedB = new JButton("Show Saved Notes");
    JButton colorB = new JButton("Change Color");
    JButton exitB = new JButton("Exit");
    JColorChooser colorChooser = new JColorChooser();
    Color currentColor = Color.green;
    ArrayList<JTextArea> noteAreas = new ArrayList<>();

    public StickyNotesApp() {
        setTitle("Sticky Notes");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleL.setFont(new Font("Arial", Font.BOLD, 24));
        titleL.setHorizontalAlignment(JLabel.CENTER);
        add(titleL, BorderLayout.NORTH);
        createB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea newNoteArea = new JTextArea();
                newNoteArea.setPreferredSize(new Dimension(400,250));
                newNoteArea.setBackground(currentColor);
                newNoteArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                mainP.add(newNoteArea);
                noteAreas.add(newNoteArea);
                mainP.revalidate();
                mainP.repaint();
            }});
        saveB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            for (JTextArea noteArea : noteAreas) {
                JTextArea savedNoteArea = new JTextArea(noteArea.getText());
                savedNoteArea.setEditable(true);
                savedNoteArea.setBackground(noteArea.getBackground());
                savedNoteArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                savedNotesP.add(new JScrollPane(savedNoteArea));}
            noteAreas.clear();
            mainP.removeAll();
            mainP.revalidate();
            mainP.repaint();
            savedNotesP.revalidate();
            savedNotesP.repaint();}
        });
        showSavedB.addActionListener(new ActionListener() {@Override
            public void actionPerformed(ActionEvent e) {
                JFrame savedNotesFrame = new JFrame("Saved Notes");
                savedNotesFrame.setLayout(new BorderLayout());
                savedNotesFrame.add(new JScrollPane(savedNotesP), BorderLayout.CENTER);
                savedNotesFrame.setSize(600, 400);
                savedNotesFrame.setLocationRelativeTo(null);
                savedNotesFrame.setVisible(true);
            }
        });
        colorB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(StickyNotesApp.this, "Choose a Color", currentColor);
                if (newColor != null) {
                    currentColor = newColor;
                }
            }
        });

        exitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting Sticky Note App...");
                System.exit(0);
            }
        });

        mainP.setBackground(Color.LIGHT_GRAY);

        createB.setBackground(Color.blue);
        saveB.setBackground(Color.blue);
        showSavedB.setBackground(Color.blue);
        colorB.setBackground(Color.blue);
        exitB.setBackground(Color.RED);


        buttonP.add(createB);

        buttonP.add(saveB);

        buttonP.add(showSavedB);

        buttonP.add(colorB);

        buttonP.add(exitB);

        add(buttonP, BorderLayout.SOUTH);

        add(new JScrollPane(mainP), BorderLayout.CENTER);
        add(new JScrollPane(mainP), BorderLayout.CENTER);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {

        new StartApp().setVisible(true);
    }
}





