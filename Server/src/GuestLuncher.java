public class GuestLuncher {

  public static void main(String[] args) {
    
    testClass myTest = new testClass(5000);
    testClass opponentTest = new testClass(0);

    String ipAdress = "";

    GuestServer guest = new GuestServer(myTest, opponentTest);
    guest.connect(ipAdress);


    try {
      Thread.sleep(60000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    guest.end();
  }
}
