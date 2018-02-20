package com.bankmega;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

public class InquiryClientTest {

	public static final String HOST = "localhost";
	public static final int PORT = 8074;
	public static final String REQUEST = "000003FC5CD4D6E2C140404040404040404040F1F04BF1F14BF3F34BF8F5404040404040404040404040404040404040404040404040404040404040E3F9F9F9F940404040405CC5D6D4D1E6E3F1404040404040404000404040F5F5F5F5F4F9F9F9F2F0F1F6F2F10000000002A2000054080000010010020101191F0000000000000000000F0000000000000000000F0000000000000000000F0000000000000000000F0000000000000000000F0000000000000000000F0000000000213114004F0000000000000000000F0000000000213114004F0000000000000000000F0000000000213114004F0000000000000000000F0000000000000000000F0000000000000000000F0000000000000000000F0000000000000000000F0000000000000000000F0000000000000000000F0000000000000000000F0000C9C4D94040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040C9C4D940C9C4D940404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040F0F0404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040404040";

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket(HOST, PORT);
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		
		byte[] byteinput = hexStringToByteArray(REQUEST);
		dout.write(byteinput);
		dout.flush();
		
		int length = din.readInt();
		if (length > 0) {
			byte[] resbyte = new byte[length];
			din.read(resbyte);
			System.out.println("Reply from Server: " + new String(resbyte, Charset.forName("IBM285")));
		}
        
		socket.close();

	}
}