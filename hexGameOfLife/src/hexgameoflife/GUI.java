package hexgameoflife;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author Wiktoria Kalata 20057
 */
public class GUI extends javax.swing.JFrame {
    private final Hexboard hexgame;
    private int birthNum;
    private int survivalNum;
    private int turnNum;
    private Thread animationThread;
    private volatile boolean stopRequested = false;
    private final int bsize;
    private Map<String, int[][]> history_dict = new HashMap<>();
    
    
    public GUI(int bsize) {
        initComponents();
        stopBttn.setEnabled(false);
        setToolTips();
        this.bsize = bsize;
        boardSizeTf.setText(String.valueOf(bsize));
        hexgame = new Hexboard(this, bsize);
        previousStateBttn.setEnabled(false);
        nextStateBttn.setEnabled(false);
    }
    
        /**
        * Main method to launch the GUI application.
        *
        * @param args The command line arguments.
        */
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI(24);
            gui.setVisible(true);
            //gui.hexgame = new Hexboard(gui, 24);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        birthNumberTf = new javax.swing.JTextField();
        survivalNumTf = new javax.swing.JTextField();
        turnsNumTf = new javax.swing.JTextField();
        resetBttn = new javax.swing.JButton();
        stopBttn = new javax.swing.JButton();
        startBttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        boardSizeTf = new javax.swing.JTextField();
        OkButton = new javax.swing.JButton();
        currentTurnTf = new javax.swing.JLabel();
        nextStateBttn = new javax.swing.JButton();
        previousStateBttn = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        birthNumberTf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birthNumberTf.setText("2");
        birthNumberTf.setName(""); // NOI18N

        survivalNumTf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        survivalNumTf.setText("2");
        survivalNumTf.setName(""); // NOI18N

        turnsNumTf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        turnsNumTf.setText("10");
        turnsNumTf.setToolTipText("");
        turnsNumTf.setName(""); // NOI18N

