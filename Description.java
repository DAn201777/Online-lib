package isu.librarysystem;


import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author North Star Inc. Team
 */
public class Description extends javax.swing.JFrame {

    private Lib openLibrary = new Lib();
    private Book book;
    private String id;
    public Description() {
        initComponents();
    }
    public Description(String url, String name){
        initComponents();
        id=name;
        //gets list of books found
        book = openLibrary.getDescription(url);
         jTitleLabel.setText(book.getTitle());
        jAuthorLabel.setText(book.getAuthor());
        putSynopsisHere.setText(book.getSynopsis());
        //initializes JList for search results
       Image image = null;
        try {
           image = ImageIO.read(new URL(getB().getCover()));
           image = temp.getScaledInstance(jCoverLabel.getWidth(), jCoverLabel.getHeight(), Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jCoverLabel.setIcon(new ImageIcon(temp));
     
        //puts book comments into comment section
       ArrayList<String>store=book.fetch();
      
        String save = "";
        for (String a:store) {
            String[]temp=a.split("||");
            save+="User Account: "+temp[]+"\n"+temp[]+"\n"+temp[]+"\n\n";
           
        }
        ratingsList.setText(save);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        resultsForQueryLabel = new javax.swing.JLabel();
        resultGoesHere = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResultsGoHere = new javax.swing.JList();
        backButton = new javax.swing.JButton();
        proceedButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultsForQueryLabel.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        resultsForQueryLabel.setText("Search Results for Query:");

        resultGoesHere.setEditable(false);
        resultGoesHere.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        resultGoesHere.setText("jTextField1");
        resultGoesHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultGoesHereActionPerformed(evt);
            }
        });

        searchResultsGoHere.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(searchResultsGoHere);

        backButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        proceedButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        proceedButton.setText("Select");
        proceedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resultsForQueryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resultGoesHere, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(proceedButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultsForQueryLabel)
                    .addComponent(resultGoesHere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(proceedButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * User is brought to the BookInfoScreen showing book info
     * @param evt 
     */
    private void proceedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedButtonActionPerformed
        // TODO add your handling code here:
        //case where no item is selected
        if(searchResultsGoHere.isSelectionEmpty())
            jOptionPane1.showMessageDialog(null, "Please select an item");// fix
        else{
            dispose();
            new UserComments(book.getUrl(),id).setVisible(true);
        }
    }//GEN-LAST:event_proceedButtonActionPerformed

    /**
     * User is brought back to the login screen and can search another book
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void resultGoesHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultGoesHereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultGoesHereActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Description.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Description.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Description.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Description.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Description().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proceedButton;
    private javax.swing.JTextField resultGoesHere;
    private javax.swing.JLabel resultsForQueryLabel;
    private javax.swing.JList searchResultsGoHere;
    // End of variables declaration//GEN-END:variables

    
public Book getBook(){
    return book;
    }
}