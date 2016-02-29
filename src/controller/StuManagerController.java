package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.aspectj.runtime.reflect.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import oracle.net.aso.s;
import service.StuManager;
import service.impl.StuManagerImpl;
import vo.Student;

@Controller
public class StuManagerController {
	
	@Autowired(required=true)
	private  StuManager sm;
	
	@Resource(name="pooledConnectionFactory")
	private ConnectionFactory factory;
	
	@Resource(name="queueDestination")
	private  ActiveMQDestination destination;
	
	private ConnectionFactory myFactory;
	private Connection conn;
	private Session session;
	private Message msg;
	private MessageProducer producer;
	
	@RequestMapping("/stuLogin")
	public String login(String xh,String psd,HttpServletRequest request){
		
		
		Student s=sm.login(xh, psd);
		
		if(s!=null){
			
			s.setIP(request.getRemoteAddr());
			s.setDate_time(new Date().toString());
			request.getSession().setAttribute("s", s);
	
			try {
				conn = factory.createConnection();
				conn.start();
				session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
				//MessageProducer producer = session.createProducer(queue);
				producer = session.createProducer(destination);
				msg = session.createTextMessage(s.toString());
				//TextMessage message = session.createTextMessage("hello lihui,my name is muxiaocao");
				producer.send(msg);

			} catch (JMSException e) {
				e.printStackTrace();
			}finally {
				
				try {
					producer.close();
					session.close();
					conn.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			return "WEB-INF/jps/loginSuc";
		}
		else{
			return "login";
		}
		
		
	}
	@RequestMapping("/stuRegist")
	public String regist(Student s,HttpServletRequest request){
	
		int rs=sm.regist(s);
		if(rs>0)
		return "redirect:/regSuc.jsp";
		else return "regist";
	}
	
	
	
	@RequestMapping("/tes1")
	public String test1(OutputStream out){
		try {
			InputStream in=new FileInputStream("e:/aa.jpg");
			byte[] buf=new byte[1024];
			int len=0;
			while((len=in.read(buf))!=-1){
				out.write(buf, 0, len);
			}
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		 
	}
	
	
	
	@RequestMapping("/test2")
	@ResponseBody
	public String test2(){
		
		
		return "Hello workd!!!!";
		
		 
	}
	
	
	@RequestMapping("/test3")
	@ResponseBody
	public Student test3(){
		Student s = new Student();
		s.setId(100);
		
		return s;
		
		 
	}
	
	
	
}
