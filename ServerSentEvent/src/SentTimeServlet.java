

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息推送
 */
@WebServlet("/SentTimeServlet")
public class SentTimeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置报头为消息推送，只有文本事件类型的请求才可以
		response.setContentType("text/event-stream;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		while (true) {
			//data:是固定的格式
			out.write("data:这是来自于服务器端的消息，" + new Date() + "\n\n" );
			out.flush();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}

	}

}