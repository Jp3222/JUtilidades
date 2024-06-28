/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jutilidades;

import com.jutil.swingw.SwFactories.FactorySw;
import com.jutil.swingw.subcomponents.CDate;
import com.jutil.swingw.subcomponents.sub.SubComponent.FormComponent;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author jp
 */
public class JUtilidades {

    public static void main(String[] args) throws Exception {
        FactorySw.setDefaultLookAndFeel();
        JFrame frame = FactorySw.getDefaultFrame();
        frame.setPreferredSize(FactorySw.getDimension(300, 600));
        frame.setLayout(new GridLayout(7, 1, 5, 5));

        FormComponent campo_nombre = new FormComponent("Nombre", new JTextField());
        FormComponent campo_apellidos = new FormComponent("Apellidos", new JTextField());
        FormComponent campo_edad = new FormComponent("Edad", new JSpinner(new SpinnerNumberModel(18, 15, 90, 1)));
        FormComponent campo_estado_civil = new FormComponent("Estado Civil", new JCheckBox("Casado"));
        FormComponent campo_fn = new FormComponent("Fecha de nacimiento", new CDate());
        FormComponent campo_estado = new FormComponent("Estado", new JComboBox(new DefaultComboBoxModel(new String[]{
            "Activo", "Inactivo"
        })));

        JButton btn = FactorySw.getButton("Mostrar Datos");

        FormComponent[] campos = {
            campo_nombre,
            campo_apellidos,
            campo_edad,
            campo_estado_civil,
            campo_fn,
            campo_estado
        };
        btn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (FormComponent i : campos) {
                if (i.getValue().isEmpty()) {
                    continue;
                }
                sb.append(i.getName()).append(": ").append(i.getValue().get()).append("\n");
            }
            JOptionPane.showConfirmDialog(null, sb.toString());
            for (FormComponent i : campos) {
                i.initialState();
            }
        });

        for (FormComponent i : campos) {
            frame.add(i);
        }
        frame.add(btn);

    }

}
