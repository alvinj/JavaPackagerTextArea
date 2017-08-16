import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.util.Map;
import java.util.Properties;
import java.util.Enumeration;

public class MacJavaPropertiesApp {

    public static void main(String[] args) {
        new MacJavaPropertiesApp();
    }

    public MacJavaPropertiesApp() {
        SwingUtilities.invokeLater(() -> {

            // system properties
            String s = "\nSYSTEM PROPERTIES\n";
            Properties p = System.getProperties();
            Enumeration keys = p.keys();
            while (keys.hasMoreElements()) {
                String key = (String)keys.nextElement();
                String value = (String)p.get(key);
                System.out.println(key + ": " + value);
                s = s + key + ": " + value + "\n";
            }

            // environment variables
            s = s + "\n\nENVIRONMENT VARIABLES\n";
            Map<String, String> env = System.getenv();
            for (String envName : env.keySet()) {
                s = s + "\n";
                s = s + envName + ": " + env.get(envName);
            }
    
            JTextArea textArea = new JTextArea();
            textArea.setText(s);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JFrame frame = new JFrame("Mac/Java Properties");
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(600, 400));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}



