package Server;


import BankServices.BankWebService;
import Contracts.IBankService;
import Data.Bank;
import Services.BankService;
import Services.SessionService;

/**
 * This class starts both RMI and UDP servers for a given bank.
 * It also contains basic tests for data access (concurrency, UDP protocols...)
 */
public class BankServer {

    private static IBankService bankService;

    private static UDPServer udp;


    /**
     * Instatiates and starts the WebService and UDP servers.
     * ATTENTION: needs a single integer argument which is the bank Id for the server
     * See the Bank enum to know what integer corresponds to what bank.
     *
     * @param args a single integer defining what bank this server belongs to.
     */
    public static void main(String[] args) {

        String serverArg = args.length > 0
                ? args[0]
                : "1";

        initialize(serverArg);

        //Starting bank server
        startWebServices();
        startUDPServer();
    }

    private static void startWebServices() {

        new BankWebService((BankService)bankService);
    }

    private static void initialize(String arg) {
        Bank serverName = Bank.fromInt(Integer.parseInt(arg));
        SessionService.getInstance().setBank(serverName);
        bankService = new BankService();
        udp = new UDPServer(bankService);
    }

    private static void startUDPServer() {
        Thread startUdpServer = new Thread(() ->
        {
            udp.startServer();
        });
        startUdpServer.start();
        SessionService.getInstance().log().info(String.format("[UDP] SERVER STARTED"));

    }
}
