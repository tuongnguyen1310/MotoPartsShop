package MotoPartsShop.Entity;

import java.util.List;

public class RecaptchaResponse {
    private boolean success;
    private String challenge_ts;
    private String hostname;
    private List<String> errorCodes;

    // Getter và Setter
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getChallenge_ts() {
        return challenge_ts;
    }
    public void setChallenge_ts(String challenge_ts) {
        this.challenge_ts = challenge_ts;
    }
    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public List<String> getErrorCodes() {
        return errorCodes;
    }
    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
}

