import java.io.IOException;
import java.net.ServerSocket;
import java.io.ObjectOutputStream;

public class HostServer extends Server{

    ServerSocket svSock;
    ServerSocket svReturnSock;

    HostServer(testClass _myTest, testClass _copy_opponentTest){
        super(_myTest, _copy_opponentTest);
    }

    public void setUpServer() {
        try {
            svSock = new ServerSocket(myPORT);
            svReturnSock = new ServerSocket(opponentPORT);
            
            sock = svSock.accept();
            returnSock = svReturnSock.accept();

            myOutStream = new ObjectOutputStream(sock.getOutputStream());
            opponentOutStream = new ObjectOutputStream(returnSock.getOutputStream());

            opponentReception = new Reception(sock, opponentTest);
            returnReception = new Reception(returnSock, myTest);
            
            System.out.println("connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(this);
        thread.start();
    }

    public void end() {
        runServer = false;
        try {
            sock.close();
            svSock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}