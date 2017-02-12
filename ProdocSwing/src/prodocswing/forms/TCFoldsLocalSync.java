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
 * MantUsers.java
 *
 * Created on 17-feb-2010, 21:16:33
 */

package prodocswing.forms;

import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import prodoc.Attribute;
import prodoc.Cursor;
import prodoc.DriverGeneric;
import prodoc.PDException;
import prodoc.PDObjDefs;
import prodoc.Record;

/**
 *
 * @author jhierrot
 */
public class TCFoldsLocalSync extends TCBase
{

/** Creates new form MantUsers
 * @param parent 
 * @param modal
 */
public TCFoldsLocalSync(javax.swing.JDialog parent, boolean modal)
{
super(parent, modal);
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
        SubFoldersCheckB = new javax.swing.JCheckBox();
        ObjTypeLabel = new javax.swing.JLabel();
        ObjTypeComboBox = new javax.swing.JComboBox();
        ParamLabel3 = new javax.swing.JLabel();
        ParamTextField3 = new javax.swing.JTextField();
        ParamLabel4 = new javax.swing.JLabel();
        ParamTextField4 = new javax.swing.JTextField();
        ButtonSelFile = new javax.swing.JButton();
        ButtonAcept = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(MainWin.TT("Programed_Task_Maintenance"));
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
        LabelOperation.setText(MainWin.TT("Param_Local_Sync"));

        SubFoldersCheckB.setFont(MainWin.getFontDialog());
        SubFoldersCheckB.setText(MainWin.TT("SubFolders"));
        SubFoldersCheckB.setToolTipText(MainWin.TT("When_checked_includes_subtypes_of_folders_in_results"));

        ObjTypeLabel.setFont(MainWin.getFontDialog());
        ObjTypeLabel.setText(MainWin.TT("Default_Docs_Type"));

        ObjTypeComboBox.setFont(MainWin.getFontDialog());
        ObjTypeComboBox.setModel(getListObjDoc());
        ObjTypeComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ObjTypeComboBoxActionPerformed(evt);
            }
        });

        ParamLabel3.setFont(MainWin.getFontDialog());
        ParamLabel3.setText(MainWin.TT("Parent_Folder"));

        ParamTextField3.setFont(MainWin.getFontDialog());

        ParamLabel4.setFont(MainWin.getFontDialog());
        ParamLabel4.setText(MainWin.TT("Source_Folder"));

        ParamTextField4.setFont(MainWin.getFontDialog());

        ButtonSelFile.setFont(MainWin.getFontDialog());
        ButtonSelFile.setText("Sel");
        ButtonSelFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonSelFileActionPerformed(evt);
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

        ButtonCancel.setFont(MainWin.getFontDialog());
        ButtonCancel.setText(MainWin.TT("Cancel"));
        ButtonCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ParamLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ParamTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ParamLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ParamTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ButtonSelFile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonAcept)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ButtonCancel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SubFoldersCheckB)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(LabelOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ObjTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ObjTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelOperation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubFoldersCheckB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ObjTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ObjTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ParamLabel3)
                    .addComponent(ParamTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ParamLabel4)
                    .addComponent(ParamTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSelFile))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(ButtonAcept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCancelActionPerformed
    {//GEN-HEADEREND:event_ButtonCancelActionPerformed
setCancel(true);
setVisible(false);
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonAceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAceptActionPerformed
    {//GEN-HEADEREND:event_ButtonAceptActionPerformed
super.setParam(SubFoldersCheckB.isSelected()?"1":"0");   
super.setParam2((String)ObjTypeComboBox.getSelectedItem());
super.setParam3(ParamTextField3.getText());
super.setParam4(ParamTextField4.getText());
setCancel(false);
setVisible(false);
    }//GEN-LAST:event_ButtonAceptActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
setCancel(true);
setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void ButtonSelFileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonSelFileActionPerformed
    {//GEN-HEADEREND:event_ButtonSelFileActionPerformed
JFileChooser fc = new JFileChooser();
fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
int returnVal = fc.showOpenDialog(this);
if (returnVal == JFileChooser.APPROVE_OPTION)
    {
    ParamTextField4.setText(fc.getSelectedFile().getAbsolutePath());
    }
    }//GEN-LAST:event_ButtonSelFileActionPerformed

    private void ObjTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ObjTypeComboBoxActionPerformed
    {//GEN-HEADEREND:event_ObjTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ObjTypeComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAcept;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonSelFile;
    private javax.swing.JLabel LabelOperation;
    private javax.swing.JComboBox ObjTypeComboBox;
    private javax.swing.JLabel ObjTypeLabel;
    private javax.swing.JLabel ParamLabel3;
    private javax.swing.JLabel ParamLabel4;
    private javax.swing.JTextField ParamTextField3;
    private javax.swing.JTextField ParamTextField4;
    private javax.swing.JCheckBox SubFoldersCheckB;
    // End of variables declaration//GEN-END:variables
//------------------------------------------------   
/**
 * @param Param the Param to set
 */
@Override
public void setParam(String Param)
{
if (Param==null || Param.length()==0 || Param.charAt(0)=='0')
    SubFoldersCheckB.setSelected(false);
else
    SubFoldersCheckB.setSelected(true);
}
//------------------------------------------------   
/**
 * @param Param the Param to set
 */
@Override
public void setParam2(String Param)
{
ObjTypeComboBox.setSelectedItem(Param);
}
//------------------------------------------------   
/**
 * @param Param the Param to set
 */
@Override
public void setParam3(String Param)
{
ParamTextField3.setText(Param);
}
//----------------------------------------------------------------
/**
 * @param Param the Param to set
 */
@Override
public void setParam4(String Param)
{
ParamTextField4.setText(Param);
}
//----------------------------------------------------------------
private ComboBoxModel getListObjDoc()
{
Vector VObjects=new Vector();
try {
DriverGeneric Session=MainWin.getSession();
PDObjDefs Obj = new PDObjDefs(Session);
Cursor CursorId = Obj.getListDocs();
Record Res=Session.NextRec(CursorId);
while (Res!=null)
    {
    Attribute Attr=Res.getAttr(PDObjDefs.fNAME);
    VObjects.add(Attr.getValue());
    Res=Session.NextRec(CursorId);
    }
Session.CloseCursor(CursorId);
} catch (PDException ex)
    {
    MainWin.Message("Error"+ex.getLocalizedMessage());
    }
return(new DefaultComboBoxModel(VObjects));
}
//----------------------------------------------------------------
}
