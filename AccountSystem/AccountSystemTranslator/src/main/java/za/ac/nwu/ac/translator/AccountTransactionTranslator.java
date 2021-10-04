package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import java.util.List;

public interface AccountTransactionTranslator {
    AccountTransactionDto save(AccountTransactionDto accountTransaction);

    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);

    AccountTransactionDto getAccountTransactionDtoByMemberId(Long memberId);
}
