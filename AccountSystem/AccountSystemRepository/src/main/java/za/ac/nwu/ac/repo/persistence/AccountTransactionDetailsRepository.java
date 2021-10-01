package za.ac.nwu.ac.repo.persistence;

import za.ac.nwu.ac.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.ac.domain.persistence.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionDetailsRepository extends JpaRepository<AccountTransactionDetails, Long> {
    @Query(value = "SELECT " +
            "        at " +
            "        FROM " +
            "        AccountType at " +

            "    WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);
}
