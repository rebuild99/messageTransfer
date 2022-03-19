package kakaoBank.messageTransfer.dao;

import kakaoBank.messageTransfer.vo.MessageTransferVo;


public interface MessageTransferDao {

    MessageTransferVo selectTransferInfo(MessageTransferVo tranInfo);
    int insertTransferInfo(MessageTransferVo tranInfo);
    int updateTransferInfo(MessageTransferVo tranInfo);
}
