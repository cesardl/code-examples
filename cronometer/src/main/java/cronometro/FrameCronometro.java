package cronometro;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.MaskFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cesardiaz
 */
public class FrameCronometro extends javax.swing.JFrame {

    private static final Logger log = LoggerFactory.getLogger(FrameCronometro.class);

    private final Timer timer;
    private final Cronometro timerListener;

    public FrameCronometro() {
        initComponents();

        timerListener = new Cronometro(labelCronometer);
        timer = new Timer(100, timerListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup = new javax.swing.ButtonGroup();
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.JLabel label = new javax.swing.JLabel();
        textField = new javax.swing.JFormattedTextField();
        javax.swing.JToggleButton toggleButtonAscendente = new javax.swing.JToggleButton();
        javax.swing.JToggleButton toggleButtonDescendente = new javax.swing.JToggleButton();
        javax.swing.JLabel labelMode = new javax.swing.JLabel();
        labelCronometer = new javax.swing.JLabel();
        javax.swing.JToolBar toolBar = new javax.swing.JToolBar();
        buttonEmpezar = new javax.swing.JButton();
        buttonDetener = new javax.swing.JButton();
        buttonTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro");
        setResizable(false);

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Desde:");

        textField.setEnabled(false);
        try {
            MaskFormatter dateMask = new MaskFormatter("##:##:##");
            dateMask.setPlaceholderCharacter('0');
            dateMask.install(textField);
        } catch (ParseException ex) {
            log.error(ex.getMessage(), ex);
        }

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

        buttonTerminar.setText("Terminar");
        buttonTerminar.setFocusable(false);
        buttonTerminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonTerminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTerminarActionPerformed(evt);
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
                        .addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
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
                    .addComponent(labelMode)
                    .addComponent(toggleButtonAscendente)
                    .addComponent(toggleButtonDescendente)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void toggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toggleButtonItemStateChanged
        if (timer.isRunning()) {
            log.info("Chronometer is running");
            return;
        }

        javax.swing.JToggleButton source = (javax.swing.JToggleButton) evt.getSource();

        if (source.isSelected()) {
            timerListener.setMode(Mode.UP);

            textField.setEnabled(false);
        } else {
            timerListener.setMode(Mode.DOWN);

            textField.setEnabled(true);
            textField.requestFocus();
        }
    }//GEN-LAST:event_toggleButtonItemStateChanged

    private void buttonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEmpezarActionPerformed
        if (Mode.DOWN.equals(timerListener.getMode())) {
            try {
                timerListener.setInicio(textField.getText());
            } catch (IllegalArgumentException e) {
                log.warn(e.getMessage());
                JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        textField.setEnabled(false);
        timer.start();

        buttonEmpezar.setEnabled(false);
        buttonDetener.setEnabled(true);
        buttonTerminar.setEnabled(false);

        log.info("Timer start '{}'", evt.getActionCommand());
    }//GEN-LAST:event_buttonEmpezarActionPerformed

    private void buttonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetenerActionPerformed
        timer.stop();

        buttonEmpezar.setEnabled(true);
        buttonDetener.setEnabled(false);
        buttonTerminar.setEnabled(true);

        log.info("Timer stop '{}'", evt.getActionCommand());
    }//GEN-LAST:event_buttonDetenerActionPerformed

    private void buttonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTerminarActionPerformed
        timerListener.init();

        if (Mode.DOWN.equals(timerListener.getMode())) {
            textField.setEnabled(true);
        }

        log.info("Timer finished '{}'", evt.getActionCommand());
    }//GEN-LAST:event_buttonTerminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDetener;
    private javax.swing.JButton buttonEmpezar;
    private javax.swing.JButton buttonTerminar;
    private javax.swing.JLabel labelCronometer;
    private javax.swing.JFormattedTextField textField;
    // End of variables declaration//GEN-END:variables
}
