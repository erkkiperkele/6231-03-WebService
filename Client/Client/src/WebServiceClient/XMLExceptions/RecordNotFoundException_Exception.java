
package WebServiceClient.XMLExceptions;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "RecordNotFoundException", targetNamespace = "http://bank")
public class RecordNotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private RecordNotFoundException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public RecordNotFoundException_Exception(String message, RecordNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public RecordNotFoundException_Exception(String message, RecordNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: WebServiceClient.XMLExceptions.RecordNotFoundException
     */
    public RecordNotFoundException getFaultInfo() {
        return faultInfo;
    }

}
