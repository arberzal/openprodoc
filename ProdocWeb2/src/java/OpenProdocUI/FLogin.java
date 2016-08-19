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
package OpenProdocUI;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Joaquin
 */
public class FLogin 
{
private static final String Html="<!DOCTYPE html>" +
"<html>" +
"    <head>" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" +
"        <title>OpenProdoc2 Web</title>" +
"        <script src=\"js/OpenProdoc.js\" type=\"text/javascript\"></script>" +
"        <script src=\"js/dhtmlx.js\" type=\"text/javascript\"></script>" +
"        <link rel=\"STYLESHEET\" type=\"text/css\" href=\"js/dhtmlx.css\">" +
"        <link rel=\"STYLESHEET\" type=\"text/css\" href=\"css/OpenProdoc.css\">" +
"        <style>" +
"        html, body {" +
"                width: 100%;" +
"                height: 100%;" +
"                margin: 0px;" +
"                padding: 0px;" +
"                overflow: hidden;" +
"           }\n" +
"	</style>" +
"        </head>" +
"    <body>" +
        "<form action=\"Login\"  method=\"post\">" +
"        <table align=\"center\"  width=\"300\" class=\"OPDForm\">" +
"        <tr><td>&nbsp</td></tr>" +
"        <tr><td><img src=\"img/Logo48.jpg\"><H3>OpenProdoc</H3></td></tr>" +
"        <tr><td>"+
        "  <fieldset class=\"dhxform_fs\"><legend class=\"fs_legend\">Login OpenProdoc:</legend><table>" +
        "  <tr><td width=\"100\"><div class=\"dhxform_label dhxform_label_align_left\" >User:</div></td>" +
        "  <td><div class=\"dhxform_control\"><input class=\"dhxform_textarea\" type=\"text\" name=\"User\"></div></td></tr>" +
        "  <tr><td><div class=\"dhxform_label dhxform_label_align_left\">Password:</div></td>" +
        "  <td><div class=\"dhxform_control\"><input class=\"dhxform_textarea\" type=\"password\" name=\"Password\"></div></td></tr>" +        
        "  <tr><td></td><td><input  class=\"dhxform_btn_filler\" type=\"submit\" value=\"  Ok  \"></td></tr>" +
        "  </table></fieldset>" +
"        </td></tr>" +
"    </table>"+        
        "</form>" +
"    </body>" +
"</html>";
// "        <table align=\"center\"  width=\"300\" style=\"font-family: Tahoma,Helvetica; font-size: 12px;\">" +
//-------------------------------------------------------------------
public FLogin(HttpSession Sess)
{
    
}
//-------------------------------------------------------------------
public String toHtml()
{
return(Html);    
}
//-------------------------------------------------------------------
    
}