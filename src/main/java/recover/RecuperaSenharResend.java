package recover;

public class RecuperaSenharResend {

    private String identificationType;
    private String otpToken;


    public RecuperaSenharResend() {
    }

    public RecuperaSenharResend(String identificationType, String otpToken) {
        this.identificationType = identificationType;
        this.otpToken = otpToken;
    }


    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getOtpToken() {
        return otpToken;
    }

    public void setOtpToken(String otpToken) {
        this.otpToken = otpToken;
    }
}
