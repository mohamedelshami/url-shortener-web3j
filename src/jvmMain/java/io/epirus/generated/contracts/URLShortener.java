package io.epirus.generated.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.7.0.
 */
@SuppressWarnings("rawtypes")
public class URLShortener extends Contract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b5060405162000c8338038062000c83833981810160405260608110156200003757600080fd5b8151602083018051604051929492938301929190846401000000008211156200005f57600080fd5b9083019060208201858111156200007557600080fd5b82516401000000008111828201881017156200009057600080fd5b82525081516020918201929091019080838360005b83811015620000bf578181015183820152602001620000a5565b50505050905090810190601f168015620000ed5780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200011157600080fd5b9083019060208201858111156200012757600080fd5b82516401000000008111828201881017156200014257600080fd5b82525081516020918201929091019080838360005b838110156200017157818101518382015260200162000157565b50505050905090810190601f1680156200019f5780820380516001836020036101000a031916815260200191505b506040525050600080546001600160a01b0319166001600160a01b038616179055508151620001d690600290602085019062000512565b50604080516373a0e62760e11b8152600060048201818152602483019384526002805460001961010060018316150201168190046044850181905288956001600160a01b0387169563e741cc4e959492606490910190849080156200027f5780601f1062000253576101008083540402835291602001916200027f565b820191906000526020600020905b8154815290600101906020018083116200026157829003601f168201915b5050935050505060206040518083038186803b1580156200029f57600080fd5b505afa158015620002b4573d6000803e3d6000fd5b505050506040513d6020811015620002cb57600080fd5b50516001908155604080516338926b6d60e01b81526000600482018181526024830193845260028054958616156101000260001901909516859004604484018190526001600160a01b038716956338926b6d959394909391606490910190849080156200037c5780601f1062000350576101008083540402835291602001916200037c565b820191906000526020600020905b8154815290600101906020018083116200035e57829003601f168201915b50509350505050602060405180830381600087803b1580156200039e57600080fd5b505af1158015620003b3573d6000803e3d6000fd5b505050506040513d6020811015620003ca57600080fd5b505060015460408051630588253160e21b815260048101838152602482019283528551604483015285516001600160a01b0386169463162094c4949093889392606490910190602085019080838360005b83811015620004355781810151838201526020016200041b565b50505050905090810190601f168015620004635780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b1580156200048457600080fd5b505af115801562000499573d6000803e3d6000fd5b50506001546040805163095ea7b360e01b81523360048201526024810192909252516001600160a01b038516935063095ea7b39250604480830192600092919082900301818387803b158015620004ef57600080fd5b505af115801562000504573d6000803e3d6000fd5b5050505050505050620005b7565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200055557805160ff191683800117855562000585565b8280016001018555821562000585579182015b828111156200058557825182559160200191906001019062000568565b506200059392915062000597565b5090565b620005b491905b808211156200059357600081556001016200059e565b90565b6106bc80620005c76000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806302d3f5851461005c578063501fe2bf1461007657806380e9071b146101385780638c0c9b2414610140578063b68d180914610164575b600080fd5b6100646101e1565b60408051918252519081900360200190f35b6100646004803603604081101561008c57600080fd5b8101906020810181356401000000008111156100a757600080fd5b8201836020820111156100b957600080fd5b803590602001918460018302840111640100000000831117156100db57600080fd5b9193909290916020810190356401000000008111156100f957600080fd5b82018360208201111561010b57600080fd5b8035906020019184600183028401116401000000008311171561012d57600080fd5b5090925090506101e7565b6100646104ea565b6101486105e5565b604080516001600160a01b039092168252519081900360200190f35b61016c6105f4565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101a657818101518382015260200161018e565b50505050905090810190601f1680156101d35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60015490565b600080546001600160a01b031681816338926b6d6102036101e1565b89896040518463ffffffff1660e01b815260040180848152602001806020018281038252848482818152602001925080828437600081840152601f19601f820116905080830192505050945050505050602060405180830381600087803b15801561026d57600080fd5b505af1158015610281573d6000803e3d6000fd5b505050506040513d602081101561029757600080fd5b5051905080156104db576000826001600160a01b031663e741cc4e6102ba6101e1565b8a8a6040518463ffffffff1660e01b815260040180848152602001806020018281038252848482818152602001925080828437600083820152604051601f909101601f1916909201965060209550909350505081840390508186803b15801561032257600080fd5b505afa158015610336573d6000803e3d6000fd5b505050506040513d602081101561034c57600080fd5b505160408051632c1a404960e21b81526004810183815260248201928352604482018990529293506001600160a01b0386169263b06901249285928b928b929091606401848480828437600081840152601f19601f820116905080830192505050945050505050600060405180830381600087803b1580156103cd57600080fd5b505af11580156103e1573d6000803e3d6000fd5b50505050826001600160a01b03166323b872dd846001600160a01b0316636352211e846040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561043857600080fd5b505afa15801561044c573d6000803e3d6000fd5b505050506040513d602081101561046257600080fd5b5051604080516001600160e01b031960e085901b1681526001600160a01b0390921660048301523360248301526044820185905251606480830192600092919082900301818387803b1580156104b757600080fd5b505af11580156104cb573d6000803e3d6000fd5b50505050600193505050506104e2565b6000925050505b949350505050565b60008054604080516338926b6d60e01b81526004810184815260248201928352600280546000196001821615610100020116819004604484018190526001600160a01b039095169485946338926b6d94889492606490910190849080156105925780601f1061056757610100808354040283529160200191610592565b820191906000526020600020905b81548152906001019060200180831161057557829003601f168201915b50509350505050602060405180830381600087803b1580156105b357600080fd5b505af11580156105c7573d6000803e3d6000fd5b505050506040513d60208110156105dd57600080fd5b505191505090565b6000546001600160a01b031681565b60028054604080516020601f600019610100600187161502019094168590049384018190048102820181019092528281526060939092909183018282801561067d5780601f106106525761010080835404028352916020019161067d565b820191906000526020600020905b81548152906001019060200180831161066057829003601f168201915b505050505090509056fea265627a7a72315820f977c52d95b709a8b977f4ca80366c2136fd22bcc425063881d8b5d2eda88b0564736f6c63430005100032";

    public static final String FUNC_AKAPADDRESS = "akapAddress";

    public static final String FUNC_CLAIMANDSETNODEBODY = "claimAndSetNodeBody";

    public static final String FUNC_RECLAIM = "reclaim";

    public static final String FUNC_PARENTNODEID = "parentNodeId";

    public static final String FUNC_GETDOMAIN = "getDomain";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0xabef272d407db72f6416810AA2e8B2500233F1A3");
    }

    @Deprecated
    protected URLShortener(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected URLShortener(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected URLShortener(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected URLShortener(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> akapAddress() {
        final Function function = new Function(FUNC_AKAPADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> claimAndSetNodeBody(byte[] label, byte[] body) {
        final Function function = new Function(
                FUNC_CLAIMANDSETNODEBODY, 
                Arrays.<Type>asList(new DynamicBytes(label),
                new DynamicBytes(body)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> reclaim() {
        final Function function = new Function(
                FUNC_RECLAIM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> parentNodeId() {
        final Function function = new Function(FUNC_PARENTNODEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getDomain() {
        final Function function = new Function(FUNC_GETDOMAIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    @Deprecated
    public static URLShortener load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new URLShortener(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static URLShortener load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new URLShortener(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static URLShortener load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new URLShortener(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static URLShortener load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new URLShortener(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<URLShortener> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _akapAddress, byte[] domain, String tokenURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_akapAddress),
                new DynamicBytes(domain),
                new org.web3j.abi.datatypes.Utf8String(tokenURI)));
        return deployRemoteCall(URLShortener.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<URLShortener> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _akapAddress, byte[] domain, String tokenURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_akapAddress),
                new DynamicBytes(domain),
                new org.web3j.abi.datatypes.Utf8String(tokenURI)));
        return deployRemoteCall(URLShortener.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<URLShortener> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _akapAddress, byte[] domain, String tokenURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_akapAddress),
                new DynamicBytes(domain),
                new org.web3j.abi.datatypes.Utf8String(tokenURI)));
        return deployRemoteCall(URLShortener.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<URLShortener> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _akapAddress, byte[] domain, String tokenURI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_akapAddress),
                new DynamicBytes(domain),
                new org.web3j.abi.datatypes.Utf8String(tokenURI)));
        return deployRemoteCall(URLShortener.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
