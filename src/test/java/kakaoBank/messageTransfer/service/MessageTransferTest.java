package kakaoBank.messageTransfer.service;

import kakaoBank.messageTransfer.dao.MessageTransferDao;
import kakaoBank.messageTransfer.vo.MessageTransferVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional
public class MessageTransferTest {

    @Autowired  MessageTransferSvc svc;
    @Autowired  MessageTransferDao  dao;

    @Test
    void 이체실행() {
        //given
        MessageTransferVo vo = new MessageTransferVo();
        vo.setTrnYmd(getToday());
        vo.setSender("남재건3");
        vo.setReceiver("박사라");
        vo.setAmt(1000L);

        //when
        int result = 0;
        try {
            result = svc.transferMoneyFromSender(vo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 이체완료() {
        //given
        MessageTransferVo vo = new MessageTransferVo();
        vo.setTrnSrn(1L);
        vo.setTrnYmd(getToday());
        vo.setSender("남재건3");

        //when
        int result = 0;
        try {
            result = svc.clickedMessageFromReceiver(vo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 날짜() {
        System.out.println(this.getToday());
    }

    private String getToday() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
