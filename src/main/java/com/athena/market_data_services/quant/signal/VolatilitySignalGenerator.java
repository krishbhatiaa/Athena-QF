package com.athena.market_data_services.quant.signal;

public class VolatilitySignalGenerator {

    public static SignalType generate(double volatility) {

        if (volatility > 0.03) {
            return SignalType.SELL;
        }

        if (volatility < 0.015) {
            return SignalType.BUY;
        }

        return SignalType.HOLD;
    }
}
