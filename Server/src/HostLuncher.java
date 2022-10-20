public class HostLuncher {

  public static void main(String[] args) {
    
    testClass myTest = new testClass(100);
    testClass opponentTest = new testClass(0);
    HostServer host = new HostServer(myTest, opponentTest);
    host.setUpServer();

    try {
      Thread.sleep(6000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    host.updateMyTest();
    myTest.x = 200;
    
    host.updateOpponentTest();
    opponentTest.x = 6000;

    System.out.println("change");

    try {
      Thread.sleep(60000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    host.end();
  }
}
