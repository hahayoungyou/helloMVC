package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId=request.getParameter("customerId"); //아이디를 받아
		
		// perform business logic. return a bean as a result->DB//DB에서 조회
		//CustomerService service=new CustomerService();//singleton패턴 
		
		CustomerService service=(CustomerService) CustomerService.getInstance();
		System.out.println(service);
		customer customer= service.findCustomer(customerId);
		//controller 데이터 view로 넘기기
		request.setAttribute("customer" , customer);//"customer"라는 키값을 바탕으로 전달
		List<customer> customerList=service.getAllCustomers();
		request.setAttribute("customers", customerList);
		String page;
		if(customer==null)
			page="/view/error.jsp";
		else 
			page="/view/success.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(page);
	
		dispatcher.forward(request,response); //view에 전달
	}

}
