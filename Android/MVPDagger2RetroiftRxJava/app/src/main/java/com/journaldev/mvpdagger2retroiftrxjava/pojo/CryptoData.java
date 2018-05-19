package com.journaldev.mvpdagger2retroiftrxjava.pojo;

import com.google.gson.annotations.SerializedName;

public class CryptoData {

    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("symbol")
    public String symbol;
    @SerializedName("rank")
    public String rank;
    @SerializedName("price_usd")
    public String priceUsd;
    @SerializedName("price_btc")
    public String priceBtc;
    @SerializedName("24h_volume_usd")
    public String _24hVolumeUsd;
    @SerializedName("market_cap_usd")
    public String marketCapUsd;
    @SerializedName("available_supply")
    public String availableSupply;
    @SerializedName("total_supply")
    public String totalSupply;
    @SerializedName("percent_change_1h")
    public String percentChange1h;
    @SerializedName("percent_change_24h")
    public String percentChange24h;
    @SerializedName("percent_change_7d")
    public String percentChange7d;
    @SerializedName("last_updated")
    public String lastUpdated;

}
