package com.neo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/Log4jInit")
public class Log4jInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = Logger.getLogger(BaseServlet.class.getName());
	
    public Log4jInitServlet() {
        super();
    }
    
    public	void init() {
      String prefix =  getServletContext().getRealPath("/");
      String file = getInitParameter("log4j-init-file");
      if(file != null) {
        PropertyConfigurator.configure(prefix+file);
      }
      
//      logger.debug("debug: Entering application.");
      logger.info("info:Entering application.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
