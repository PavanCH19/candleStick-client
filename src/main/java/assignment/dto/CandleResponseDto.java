package assignment.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CandleResponseDto {

    private String symbol;
    private String timeframe;
    private List<CandleDto> candles;
    private Integer count;

    public CandleResponseDto() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public List<CandleDto> getCandles() {
        return candles;
    }

    public void setCandles(List<CandleDto> candles) {
        this.candles = candles;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}