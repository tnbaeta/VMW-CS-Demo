package lab.illfact.vmwcsdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FullNameTest {

	@Test
	public void testFullName() throws IOException, ServletException {
	
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		
		when(request.getParameter("fn")).thenReturn("Tiago");
		when(request.getParameter("ln")).thenReturn("Baeta");
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		when(response.getWriter()).thenReturn(pw);
		
		FullName fnServlet = new FullName();
		fnServlet.doGet(request, response);
		String result = sw.getBuffer().toString().trim();
		assertEquals(result, new String( "Full Name: Tiago Baeta" ));
		
	}
	
}