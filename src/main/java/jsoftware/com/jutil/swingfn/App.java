/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.swingfn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

/**
 *
 * @author juan-campos
 */
public class App {

    public static final String TEXT = "text";
    public static final String PASSWORD = "password";
    public static final String TEXT_AREA = "text-area";
    public static final String TEXT_PANE = "text-pane";

    private final JFrame root;
    private final JPanel panel_root;
    private final LayoutManager ly;

    public App(String title) {
        root = new JFrame(title);
        root.setPreferredSize(new Dimension(600, 600));
        root.setLocationRelativeTo(null);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.pack();
        ly = new BorderLayout();
        panel_root = new JPanel(ly);
        root.setContentPane(panel_root);
    }

    public App addComponent(String component, AppComponent com) {
        JComponent c;
        if (com == null) {
            JLabel o = new JLabel("Hola mundo");
            o.setHorizontalAlignment(SwingConstants.CENTER);
            c = o;
        } else {
            c = switch (component) {
                case TEXT:
                    yield new JTextField();
                case PASSWORD:
                    yield new JPasswordField();
                case TEXT_AREA:
                    yield new JTextArea();
                case TEXT_PANE:
                    yield new JTextPane();
                default:
                    yield new JPanel();
            };
            c = com.component(c);
        }

        root.add(c, BorderLayout.CENTER);
        return this;
    }

    public JFrame getRoot() {
        return root;
    }

}
