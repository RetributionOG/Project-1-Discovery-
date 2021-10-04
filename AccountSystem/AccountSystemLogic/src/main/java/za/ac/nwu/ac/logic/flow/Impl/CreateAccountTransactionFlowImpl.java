package za.ac.nwu.ac.logic.flow.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    public CreateAccountTransactionFlowImpl (AccountTransactionTranslator accountTransactionTranslator)
    {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransaction)
    {
        if (null == accountTransaction.getTransactionDate())
        {
            accountTransaction.setTransactionDate(LocalDate.now());
        }
        return accountTransactionTranslator.create(accountTransaction);
    }
}

//    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);
//
//    private final AccountTransactionTranslator accountTransactionTranslator;
//    private final FetchAccountTypeFlow fetchAccountTypeFlow;
//
//    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
//                                            FetchAccountTypeFlow fetchAccountTypeFlow){
//        this.accountTransactionTranslator = accountTransactionTranslator;
//        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
//    }
//    @Override
//    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {
//
//        if (LOGGER.isDebugEnabled()) {
//
//            String outputForLogging = "null";
//
//            LOGGER.info("The input object was {} and the Details is {}", accountTransactionDto, outputForLogging);
//        }
//
//        accountTransactionDto.setTransactionId(null);
//
//        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
//
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Got AccountType for {} and the AccountTypeID is {}", accountTransactionDto.getAccountTypeMnemonic(), accountType.getAccountTypeId());
//        }
//
//        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
//
//        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);
//
//        AccountTransactionDto results = new AccountTransactionDto(createdAccountTransaction);
//        LOGGER.info("The return object is {}", results);
//        return results;
//    }
//}
