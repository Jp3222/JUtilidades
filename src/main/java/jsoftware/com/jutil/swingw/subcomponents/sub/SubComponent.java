/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsoftware.com.jutil.swingw.subcomponents.sub;

import jsoftware.com.jutil.framework.ComponentStates;
import java.awt.BorderLayout;
import java.util.Date;
import java.util.Optional;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author juan-campos
 */
public abstract class SubComponent extends JPanel implements ComponentStates {

    public SubComponent() {
        super(new BorderLayout());
    }

    public abstract <T> T getValue();

    public abstract <T> void setValue(T data);

}
