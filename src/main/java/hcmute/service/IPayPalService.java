package hcmute.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import hcmute.model.PaypalPaymentIntent;
import hcmute.model.PaypalPaymentMethod;

public interface IPayPalService {
    public Payment createPayment(
            Double total,
            String currency,
            PaypalPaymentMethod method,
            PaypalPaymentIntent intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException;

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
}