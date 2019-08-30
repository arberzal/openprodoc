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
 * author: Joaquin Hierro      2019
 * 
 */
package APIRest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jhier
 */
@Path("/session")
public class Login extends APICore
{
//-------------------------------------------------------------------------
/**
* Creates a new instance of Login
*/
public Login()
{
}
//-------------------------------------------------------------------------
/**
 * Deletes session
 * http://localhost:8080/TestAPIRest/APIRest/login Content-Type: application/json  
 * @param request HttpServletRequest
 * @return Response
 */
@DELETE
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response Disconnect(@Context HttpServletRequest request)
{
if (isLogDebug())    
    Debug("Disconnecting=");    
return(CloseSession(request));
}
//-------------------------------------------------------------------------
/**
 * PUT method for creating a session
 * http://localhost:8080/TestAPIRest/APIRest/login Content-Type: application/json  {"Name":"pep", "Password":"ll"}
 * @param Credentials representation for the resource
 * @param request
 * @return 
 */
@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response Connect(String Credentials, @Context HttpServletRequest request)
{
if (isLogDebug())    
    Debug("Login="+Credentials);
String Token=CanCreateSess(Credentials, request);
if (Token==null)
    return(returnUnathorize());
return(NewOKSesion(Token));
}
//-------------------------------------------------------------------------
}
