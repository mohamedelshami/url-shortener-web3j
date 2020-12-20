package io.epirus

import org.web3j.tx.gas.ContractGasProvider
import java.math.BigInteger

class GanacheGasProvider : ContractGasProvider {
    override fun getGasPrice(contractFunc: String): BigInteger {
        return BigInteger.valueOf(20000000000L)
    }

    override fun getGasPrice(): BigInteger {
        return BigInteger.valueOf(20000000000L)
    }

    override fun getGasLimit(contractFunc: String): BigInteger {
        return BigInteger.valueOf(6721975)
    }

    override fun getGasLimit(): BigInteger {
        return BigInteger.valueOf(6721975)
    }
}