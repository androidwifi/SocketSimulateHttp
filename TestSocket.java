import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SocketSimulate {
	String host = "www.javathinker.org";
	int port = 80;
	Socket socket;

	public void createSocket() throws Exception {
		socket = new Socket("www.baidu.com", 80);
	}

	public void connect() throws Exception {
    StringBuffer sb = new StringBuffer("GET / HTTP/1.1/r/n");
    sb.append("Host: <A href=\"www.baidu.com\" mce_href=\"www.baidu.com\" target=_blank>www.baidu.com</A>/r/n");
    sb.append("Connection: Keep-Alive/r/n");
    sb.append("Accept: */*/r/n/r/n");

    OutputStream socketOut = socket.getOutputStream();
    socketOut.write(sb.toString().getBytes());
    socket.shutdownOutput();

    System.out.println(socket);

    InputStream socketIn = socket.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(socketIn));
    String data;
    while ((data = br.readLine()) != null) {
      System.out.println(data);
    }
    socket.close();
  }

	public static void main(String args[]) throws Exception {
		SocketSimulate client = new SocketSimulate();
		client.createSocket();
		client.connect();
	}

}
