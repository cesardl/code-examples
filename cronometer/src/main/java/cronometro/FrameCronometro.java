package cronometro;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameCronometro extends JFrame {

    private static final Logger log = LoggerFactory.getLogger(FrameCronometro.class);

    private CronometerWorker worker;
//    private int inicio;

    public FrameCronometro() {
        initComponents();

//        inicio = 0;
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
        labelMode = new javax.swing.JLabel();
        labelCronometer = new javax.swing.JLabel();
        toolBar = new javax.swing.JToolBar();
        buttonEmpezar = new javax.swing.JButton();
        buttonDetener = new javax.swing.JButton();
        buttonContinuar = new javax.swing.JButton();
        buttonTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro");

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Desde:");

        textField.setEnabled(false);

        buttonGroup.add(toggleButtonAscendente);
        toggleButtonAscendente.setSelected(true);
        toggleButtonAscendente.setText("Ascendente");
        toggleButtonAscendente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toggleButtonItemStateChanged(evt);
            }
        });

        buttonGroup.add(toggleButtonDescendente);
        toggleButtonDescendente.setText("Descendente");

        labelMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMode.setText("Modo:");

        labelCronometer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelCronometer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCronometer.setText("00 : 00 : 00");
        labelCronometer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        toolBar.setRollover(true);

        buttonEmpezar.setText("Empezar");
        buttonEmpezar.setFocusable(false);
        buttonEmpezar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonEmpezar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEmpezarActionPerformed(evt);
            }
        });
        toolBar.add(buttonEmpezar);

        buttonDetener.setText("Detener");
        buttonDetener.setEnabled(false);
        buttonDetener.setFocusable(false);
        buttonDetener.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDetener.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetenerActionPerformed(evt);
            }
        });
        toolBar.add(buttonDetener);

        buttonContinuar.setText("Continuar");
        buttonContinuar.setEnabled(false);
        buttonContinuar.setFocusable(false);
        buttonContinuar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonContinuar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolBarButtonActionPerformed(evt);
            }
        });
        toolBar.add(buttonContinuar);

        buttonTerminar.setText("Terminar");
        buttonTerminar.setEnabled(false);
        buttonTerminar.setFocusable(false);
        buttonTerminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonTerminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolBarButtonActionPerformed(evt);
            }
        });
        toolBar.add(buttonTerminar);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCronometer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMode, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toggleButtonAscendente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleButtonDescendente)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMode)
                    .addComponent(toggleButtonAscendente)
                    .addComponent(toggleButtonDescendente))
                .addGap(18, 18, 18)
                .addComponent(labelCronometer, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void toggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toggleButtonItemStateChanged
        // TODO add your handling code here:
        JToggleButton b = (JToggleButton) evt.getSource();
        System.out.println(b.getText() + " - " + b.isSelected());
    }//GEN-LAST:event_toggleButtonItemStateChanged

    private void toolBarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolBarButtonActionPerformed
        if (evt.getSource().equals(buttonContinuar)) {
            // TODO worker.resume();
            buttonDetener.setEnabled(true);
            buttonContinuar.setEnabled(false);
        }
        if (evt.getSource().equals(buttonTerminar)) {
            // TODO worker.stop();
            labelCronometer.setText("00 : 00 : 00");
            buttonEmpezar.setEnabled(true);
            buttonDetener.setEnabled(false);
            buttonContinuar.setEnabled(false);
            buttonTerminar.setEnabled(false);
        }
    }//GEN-LAST:event_toolBarButtonActionPerformed

    private void buttonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEmpezarActionPerformed
        try {
            worker = new CronometerWorker(labelCronometer);

            worker.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(
                        final PropertyChangeEvent event) {
                    switch (event.getPropertyName()) {
                        case "progress":
//                                            progressBar.setIndeterminate(false);
//                                            progressBar.setValue((Integer) event
//                                                    .getNewValue());
                            log.info("Progress value {}", event.getNewValue());
                            break;

                        case "state":
                            log.info("Status value {}", event.getNewValue());
                            switch ((SwingWorker.StateValue) event.getNewValue()) {
                                case DONE:
//                                                    setEnabledAllButtons(true);
                                    buttonEmpezar.setEnabled(true);
                                    buttonDetener.setEnabled(false);
                                    worker = null;
//                                                    if (progressBar.isIndeterminate()) {
//                                                        progressBar
//                                                        .setIndeterminate(false);
//                                                    }
//                                                    progressBar.setValue(0);
                                    break;

                                case STARTED:
                                case PENDING:
//                                                    progressBar.setIndeterminate(true);
                                    break;
                            }
                            break;
                    }
                }
            });
            worker.execute();

            buttonEmpezar.setEnabled(false);
            buttonDetener.setEnabled(true);
            buttonTerminar.setEnabled(true);
        } catch (Exception e) {
//            textAreaLog.append(e.getClass().getCanonicalName() + ": "
//                    + e.getMessage() + "\n\n");
            log.error(e.getMessage(), e);
        }
    }//GEN-LAST:event_buttonEmpezarActionPerformed

    private void buttonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetenerActionPerformed
        // TODO add your handling code here:
        worker.cancel(true);
        log.info("Stoped");
    }//GEN-LAST:event_buttonDetenerActionPerformed

    private int aInteger(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonContinuar;
    private javax.swing.JButton buttonDetener;
    private javax.swing.JButton buttonEmpezar;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton buttonTerminar;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelCronometer;
    private javax.swing.JLabel labelMode;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textField;
    private javax.swing.JToggleButton toggleButtonAscendente;
    private javax.swing.JToggleButton toggleButtonDescendente;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
