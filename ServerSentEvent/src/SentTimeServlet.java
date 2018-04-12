

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��Ϣ����
 */
@WebServlet("/SentTimeServlet")
public class SentTimeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//���ñ�ͷΪ��Ϣ���ͣ�ֻ���ı��¼����͵�����ſ���
		response.setContentType("text/event-stream;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		while (true) {
			//data:�ǹ̶��ĸ�ʽ
			out.write("data:���������ڷ������˵���Ϣ��" + new Date() + "\n\n" );
			out.flush();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}

	}

}