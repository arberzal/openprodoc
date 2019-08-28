/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIRest;

import APIRest.beans.FolderB;
import APIRest.beans.QueryJSON;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import prodoc.Cursor;
import prodoc.DriverGeneric;
import prodoc.PDException;
import prodoc.PDFolders;

/**
 * REST Web Service
 *
 * @author jhier
 */
@Path("/folders")
public class FoldersAPI extends APICore
{
/**
 * Creates a new instance of FoldAPI
 */
public FoldersAPI()
{
}
//-------------------------------------------------------------------------
/**
 * Retrieves representation of an instance of APIRest.FoldersAPI
 * @param FoldId
 * @param request
 * @return an instance of java.lang.String
 */
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/ById/{foldId}")
public Response getFoldById(@PathParam("foldId") String FoldId,@Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
if (isLogDebug())
    Debug("getFoldById="+FoldId);    
try {
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
Fold.LoadFull(FoldId);
FolderB f=FolderB.CreateFolder(Fold);
return (Response.ok(f.getJSON()).build());
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
/**
 * Retrieves representation of an instance of APIRest.FoldersAPI
 * @param path
 * @param request
 * @return an instance of java.lang.String
 */
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/ByPath/{path:.*}")
public Response getFoldByPath(@PathParam("path") String path, @Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
if (isLogDebug())
    Debug("getFoldByPath="+path);   
try {
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
String idPath = Fold.getIdPath("/"+path);
Fold.LoadFull(idPath);
FolderB f=FolderB.CreateFolder(Fold);
return (Response.ok(f.getJSON()).build());
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
/**
 * POST method for creating an instance of FoldersAPI
 * @param NewFold representation for the resource
 * @param request
 * @return 
 */
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response Insert(String NewFold,@Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
try {
FolderB f=FolderB.CreateFolder(NewFold);
if (isLogDebug())
    Debug("NewFolder="+NewFold);
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD, f.getType());
f.Assign(Fold);
if (f.getId()!=null && f.getId().length()!=0)
    Fold.setPDId(f.getId());
if (f.getIdparent()!=null && f.getIdparent().length()!=0)
    Fold.setParentId(f.getIdparent());
Fold.insert();
return (returnOK("Creado="+Fold.getPDId()));
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
/**
 * PUT method for updating an instance of FoldersAPI
 * @param FoldId
 * @param UpdFold representation for the resource
 * @param request
 * @return 
 */
@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/ById/{foldId}")
public Response UpdateById(@PathParam("foldId") String FoldId, String UpdFold,@Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
try {
if (isLogDebug())
    Debug("Fold UpdateById="+UpdFold);
FolderB f=FolderB.CreateFolder(UpdFold);
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
Fold.Load(FoldId);
f.Assign(Fold);
Fold.update();
return (returnOK("Updated="+Fold.getPDId()));
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
/**
 * PUT method for updating an instance of FoldersAPI
 * @param path
 * @param UpdFold representation for the resource
 * @param request
 * @return 
 */
@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/ByPath/{path:.*}")
public Response UpdateByPath(@PathParam("path") String path, String UpdFold,@Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
try {
if (isLogDebug())
    Debug("Fold UpdateByPath="+UpdFold);
FolderB f=FolderB.CreateFolder(UpdFold);
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
Fold.Load(Fold.getIdPath("/"+path));
f.Assign(Fold);
Fold.update();
return (returnOK("Updated="+Fold.getPDId()));
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
/**
 * Retrieves representation of an instance of APIRest.FoldersAPI
 * @param FoldId
 * @param Initial
 * @param Final
 * @param request
 * @return an instance of java.lang.String
 */
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/SubFoldersById/{foldId}")
public Response getSubFoldsById(@PathParam("foldId") String FoldId, @DefaultValue("0") @QueryParam("Initial") int Initial,@DefaultValue("100") @QueryParam("Final") int Final, @Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
if (isLogDebug())
    Debug("getSubFoldsById="+FoldId+ ",Initial="+Initial+ ",Final="+Final);    
try {
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
return (Response.ok(GenSubFoldersList(Fold, FoldId, Initial, Final)).build());
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
/**
 * Retrieves representation of an instance of APIRest.FoldersAPI
 * @param Path
 * @param Initial
 * @param Final
 * @param request
 * @return an instance of java.lang.String
 */
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/SubFoldersByPath/{path:.*}")
public Response getSubFoldsByPath(@PathParam("path") String Path, @DefaultValue("0") @QueryParam("Initial") int Initial,@DefaultValue("100") @QueryParam("Final") int Final, @Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
if (isLogDebug())
    Debug("getSubFoldsByPath="+Path+ ",Initial="+Initial+ ",Final="+Final);    
try {
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
return (Response.ok(GenSubFoldersList(Fold, Fold.getIdPath("/"+Path), Initial, Final)).build());
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
private String GenSubFoldersList(PDFolders Fold, String Id, int Initial, int Final) throws PDException
{
HashSet<String> ChildFolds = Fold.getListDirectDescendList(Id);
ArrayList<FolderB> L=new ArrayList();
int count=0;
for (String ChildFold : ChildFolds)
    {
    Fold.LoadFull(ChildFold);
    FolderB f=FolderB.CreateFolder(Fold);
    if (count++>=Initial)
        L.add(f);
    if (count>=Final)
        break;
    }
Gson g = new Gson();
return g.toJson(L);
}
//-------------------------------------------------------------------------
/**
 * DELETE method for deleting an instance of FoldersAPI
 * @param FoldId
 * @param request
 * @return 
 */
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/ById/{foldId}")
public Response DeleteById(@PathParam("foldId") String FoldId,@Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
try {
if (isLogDebug())
    Debug("Fold DeleteById="+FoldId);
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
Fold.Load(FoldId);
Fold.delete();
return (returnOK("Deleted="+Fold.getPDId()));
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
/**
 * DELETE method for deleting an instance of FoldersAPI
 * @param path
 * @param request
 * @return 
 */
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/ByPath/{path:.*}")
public Response DeleteByPath(@PathParam("path") String path, @Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
try {
if (isLogDebug())
    Debug("Fold DeleteByPath="+path);
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
Fold.Load(Fold.getIdPath("/"+path));
Fold.delete();
return (returnOK("Deleted="+Fold.getPDId()));
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
/**
 * Retrieves representation of an instance of APIRest.FoldersAPI
 * @param QueryParams
 * @param request
 * @return an instance of java.lang.String
 */
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/Search")
public Response Search(String QueryParams, @Context HttpServletRequest request)
{
if (!IsConnected(request))    
    return(returnUnathorize());
if (isLogDebug())
    Debug("Fold Search=["+QueryParams+ "]");  
try { // TODO: Check empty
QueryJSON RcvQuery = QueryJSON.CreateQuery(QueryParams);   
DriverGeneric sessOPD = getSessOPD(request);
PDFolders Fold=new PDFolders(sessOPD);
Cursor SearchFold = Fold.SearchSelect(RcvQuery.getQuery());
return (Response.ok(genCursor(sessOPD, SearchFold, RcvQuery.getInitial(), RcvQuery.getFinal())).build());
} catch (Exception Ex)
    {
    Ex.printStackTrace();
    return(returnERROR(Ex.getLocalizedMessage()));
    }
}
//-------------------------------------------------------------------------
}
