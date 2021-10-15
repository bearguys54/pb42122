import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerWorker extends Thread {
	private final Socket clientSocket;
	public ServerWorker(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			handleClientSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void handleClientSocket() throws IOException, InterruptedException {
		InputStream inputStream = clientSocket.getInputStream();
		OutputStream outputStream = clientSocket.getOutputStream();
		outputStream.write("conected".getBytes());
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = reader.readLine()) != null) {
			if("quit".equalsIgnoreCase(line)) {
				break;
			}
			String msg = "you typed:" + line + "\n";
			outputStream.write(msg.getBytes());
		}
		
		clientSocket.close();
	}

}
