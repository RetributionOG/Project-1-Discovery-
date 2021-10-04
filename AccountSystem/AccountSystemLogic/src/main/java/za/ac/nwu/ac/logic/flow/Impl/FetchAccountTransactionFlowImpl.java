package za.ac.nwu.ac.logic.flow.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator)
    {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public List<AccountTransactionDto> getAllTransactionTypes()
    {
        return accountTransactionTranslator.getAllAccountTransactions();
    }

    @Override
    public AccountTransactionDto getAccountTransactionByMemberId(Long memberId) {
        return accountTransactionTranslator.getAccountTransactionDtoByMemberId(memberId);
    }
}

//package za.ac.nwu.ac.logic.flow.Impl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
//import za.ac.nwu.ac.domain.persistence.AccountTransaction;
//import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
//import za.ac.nwu.ac.translator.AccountTransactionTranslator;
//import org.springframework.stereotype.Component;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountTransactionFlowImpl.class);
//
//    private AccountTransactionTranslator translator;
//
//    private FetchAccountTransactionFlowImpl(AccountTransactionTranslator translator) {
//        this.translator = translator;
//    }
//
//    @Override
//    public List<AccountTransactionDto> getAllAccountTransactions() {
//        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
//        for (AccountTransaction accountTransaction : translator.getAllAccountTransactions()) {
//            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
//        }
//        return accountTransactionDtos;
//    }
//
//    @Override
//    public AccountTransactionDto getAccountTransactionById(Long transactionId) {
//        AccountTransaction accountTransaction = translator.getAccountTransactionByPk(transactionId);
//        return null != accountTransaction ? new AccountTransactionDto(accountTransaction) : null;
//    }
//}
