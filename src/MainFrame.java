
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import raven.toast.Notifications;

public class MainFrame extends javax.swing.JFrame {

    //Placeholder variable for each panel
    NotesPanel notesPanel;
    VaultPanel vaultPanel;
    SearchPanel searchPanel;

    public MainFrame() {
        //These panels act as pages like on a website
        //The MainFrame is the container for each of the panels.
        vaultPanel = new VaultPanel(this);
        notesPanel = new NotesPanel(this);
        searchPanel = new SearchPanel(this);

        initComponents();

        //Sets the defualt panel to the vault panel
        Parent.add(vaultPanel);

        //Displays the vault panel on the screen
        Parent.repaint();
        Parent.revalidate();

        //Sets the notifcation popup frame to this.
        //This is an external library
        Notifications.getInstance().setJFrame(this);
    }

    //A function that depending on which panel is chosen as a parameter, will switch
    //to said panel.
    public void setPanel(String name) {
        switch (name) {
            case "Notes" -> {
                //Removes any previus panels
                Parent.removeAll();

                Parent.add(notesPanel);

                Parent.repaint();
                Parent.revalidate();

                //Any code that i want run when the panel is added back to the screen will be ran in this function.
                notesPanel.onInit();
            }
            case "Vaults" -> {
                Parent.removeAll();

                Parent.add(vaultPanel);

                Parent.repaint();
                Parent.revalidate();
                vaultPanel.onInit();
            }
            case "Search" -> {
                Parent.removeAll();

                Parent.add(searchPanel);
                Parent.repaint();
                Parent.revalidate();
                searchPanel.onInit();
            }
            //Only will run if I did not choose a proper panel
            default ->
                System.out.println("Panel not chosen");
        }
    }

    //This is a special version of the setPanel function.
    //This one is used when the user clicks on a search result on the search page
    //This will display the file that was chosen in the search on the notesPanel screen.
    //Instead of displaying "No note chosen"
    public void setNotesPanelWithResult(JournalFile result) {
        notesPanel.currentFile = result;
        setPanel("Notes");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        Parent = new javax.swing.JPanel();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memoir");
        setResizable(false);

        Parent.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Parent, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Parent, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Custom Look and feel for swing, the default was ugly.
        //This is an external library
        FlatArcDarkIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Parent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
