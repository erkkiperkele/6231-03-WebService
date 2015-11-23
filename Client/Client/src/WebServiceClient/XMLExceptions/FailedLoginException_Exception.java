
package WebServiceClient.XMLExceptions;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 *
 */
@WebFault(name = "FailedLoginException", targetNamespace = "http://bank")
public class FailedLoginException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     *
     */
    private FailedLoginException faultInfo;

    /**
     *
     * @param faultInfo
     * @param message
     */
    public FailedLoginException_Exception(String message, FailedLoginException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     *
     * @param faultInfo
     * @param cause
     * @param message
     */
    public FailedLoginException_Exception(String message, FailedLoginException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     *
     * @return
     *     returns fault bean: WebServiceClient.XMLExceptions.FailedLoginException
     */
    public FailedLoginException getFaultInfo() {
        return faultInfo;
    }

}