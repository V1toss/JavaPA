package vkaretko.servlets;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.io.IOException;
import java.sql.Connection;

import static org.mockito.Mockito.*;

/**
 * Class CreateUserTest.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 04.04.2017.
 */
public class UsersControllerTest {

     @Test
    public void deleteUser() throws ServletException, IOException, NamingException {
         DeleteUser controller = new DeleteUser();
         HttpServletRequest request = mock(HttpServletRequest.class);
         HttpServletResponse response = mock(HttpServletResponse.class);

         when(request.getParameter("login")).thenReturn("111");

         controller.doPost(request, response);

         verify(request, atLeast(1)).getParameter("login");
    }
}