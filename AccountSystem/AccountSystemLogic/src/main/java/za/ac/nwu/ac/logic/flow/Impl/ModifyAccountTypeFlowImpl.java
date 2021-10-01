package za.ac.nwu.ac.logic.flow.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.ModifyAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import java.time.LocalDate;

@Component
public class ModifyAccountTypeFlowImpl implements ModifyAccountTypeFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyAccountTypeFlowImpl.class);

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public ModifyAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        return accountTypeTranslator.deleteAccountType();
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate) {
        return accountTypeTranslator.updateAccountType(mnemonic, newAccountTypeName, newCreationDate);
    }

    public boolean methodToTest() {
        return true;
    }
}
