package online_shopping_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentGateway {
    private List<Payment> payments = new ArrayList<>();
    private Random random = new Random();

    public int generatePaymentId() {
        return random.nextInt(10000); // Generates a random payment ID
    }

    public void processPayment(Payment payment) {
        payment.setStatus("Success");
        payments.add(payment);
    }

    public Payment getPaymentById(int paymentId) {
        for (Payment payment : payments) {
            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }
        return null;
    }

    public List<Payment> getAllPayments() {
        return payments;
    }
}
