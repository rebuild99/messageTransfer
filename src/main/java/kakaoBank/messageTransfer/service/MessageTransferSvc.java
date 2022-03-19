package kakaoBank.messageTransfer.service;

import kakaoBank.messageTransfer.dao.MessageTransferDao;
import kakaoBank.messageTransfer.vo.MessageTransferVo;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageTransferSvc {
    private final MessageTransferDao dao;

    @Autowired
    public MessageTransferSvc(MessageTransferDao dao) {
        this.dao = dao;
    }

    // 이체
    public int transferMoneyFromSender(MessageTransferVo inSvo) {
        return dao.insertTransferInfo(inSvo);
    }

    // 이체완료
    public int clickedMessageFromReceiver(MessageTransferVo inSvo) {
        return dao.updateTransferInfo(inSvo);
    }
}
