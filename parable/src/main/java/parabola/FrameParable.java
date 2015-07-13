package parabola;

/**
 *
 * @author Cesardl
 */
public class FrameParable extends javax.swing.JFrame {

    public FrameParable() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JToolBar toolBar = new javax.swing.JToolBar();
        buttonArriba = new javax.swing.JButton();
        buttonAbajo = new javax.swing.JButton();
        buttonIzquierda = new javax.swing.JButton();
        buttonDerecha = new javax.swing.JButton();
        buttonBorrar = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parabolas");
        setResizable(false);

        buttonArriba.setText("Arriba");
        buttonArriba.setMaximumSize(new java.awt.Dimension(70, 27));
        buttonArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        toolBar.add(buttonArriba);

        buttonAbajo.setText("Abajo");
        buttonAbajo.setMaximumSize(new java.awt.Dimension(70, 27));
        buttonAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        toolBar.add(buttonAbajo);

        buttonIzquierda.setText("Izquierda");
        buttonIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        toolBar.add(buttonIzquierda);

        buttonDerecha.setText("Derecha");
        buttonDerecha.setMaximumSize(new java.awt.Dimension(70, 27));
        buttonDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        toolBar.add(buttonDerecha);

        buttonBorrar.setText("Borrar");
        buttonBorrar.setMaximumSize(new java.awt.Dimension(70, 27));
        buttonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        toolBar.add(buttonBorrar);

        labelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatus.setText("Parabolas");
        labelStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        java.awt.Graphics graphics = getGraphics();

        if (evt.getSource().equals(buttonArriba)) {
            graphics.drawArc(160, 10, 100, 250, 180, 180);
            labelStatus.setText("Parabola hacia arriba");
        }
        if (evt.getSource().equals(buttonAbajo)) {
            graphics.drawArc(160, 100, 100, 250, 0, 180);
            labelStatus.setText("Parabola hacia abajo");
        }
        if (evt.getSource().equals(buttonIzquierda)) {
            graphics.drawArc(120, 120, 250, 100, 90, 180);
            labelStatus.setText("Parabola hacia la izquierda");
        }
        if (evt.getSource().equals(buttonDerecha)) {
            graphics.drawArc(50, 120, 250, 100, 270, 180);
            labelStatus.setText("Parabola hacia derecha");
        }
        if (evt.getSource().equals(buttonBorrar)) {
            graphics.clearRect(50, 50, 270, 220);
            labelStatus.setText("Parabolas");
        }
    }//GEN-LAST:event_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbajo;
    private javax.swing.JButton buttonArriba;
    private javax.swing.JButton buttonBorrar;
    private javax.swing.JButton buttonDerecha;
    private javax.swing.JButton buttonIzquierda;
    private javax.swing.JLabel labelStatus;
    // End of variables declaration//GEN-END:variables

}
