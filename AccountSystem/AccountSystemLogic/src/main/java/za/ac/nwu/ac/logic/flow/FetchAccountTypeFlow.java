package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();

    AccountType getAccountTypeDbEntityByMnemonic(String mnemonic);
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTransactionDto getAccountTransactionById(Long transactionId);
    AccountTransactionDto getAccountTransactionByMnemonic(Long transactionId);
}
