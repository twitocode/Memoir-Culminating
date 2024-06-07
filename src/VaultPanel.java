/*
Toheeb Eji
June 7, 2024

This class is responsible for www all the vaults that the user has.
 */

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import raven.toast.Notifications;

public class VaultPanel extends javax.swing.JPanel {

    //The Frame that this class belongs to, set at startup in the constructor
    MainFrame ParentFrame;
    //Load vaults into this list to then display
    DefaultListModel vaultListModel = new DefaultListModel();

    //Constructor, sets the parent frame to be used. and runs the initial code.
    public VaultPanel(MainFrame parent) {
        initComponents();

        ParentFrame = parent;

        //Calls the onInit function.
        onInit();
    }

    public void onInit() {
        //Removes any previus vaultList results just in case one was added
        vaultListModel.removeAllElements();

        //Searches through every vault created
        for (String vaultName : FileManager.loadVaultNames()) {
            //Adds the vault name to the model
            vaultListModel.addElement(vaultName);

            //Adds the vault to the tracked list of vaults
            VaultManager.addVault(vaultName);
        }

        //Lists in swing use a model to get the data from. This sets the VaultList model to the vault search result model
        VaultList.setModel(vaultListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        VaultList = new javax.swing.JList<>();
        CreateVaultButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Roboto Thin", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Memoir");

        VaultList.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        VaultList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        VaultList.setFixedCellHeight(50);
        VaultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VaultListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(VaultList);

        CreateVaultButton.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        CreateVaultButton.setText("New Vault");
        CreateVaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateVaultButtonActionPerformed(evt);
            }
        });

        SearchButton.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8-search-30 (1).png"))); // NOI18N
        SearchButton.setText("Notes Search");
        SearchButton.setMaximumSize(new java.awt.Dimension(37, 37));
        SearchButton.setMinimumSize(new java.awt.Dimension(37, 37));
        SearchButton.setPreferredSize(new java.awt.Dimension(37, 37));
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Thin", 0, 48)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vaults");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CreateVaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(246, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateVaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(574, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Runs when the user clicks the create vault button
    private void CreateVaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateVaultButtonActionPerformed
        //Opens up a popup that asks the user for a vault name. When the user enters in a name, it will be captured in this variable
        //It also trims the whitespace out
        String newVaultName = JOptionPane
                .showInputDialog(this, "What do you want the vault to be called?", null)
                .trim();

        //Adds the vault name to the vault list results model
        vaultListModel.addElement(newVaultName);

        //Creates a vault in the files.
        FileManager.createVault(newVaultName);

        //Adds the vault to the tracked vault list
        VaultManager.addVault(newVaultName);

        //Sends a notification popup to the user that the vault was created
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Sucessfully created vault");
    }//GEN-LAST:event_CreateVaultButtonActionPerformed

    //Runs when the user clicks a vault
    private void VaultListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VaultListMouseClicked
        //If the user double clicked the vault they want to choose
        if (evt.getClickCount() == 2) {
            JList source = (JList) evt.getSource();
            String selectedVault = source.getSelectedValue().toString();

            //Sets the current vualt with the vault chosen
            VaultManager.setCurrentVaultByName(selectedVault);

            //Changes the screen to the notes panel
            ParentFrame.setPanel("Notes");
        }
    }//GEN-LAST:event_VaultListMouseClicked

    //Runs when the user clicks the search button
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        //Tells the mainframe to change the panel to the search panel
        ParentFrame.setPanel("Search");
    }//GEN-LAST:event_SearchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateVaultButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JList<String> VaultList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
