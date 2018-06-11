/*
 * OpenProdoc
 * 
 * See the help doc files distributed with
 * this work for additional information regarding copyright ownership.
 * Joaquin Hierro licenses this file to You under:
 * 
 * License GNU Affero GPL v3 http://www.gnu.org/licenses/agpl.html
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

import javax.swing.JDialog;
import prodoc.PDException;
import prodoc.PDThesaur;
import prodoc.Record;

/**
 *
 * @author jhierrot
 */
public class AddTermRT extends javax.swing.JDialog
{
private Record RTTermRecord;
private boolean Cancel;
private PDThesaur RTUseTerm=null;
String LocalThes=PDThesaur.ROOTTERM;
private boolean Translations=false;

/** Creates new form MantUsers
 * @param parent
 * @param modal
 * @param pModeGrp  
 */
public AddTermRT(JDialog parent, boolean modal, String Thes)
{
super(parent, modal);
LocalThes=Thes;
initComponents();
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

        LabelOperation = new javax.swing.JLabel();
        ButtonAcept = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        AddButtonU1 = new javax.swing.JButton();
        RTLabe = new javax.swing.JLabel();
        RTTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(MainWin.TT("Maintenance of Relations"));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        LabelOperation.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        LabelOperation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelOperation.setText("Operation");

        ButtonAcept.setFont(MainWin.getFontDialog());
        ButtonAcept.setText(MainWin.TT("Ok"));
        ButtonAcept.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonAceptActionPerformed(evt);
            }
        });

        ButtonCancel.setFont(MainWin.getFontDialog());
        ButtonCancel.setText(MainWin.TT("Cancel"));
        ButtonCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonCancelActionPerformed(evt);
            }
        });

        AddButtonU1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/tree.png"))); // NOI18N
        AddButtonU1.setToolTipText(MainWin.TT("Add_user_to_group"));
        AddButtonU1.setFocusable(false);
        AddButtonU1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddButtonU1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AddButtonU1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AddButtonU1ActionPerformed(evt);
            }
        });

        RTLabe.setFont(MainWin.getFontDialog());
        RTLabe.setText(MainWin.TT("Related_Term"));

        RTTextField.setEditable(false);
        RTTextField.setFont(MainWin.getFontDialog());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelOperation, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonAcept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonCancel)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RTLabe, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RTTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddButtonU1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelOperation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(ButtonAcept))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(AddButtonU1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RTTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RTLabe))
                    .addContainerGap(55, Short.MAX_VALUE)))
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
this.dispose();
    }//GEN-LAST:event_ButtonAceptActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
Cancel=true;
    }//GEN-LAST:event_formWindowClosing

    private void AddButtonU1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AddButtonU1ActionPerformed
    {//GEN-HEADEREND:event_AddButtonU1ActionPerformed
MainThes MTW=new MainThes( (JDialog)this, false, MainWin.getSession(), LocalThes);
MTW.setLocationRelativeTo(null);
MTW.ModeSelect();
MTW.setModal(true);
MTW.setVisible(true);
RTUseTerm=MTW.getTermAct();
if (getUseTerm()==null)
    RTTextField.setText("");
else
    RTTextField.setText(getUseTerm().getName());
    }//GEN-LAST:event_AddButtonU1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButtonU1;
    private javax.swing.JButton ButtonAcept;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JLabel LabelOperation;
    private javax.swing.JLabel RTLabe;
    private javax.swing.JTextField RTTextField;
    // End of variables declaration//GEN-END:variables

/**
*
*/
public void AddMode()
{
if (Translations)    
    LabelOperation.setText(MainWin.TT("Add_translation_of_the_Term"));
else
    LabelOperation.setText(MainWin.TT("Add_Related_Term"));
}
//----------------------------------------------------------------
/**
*
*/
public void DelMode()
{
if (Translations)    
    LabelOperation.setText(MainWin.TT("Delete_translation_of_the_Term"));
else    
    LabelOperation.setText(MainWin.TT("Delete_Relation_with_Term"));
this.AddButtonU1.setEnabled(false);
}
//----------------------------------------------------------------
/**
 * @param pRTTerm
*/
public void setRecord(Record pRTTerm)
{
try {    
RTTermRecord = pRTTerm;
RTUseTerm=new PDThesaur(MainWin.getSession());
RTUseTerm.assignValues(RTTermRecord);
this.RTTextField.setText(RTUseTerm.getName());
} catch (PDException ex)
    {
    MainWin.Message(MainWin.DrvTT(ex.getLocalizedMessage()));
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
//----------------------------------------------------------------
/**
 * @return the UseTerm
 */
public PDThesaur getUseTerm()
{
return RTUseTerm;
}
//----------------------------------------------------------------

/**
 * @param Translations the Translations to set
 */
public void setTranslations(boolean Translations)
{
this.Translations = Translations;
}
}