package xyzhotel.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PaymentLine")
public class PaymentLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentLineId;
    private int paymentId;
    private BigDecimal amount;
    private LocalDateTime dateAndTime;

    public int getPaymentLineId() {
        return paymentLineId;
    }

    public void setPaymentLineId(int paymentLineId) {
        this.paymentLineId = paymentLineId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
