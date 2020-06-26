/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiennd
 */
public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("Running at 9999");
		ServerSocket listener = new ServerSocket(9999);
		int countClient = 0;
		while (true) {
			Socket clientSocket = listener.accept();
			ConnectedThread newClient = new ConnectedThread(clientSocket, countClient); // tao luong rieng de xuuy
			newClient.start();
		}
	}
}

class ConnectedThread extends Thread {

	Socket socket;
	int id;
	BufferedReader in;
	PrintWriter out;

	ConnectedThread(Socket clientSocket, int numClients) throws IOException {
		this.socket = clientSocket;
		this.id = numClients;
		System.out.println("Client " + socket + " connected! Client number " + id);
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("Connected to server!");
			while (true) {
				String buf = in.readLine(); // nhan du lieu tu client
				System.out.println("RECV: " + buf);

				// "8 7 65 0 8 6 0"
				String[] strArr = buf.split(" ");// "8" "7" ...

				int[] intArr = new int[strArr.length];
				for (int i = 0; i < strArr.length; i++) {
					intArr[i] = Integer.parseInt(strArr[i]); // chuyen string ve int
				}

				int[] intAns = Sorter.getInstance().sort(intArr);
				System.out.println("after sort: " + Arrays.toString(intAns));

				String ans = "ANS: ";
				for (int i = 0; i < intAns.length; i++) {
					ans = ans + intAns[i] + "; ";
				}

				out.println("FUNCTION ANS: " + ans);
			}
		} catch (Exception e) {
			System.out.println("Error: client " + id + "; message " + e.getMessage());

		} finally {
			try {
				socket.close();
			} catch (IOException ex) {
				System.out.println("Client error while close socket " + ex.getMessage());
			} finally {
				System.out.println("Client " + id + " closed!");
			}
		}

	}

}
