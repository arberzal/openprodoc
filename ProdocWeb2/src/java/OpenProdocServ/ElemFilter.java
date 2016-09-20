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
 * author: Joaquin Hierro      2016
 * 
 */

package OpenProdocServ;

import OpenProdocUI.SParent;
import static OpenProdocUI.SParent.TT;
import static OpenProdocUI.SParent.getSessOPD;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import prodoc.Attribute;
import prodoc.DriverGeneric;
import prodoc.PDDocs;

/**
 *
 * @author jhierrot
 */
public class ElemFilter extends SParent
{
    
static private int NUMATTREXC=7;
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
DriverGeneric PDSession=getSessOPD(Req);
PDDocs TmpFold=new PDDocs(PDSession);
StringBuilder Form= new StringBuilder(3000);
Attribute Attr;
Form.append("[");
Attr=TmpFold.getRecord().getAttr(PDDocs.fDOCTYPE);
Form.append("{type: \"block\", width: 450, list:[");
Form.append("{type: \"input\", name: \"filter\", label: \"").append(TT(Req, "Filter")).append("\", tooltip:\"").append(TT(Req, "Enter_full_or_partial_name_of_the_item")).append("\"},");
Form.append("{type: \"newcolumn\", offset:20 },");
Form.append("{type: \"button\", name: \"OK\", value: \"").append(TT(Req, "Ok")).append("\"}");
Form.append("]}];");
out.println(Form.toString());
}
//-----------------------------------------------------------------------------------------------

/** 
 * Returns a short description of the servlet.
 * @return a String containing servlet description
 */
@Override
public String getServletInfo()
{
return "ElemFilter Servlet";
}
//-----------------------------------------------------------------------------------------------
static public String getUrlServlet()
{
return("ElemFilter");
}
//-----------------------------------------------------------------------------------------------
}