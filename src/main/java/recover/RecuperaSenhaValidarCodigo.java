package recover;

public class RecuperaSenhaValidarCodigo {

    private String otp;
    private String otpToken;

    public RecuperaSenhaValidarCodigo() {
    }

    public RecuperaSenhaValidarCodigo(String otp, String otpToken) {
        this.otp = otp;
        this.otpToken = otpToken;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getOtpToken() {
        return otpToken;
    }

    public void setOtpToken(String otpToken) {
        this.otpToken = otpToken;
    }
}
