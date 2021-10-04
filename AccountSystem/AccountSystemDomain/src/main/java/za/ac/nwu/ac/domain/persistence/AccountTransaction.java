package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DEMO_ACCOUNT_TX", schema = "hr")
public class AccountTransaction implements Serializable {


    private Long transactionId;
//    private AccountType accountType;
    private Long accountTypeId;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Long memberId, Long amount, LocalDate transactionDate) {
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction(Long accountTypeId, Long memberId, Long amount, LocalDate transactionDate){
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }



    @Id
    @SequenceGenerator(name = "DEMO_ACCOUNT_TX_SEQ", sequenceName = "HR.DEMO_ACCOUNT_TX_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_ACCOUNT_TX_SEQ")

    @Column(name = "ACCOUNT_TX_ID")
    public Long getTransactionId(){
        return transactionId;
    }

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId(){
        return memberId;
    }

    @Column(name = "AMOUNT")
    public Long getAmount(){
        return amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate(){
        return transactionDate;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ACCOUNT_TYPE_ID")
//    public AccountType getAccountType(){
//        return accountType;
//    }

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
//    public void setAccountType(AccountType accountType) {
//        this.accountType = accountType;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}

