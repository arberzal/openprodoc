/*
 * OpenProdoc
 * 
 * See the help doc files distributed with
 * this work for additional information regarding copyright ownership.
 * Joaquin Hierro licenses this file to You under:
 * 
 * License GNU GPL v3 http://www.gnu.org/licenses/gpl.html
 * 
 * you may not use this file except in compliance with the License.  
 * Unless agreed to in writing, software is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * author: Joaquin Hierro      2014
 * 
 */

/*
 * ListObjects.java
 *
 * Created on 12-feb-2010, 20:39:16
 */

package prodocswing.forms;

import javax.swing.JDialog;
import prodoc.Cursor;
import prodoc.PDDocs;
import prodoc.PDException;
import prodoc.Record;
import prodoc.PDReport;
import prodocswing.PDTableModel;

/**
 *
 * @author jhierrot
 */
public final class SelectReport extends javax.swing.JDialog
{
PDTableModel DocsList = new PDTableModel();
/**
 * 
 */
protected JDialog MantForm;
String TypeDocRestore="";
String DocType=null;
private Cursor RetrievedDocsCur=null;
private Record RepStruct=new Record();
private boolean Cancel;

/** Creates new form ListObjects
 * @param parent 
 * @param modal
 */
public SelectReport(java.awt.Frame parent, boolean modal) throws PDException
{
super(parent, modal);
initComponents();
ObjectsTable.setAutoCreateRowSorter(true);
ObjectsTable.setAutoCreateColumnsFromModel(true);
DocType=PDReport.getTableName();
PDReport Rep=new PDReport(MainWin.getSession());
RetrievedDocsCur=Rep.GetListReports();
//Record Original=Rep.getRecSum().CopyMono();
//RepStruct.addAttr(Original.getAttr(PDDocs.fPDID));
//RepStruct.addAttr(Original.getAttr(PDDocs.fTITLE));
//RepStruct.addAttr(Original.getAttr(PDDocs.fDOCTYPE));
//RepStruct.addAttr(Original.getAttr(PDDocs.fDOCDATE));
//RepStruct.addAttr(Original.getAttr(PDDocs.fVERSION));
RepStruct=Rep.getRecSum().CopyMono();
RefreshTable();
}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        ObjectsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        DocsPerPageLab = new javax.swing.JLabel();
        DocsPerPageText = new javax.swing.JFormattedTextField();
        PagesPerDocLabel = new javax.swing.JLabel();
        PagesPerDocText = new javax.swing.JFormattedTextField();
        ButtonCancel = new javax.swing.JButton();
        ButtonAcept = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(MainWin.TT("Reports_Generation"));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        ObjectsTable.setAutoCreateRowSorter(true);
        ObjectsTable.setFont(MainWin.getFontList());
        ObjectsTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                ObjectsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ObjectsTable);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(MainWin.TT("Reports_List"));

        DocsPerPageLab.setFont(MainWin.getFontDialog());
        DocsPerPageLab.setText(MainWin.TT("Docs_per_Page"));

        DocsPerPageText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########0"))));
        DocsPerPageText.setText("0");

        PagesPerDocLabel.setFont(MainWin.getFontDialog());
        PagesPerDocLabel.setText(MainWin.TT("Pages_per_File"));

        PagesPerDocText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########0"))));
        PagesPerDocText.setText("0");

        ButtonCancel.setFont(MainWin.getFontDialog());
        ButtonCancel.setText(MainWin.TT("Cancel"));
        ButtonCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonCancelActionPerformed(evt);
            }
        });

        ButtonAcept.setFont(MainWin.getFontDialog());
        ButtonAcept.setText(MainWin.TT("Ok"));
        ButtonAcept.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonAceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonAcept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DocsPerPageLab, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DocsPerPageText, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PagesPerDocLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PagesPerDocText, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DocsPerPageLab)
                    .addComponent(DocsPerPageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PagesPerDocLabel)
                    .addComponent(PagesPerDocText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(ButtonAcept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
{//GEN-HEADEREND:event_formWindowClosing
}//GEN-LAST:event_formWindowClosing

    private void ObjectsTableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_ObjectsTableMouseClicked
    {//GEN-HEADEREND:event_ObjectsTableMouseClicked

    }//GEN-LAST:event_ObjectsTableMouseClicked

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCancelActionPerformed
    {//GEN-HEADEREND:event_ButtonCancelActionPerformed
Cancel=true;
this.dispose();
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonAceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAceptActionPerformed
    {//GEN-HEADEREND:event_ButtonAceptActionPerformed
Cancel=false;
this.dispose();
    }//GEN-LAST:event_ButtonAceptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAcept;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JLabel DocsPerPageLab;
    private javax.swing.JFormattedTextField DocsPerPageText;
    private javax.swing.JTable ObjectsTable;
    private javax.swing.JLabel PagesPerDocLabel;
    private javax.swing.JFormattedTextField PagesPerDocText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

//----------------------------------------------------------------
/**
 * 
 * @return
 */
protected PDTableModel getPDTableModel()
{
return ((PDTableModel) getObjectsTable().getModel());
}
//----------------------------------------------------------------
/**
 * 
 * @return
 */
protected int getSelectedRow()
{
return (getObjectsTable().convertRowIndexToModel(getObjectsTable().getSelectedRow()));
}
//--------------------------------------------------------------------
/**
* @return the ObjectsTable
*/
protected javax.swing.JTable getObjectsTable()
{
return ObjectsTable;
}
//--------------------------------------------------------------------
/**
 * 
 */
protected void RefreshTable()
{
try {
DocsList = new PDTableModel();
DocsList.setDrv(MainWin.getSession());
DocsList.setListFields(RepStruct);
DocsList.setCursor(RetrievedDocsCur);
getObjectsTable().setModel(DocsList);
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(2));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(3));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(3));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(3));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(3));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(3));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(3));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(4));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(4));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(4));
getObjectsTable().getColumnModel().removeColumn(getObjectsTable().getColumnModel().getColumn(4));
} catch (PDException ex)
    {
    MainWin.Message(MainWin.TT("Error_assigning_columns_to_table")+":"+MainWin.DrvTT(ex.getLocalizedMessage()));
    }
}
//----------------------------------------------------------------
/**
* @return the Cancel
*/
public boolean isCancel()
{
return Cancel;
}
//--------------------------------------------------------------------
public int getDocsPerPage()
{
return (Integer.parseInt(DocsPerPageText.getText()));    
}
//--------------------------------------------------------------------
public int getPagesPerFile()
{
return (Integer.parseInt(PagesPerDocText.getText()));        
}
//--------------------------------------------------------------------
public String getSelectedRep()
{
Record R=DocsList.getElement(getObjectsTable().convertRowIndexToModel(getObjectsTable().getSelectedRow()));
return((String)R.getAttr(PDDocs.fPDID).getValue());
}
//--------------------------------------------------------------------
}