        resetBttn.setLabel("Reset");
        resetBttn.setName(""); // NOI18N
        resetBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBttnActionPerformed(evt);
            }
        });

        stopBttn.setLabel("Stop");
        stopBttn.setName(""); // NOI18N
        stopBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBttnActionPerformed(evt);
            }
        });

        startBttn.setLabel("Start");
        startBttn.setName(""); // NOI18N
        startBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBttnActionPerformed(evt);
            }
        });

        jLabel1.setText("Birth:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Survival:");

        jLabel3.setText("Turns:");

        jLabel4.setText("Board size:");

        boardSizeTf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        boardSizeTf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                boardSizeTfCaretUpdate(evt);
            }
        });

        OkButton.setText("Ok");
        OkButton.setEnabled(false);
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        currentTurnTf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentTurnTf.setText("0");
        currentTurnTf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        currentTurnTf.setVerifyInputWhenFocusTarget(false);

        nextStateBttn.setText(">");
        nextStateBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextStateBttnActionPerformed(evt);
            }
        });

        previousStateBttn.setText("<");
        previousStateBttn.setToolTipText("");
        previousStateBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousStateBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 5, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthNumberTf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(survivalNumTf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(turnsNumTf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(boardSizeTf, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resetBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stopBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(previousStateBttn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentTurnTf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextStateBttn)
                        .addGap(60, 60, 60))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(survivalNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turnsNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(boardSizeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OkButton))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentTurnTf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nextStateBttn)
                    .addComponent(previousStateBttn))
                .addGap(40, 40, 40)
                .addComponent(resetBttn)
                .addGap(18, 18, 18)
                .addComponent(stopBttn)
                .addGap(18, 18, 18)
                .addComponent(startBttn)
                .addGap(19, 19, 19))
        );

        turnsNumTf.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(650, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Handles the action when the Start button is clicked, initiating the animation thread.
    *
    * @param evt The ActionEvent associated with the button click.
    */
    private void startBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBttnActionPerformed
        birthNum = getBirthsNum();
        survivalNum = getSurvivalNum();
        turnNum = getTurnsNum();
        if(birthNum == -1 || survivalNum ==-1 || turnNum ==-1) {reset(); return;}
        setTfsState(false);
        stopBttn.setEnabled(true);
        resetBttn.setEnabled(false);
        if (animationThread == null || !animationThread.isAlive()) {
            history_dict.put("0", hexgame.getBoard());
            startBttn.setEnabled(false);
            stopRequested = false;
            animationThread = new Thread(() -> {
                for (int i = 0; i< turnNum && !stopRequested; i++){
                    currentTurnTf.setText(String.valueOf(i+1));
                    int[][] board = hexgame.getBoard().clone();
                    int[][] temp = GameLogic.computeNextState(board, survivalNum, birthNum);
                    hexgame.setBoard(temp);
                    
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {}
                    
                    temp = GameLogic.prepareNextGeneration(hexgame.getBoard());
                    hexgame.setBoard(temp);
                    history_dict.put(String.valueOf(i+1), temp);
                    
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {}
                }
                startBttn.setEnabled(true);
                stopBttn.setEnabled(false);
                resetBttn.setEnabled(true);
                setTfsState(true);
            });
            animationThread.start();
        }
    }//GEN-LAST:event_startBttnActionPerformed

    /**
    * Handles the action when the Stop button is clicked, stopping the animation thread.
    *
    * @param evt The ActionEvent associated with the button click.
    */
    private void stopBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBttnActionPerformed
         if (animationThread != null && animationThread.isAlive()) {
            stopRequested = true;
            animationThread.interrupt();
            resetBttn.setEnabled(true);
            startBttn.setEnabled(true);
            setTfsState(true);
            history_dict = new HashMap<>();
        }
    }//GEN-LAST:event_stopBttnActionPerformed

    /**
    * Handles the action when the Reset button is clicked, resetting the game state.
    *
    * @param evt The ActionEvent associated with the button click.
    */
    private void resetBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBttnActionPerformed
        reset();   
    }//GEN-LAST:event_resetBttnActionPerformed

    private void boardSizeTfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_boardSizeTfCaretUpdate
        OkButton.setEnabled(true);
    }//GEN-LAST:event_boardSizeTfCaretUpdate

    
    /**
    * Handles the action when the "Ok" button is clicked, changing the board size.
    *
    * @param evt The ActionEvent associated with the button click.
    */
    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
        int new_size = getBsizeNumber();
        if (new_size == -1) return;
        GUI new_frame = new GUI(new_size);
        new_frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OkButtonActionPerformed

    /**
    * Handles the action when the button is clicked, loading the previous state of the current board.
    *
    * @param evt The ActionEvent associated with the button click.
    */
    private void previousStateBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousStateBttnActionPerformed
        int currentTurn = Integer.parseInt(currentTurnTf.getText());
        currentTurn--;
        if(currentTurn<0)return;
        currentTurnTf.setText(String.valueOf(currentTurn));
        int[][] previousState = history_dict.get(String.valueOf(currentTurn));
        hexgame.setBoard(previousState);
    }//GEN-LAST:event_previousStateBttnActionPerformed

    /**
    * Handles the action when the button is clicked, loading the next state of the current board.
    *
    * @param evt The ActionEvent associated with the button click.
    */
    private void nextStateBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextStateBttnActionPerformed
        int currentTurn = Integer.parseInt(currentTurnTf.getText());
        currentTurn++;
        if(currentTurn>turnNum)return;
        currentTurnTf.setText(String.valueOf(currentTurn));
        int[][] nextState = history_dict.get(String.valueOf(currentTurn));
        hexgame.setBoard(nextState);
    }//GEN-LAST:event_nextStateBttnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OkButton;
    private javax.swing.JTextField birthNumberTf;
    private javax.swing.JTextField boardSizeTf;
    private javax.swing.JLabel currentTurnTf;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nextStateBttn;
    private javax.swing.JButton previousStateBttn;
    private javax.swing.JButton resetBttn;
    private javax.swing.JButton startBttn;
    private javax.swing.JButton stopBttn;
    private javax.swing.JTextField survivalNumTf;
    private javax.swing.JTextField turnsNumTf;
    // End of variables declaration//GEN-END:variables

    
    private void setTfsState(boolean flag){
        survivalNumTf.setEnabled(flag);
        turnsNumTf.setEnabled(flag);
        OkButton.setEnabled(flag);
        birthNumberTf.setEnabled(flag);
        boardSizeTf.setEnabled(flag);
        previousStateBttn.setEnabled(flag);
        nextStateBttn.setEnabled(flag);
    }
    
    /**
    * Resets the game state, including the game board and UI components.
    */
    public void reset(){
        hexgame.initGame();
        SwingUtilities.windowForComponent(this.getbutton()).repaint();
        birthNumberTf.setText("2");
        survivalNumTf.setText("2");
        turnsNumTf.setText("10");
        currentTurnTf.setText("0");
        
        
    }
    
    /**
    * Sets tooltips for UI components.
    */
    private void setToolTips(){
        resetBttn.setToolTipText("Reset all");
        stopBttn.setToolTipText("Stop the animation");
        startBttn.setToolTipText("Start the animation");
        birthNumberTf.setToolTipText("The number of living neighbors required for a new cell to be born.");
        survivalNumTf.setToolTipText("The number of living neighbors required for a cell to survive to the next generation.");
        turnsNumTf.setToolTipText("The number of turns.");
        previousStateBttn.setToolTipText("Load previous state of current board");
        nextStateBttn.setToolTipText("Load next state of current board");
        
    }
    
    /**
    * Gets the number of births from the birth text field.
    *
    * @return The birth number, or -1 if an error occurs.
    */
    public int getBirthsNum() {
        try{
            int birthsNumber = Integer.parseInt(birthNumberTf.getText());
            if(birthsNumber < 0) {
                showMessageDialog(null, "Please enter a positice number in birth textbox");
                return -1;
            }
            return birthsNumber;
        }
        catch(NumberFormatException e) {
            showMessageDialog(null, "Please enter a valid number in birth textbox");
        }
        return -1;
    }

    /**
    * Gets the number of survival from the survival text field.
    *
    * @return The survival number, or -1 if an error occurs.
    */
    public int getSurvivalNum() {
        try{
            int deathsNumber = Integer.parseInt(survivalNumTf.getText());
            if(deathsNumber < 0) {
                showMessageDialog(null, "Please enter a positice number in survival textbox");
                return -1;
            }
            return deathsNumber;
        }
        catch(NumberFormatException e) {
            showMessageDialog(null, "Please enter a valid number in survival textbox");
        }
        return -1;
    }

    /**
    * Gets the number of turns from the turns text field.
    *
    * @return The number of turns, or -1 if an error occurs.
    */
    public int getTurnsNum() {
        try{
            int turnsNumber = Integer.parseInt(turnsNumTf.getText());
            if(turnsNumber < 0) {
                showMessageDialog(null, "Please enter a positice number in deaths textbox");
                return -1;
            }
            return turnsNumber;
        }
        catch(NumberFormatException e) {
            showMessageDialog(null, "Please enter a valid number in turns textbox");
        }
        return -1;
    }
    
    public javax.swing.JButton getbutton(){
         return resetBttn;
     }
     
    
    /**
    * Gets the board size from the board size text field.
    *
    * @return The board size, or -1 if an error occurs.
    */
    public int getBsizeNumber() {
        try{
            int BsizeNumber = Integer.parseInt(boardSizeTf.getText());
            if(BsizeNumber < 5 || BsizeNumber > 25) {
                showMessageDialog(null, "Please enter a positice number between 5-25");
                return -1;
            }
            return BsizeNumber;
        }
        catch(NumberFormatException e) {
            showMessageDialog(null, "Please enter a valid number in board size textbox");
        }
        return -1;
    }
}
