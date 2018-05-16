/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.sobercoin.params;

import com.google.sobercoin.core.NetworkParameters;
import com.google.sobercoin.core.Utils;
import org.spongycastle.util.encoders.Hex;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the testnet, a separate public instance of Bitcoin that has relaxed rules suitable for development
 * and testing of applications and new Bitcoin versions.
 */
public class TestNet3Params extends NetworkParameters {
    public TestNet3Params() {
        super();
        id = ID_TESTNET;
        packetMagic = 0xfcc1b7dc;
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        proofOfWorkLimit = Utils.decodeCompactBits(0x1e0ffff0L);
        port = 12333;
        addressHeader = 125;
        p2shHeader = 196;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        dumpedPrivateKeyHeader = 239;
        genesisBlock.setTime(1516430418L);
        genesisBlock.setDifficultyTarget(0x1d018ea7L);
        genesisBlock.setNonce(386449828L);
        spendableCoinbaseDepth = 100;
        subsidyDecreaseBlockCount = 840000;
        String genesisHash = genesisBlock.getHashAsString();
        LOGGER.info("Genesis Hash: " + genesisHash.toString());
        checkState(genesisHash.equals("b794d6d037a2e221b744c6f7c99cb139c6e3013fa7e775c0a95a410404a2ea21"));
        alertSigningKey = Hex.decode("045bc4513f0863d402071aed43eba44530f8462b68fc0804d2df29ff5136866ce5b12e0722157112c1e3319ddfc9a010e9bbc235703630736e4c6997fd7c3b89a7");

        dnsSeeds = new String[] {

        };
    }

    private static TestNet3Params instance;
    public static synchronized TestNet3Params get() {
        if (instance == null) {
            instance = new TestNet3Params();
        }
        return instance;
    }
}
