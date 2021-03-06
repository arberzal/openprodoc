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

package prodoc;

import java.util.Date;

/**
 * Class for managing (relaunch, delete,..) the task ended
 * @author jhierrot
 */
public class PDTasksExecEnded extends PDTasksExec
{

    /**
     *
     */
    public static final String fSTARTDATE="StartDate";

    /**
     *
     */
    public static final String fENDDATE="EndDate";

    /**
     *
     */
    public static final String fRESULT="Result";

    /**
     *
     */
    public static final String fENDSOK="EndsOk";

/**
 *
 */
static private Record TaksTypeStruct=null;

/**
 *
 */
private Date StartDate;
private Date EndDate;
private String Result;
private boolean EndsOk;

/**
 * Dafult constructor
 * @param Drv Openprodoc Session
 * @throws PDException in any error
 */
public PDTasksExecEnded(DriverGeneric Drv)  throws PDException
{
super(Drv);
}
//-------------------------------------------------------------------------
/**
 * Assign new values to the TasksExecEnded object
 * @param Rec Record of TasksExecEnded type with new values
 * @throws PDException in any error
 */
@Override
public void assignValues(Record Rec) throws PDException
{
super.assignValues(Rec);    
setPDId((String) Rec.getAttr(fPDID).getValue());
setStartDate((Date) Rec.getAttr(fSTARTDATE).getValue());
setEndDate((Date) Rec.getAttr(fENDDATE).getValue());
setResult((String) Rec.getAttr(fRESULT).getValue());
if (Rec.getAttr(fENDSOK).getValue()==null)
   setEndsOk(false);
else
    setEndsOk((Boolean) Rec.getAttr(fENDSOK).getValue());
assignCommonValues(Rec);
}
//-------------------------------------------------------------------------
/**
 * Returns a record with the current values
 * @return a record with the current values
 * @throws PDException in any error
 */
@Override
synchronized public Record getRecord() throws PDException
{
Record Rec=getRecordStruct();
Rec.assign(super.getRecord().Copy());
Rec.getAttr(fPDID).setValue(getPDId());
Rec.getAttr(fSTARTDATE).setValue(getStartDate());
Rec.getAttr(fENDDATE).setValue(getEndDate());
Rec.getAttr(fRESULT).setValue(getResult());
Rec.getAttr(fENDSOK).setValue(isEndsOk());
getCommonValues(Rec);
return(Rec);
}

//-------------------------------------------------------------------------
/**
 * Returns the name of TasksExecEnded table in DDBB
 * @return the name of TasksExecEnded table in DDBB
 */
@Override
public String getTabName()
{
return (getTableName());
}
//-------------------------------------------------------------------------
/**
 * Static method that returns the name of TasksExecEnded table in DDBB
 * @return the name of TasksExecEnded table in DDBB
 */
static public String getTableName()
{
return ("PD_TASKS_ENDED");
}
//-------------------------------------------------------------------------
/**
*
* @return
*/
@Override
Record getRecordStruct() throws PDException
{
if (TaksTypeStruct==null)
    TaksTypeStruct=CreateRecordStruct();
return(TaksTypeStruct.Copy());
}
//-------------------------------------------------------------------------
/**
*
* @return
*/
static synchronized private Record CreateRecordStruct() throws PDException
{
if (TaksTypeStruct==null)
    {
    Record R=new Record();
    CreateRecordStructBase(R);
    R.addAttr( new Attribute(fPDID, fPDID, "Unique_identifier", Attribute.tSTRING, true, null, 32, true, false, false));
    R.addAttr( new Attribute(fENDDATE, fENDDATE, "Next Date of execution", Attribute.tTIMESTAMP, false, null, 32, false, false, true));
    R.addAttr( new Attribute(fSTARTDATE, fSTARTDATE, "Start Date of execution", Attribute.tTIMESTAMP, false, null, 32, false, false, true));
    R.addAttr( new Attribute(fNEXTDATE, fNEXTDATE, "Next Date of execution", Attribute.tTIMESTAMP, true, null, 128, false, false, true));
    R.addAttr( new Attribute(fRESULT, fRESULT, "Description of error", Attribute.tSTRING, false, null, 254, false, false, true));
    R.addAttr( new Attribute(fENDSOK, fENDSOK, "True if the taks end correctly", Attribute.tBOOLEAN, false, null, 32, false, false, true));
    return(R);
    }
else
    return(TaksTypeStruct);
}
//-------------------------------------------------------------------------
/**
* @return the StartDate
*/
public Date getStartDate()
{
return StartDate;
}
//-----------------------------------------------------------------------
/**
* @param StartDate the StartDate to set
*/
public void setStartDate(Date StartDate)
{
this.StartDate = StartDate;
}
//-----------------------------------------------------------------------
/**
* @return the NextDate
*/
public Date getEndDate()
{
return EndDate;
}
//-----------------------------------------------------------------------
/**
 * @param NextDate the nextdate
 */
public void setEndDate(Date NextDate)
{
this.EndDate = NextDate;
}
//-------------------------------------------------------------------------
/**
 * @return the Result
 */
public String getResult()
{
return Result;
}
//-------------------------------------------------------------------------
/**
 * @param Result the Result to set
 */
public void setResult(String Result)
{
this.Result = Result;
}
//-------------------------------------------------------------------------
/**
 * @return the EndsOk
 */
public boolean isEndsOk()
{
return EndsOk;
}
//-------------------------------------------------------------------------
/**
 * @param EndsOk the EndsOk to set
 */
public void setEndsOk(boolean EndsOk)
{
this.EndsOk = EndsOk;
}
//-------------------------------------------------------------------------
/**
 *
 * @return
 * @throws PDException in any error
 */
protected Conditions getConditions() throws PDException
{
Conditions ListCond=new Conditions();
ListCond.addCondition(new Condition(fPDID, Condition.cEQUAL, getPDId()));
return(ListCond);
}
//-------------------------------------------------------------------------
/**
 *
 * @param Ident
 * @throws PDExceptionFunc  in any error 
 */
@Override
protected void AsignKey(String Ident) throws PDExceptionFunc
{
setPDId(Ident);
}
//-------------------------------------------------------------------------

}
