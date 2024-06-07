/*
Toheeb Eji
June 7, 2024

This class is responsible for listing notes, and allowing the user to manipulate notes
 */
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

    //A variable that tracks the current Note in the editor
    JournalNote currentNote;

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

            //Loops through every note in the current vault
            for (var file : VaultManager.getFiles()) {
                //Adds the note's name to the model to display it to the user
                noteListModel.addElement(file.name);
            }

            //currentNote would have been set if i completed searching, which would set the currentNote at the start
            if (currentNote != null) {
                //StringBuilders are better than strings when repedelty adding text to a String
                StringBuilder builder = new StringBuilder();

                //Goes through every line of the current note chosen and adds it to the builder
                for (String line : currentNote.contents) {
                    builder.append(line);
                }

                NoteNameLabel.setText(currentNote.name);

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
        currentNote = null;
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

        VaultNameLabel.setForeground(java.awt.Color.white);
        VaultNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        VaultName1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        VaultName1.setForeground(java.awt.Color.white);
        VaultName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VaultName1.setText("Notes");

        NotesList.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
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

        ReturnToVaultButton.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
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

        NoteNameLabel.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        NoteNameLabel.setText("No note selected");

        NoteContentsField.setColumns(20);
        NoteContentsField.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NoteContentsField.setRows(5);
        jScrollPane2.setViewportView(NoteContentsField);

        SaveButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBorderColor"));
        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SaveButton.setForeground(java.awt.Color.white);
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DeleteButton.setForeground(java.awt.Color.white);
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SearchButton.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8-search-30 (1).png"))); // NOI18N
        SearchButton.setText("Search");
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
                        .addComponent(SearchButton)
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
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //This runs whenever the user clicks a note
    private void NotesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotesListMouseClicked
        //Prevents read errors by making sure that there are actually notes in the vault first
        if (noteListModel.isEmpty()) {
            return;
        }

        JList source = (JList) evt.getSource();
        //Gets the notes name
        String selectedNote = source.getSelectedValue().toString();

        //If the current vault does not have any files, then don't do anything
        if (VaultManager.getFiles().isEmpty()) {
            return;
        }

        NoteNameLabel.setText(selectedNote);

        //Sets the current note by gettings the note by name chosen by the user
        currentNote = VaultManager.findNoteByName(selectedNote);

        //StringBuilders are better than strings when repedelty adding text to a String
        StringBuilder builder = new StringBuilder();

        //Goes through every line of the current note chosen and adds it to the builder
        for (String line : currentNote.contents) {
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
            //Sets the current note's contents to what was typed in by the user.
            currentNote.contents = Arrays.asList(NoteContentsField.getText().split(""));

            //Saves the note that was just edited
            FileManager.saveFile(currentNote);

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
            FileManager.deleteFile(currentNote);

            //Reloads the Vault's note files
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
            currentNote = FileManager.createFile(newNoteName);
            //Adds the note to the vault's notes
            VaultManager.addFile(currentNote);

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
