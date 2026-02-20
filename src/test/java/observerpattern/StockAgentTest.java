package observerpattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockAgentTest {
    private StockAgent stockAgent;
    private Stock appleStock;
    private StockExchangeAgency agency1;
    private StockExchangeAgency agency2;
    private StockExchangeAgency agency3;

    @BeforeEach
    void setup() {
        appleStock = new Stock("Apple");
        appleStock.setValue(100.0); // Start at $100

        stockAgent = new StockAgent(appleStock);

        agency1 = new StockExchangeAgency("agency1");
        agency2 = new StockExchangeAgency("agency2");
        agency3 = new StockExchangeAgency("agency3");

        stockAgent.attach(agency1);
        stockAgent.attach(agency2);
        stockAgent.attach(agency3);
    }

    @Test
    void verify_Agent_Can_Attach_New_Agencies() {

        int initialObserverCount = stockAgent.getObservers().size();
        assertEquals(3, initialObserverCount, "Should start with 3 observers from setup");

        StockExchangeAgency newAgency = new StockExchangeAgency("newAgency");
        StockExchangeAgency anotherNewAgency = new StockExchangeAgency("anotherNewAgency");

        stockAgent.attach(newAgency);
        stockAgent.attach(anotherNewAgency);

        assertEquals(5, stockAgent.getObservers().size(), "Should have 5 observers after attaching 2 more");

        assertTrue(stockAgent.getObservers().contains(newAgency), "New agency should be in the observers list");
        assertTrue(stockAgent.getObservers().contains(anotherNewAgency), "Another new agency should be in the observers list");
    }

    @Test
    void verify_Agent_Can_Detach_Agencies() {

        assertEquals(3, stockAgent.getObservers().size(), "Should start with 3 observers");

        stockAgent.detach(agency1);

        assertEquals(2, stockAgent.getObservers().size(), "Should have 2 observers after detaching one");
        assertFalse(stockAgent.getObservers().contains(agency1), "Agency 1 should no longer be in the observers list");

        stockAgent.detach(agency2);

        assertEquals(1, stockAgent.getObservers().size(), "Should have 1 observer after detaching two");
        assertFalse(stockAgent.getObservers().contains(agency2), "Agency 2 should no longer be in the observers list");

        assertTrue(stockAgent.getObservers().contains(agency3), "Agency 3 should still be in the observers list");
    }

    @Test
    void verify_Observers_Receive_Notification_When_Stock_Increases() {

        stockAgent.stockGoesUp(25.0);

        String expectedMessagePart = "increasing";

        assertNotNull(agency1.getMessage(), "Agency 1 should have received a message");
        assertTrue(agency1.getMessage().toLowerCase().contains(expectedMessagePart), "Agency 1 message should indicate stock is increasing. Got: " + agency1.getMessage());

        assertNotNull(agency2.getMessage(), "Agency 2 should have received a message");
        assertTrue(agency2.getMessage().toLowerCase().contains(expectedMessagePart), "Agency 2 message should indicate stock is increasing. Got: " + agency2.getMessage());

        assertNotNull(agency3.getMessage(), "Agency 3 should have received a message");
        assertTrue(agency3.getMessage().toLowerCase().contains(expectedMessagePart), "Agency 3 message should indicate stock is increasing. Got: " + agency3.getMessage());

        assertEquals(125.0, appleStock.getActualValue(), "Stock value should now be $125");
    }

    @Test
    void verify_Observers_Receive_Notification_When_Stock_Decreases() {

        stockAgent.stockGoesDown(30.0);

        String expectedMessagePart = "decreasing";

        assertNotNull(agency1.getMessage(), "Agency 1 should have received a message");
        assertTrue(agency1.getMessage().toLowerCase().contains(expectedMessagePart), "Agency 1 message should indicate stock is decreasing. Got: " + agency1.getMessage());

        assertNotNull(agency2.getMessage(), "Agency 2 should have received a message");
        assertTrue(agency2.getMessage().toLowerCase().contains(expectedMessagePart), "Agency 2 message should indicate stock is decreasing. Got: " + agency2.getMessage());

        assertNotNull(agency3.getMessage(), "Agency 3 should have received a message");
        assertTrue(agency3.getMessage().toLowerCase().contains(expectedMessagePart), "Agency 3 message should indicate stock is decreasing. Got: " + agency3.getMessage());

        assertEquals(70.0, appleStock.getActualValue(), "Stock value should now be $70");
    }

    @Test
    void verify_Multiple_Stock_Changes_Update_Observers_Each_Time() {

        stockAgent.stockGoesUp(10.0); // Now $110
        assertTrue(agency1.getMessage().toLowerCase().contains("increasing"), "After first increase, message should say increasing");

        stockAgent.stockGoesDown(5.0); // Now $105
        assertTrue(agency1.getMessage().toLowerCase().contains("decreasing"), "After decrease, message should update to decreasing");

        stockAgent.stockGoesUp(20.0); // Now $125
        assertTrue(agency1.getMessage().toLowerCase().contains("increasing"), "After second increase, message should say increasing again");

        assertEquals(125.0, appleStock.getActualValue(), "Final stock value should be $125");
    }

    @Test
    void verify_Detached_Observer_Does_Not_Receive_Notifications() {
        stockAgent.detach(agency2);

        stockAgent.stockGoesUp(50.0);

        assertNotNull(agency1.getMessage(), "Agency 1 should have received notification");
        assertNotNull(agency3.getMessage(), "Agency 3 should have received notification");

        assertNull(agency2.getMessage(), "Agency 2 should NOT have received notification after being detached");
    }

    @Test
    void verify_Newly_Attached_Observer_Receives_Subsequent_Notifications() {

        stockAgent.stockGoesUp(10.0);

        StockExchangeAgency lateAgency = new StockExchangeAgency("lateAgency");
        stockAgent.attach(lateAgency);

        assertNull(lateAgency.getMessage(), "Late agency should not have message from before it subscribed");

        stockAgent.stockGoesDown(5.0);

        assertNotNull(lateAgency.getMessage(), "Late agency should receive notifications after subscribing");
        assertTrue(lateAgency.getMessage().toLowerCase().contains("decreasing"), "Late agency should know about the decrease");
    }

    @Test
    void verify_Stock_Event_Contains_Correct_Information() {

        stockAgent.stockGoesUp(25.0);

        StockEvent event = new StockEvent(appleStock);

        assertEquals(125.0, event.getActualValue(), "Event should report current value of $125");
        assertEquals(25.0, event.getLastChangeValue(), "Event should report a change of +$25");
        assertTrue(event.increase(), "Event should indicate this was an increase");
        assertFalse(event.decrease(), "Event should not indicate this was a decrease");
        assertEquals("Apple", event.getStockName(), "Event should report correct stock name");
    }
}