package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "DEMO_ACCOUNT_TYPE", schema = "hr")
public class AccountTransaction implements Serializable {

    private Long transactionId;
    private AccountType accountType;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Long amount, LocalDate transactionDate){
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }


    @Id
    @SequenceGenerator(name = "DEMO_ACCOUNT_TX_SEQ", sequenceName = "HR.DEMO_ACCOUNT_TX_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_ACCOUNT_TX_SEQ")

    @Column(name = "TX_ID")
    private Long getTransactionId(){
        return transactionId;
    }

    @Column(name = "MEMBER_ID")
    private Long getMemberId(){
        return memberId;
    }

    @Column(name = "AMOUNT")
    private Long getAmount(){
        return amount;
    }
    @Column(name = "TX_DATE")
    private LocalDate getTransactionDate(){
        return transactionDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    private AccountType getAccountType(){
        return accountType;
    }

    public void setTransactionId(Long transactionId){
        this.transactionId = transactionId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction " +
                "transactionID" + transactionId +
                "accountTypeId=" + accountType +
                ", memberID=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}

