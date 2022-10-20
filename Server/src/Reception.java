import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;

public class Reception extends Thread {
    Socket sock;
    ObjectInputStream in;
    testClass test;

    Reception(Socket _sock, testClass _test) {
        sock = _sock;
        test = _test;
        try {
            in = new ObjectInputStream(sock.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {

            try {
                testClassWrapper _testWrapper = (testClassWrapper) in.readObject();
                if (_testWrapper.valid == true) {
                    test.x = _testWrapper.test.x;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("receivedData: " + test.x);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
