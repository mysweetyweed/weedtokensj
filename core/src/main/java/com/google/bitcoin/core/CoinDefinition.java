package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "WeedTokens";
    public static final String coinTicker = "WeTk";
    public static final String coinURIScheme = "weedtokens";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "[7X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.darkcoin.io/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "Xdeh9YTLNtci5zSL4DDayRSVTLf299n9jv";  //Hash Engineering donation DRK address
    public static final String DONATION_ADDRESS_TESTNET = "";  //Hash Engineering donation DRK address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(16 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(64);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 150; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(100000000).multiply(Utils.COIN);   //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(1000); //main.h CTransaction::GetMinFee    0.01 coins

    public static final int PROTOCOL_VERSION = 60014;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 60012;        //version.h MIN_PROTO_VERSION
    public static final int BIP0031_VERSION = 60000;

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 15714;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 25714;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 73;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 85;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xbf0c6bbd;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1421225489L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (449206);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "000009ddc8453966eedafb25b12720153ce31e6d89ec8a23aad7e2dbd1b62acd"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "4d553e4ff66d871e0f16ca3081e7a11d022d25b34cc9515f2aab8eb293c280a5";
    static public int genesisBlockValue = 0;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "00012a4c50466972737420536f6369616c204e6574776f726b20666f722043616e6e6162697320666f6c6c6f776572732c20736861726520796f757220657870657269656e636520616e6420686176652066756e2e";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "dnsseed.mysweetyweed.com",

    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - dimecoin - not tested
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 139;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xcee2caff;      //
    public static final String testnetGenesisHash = "00000bafbc94add76cb75e2ec92894837288a481e5c005f6563d91623bf8bc2c";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1390666206L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (3861367235L);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final BigInteger GetBlockReward(int height)
    /*{
        int COIN = 1;
        BigInteger nSubsidy = Utils.toNanoCoins(100, 0);
        if (height == 1)
            nSubsidy = Utils.toNanoCoins(420000, 0);
        return nSubsidy;
    }
*/
    //public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-seed.darkcoin.io",
            "testnet-seed.darkcoin.qa",
            "23.23.186.131"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "048240a8748a80a286b270ba126705ced4f2ce5a7847b3610ea3c06513150dade2a8512ed5ea86320824683fc0818f0ac019214973e677acd1244f6d0571fc5103";
    public static final String TESTNET_SATOSHI_KEY = "04517d8a699cb43d3938d7b24faaff7cda448ca4ea267723ba614784de661949bf632d6304316b244646dea079735b9a6fc4af804efb4752075b9fe2245e14e412";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.darkcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.darkcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

        checkpoints.put(  1, new Sha256Hash("00000e3788793c0c0e7e7a4f034995fc29232b791d5a62846f33978d8eda85ec"));
        checkpoints.put(  2, new Sha256Hash("00000dd5b000e55aa2a9ce4ed432183b20145aaa05bfa12c05eece7bf22421c9"));
        checkpoints.put(  3, new Sha256Hash("000006cf7df9f0139148f0b76976a0b89157dd28f89780726a65d7d5016b9dae"));
        checkpoints.put(  4, new Sha256Hash("000002539d5b78ef8943a0bfeeee42394e845297eb830ea434ba3bbe71c80c08"));
        checkpoints.put(  5, new Sha256Hash("00000618fa81a7ecd3742fbb6378a9c5c201e26114074a387f502e643f18817a"));

    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "WPLjGLbRGbAcUoFxJJD3Hx8qPFHTBdc4EY";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "WsSBcjK2W1yPkW3BrtpmJuttrHM8o3zi15GJU8PduSn8VmqrSb4Z";

}
