
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class NotesPanel extends javax.swing.JPanel {

    MainFrame ParentFrame;
    DefaultListModel noteListModel = new DefaultListModel();

    public NotesPanel(MainFrame parent) {
        initComponents();

        ParentFrame = parent;

        onInit();
    }

    public void onInit() {
        if (VaultManager.currentVault != null) {
            VaultNameLabel.setText(VaultManager.currentVault.name);

            for (var file : VaultManager.currentVault.files) {
                noteListModel.addElement(file.title);
            }
        }

        NotesList.setModel(noteListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        VaultNameLabel = new javax.swing.JLabel();
        VaultName1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NotesList = new javax.swing.JList<>();
        NoteNameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        NoteContentsField = new javax.swing.JTextArea();

        jPanel1.setBackground(java.awt.Color.black);

        VaultNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VaultNameLabel.setText("jLabel2");

        VaultName1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        VaultName1.setForeground(java.awt.Color.white);
        VaultName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VaultName1.setText("Notes");

        NotesList.setBackground(java.awt.Color.black);
        NotesList.setForeground(java.awt.Color.white);
        NotesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        NotesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NotesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(NotesList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VaultNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VaultName1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(VaultNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(VaultName1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NoteNameLabel.setText("Note Name");

        NoteContentsField.setColumns(20);
        NoteContentsField.setRows(5);
        jScrollPane2.setViewportView(NoteContentsField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NoteNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(NoteNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NotesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotesListMouseClicked
        if (evt.getClickCount() == 2) {
            JList source = (JList) evt.getSource();
            String selectedNote = source.getSelectedValue().toString();

            if (VaultManager.currentVault.files.size() == 0) {
                return;
            }

            NoteNameLabel.setText(selectedNote);

            JournalFile file = VaultManager.currentVault.getNoteByName(selectedNote);

            StringBuilder builder = new StringBuilder();
            for (String line : file.contents) {
                builder.append(line);
            }

            NoteContentsField.setText(builder.toString());
        }
    }//GEN-LAST:event_NotesListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea NoteContentsField;
    private javax.swing.JLabel NoteNameLabel;
    private javax.swing.JList<String> NotesList;
    private javax.swing.JLabel VaultName1;
    private javax.swing.JLabel VaultNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
