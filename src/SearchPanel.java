
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.util.List;
import raven.toast.Notifications;

public class SearchPanel extends javax.swing.JPanel {

    //The Frame that this class belongs to, set at startup in the constructor
    MainFrame ParentFrame;

    //Load serach results into this list to then display
    DefaultListModel searchResultsListModel = new DefaultListModel();

    //Where all of the search results are
    List<JournalFile> searchResults = new ArrayList<JournalFile>();

    public SearchPanel(MainFrame parent) {
        initComponents();

        ParentFrame = parent;

        //Calls the onInit function
        onInit();
    }

    public void onInit() {
        //Lists in swing use a model to get the data from. This sets the SearchResultList model to the search result model
        SearchList.setModel(searchResultsListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchList = new javax.swing.JList<>();
        BackToNotesButton = new javax.swing.JButton();
        BackToVaultsButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search");

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search for any note across all your vaults");
        jLabel2.setToolTipText("");

        SearchList.setFixedCellHeight(50);
        SearchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SearchList);

        BackToNotesButton.setText("Back to Notes");
        BackToNotesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToNotesButtonActionPerformed(evt);
            }
        });

        BackToVaultsButton.setText("Back to Vaults");
        BackToVaultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToVaultsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackToVaultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackToNotesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(SearchField)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(BackToVaultsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackToNotesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Runs whenever the user pressed enter in the search bar
    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        //Gets the query from the the user
        String query = SearchField.getText();

        //Tries to search for results
        try {
            //Searches for results with the query and sets the searchResults variable to the output
            searchResults = FileManager.searchAllFiles(query);
        } catch (IOException ex) {
            //Otherwise, send a error notificatio.
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Searching files failed");
        }

        searchResultsListModel.removeAllElements();
        searchResults.forEach(x -> {
            searchResultsListModel.addElement(x.name);
        });
    }//GEN-LAST:event_SearchFieldActionPerformed

    //Runs wheneveer the user presses a searc result
    private void SearchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchListMouseClicked
        JList source = (JList) evt.getSource();

        //Gets the name of the note chosen
        String selectedNote = source.getSelectedValue().toString();

        //Sortes through each of the search results
        for (JournalFile result : searchResults) {
            //If the name of the result is equal to the name chosen
            if (result.name.equals(selectedNote)) {

                //Sets the current vault with the chosen note's vault
                VaultManager.setCurrentVault(result.vault);

                //Goes to the notes panel with the currentFile chosen
                ParentFrame.setNotesPanelWithResult(result);
            }
        }
    }//GEN-LAST:event_SearchListMouseClicked

    //Takes the user back to the vault page
    private void BackToVaultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToVaultsButtonActionPerformed
        ParentFrame.setPanel("Vaults");
    }//GEN-LAST:event_BackToVaultsButtonActionPerformed

    //Takes the user back to the notes page
    private void BackToNotesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToNotesButtonActionPerformed
        ParentFrame.setPanel("Notes");
    }//GEN-LAST:event_BackToNotesButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToNotesButton;
    private javax.swing.JButton BackToVaultsButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JList<String> SearchList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
