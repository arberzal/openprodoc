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
 * author: Joaquin Hierro      2016
 * 
 */

package OpenProdocServ;

import OpenProdocUI.SParent;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import prodoc.Attribute;
import prodoc.DriverGeneric;
import prodoc.PDException;
import prodoc.PDFolders;

/**
 *
 * @author jhierrot
 */
public class AddFold extends SParent
{

//-----------------------------------------------------------------------------------------------
/**
 *
 * @param Req
 * @param out
 * @throws Exception
 */
@Override
protected void ProcessPage(HttpServletRequest Req, PrintWriter out) throws Exception
{   
DriverGeneric PDSession=SParent.getSessOPD(Req);
PDFolders TmpFold=new PDFolders(PDSession);
String CurrFold=Req.getParameter("F");
if (CurrFold!=null)
    {
    Attribute Attr;
    Attr=TmpFold.getRecord().getAttr(PDFolders.fTITLE);
    out.println(
    "[" +
    "{type: \"label\", label: \""+TT(Req, "Add_Folder")+"\"}," +
    "{type: \"input\", name: \""+PDFolders.fTITLE+"\", label: \""+TT(Req, Attr.getUserName())
                   +"\", required: true, tooltip:\""+TT(Req, Attr.getDescription())+"\", inputWidth: 300, maxLength:"+Attr.getLongStr()+"}," +
    "{type: \"block\", width: 250, list:[" +
        "{type: \"button\", name: \"OK\", value: \""+TT(Req, "Ok")+"\"}," +
        "{type: \"newcolumn\", offset:20 }," +
        "{type: \"button\", name: \"CANCEL\", value: \""+TT(Req, "Cancel")+"\"}," +
        "{type: \"hidden\", name:\"CurrFold\", value: \""+CurrFold+"\"}" +
    "]} ];");
    }
else
    {
    try {    
    String IdParent=Req.getParameter("CurrFold");    
    String NewFolder=Req.getParameter(PDFolders.fTITLE);    
    TmpFold.setPDId(IdParent);
    String ChildId = TmpFold.CreateChild(NewFolder);
    out.println("OK"+ChildId);
    } catch (PDException Ex)
        {
        PrepareError(Req, Ex.getLocalizedMessage(), out);
        }
    }
}
//-----------------------------------------------------------------------------------------------

/** 
 * Returns a short description of the servlet.
 * @return a String containing servlet description
 */
@Override
public String getServletInfo()
{
return "AddFold Servlet";
}
//-----------------------------------------------------------------------------------------------
}
