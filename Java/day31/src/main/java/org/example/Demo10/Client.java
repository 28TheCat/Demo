package org.example.Demo10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",11111);
        OutputStream os=socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        while ( true){
            String line = sc.nextLine();
            if( line.equals("over")){
                System.out.println("程序结束");
                os.close();
                bw.close();
                socket.close();
                return;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
    }
}
