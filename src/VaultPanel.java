
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VaultPanel extends javax.swing.JPanel {

    MainFrame ParentFrame;
    //Load vaults into this list to then display
    DefaultListModel vaultListModel = new DefaultListModel();

    public VaultPanel(MainFrame parent) {
        initComponents();

        ParentFrame = parent;

        onInit();
    }

    public void onInit() {
        for (String vaultName : FileManager.loadVaults()) {
            vaultListModel.addElement(vaultName);
            var vault = new Vault(vaultName);

            VaultManager.vaults.add(vault);
        }

        VaultList.setModel(vaultListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        VaultList = new javax.swing.JList<>();
        CreateVaultButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vaults");

        VaultList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        VaultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VaultListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(VaultList);

        CreateVaultButton.setText("New Vault");
        CreateVaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateVaultButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 416, Short.MAX_VALUE)
                .addComponent(CreateVaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CreateVaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreateVaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateVaultButtonActionPerformed
        String newVaultName = JOptionPane.showInputDialog(this, "What do you want the vault to be called?", null).trim();
        vaultListModel.addElement(newVaultName);

        //String[] vaults = new String[demoList.getSize()];
        //for (int i = 0; i < demoList.getSize(); i++) {
        //    vaults[i] = demoList.getElementAt(i).toString();
        //}
        FileManager.createVault(newVaultName);
    }//GEN-LAST:event_CreateVaultButtonActionPerformed

    private void VaultListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VaultListMouseClicked
        if (evt.getClickCount() == 2) {
            JList source = (JList) evt.getSource();
            String selectedVault = source.getSelectedValue().toString();

            VaultManager.setCurrentVault(selectedVault);
            ParentFrame.setPanel("Notes");
        }
    }//GEN-LAST:event_VaultListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateVaultButton;
    private javax.swing.JList<String> VaultList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
