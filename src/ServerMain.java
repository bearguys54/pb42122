import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 7100;
		try {
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("chtsrv started");
		
		while(true) {
		Socket clientSocket = serverSocket.accept();
		ServerWorker sWorker = new ServerWorker(clientSocket);
		sWorker.start();
		}
		/*
		Scanner kb = new Scanner (System.in);
		
		while(true) {
			String st = din.readUTF();
			System.out.println(st);
			System.out.println("server:  ");
			String msg = kb.nextLine();
			dos.writeUTF("server: " + msg);
			dos.flush();
			kb=kb.reset();
	}
	*/
		
	} catch (Exception e) {
		// TODO: handle exception
	}

}


}
