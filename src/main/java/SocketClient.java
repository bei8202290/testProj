import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient implements Runnable{
	
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	
	SocketClient(){
		try{
			socket = new Socket("127.0.0.1", 10000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try{
			writer = new PrintWriter(socket.getOutputStream());
			writer.print("working......");
			writer.flush();
			socket.shutdownOutput(); //关闭输出流后发送消息？
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line, buffer="";
			while((line = reader.readLine()) != null){
				buffer += line;
			}
			System.out.println(buffer);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(socket != null){
					socket.close();
				}
				if(reader != null){
					reader.close();
				}
				if(writer != null){
					writer.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		new Thread(new SocketClient()).start();
	}
}
