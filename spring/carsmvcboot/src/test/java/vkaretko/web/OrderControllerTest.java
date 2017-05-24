package vkaretko.web;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import vkaretko.Application;
import vkaretko.domain.Order;
import vkaretko.repository.OrderDAO;

import java.util.ArrayList;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Class OrderControllerTest.
 * Description TODO.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.05.17 19:13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderControllerTest {

    private MockMvc mvc;

    @MockBean
    private OrderDAO orderDAO;

    @Before
    public void setup() {
       this.mvc = standaloneSetup(new OrderController(orderDAO)).build();
    }

    @Test
    @WithMockUser(username="user", roles={"USER"})
    public void whenGetOrdersThenPageOrders() throws Exception {
        given(
                this.orderDAO.findAll()
        ).willReturn(
                new ArrayList<>(
                        Lists.newArrayList(new Order())
                )
        );

        this.mvc.perform(
                get("/").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("index")
        );
    }

}