package calculator1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class WelcomeServlet1 extends GenericServlet{

	
	@Override
		public void init() throws ServletException {
			System.out.println("init");
			super.init();
		}

		@Override
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			PrintWriter output = res.getWriter();
			res.setContentType("text/html");
			 String choice =req.getParameter("btn");
			 String user = req.getParameter("nm");
//			 String course[] = req.getParameterValues("c1");
			 output.println("<h2>Hii "+user+"</h2>");
			 String gadget = req.getParameter("r1");
			 
//			 if(course == null) {
//				 output.println("<h2>Please select a course</h2>");
//			 }
//			 for (int i = 0; i < course.length; i++) {
//				switch(course[i]) {
//				case "java":
//					output.println("<h2>java fee is 5000</h2>");
//					break;
//				case "python":
//					output.println("<h2>python fee is 6000</h2>");
//					break;
//				case "go":
//					output.println("<h2>go fee is 7000</h2>");
//					break;
//				case "c++":
//					output.println("<h2>c++ fee is 9000</h2>");
//					break;
//				default :
//					output.println("<h2>Please select a course</h2>");
//					break;
//				}
//			}
			 
//			System.out.println(choice);
//			Integer n1 = Integer.parseInt(req.getParameter("num1"));
//			Integer n2 = Integer.parseInt(req.getParameter("num2"));
//			//int sum = n1+n2;
//			if (choice.equals("Add")) {
//				int add = n1+n2;
//			output.print("<h1>addition="+add+"</h1>");
//			}
//			else if (choice.equals("Sub")) {
//				int sub = n1-n2;
//			output.print("<h1>substraction="+sub+"</h1>");
//			}
//			else if (choice.equals("Div")) {
//				int div = n1/n2;
//			output.print("<h1>division="+div+"</h1>");
//			}
//			else if(choice.equals("Mul")) {
//				int mul = n1*n2;
//			output.println("<h1>multiplication="+mul+"</h1>");
//			}
			
			output.println("<a href='calculator1.html'>Back</a><br>");
			
		}
		
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			System.out.println("destroy");
			super.destroy();
		}

	}


