package kakaoBank.messageTransfer.dao;

import kakaoBank.messageTransfer.vo.MessageTransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

public class MessageTransferDaoImpl implements MessageTransferDao {

    private final JdbcTemplate jdbcTemplate;

    final String SELECT_QUERY = "select * from EBB049l where trnSrn = ? and sender = ?";
    final String INSERT_QUERY = "insert into EBB049l (trnYmd, sender, receiver, amt, status) values (?, ?, ?, ?, ?)";
    final String UPDATE_QUERY = "update EBB049l set status = ? where trnYmd = ? and trnSrn = ? and sender = ?";

    final String DELETE_QUERY = "delete from employee where id = ?";

    @Autowired
    public MessageTransferDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int insertTransferInfo(MessageTransferVo tranInfo) {
        return jdbcTemplate.update(INSERT_QUERY, tranInfo.getTrnYmd(), tranInfo.getSender(), tranInfo.getReceiver(), tranInfo.getAmt(), StatusCode.ING.getValue());
    }

    @Override
    public int updateTransferInfo(MessageTransferVo tranInfo) {
        return jdbcTemplate.update(UPDATE_QUERY, StatusCode.SUCCESS.getValue(), tranInfo.getTrnYmd(), tranInfo.getTrnSrn(), tranInfo.getSender());
    }

    @Override
    public MessageTransferVo selectTransferInfo(MessageTransferVo tranInfo) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, memberRowMapper(), tranInfo.getTrnSrn(), tranInfo.getSender());
    }

    private RowMapper<MessageTransferVo> memberRowMapper() {
        return (rs, rowNum) -> {
            MessageTransferVo vo = new MessageTransferVo();
            vo.setSender(rs.getString("sender"));
            vo.setReceiver(rs.getString("receiver"));
            vo.setAmt(rs.getLong("amt"));
            return vo;
        };
    }
}
