package kakaoBank.messageTransfer.vo;

public class MessageTransferVo {

    private Long    trnSrn;
    private String  trnYmd;
    private String  sender;
    private String  receiver;
    private Long    amt;
    private String  status;

    public Long getTrnSrn() {
        return trnSrn;
    }

    public void setTrnSrn(Long trnSrn) {
        this.trnSrn = trnSrn;
    }

    public String getTrnYmd() {
        return trnYmd;
    }

    public void setTrnYmd(String trnYmd) {
        this.trnYmd = trnYmd;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Long getAmt() {
        return amt;
    }

    public void setAmt(Long amt) {
        this.amt = amt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
