package ServicesTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.sgcib.superMarketPricing.AbstractTest;
import com.sgcib.superMarketPricing.TestUtil;
import com.sgcib.superMarketPricing.entities.CartItem;
import com.sgcib.superMarketPricing.entities.ShoppingCart;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

public class ShoppingCartServiceTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void payTest() throws Exception {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setListItems(Arrays.asList(
                new CartItem(),
                new CartItem()
        ));
        ResultActions mvcResult = mvc.perform(MockMvcRequestBuilders.post("/pay")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(shoppingCart)));

        mvcResult.andExpect(status().isCreated());

    }
}
