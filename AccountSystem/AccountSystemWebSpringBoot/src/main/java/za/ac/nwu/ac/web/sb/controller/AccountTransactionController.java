package za.ac.nwu.ac.web.sb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
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
import za.ac.nwu.ac.logic.flow.ModifyAccountTransactionFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);
//
//    private final CreateAccountTransactionFlow createAccountTransactionFlow;
//    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
//    private final ModifyAccountTransactionFlow modifyAccountTransactionFlow;
//
//    @Autowired
//    public AccountTransactionController(CreateAccountTransactionFlow createAccounttransactionFlow, FetchAccountTransactionFlow fetchAccountTransactionFlow, ModifyAccountTransactionFlow modifyAccountTransactionFlow){
//        this.createAccountTransactionFlow = createAccounttransactionFlow;
//        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
//        this.modifyAccountTransactionFlow = modifyAccountTransactionFlow;
//    }
//
//    @PostMapping("")
//    @ApiOperation(value = "Creates a new AccountTransaction.", notes = "Creates a new AccountTransaction in the DB.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
//            @ApiParam(value = "Request body to create a new AccountTransaction.",
//                    required = true)
//            @RequestBody AccountTransactionDto AccountTransaction) {
//        long startTime = System.nanoTime();
//        LOGGER.debug("Create a new AccountTransaction");
//        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
//        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
//        ResponseEntity<GeneralResponse<AccountTransactionDto>> generalResponseResponseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);
//        LOGGER.info("Response time {}", ((System.nanoTime() - startTime) / 1000000L));
//        return generalResponseResponseEntity;
//    }
//
//    @GetMapping("/all")
//    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of Account types")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){
//        List<AccountTransactionDto> accountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
//        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, accountTransactions);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping("/{transactionId}")
//    @ApiOperation(value = "Fetches the specified AccountTransaction.", notes = "Fetches the AccountTransaction corresponding to the given transactionId")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "AccountTransaction Found", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
//            @ApiParam(value = "The Transaction that uniquely identifies the AccountTransaction.",
//                    example = "50002",
//                    name = "transactionId",
//                    required = true)
//            @PathVariable("transactionId") final Long transactionId) {
//        AccountTransactionDto accountTransaction = fetchAccountTransactionFlow.getAccountTransactionById(transactionId);
//        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//
//    @PutMapping("{memberId}")
//    @ApiOperation(value = "Updates the specified AccountType.", notes = "Updates the AccoutType corresponding to the given mnemonic")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "AccountType Updated", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTypeDto>> updateAccountType(
//            @ApiParam(value = "The memberId that uniquely identifies who the account belongs to.",
//                    example = "1",
//                    name = "memberId",
//                    required = true)
//            @RequestParam("memberId") final Long memberId,
//
//            @ApiParam(value = "The new AccountTypeName that the specified AccountType should be update with.",
//                    name = "newAccountTypeName",
//                    required = true)
//            @RequestParam("newAccountTypeName") final String newAccountTypeName,
//
//            @ApiParam(value = "The optional new date with which the CreationDate in ISO date format (yyyy-MM-dd). If empty/null, it will not be updated.",
//                    name = "newCreationDate",
//                    required = true)
//            @RequestParam(value = "newCreationDate", required = false)
//            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                    LocalDate newCreationDate
//    ) {
//        AccountTypeDto accountType = modifyAccountTransactionFlow.updateAccountTransaction(memberId);
//        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
}
