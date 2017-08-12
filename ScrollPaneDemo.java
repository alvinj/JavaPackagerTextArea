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

public class ScrollPaneDemo
{
  public static void main(String[] args)
  {
    new ScrollPaneDemo();
  }
  
  public ScrollPaneDemo()
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        // create a jtextarea
        JTextArea textArea = new JTextArea();

        String s = "\nSYSTEM PROPERTIES\n";
        Properties p = System.getProperties();
        Enumeration keys = p.keys();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = (String)p.get(key);
            System.out.println(key + ": " + value);
            s = s + key + ": " + value + "\n";
        }

        s = s + "\n\nENVIRONMENT VARIABLES\n";
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            s = s + "\n";
            s = s + envName + ": " + env.get(envName);
        }
        
        // add text to it; we want to make it scroll
        //textArea.setText("xx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\n");
        textArea.setText(s);
        
        // create a scrollpane, givin it the textarea as a constructor argument
        JScrollPane scrollPane = new JScrollPane(textArea);

        // now add the scrollpane to the jframe's content pane, specifically
        // placing it in the center of the jframe's borderlayout
        JFrame frame = new JFrame("Mac/Java Properties");
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // make it easy to close the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the frame size (you'll usually want to call frame.pack())
        frame.setSize(new Dimension(600, 400));
        
        // center the frame
        frame.setLocationRelativeTo(null);
        
        // make it visible to the user
        frame.setVisible(true);
      }
    });
  }
}



