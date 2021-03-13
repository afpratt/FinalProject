package tests;

import state.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StateTest {

	@Test
	void test() {
		JerseyStoreState jerseyStoreState = new JerseyStoreState();
		
		String expectedState = "No payment information state.";
		String actualState = jerseyStoreState.toString();
		assertEquals(expectedState, actualState);
		
		jerseyStoreState.enterPaymentInformation();
		
		String expectedState2 = "Has payment information state.";
		String actualState2 = jerseyStoreState.toString();
		assertEquals(expectedState2, actualState2);
		
		jerseyStoreState.placeOrder();
		
		String expectedState3 = "Sold state.";
		String actualState3 = jerseyStoreState.toString();
		assertEquals(expectedState3, actualState3);
	}

}
