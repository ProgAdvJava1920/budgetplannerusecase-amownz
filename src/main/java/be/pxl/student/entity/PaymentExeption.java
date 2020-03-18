package be.pxl.student.entity;

public class PaymentExeption extends Exception {
    public PaymentExeption() {
        super();
    }

    public PaymentExeption(String message) {
        super(message);
    }

    public PaymentExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentExeption(Throwable cause) {
        super(cause);
    }
}
