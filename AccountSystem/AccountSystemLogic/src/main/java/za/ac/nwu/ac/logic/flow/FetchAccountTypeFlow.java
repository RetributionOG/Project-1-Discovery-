package za.ac.nwu.ac.logic.flow;

import java.util.List;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();
}
