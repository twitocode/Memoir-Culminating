
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import raven.toast.Notifications;

public class NotesPanel extends javax.swing.JPanel {

    //The Frame that this class belongs to, set at startup in the constructor
    MainFrame ParentFrame;

    //Load notes into this list to then display
    DefaultListModel noteListModel = new DefaultListModel();

    //A variable that tracks the current file in the editor
    JournalFile currentFile;

    public NotesPanel(MainFrame parent) {
        initComponents();

        ParentFrame = parent;

        //Calls the onInit function
        onInit();
    }

    public void onInit() {
        //Removes any previus noteList results just in case one was added
        noteListModel.removeAllElements();

        //If the user has chosen a vault
        if (VaultManager.get() != null) {
            //dispays the vault name on the screen
            VaultNameLabel.setText(VaultManager.getName());

            //Loops through every file in the current vault
            for (var file : VaultManager.getFiles()) {
                //Ads the file's name to the model to display it to the user
                noteListModel.addElement(file.name);
            }

            //currentFile would have been set if i completed searching, which would set the currentFile at the start
            if (currentFile != null) {
                //StringBuilders are better than strings when repedelty adding text to a String
                StringBuilder builder = new StringBuilder();

                //Goes through every line of the current file chosen and adds it to the builder
                for (String line : currentFile.contents) {
                    builder.append(line);
                }

                NoteNameLabel.setText(currentFile.name);

                //The builder outputs a string to user. This string is the file contents
                //That the user typed in
                NoteContentsField.setText(builder.toString());
                NoteContentsField.setEnabled(true);
                SaveButton.setEnabled(true);
                DeleteButton.setEnabled(true);
            }
        } else {
            //Otherwise set an empty screen, calls the reset button
            reset();
        }

        //Lists in swing use a model to get the data from. This sets the NoteList model to the note search result model
        NotesList.setModel(noteListModel);
    }

    //This function sets everything to the defualt state of (No note chosen)
    //Removes controls until the user clicks a note
    private void reset() {
        currentFile = null;
        NoteNameLabel.setText("No note chosen");
        NoteContentsField.setEnabled(false);
        NoteContentsField.setText("");

        SaveButton.setEnabled(false);
        DeleteButton.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        VaultNameLabel = new javax.swing.JLabel();
        VaultName1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NotesList = new javax.swing.JList<>();
        ReturnToVaultButton = new javax.swing.JButton();
        CreateNoteButton = new javax.swing.JButton();
        NoteNameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        NoteContentsField = new javax.swing.JTextArea();
        SaveButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();

        jPanel1.setBackground(java.awt.Color.black);

        VaultNameLabel.setForeground(java.awt.Color.white);
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
        NotesList.setFixedCellHeight(50);
        NotesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NotesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(NotesList);

        ReturnToVaultButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ReturnToVaultButton.setText("Back to Vaults");
        ReturnToVaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnToVaultButtonActionPerformed(evt);
            }
        });

        CreateNoteButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CreateNoteButton.setText("Create Note");
        CreateNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNoteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CreateNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnToVaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addComponent(CreateNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReturnToVaultButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        NoteNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        NoteNameLabel.setText("No note selected");

        NoteContentsField.setColumns(20);
        NoteContentsField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NoteContentsField.setRows(5);
        jScrollPane2.setViewportView(NoteContentsField);

        SaveButton.setBackground(new java.awt.Color(51, 153, 0));
        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SaveButton.setForeground(java.awt.Color.white);
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(java.awt.Color.red);
        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DeleteButton.setForeground(java.awt.Color.white);
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SearchButton.setBackground(java.awt.Color.white);
        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8-search-30.png"))); // NOI18N
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(NoteNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoteNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //This runs whenever the user clicks a note
    private void NotesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotesListMouseClicked
        JList source = (JList) evt.getSource();
        //Gets the notes name
        String selectedNote = source.getSelectedValue().toString();

        //If the current vault does not have any files, then don't do anything
        if (VaultManager.getFiles().isEmpty()) {
            return;
        }

        NoteNameLabel.setText(selectedNote);

        //Sets the current file by gettings the note by name chosen by the user
        currentFile = VaultManager.findNoteByName(selectedNote);

        //StringBuilders are better than strings when repedelty adding text to a String
        StringBuilder builder = new StringBuilder();

        //Goes through every line of the current file chosen and adds it to the builder
        for (String line : currentFile.contents) {
            builder.append(line);
        }

        //The builder outputs a string
        NoteContentsField.setText(builder.toString());
        NoteContentsField.setEnabled(true);
        SaveButton.setEnabled(true);
        DeleteButton.setEnabled(true);

    }//GEN-LAST:event_NotesListMouseClicked

    //This runs whenever the user clicks the save button
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        //Tries to save the note
        try {
            //Sets the current file contents to what was typed in by the user.
            currentFile.contents = Arrays.asList(NoteContentsField.getText().split(""));

            //Saves the file that was just edited
            FileManager.saveFile(currentFile);

        } catch (IOException ex) {
            //If it cant then display show an error notifcation to the user
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Could not save note");
        } finally {
            //Otherwise display a success notification to the user
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Sucessfully saved the note");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    //The runs when the user wants to go back to the vault page
    private void ReturnToVaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnToVaultButtonActionPerformed
        reset();
        ParentFrame.setPanel("Vaults");
    }//GEN-LAST:event_ReturnToVaultButtonActionPerformed

    //This runs when the user wants to delete a note
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed

        //Tries to delete the note
        try {
            //Deletes the note
            FileManager.deleteFile(currentFile);

            //Reloads the Vault's files
            VaultManager.loadFiles();
            
            //Sends a notification to the user that the deletion was a success
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Sucessfully deleted the note");
        } catch (IOException ex) {
            //Otherwise, send a notification to the user that the deletion was not successful.
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Could not delete note");
        } finally {
            //Resets the screen
            reset();

            //Updates the notes list
            onInit();
        }

    }//GEN-LAST:event_DeleteButtonActionPerformed

    //Runs when the user wants to create a note
    private void CreateNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNoteButtonActionPerformed
        //Opens up a popup that asks the user for a note name. When the user enters in a name, it will be captured in this variable
        //It also trims the whitespace out
        String newNoteName = JOptionPane
                .showInputDialog(this, "What do you want the note to be called?", null)
                .trim();

        try {
            //Creates a note in the vault's folder.
            currentFile = FileManager.createFile(newNoteName);
            //Adds the file to the vault's files
            VaultManager.addFile(currentFile);

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Sucessfully created the note");
        } catch (IOException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Could not create the note");
        } finally {
            //Adds the note name to the note list results model
            noteListModel.addElement(newNoteName);

            NoteNameLabel.setText(newNoteName);
            NoteContentsField.setText("");

            NoteContentsField.setEnabled(true);
            SaveButton.setEnabled(true);
            DeleteButton.setEnabled(true);
        }
    }//GEN-LAST:event_CreateNoteButtonActionPerformed

    //Runs when the user clicks the search button
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        ParentFrame.setPanel("Search");
    }//GEN-LAST:event_SearchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateNoteButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextArea NoteContentsField;
    private javax.swing.JLabel NoteNameLabel;
    private javax.swing.JList<String> NotesList;
    private javax.swing.JButton ReturnToVaultButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel VaultName1;
    private javax.swing.JLabel VaultNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
