package vkaretko.servlets;

import vkaretko.DBManager;
import vkaretko.models.User;
import org.junit.Test;

import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeast;


/**
 * Class CreateUserTest.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 04.04.2017.
 */
public class ControllersTest {

    /**
     * Test for creating user servlet.
     * @throws ServletException servlet exception.
     * @throws IOException IOException.
     */
    @Test
    public void createUser() throws ServletException, IOException {
        CreateUser controller = new CreateUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("name")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test@test.ru");
        when(request.getParameter("password")).thenReturn("111");
        when(request.getParameter("role_id")).thenReturn("3");

        controller.doPost(request, response);
        User user = DBManager.getInstance().getUser("test", "111");
        assertEquals("test", user.getLogin());

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("name");
        verify(request, atLeast(1)).getParameter("email");
        verify(request, atLeast(1)).getParameter("password");
        verify(request, atLeast(1)).getParameter("role_id");
    }

    /**
     * Test for deleting user.
     * @throws ServletException ServletException.
     * @throws IOException IOException.
     * @throws NamingException NamingException.
     */
    @Test
    public void deleteUser() throws ServletException, IOException, NamingException {
        DeleteUser controller = new DeleteUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");

        controller.doPost(request, response);
        User user = DBManager.getInstance().getUser("test", "111");

        assertNull(user);
        verify(request, atLeast(1)).getParameter("login");
    }

    /**
     * Test for update user servlet.
     * @throws ServletException servlet exception.
     * @throws IOException IOException.
     */
    @Test
    public void updateUser() throws ServletException, IOException {
        UpdateUser controller = new UpdateUser();
        this.createUser();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("name")).thenReturn("testAfterEdit");
        when(request.getParameter("email")).thenReturn("test@test.ru");
        when(request.getParameter("password")).thenReturn("111");
        when(request.getParameter("role_id")).thenReturn("3");

        controller.doPost(request, response);
        User user = DBManager.getInstance().getUser("test", "111");
        assertEquals("testAfterEdit", user.getName());

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("name");
        verify(request, atLeast(1)).getParameter("email");
        verify(request, atLeast(1)).getParameter("password");
        verify(request, atLeast(1)).getParameter("role_id");
    }
}