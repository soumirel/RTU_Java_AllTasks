
package rtu.task15;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditorWindow extends JFrame {
    private final String PATH = "C:\\Users\\soumireL\\Code\\Java\\RTU\\src\\rtu\\task15\\output";
    private final JTextArea textArea;
    private final ICreateDocument createDocument;
    private IDocument document;
    private File selectedFile;
    public EditorWindow(ICreateDocument createDocument) {
        this.createDocument = createDocument;
        textArea = new JTextArea();
    }
    public void run(){
        final int WIDTH = 520;
        final int HEIGHT = 500;

        final String FILE = "File";
        final String NEW = "New";
        final String OPEN = "Open";
        final String SAVE = "Save";
        final String SAVED = "Saved!";
        final String EXIT = "EXIT";

        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu(FILE);

        JMenuItem itemNew = new JMenuItem(NEW);
        JMenuItem itemOpen = new JMenuItem(OPEN);
        JMenuItem itemSave = new JMenuItem(SAVE);
        JMenuItem itemExit = new JMenuItem(EXIT);

        itemNew.addActionListener(e -> {
            createAndOpenNewDocument();
        });

        itemOpen.addActionListener(e -> {
            selectedFile = getSelectedFile();
            if(selectedFile != null){
                document = createDocument.createOpen();
                openSelectedFile();
            }
        });

        itemSave.addActionListener(e -> {
            if(selectedFile == null)
                return;

            try (FileWriter writer = new FileWriter(selectedFile.getAbsolutePath())){
                    writer.write(textArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(this, SAVED);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        itemExit.addActionListener(e -> {
            dispose();
        });

        menu.add(itemNew);
        menu.add(itemOpen);
        menu.add(itemSave);
        menu.add(itemExit);

        menuBar.add(menu);

        setJMenuBar(menuBar);
        add(textArea);
        textArea.setFocusable(false);
        setVisible(true);
    }

    private void createAndOpenNewDocument(){
        String name = getEnteredName();
        if(name == null)
            return;
        name += ".txt";

        document = createDocument.createNew();
        selectedFile = new File(PATH, name);

        try {
            selectedFile.createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        openSelectedFile();
    }

    private void openSelectedFile(){
        textArea.setText("");
        setTitle(selectedFile.getName());

        try(FileReader reader = new FileReader(selectedFile.getAbsolutePath()))
        {
            StringBuilder stringBuilder = new StringBuilder();
            int currentCharacter;
            while((currentCharacter=reader.read())!=-1){
                stringBuilder.append((char)currentCharacter);
            }
            reader.close();
            textArea.setText(stringBuilder.toString());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        textArea.setFocusable(true);
        textArea.requestFocus();
    }

    private File getSelectedFile(){
        JFileChooser fileChooser = new JFileChooser(PATH);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);

        return fileChooser.getSelectedFile();
    }

    private String getEnteredName(){
        return JOptionPane.showInputDialog(
                this,
                "Enter the file name.",
                "New file",
                JOptionPane.PLAIN_MESSAGE);
    }
}
