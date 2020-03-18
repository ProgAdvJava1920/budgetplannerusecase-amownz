package be.pxl.student.entity;

import java.util.List;

public class PaymentDAO implements DAO<Payment, PaymentExeption>{



    @Override
    public Payment create(Payment payment) throws PaymentExeption {
        throw new PaymentExeption("not yet implemented");
    }

    @Override
    public Payment getById(int id) throws PaymentExeption {
        throw new PaymentExeption("not yet implemented");
    }

    @Override
    public List<Payment> getAll() throws PaymentExeption {
        throw new PaymentExeption("not yet implemented");
    }

    @Override
    public Payment update(Payment payment) throws PaymentExeption {
        throw new PaymentExeption("not yet implemented");
    }

    @Override
    public Payment delete(Payment payment) throws PaymentExeption {
        throw new PaymentExeption("not yet implemented");
    }
}
