package chronometer;

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
public class FrameChronometer extends javax.swing.JFrame implements Chronometer.OnTimerWorksListener {

    private static final Logger log = LoggerFactory.getLogger(FrameChronometer.class);

    private final Timer timer;
    private final Chronometer timerListener;

    public FrameChronometer() {
        initComponents();

        timerListener = new Chronometer(this);
        timer = new Timer(100, timerListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup = new javax.swing.ButtonGroup();
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.JLabel labelFrom = new javax.swing.JLabel();
        textField = new javax.swing.JFormattedTextField();
        toggleButtonUp = new javax.swing.JToggleButton();
        toggleButtonDown = new javax.swing.JToggleButton();
        javax.swing.JLabel labelMode = new javax.swing.JLabel();
        labelChronometer = new javax.swing.JLabel();
        javax.swing.JToolBar toolBar = new javax.swing.JToolBar();
        buttonStart = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();
        buttonFinish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro");
        setResizable(false);

        labelFrom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFrom.setText("Desde:");

        textField.setEnabled(false);
        try {
            MaskFormatter dateMask = new MaskFormatter("##:##:##");
            dateMask.setPlaceholderCharacter('0');
            dateMask.install(textField);
        } catch (ParseException ex) {
            log.error(ex.getMessage(), ex);
        }

        buttonGroup.add(toggleButtonUp);
        toggleButtonUp.setSelected(true);
        toggleButtonUp.setText("Ascendente");
        toggleButtonUp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toggleButtonItemStateChanged(evt);
            }
        });

        buttonGroup.add(toggleButtonDown);
        toggleButtonDown.setText("Descendente");

        labelMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMode.setText("Modo:");

        labelChronometer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelChronometer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelChronometer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        toolBar.setRollover(true);

        buttonStart.setText("Empezar");
        buttonStart.setFocusable(false);
        buttonStart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonStart.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });
        toolBar.add(buttonStart);

        buttonStop.setText("Detener");
        buttonStop.setEnabled(false);
        buttonStop.setFocusable(false);
        buttonStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });
        toolBar.add(buttonStop);

        buttonFinish.setText("Terminar");
        buttonFinish.setEnabled(false);
        buttonFinish.setFocusable(false);
        buttonFinish.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonFinish.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFinishActionPerformed(evt);
            }
        });
        toolBar.add(buttonFinish);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelChronometer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(labelFrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(labelMode, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toggleButtonUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleButtonDown)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFrom)
                    .addComponent(labelMode)
                    .addComponent(toggleButtonUp)
                    .addComponent(toggleButtonDown)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelChronometer, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
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
        javax.swing.JToggleButton source = (javax.swing.JToggleButton) evt.getSource();

        if (source.isSelected()) {
            timerListener.setMode(Mode.UP);

            textField.setEnabled(false);
        } else {
            timerListener.setMode(Mode.DOWN);

            textField.setEnabled(true);
            textField.requestFocus();
        }

        log.info("Setting mode '{}'", timerListener.getMode());
    }//GEN-LAST:event_toggleButtonItemStateChanged

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        switch (timerListener.getMode()) {
            case UP:
                toggleButtonDown.setEnabled(false);
                break;

            case DOWN:
                if (textField.isEnabled()) {
                    try {
                        timerListener.setStart(textField.getText());

                        toggleButtonUp.setEnabled(false);
                    } catch (IllegalArgumentException e) {
                        log.warn(e.getMessage());
                        JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                break;
        }

        textField.setEnabled(false);
        timer.start();

        buttonStart.setEnabled(false);
        buttonStop.setEnabled(true);
        buttonFinish.setEnabled(false);

        log.info("Timer start '{}'", evt.getActionCommand());
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        timer.stop();

        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
        buttonFinish.setEnabled(true);

        log.info("Timer stop '{}'", evt.getActionCommand());
    }//GEN-LAST:event_buttonStopActionPerformed

    private void buttonFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFinishActionPerformed
        timerListener.init();

        switch (timerListener.getMode()) {
            case UP:
                toggleButtonDown.setEnabled(true);
                break;

            case DOWN:
                textField.setEnabled(true);
                toggleButtonUp.setEnabled(true);
                break;
        }

        buttonFinish.setEnabled(false);

        log.info("Timer finished '{}'", evt.getActionCommand());
    }//GEN-LAST:event_buttonFinishActionPerformed

    @Override
    public void finishTimerDown() {
        log.warn("Down mode was finished");

        timer.stop();

        textField.setEnabled(true);
        toggleButtonUp.setEnabled(true);

        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
        buttonFinish.setEnabled(false);
    }

    @Override
    public void printTime(String message) {
        labelChronometer.setText(message);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFinish;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonStop;
    private javax.swing.JLabel labelChronometer;
    private javax.swing.JFormattedTextField textField;
    private javax.swing.JToggleButton toggleButtonDown;
    private javax.swing.JToggleButton toggleButtonUp;
    // End of variables declaration//GEN-END:variables
}
