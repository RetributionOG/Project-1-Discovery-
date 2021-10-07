package za.ac.nwu.ac.web.sb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.Impl.CreateAccountTransactionFlowImpl;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccounttransactionFlow, FetchAccountTransactionFlow fetchAccountTransactionFlow){
        this.createAccountTransactionFlow = createAccounttransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Makes changes to the specified Member ID account.", notes = "Add or subtracts the specified amount of points from the member ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction.",
                    required = true)
            @RequestBody AccountTransactionDto AccountTransaction) {
        long startTime = System.nanoTime();
        LOGGER.debug("Create a new AccountTransaction");
        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        ResponseEntity<GeneralResponse<AccountTransactionDto>> generalResponseResponseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);
        LOGGER.info("Response time {}", ((System.nanoTime() - startTime) / 1000000L));
        return generalResponseResponseEntity;
    }

    @GetMapping("/{memberId}")
    @ApiOperation(value = "Fetches the specified AccountTransaction.", notes = "Fetches the AccountTransaction corresponding to the given transactionId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTransaction Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value = "The Member ID that uniquely identifies the AccountTransaction.",
                    example = "40",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId) {
        AccountTransactionDto accountTransaction = fetchAccountTransactionFlow.getAccountTransactionByMemberId(memberId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
