package parabola;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameParabola extends javax.swing.JFrame implements ActionListener {

    private Graphics graphics;

    public FrameParabola() {
        initComponents();

        graphics = this.getGraphics();

        jButtonArriba.addActionListener(this);
        jButtonAbajo.addActionListener(this);
        jButtonIzquierda.addActionListener(this);
        jButtonDerecha.addActionListener(this);
        jButtonBorrar.addActionListener(this);

    }

    private void borrar(Graphics g) {
        g.clearRect(50, 80, 300, 220);
        jLabel.setText("Parabolas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        jButtonArriba = new javax.swing.JButton();
        jButtonAbajo = new javax.swing.JButton();
        jButtonIzquierda = new javax.swing.JButton();
        jButtonDerecha = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parabolas");
        setResizable(false);

        jToolBar.setRollover(true);

        jButtonArriba.setText("Arriba");
        jButtonArriba.setMaximumSize(new java.awt.Dimension(70, 27));
        jToolBar.add(jButtonArriba);

        jButtonAbajo.setText("Abajo");
        jButtonAbajo.setMaximumSize(new java.awt.Dimension(70, 27));
        jToolBar.add(jButtonAbajo);

        jButtonIzquierda.setText("Izquierda");
        jToolBar.add(jButtonIzquierda);

        jButtonDerecha.setText("Derecha");
        jButtonDerecha.setMaximumSize(new java.awt.Dimension(70, 27));
        jToolBar.add(jButtonDerecha);

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.setMaximumSize(new java.awt.Dimension(70, 27));
        jToolBar.add(jButtonBorrar);

        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("Parabolas");
        jLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameParabola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbajo;
    private javax.swing.JButton jButtonArriba;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonDerecha;
    private javax.swing.JButton jButtonIzquierda;
    private javax.swing.JLabel jLabel;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jButtonArriba)) {
            graphics.drawArc(160, 10, 100, 250, 180, 180);
            jLabel.setText("Parabola hacia arriba");
        }
        if (e.getSource().equals(jButtonAbajo)) {
            graphics.drawArc(160, 100, 100, 250, 0, 180);
            jLabel.setText("Parabola hacia abajo");
        }
        if (e.getSource().equals(jButtonIzquierda)) {
            graphics.drawArc(120, 120, 250, 100, 90, 180);
            jLabel.setText("Parabola hacia la izquierda");
        }
        if (e.getSource().equals(jButtonDerecha)) {
            graphics.drawArc(50, 120, 250, 100, 270, 180);
            jLabel.setText("Parabola hacia derecha");
        }
        if (e.getSource().equals(jButtonBorrar)) {
            borrar(graphics);
        }
    }
}
