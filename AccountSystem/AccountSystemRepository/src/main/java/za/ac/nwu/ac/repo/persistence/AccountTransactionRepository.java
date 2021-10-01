package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long>{
    @Query(value = "SELECT " +
            "        at " +
            "        FROM " +
            "        AccountType at " +

            "    WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);
}
