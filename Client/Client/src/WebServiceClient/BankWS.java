package WebServiceClient;/**
 * Created by Aymeric on 2015-11-21.
 */
public class BankWS {
  public static void main(String[] argv) {
    WebServiceClient.BankWebService service = new WebServiceClient.BankWebService_Service().getPort();
    //invoke business method
    service.sayHelloWorldFrom("Aymeric");
  }
}
