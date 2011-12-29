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
 * author: Joaquin Hierro      2011
 * 
 */

/*
 * MantUsers.java
 *
 * Created on 17-feb-2010, 21:16:33
 */

package prodocswing.forms;

import javax.swing.DefaultComboBoxModel;
import prodoc.Attribute;
import prodoc.PDException;
import prodoc.PDGroups;
import prodoc.Record;

/**
 *
 * @author jhierrot
 */
public class MantMembers extends javax.swing.JDialog
{
private Record Perm;
private boolean Cancel;
private boolean ModeGrp=false;

/** Creates new form MantUsers
 * @param parent
 * @param modal
 * @param pModeGrp  
 */
public MantMembers(java.awt.Frame parent, boolean modal, boolean pModeGrp)
{
super(parent, modal);
ModeGrp=pModeGrp;
initComponents();
}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelOperation = new javax.swing.JLabel();
        UserNameLabel = new javax.swing.JLabel();
        UserComboBox = new javax.swing.JComboBox();
        ButtonAcept = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(MainWin.TT("Members_Maintenance"));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        LabelOperation.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        LabelOperation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelOperation.setText("jLabel1");

        UserNameLabel.setFont(MainWin.getFontDialog());
        UserNameLabel.setText("jLabel1");

        UserComboBox.setFont(MainWin.getFontDialog());
        UserComboBox.setModel(getComboModel());

        ButtonAcept.setFont(MainWin.getFontDialog());
        ButtonAcept.setText(MainWin.TT("Ok"));
        ButtonAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAceptActionPerformed(evt);
            }
        });

        ButtonCancel.setFont(MainWin.getFontDialog());
        ButtonCancel.setText(MainWin.TT("Cancel"));
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(UserNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelOperation, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonAcept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelOperation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserNameLabel)
                    .addComponent(UserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(ButtonAcept))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCancelActionPerformed
    {//GEN-HEADEREND:event_ButtonCancelActionPerformed
Cancel=true;
this.dispose();
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonAceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAceptActionPerformed
    {//GEN-HEADEREND:event_ButtonAceptActionPerformed
try {
Attribute Attr;
if (ModeGrp) {
    Attr = Perm.getAttr(PDGroups.fMEMBERNAME);
} else {
    Attr = Perm.getAttr(PDGroups.fUSERNAME);
}
Attr.setValue(UserComboBox.getSelectedItem());
Cancel = false;
this.dispose();
} catch (PDException ex)
    {
    MainWin.Message(MainWin.DrvTT(ex.getLocalizedMessage()));
    }
    }//GEN-LAST:event_ButtonAceptActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
Cancel=true;
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAcept;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JLabel LabelOperation;
    private javax.swing.JComboBox UserComboBox;
    private javax.swing.JLabel UserNameLabel;
    // End of variables declaration//GEN-END:variables

/**
*
*/
public void AddMode()
{
LabelOperation.setText(MainWin.TT("Add_Member"));
}
//----------------------------------------------------------------
/**
*
*/
public void DelMode()
{
LabelOperation.setText(MainWin.TT("Delete_Member"));
UserComboBox.setEnabled(false);
}
//----------------------------------------------------------------
/**
*
*/
public void EditMode()
{
LabelOperation.setText(MainWin.TT("Update_Member"));
UserComboBox.setEnabled(false);
}
//----------------------------------------------------------------
/**
* @return the User
*/
public Record getRecord()
{
return Perm;
}
//----------------------------------------------------------------
/**
 * @param pPerm
*/
public void setRecord(Record pPerm)
{
Perm = pPerm;
Attribute Attr;
if (ModeGrp)
    Attr=Perm.getAttr(PDGroups.fMEMBERNAME);
else
    Attr=Perm.getAttr(PDGroups.fUSERNAME);
UserNameLabel.setText(Attr.getUserName());
if (Attr.getValue()!=null)
    UserComboBox.setSelectedItem((String)Attr.getValue());
else
    UserComboBox.setSelectedItem("");
UserComboBox.setToolTipText(Attr.getDescription());
}
//----------------------------------------------------------------
private DefaultComboBoxModel getComboModel()
{
if (ModeGrp)
    return(ListObjects.getComboModel("Groups"));
else
    return(ListObjects.getComboModel("Users"));
}
//----------------------------------------------------------------
/**
* @return the Cancel
*/
public boolean isCancel()
{
return Cancel;
}
//----------------------------------------------------------------
}
