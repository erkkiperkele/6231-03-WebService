
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by Aymeric on 2015-11-21.
 */
@WebService(targetNamespace = "http://test")
public class AymericHelloService {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
  public static void main(String[] argv) {
    Object implementor = new AymericHelloService ();
    String address = "http://localhost:8080/AymericHelloService";
    Endpoint.publish(address, implementor);
  }
}
