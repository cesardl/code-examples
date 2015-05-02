package cronometro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameCronometro extends JFrame implements ActionListener {

    private Cronometro c;
    private int inicio;

    public FrameCronometro() {
        initComponents();

        inicio = 0;

        buttonIniciar.addActionListener(this);
        buttonEmpezar.addActionListener(this);
        buttonDetener.addActionListener(this);
        buttonContinuar.addActionListener(this);
        buttonTerminar.addActionListener(this);
        toggleButtonAscendente.addActionListener(this);
        toggleButtonDescendente.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        toggleButtonAscendente = new javax.swing.JToggleButton();
        toggleButtonDescendente = new javax.swing.JToggleButton();
        labelModo = new javax.swing.JLabel();
        labelCronometro = new javax.swing.JLabel();
        toolBar = new javax.swing.JToolBar();
        buttonEmpezar = new javax.swing.JButton();
        buttonDetener = new javax.swing.JButton();
        buttonContinuar = new javax.swing.JButton();
        buttonTerminar = new javax.swing.JButton();
        buttonIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro");

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Desde:");

        textField.setEnabled(false);

        buttonGroup.add(toggleButtonAscendente);
        toggleButtonAscendente.setSelected(true);
        toggleButtonAscendente.setText("Ascendente");

        buttonGroup.add(toggleButtonDescendente);
        toggleButtonDescendente.setText("Descendente");

        labelModo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelModo.setText("Modo:");

        labelCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCronometro.setText("00:00:00");
        labelCronometro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        toolBar.setRollover(true);

        buttonEmpezar.setText("Empezar");
        buttonEmpezar.setEnabled(false);
        buttonEmpezar.setFocusable(false);
        buttonEmpezar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonEmpezar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonEmpezar);

        buttonDetener.setText("Detener");
        buttonDetener.setEnabled(false);
        buttonDetener.setFocusable(false);
        buttonDetener.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDetener.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonDetener);

        buttonContinuar.setText("Continuar");
        buttonContinuar.setEnabled(false);
        buttonContinuar.setFocusable(false);
        buttonContinuar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonContinuar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonContinuar);

        buttonTerminar.setText("Terminar");
        buttonTerminar.setEnabled(false);
        buttonTerminar.setFocusable(false);
        buttonTerminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonTerminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonTerminar);

        buttonIniciar.setText("Inicar");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(labelCronometro, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelModo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toggleButtonAscendente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleButtonDescendente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelModo)
                    .addComponent(toggleButtonAscendente)
                    .addComponent(toggleButtonDescendente)
                    .addComponent(buttonIniciar))
                .addGap(18, 18, 18)
                .addComponent(labelCronometro, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int aInteger(String s) {
        try {
            int valor = Integer.parseInt(s.trim());
            return valor;
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public void iniciar() {
        if (toggleButtonDescendente.isSelected()) {
            inicio = aInteger(textField.getText().trim());
            if (inicio == -1) {
                JOptionPane.showMessageDialog(this, "Ingrese entero",
                        "Cronometro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                buttonEmpezar.setEnabled(true);
                textField.setEnabled(false);
                buttonIniciar.setEnabled(false);
                toggleButtonAscendente.setEnabled(false);
                toggleButtonDescendente.setEnabled(false);
            }
        }
    }

    public void actionPerformed(ActionEvent evt) {
        if (toggleButtonAscendente.isSelected()) {
            textField.setEnabled(false);
        }
        if (toggleButtonDescendente.isSelected()) {
            textField.setEnabled(true);
        }
        if (evt.getSource().equals(buttonIniciar)) {
            iniciar();
        }
        if (evt.getSource().equals(buttonEmpezar)) {
            boolean modo = toggleButtonAscendente.isSelected();
            c = new Cronometro(inicio, modo, labelCronometro);
            c.start();
            buttonEmpezar.setEnabled(false);
            buttonDetener.setEnabled(true);
            buttonTerminar.setEnabled(true);
        }
        if (evt.getSource().equals(buttonDetener)) {
            c.suspend();
            buttonDetener.setEnabled(false);
            buttonContinuar.setEnabled(true);
        }
        if (evt.getSource().equals(buttonContinuar)) {
            c.resume();
            buttonDetener.setEnabled(true);
            buttonContinuar.setEnabled(false);
        }
        if (evt.getSource().equals(buttonTerminar)) {
            c.stop();
            labelCronometro.setText("00 : 00 : 00");
            buttonEmpezar.setEnabled(true);
            buttonDetener.setEnabled(false);
            buttonContinuar.setEnabled(false);
            buttonTerminar.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonContinuar;
    private javax.swing.JButton buttonDetener;
    private javax.swing.JButton buttonEmpezar;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton buttonIniciar;
    private javax.swing.JButton buttonTerminar;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelCronometro;
    private javax.swing.JLabel labelModo;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textField;
    private javax.swing.JToggleButton toggleButtonAscendente;
    private javax.swing.JToggleButton toggleButtonDescendente;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
